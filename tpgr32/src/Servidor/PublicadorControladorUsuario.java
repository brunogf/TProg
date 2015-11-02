/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import tpgr32.DataCliente;
import tpgr32.FabricaControladores;
import tpgr32.IControladorUsuario;

/**
 *
 * @author Nico
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PublicadorControladorUsuario {
    
    private Endpoint endpoint = null;
    
    public PublicadorControladorUsuario(){}
    
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
        
        endpoint = Endpoint.publish(srv + "/controlador_usuario", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public void altaCliente(String nickname,String nombre,String apellido,String correo,Date fnac,String pass) throws Exception{
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        cusr.altaCliente(nickname, nombre, apellido, correo, fnac, pass);

    }
    
    @WebMethod
    public DataCliente infoUsuario(String nickname){
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       return (DataCliente)cusr.infoCliente(nickname);
    }
    
    
    
}
