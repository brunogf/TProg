/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author spesamosca
 */
public interface IControladorUsuario {
    
    public void altaCliente(String nickname,String nombre,String apellido,String correo,Date fnac,String pass) throws Exception;

    public void altaClienteConImg(String nickname,String nombre,String apellido,String correo,
            Date fnac,String img,String pass) throws Exception;
    
    public void altaProveedor(String nickname,String nombre,String apellido,String correo,Date fnac,String nombreEmp,String url) throws Exception;
         
    public void altaProveedorConImg(String nickname,String nombre,String apellido,String correo,
            Date fnac,String nombreEmp,String url,String img)throws Exception;

    public DataUsuario infoCliente(String nickname); 

    public Set<DataUsuario> listarClientes();

    public Set<DataUsuario> listarProveedores();
    
    public Set<DataPublicacion> listarPublicacionesProveedor(String nick);
    
    public String getImagenDelUsuario(String nombre);
   
}
