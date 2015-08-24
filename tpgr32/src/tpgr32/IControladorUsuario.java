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
    
    void altaCliente(String nickname,String nombre,String apellido,String correo,Date fnac) throws Exception;

    void altaClienteConImg(String nickname,String nombre,String apellido,String correo,Date fnac,Image img) throws Exception;
    
    void altaProveedor(String nickname,String nombre,String apellido,String correo,Date fnac,String nombreEmp,String url) throws Exception;
         
    void altaProveedorConImg(String nickname,String nombre,String apellido,String correo,Date fnac,String nombreEmp,String url,Image img) throws Exception;

    DataUsuario infoCliente(String nickname); 

    Set<DataUsuario> listarClientes();

    Set<DataUsuario> listarProveedores(); 
   
}
