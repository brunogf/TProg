/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Endpoint;
import tpgr32.DataReserva;
import tpgr32.Estado;
import tpgr32.FabricaControladores;
import tpgr32.IControladorReserva;
import tpgr32.ParDPD;

/**
 *
 * @author Nico
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PublicadorControladorReserva {
    private Endpoint endpoint = null;
    
    public PublicadorControladorReserva(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
        String srv = "";
        try{
            BufferedReader in = new BufferedReader(new FileReader("server.txt"));
            srv = in.readLine();
            in.close();
        }catch(Exception e){
            srv = "http://localhost:9128";
        }
        
        endpoint = Endpoint.publish(srv + "/controlador_reserva", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public void actualizarEstado(int num, Estado est) throws Exception{
        FabricaControladores.getInstancia().getControladorReserva().actualizarEstado(num, est);
    }
    
    @WebMethod
    public void generarReserva(ParDPD[] apdpd, String nickname){
        IControladorReserva cont_r = FabricaControladores.getInstancia().getControladorReserva();
        cont_r.borrarPublicacionesSeleccionadas();
        for (int i = 0; i < apdpd.length; i++){
            cont_r.seleccionarProveedor(apdpd[i].getDpub().getProveedor());
            cont_r.seleccionarCliente(nickname);
            cont_r.seleccionarPublicacion(apdpd[i].getDpub().getNombre(),apdpd[i].getDd().getCant(),apdpd[i].getDd().getFechaIni(),apdpd[i].getDd().getFechaFin());
        }
        cont_r.confirmarReserva(); 
    }
    
    @WebMethod
    public void cambiarFechaCreacionReserva(String fecha, int nro) throws ParseException{
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date f = df.parse(fecha);
        FabricaControladores.getInstancia().getControladorReserva().cambiarFechaCreacionReserva(f, nro);
    }
    
    @WebMethod
    public DataReserva infoReserva(int nro){
        return FabricaControladores.getInstancia().getControladorReserva().infoReserva(nro);
    }
}
