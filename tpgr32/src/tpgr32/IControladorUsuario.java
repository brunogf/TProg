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
interface IControladorUsuario {
    
    void altaCliente(String nickname,String nombre,String apellido,String correo,Date fnac);

    void altaClienteConImg(String nickname,String nombre,String apellido,String correo,Date fnac,Image img);
    
    void altaProveedor(String nickname,String nombre,String apellido,String correo,Date fnac,String nombreEmp,String url);
         
    void altaProveedorConImg(String nickname,String nombre,String apellido,String correo,Date fnac,String nombreEmp,String url,Image img);

    DataUsuario infoCliente(String nickname); 

    Set<DataUsuario> listarClientes();

    Set<DataUsuario> listarProveedores(); 
   
}
