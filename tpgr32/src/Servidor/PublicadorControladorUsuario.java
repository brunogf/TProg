/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import tpgr32.DataCliente;
import tpgr32.DataProveedor;
import tpgr32.DataPublicacion;
import tpgr32.DataUsuario;
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
    public void altaCliente(String nickname,String nombre,String apellido,String correo,String fnac,String pass) throws Exception{
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        cusr.altaCliente(nickname, nombre, apellido, correo, dt.parse(fnac), pass);
    }
    
    @WebMethod
    public void altaClienteConImg(String nickname,String nombre,String apellido,String correo,
            String fnac,byte[] img,String pass) throws Exception{
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(img));
        //Antes de copiar la imagen trato de dar el alta
        String ruta = "Imagenes/" + nickname + ".jpg";
        cusr.altaClienteConImg(nickname, nombre, apellido, correo, dt.parse(fnac), ruta, pass);
        if(imagen != null){
                String destino = ruta;
                File file_d = new File(destino);
                if(file_d.exists())
                    file_d.delete();
                if (!(file_d.exists())){
                            BufferedImage newBufferedImage = new BufferedImage(imagen.getWidth(),
                            imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
                            newBufferedImage.createGraphics().drawImage(imagen, 0, 0, Color.WHITE, null);
                            ImageIO.write(newBufferedImage,"jpg",file_d);
                        }
            }
    }
    
    @WebMethod
    public void altaProveedor(String nickname,String nombre,String apellido,String correo,String fnac,String nombreEmp,String url, String pass) throws Exception{
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        cusr.altaProveedor(nickname, nombre, apellido, correo, dt.parse(fnac), nombreEmp, url, pass);
    }
    
    @WebMethod
    public void altaProveedorConImg(String nickname,String nombre,String apellido,String correo,
            String fnac,String nombreEmp,String url,byte[] img, String pass)throws Exception{
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(img));
        //Antes de copiar la imagen trato de dar el alta
        String ruta = "Imagenes/" + nickname + ".jpg";
        cusr.altaProveedorConImg(nickname, nombre, apellido, correo, dt.parse(fnac), nombreEmp, url, ruta, pass);
        if(imagen != null){
                String destino = ruta;
                File file_d = new File(destino);
                if(file_d.exists())
                    file_d.delete();
                if (!(file_d.exists())){
                            BufferedImage newBufferedImage = new BufferedImage(imagen.getWidth(),
                            imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
                            newBufferedImage.createGraphics().drawImage(imagen, 0, 0, Color.WHITE, null);
                            ImageIO.write(newBufferedImage,"jpg",file_d);
                        }
            }
    }
    
    @WebMethod
    public DataCliente infoCliente(String nickname){
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       return (DataCliente)cusr.infoCliente(nickname);
    }
    
    @WebMethod
    public DataProveedor infoProveedor(String nickname){
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       return (DataProveedor)cusr.infoProveedor(nickname);
    }
    
    @WebMethod
    public DataUsuario[] listarClientes(){
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       Set<DataUsuario> sdtu = cusr.listarClientes();
       DataUsuario[] adtu = new DataUsuario[sdtu.size()];
       int i = 0;
       for(DataUsuario dtu : sdtu){
           adtu[i] = dtu;
           i++;
       }
       return adtu; 
    }
    
    @WebMethod
    public DataUsuario[] listarProveedores(){
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       Set<DataUsuario> sdtu = cusr.listarProveedores();
       DataUsuario[] adtu = new DataUsuario[sdtu.size()];
       int i = 0;
       for(DataUsuario dtu : sdtu){
           adtu[i] = dtu;
           i++;
       }
       return adtu; 
    }
    
    @WebMethod
    public DataPublicacion[] listarPublicacionesProveedor(String nick){
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       Set<DataPublicacion> sdtp = cusr.listarPublicacionesProveedor(nick);
       DataPublicacion[] adtp = new DataPublicacion[sdtp.size()];
       int i = 0;
       for(DataPublicacion dtp : sdtp){
           adtp[i] = dtp;
           i++;
       }
       return adtp;
    }
    
    @WebMethod
    public byte[] getImagenDelUsuario(String nombre){
        ByteArrayOutputStream bArray = new ByteArrayOutputStream();
        byte[] rArray = null;
        Image img = FabricaControladores.getInstancia().getControladorUsuario().getImagenDelUsuario(nombre);
        if (img != null){
            try{
            ImageIO.write((BufferedImage)img, "jpg", bArray);
            rArray = bArray.toByteArray();
            }catch(Exception e){
                rArray = null;
            }
        }
        return rArray;
    }
    
    @WebMethod
    public int comprobarUsuario(String usuario, String password){
        return FabricaControladores.getInstancia().getControladorUsuario().comprobarUsuario(usuario, password);
    }
    
    @WebMethod
    public String getNickUsuario(String usuario){
        return FabricaControladores.getInstancia().getControladorUsuario().getNickUsuario(usuario);
    }
    
    @WebMethod
    public boolean existeMail(String email){
        return FabricaControladores.getInstancia().getControladorUsuario().existeMail(email);
    }
}
