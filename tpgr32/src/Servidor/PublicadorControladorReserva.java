/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Endpoint;
import tpgr32.DataCliente;
import tpgr32.DataReserva;
import tpgr32.DataServicio;
import tpgr32.DataServicioBean;
import tpgr32.DataUsuario;
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
    public int generarReserva(String jsonParDPDCollection, String nickname){
        IControladorReserva cont_r = FabricaControladores.getInstancia().getControladorReserva();
        Set<LinkedTreeMap> st = new Gson().fromJson(jsonParDPDCollection, HashSet.class);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        for(LinkedTreeMap ltm : st){
            LinkedTreeMap dpub = (LinkedTreeMap)ltm.get("dpub");
            LinkedTreeMap dd = (LinkedTreeMap)ltm.get("dd");      
            String nombre = (String)dpub.get("nombre");
            String proveedor = (String)dpub.get("proveedor");
            Double o = (Double)dd.get("cant");
            int cant = o.intValue();
            LinkedTreeMap fini = (LinkedTreeMap) dd.get("fechaIni"); 
            LinkedTreeMap ffin = (LinkedTreeMap) dd.get("fechaFin");
            int dia = ((Double)(fini.get("day"))).intValue();
            int MM = ((Double)(fini.get("month"))).intValue();
            int year = ((Double)(fini.get("year"))).intValue();
            String dte = "";
            dte = dte + Integer.toString(dia)+ "-" + Integer.toString(MM) +"-"+ Integer.toString(year);
            Date dateini;
            try{
             dateini = df.parse(dte);
            }catch(Exception e){dateini = new Date();}
            dia = ((Double)(ffin.get("day"))).intValue();
            MM = ((Double)(ffin.get("month"))).intValue();
            year = ((Double)(ffin.get("year"))).intValue();
            dte = "" + Integer.toString(dia)+ "-" + Integer.toString(MM) +"-"+ Integer.toString(year);
            Date datefin;
            try{
             datefin = df.parse(dte);
            }catch(Exception e){datefin = new Date();}
            cont_r.seleccionarProveedor(proveedor);
            cont_r.seleccionarCliente(nickname);
            cont_r.seleccionarPublicacion(nombre, cant, dateini, datefin);
        }
        
        return cont_r.confirmarReserva(); 
    }
    
    @WebMethod
    public void cambiarFechaCreacionReserva(String fecha, int nro) throws ParseException{
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date f = df.parse(fecha);
        FabricaControladores.getInstancia().getControladorReserva().cambiarFechaCreacionReserva(f, nro);
    }
    
    @WebMethod
    public DataReserva infoReserva(int nro){
        DataReserva r = FabricaControladores.getInstancia().getControladorReserva().infoReserva(nro);
        Set<ParDPD> sdpd = r.getdpd();
        for(ParDPD pdpd : sdpd){
            if(pdpd.getDpub() instanceof DataServicio){
                Set<String> categorias = ((DataServicio)(pdpd.getDpub())).getCategorias();
                String[] cats = new String[categorias.size()];
                int iter = 0;
                for (String c : categorias){
                    cats[iter] = c;
                    iter++;
                }
                pdpd.setDataPub(new DataServicioBean(((DataServicio)(pdpd.getDpub())).getNombre(), ((DataServicio)(pdpd.getDpub())).getDescripcion(), ((DataServicio)(pdpd.getDpub())).getPrecio(), ((DataServicio)(pdpd.getDpub())).getProveedor(),cats, ((DataServicio)(pdpd.getDpub())).getCantVisitas()));
            }
        }
        r.setParDPD(sdpd);
        return r;
    }
    
    @WebMethod
    public String getClienteReserva(int nro){
        DataUsuario dtu = FabricaControladores.getInstancia().getControladorReserva().getInfoClienteReserva(nro);
        return dtu.getNickname();
    }
    
    @WebMethod
    public int facturarReserva(String nick, int nro){ 
        //RETORNA -1 SI NO SE FACTURO, EL NRO DE LA FACTURA EN OTRO CASO (ID FACTURA EN DB)
        return FabricaControladores.getInstancia().getControladorReserva().facturarReserva(nick, nro);
    }
    
    @WebMethod
    public byte[] obtenerFactura(int id){
        return FabricaControladores.getInstancia().getControladorReserva().obtenerFactura(id);
    }
}
