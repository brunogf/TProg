/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.Date;
import java.util.Set;


public class ControladorUsuario implements IControladorUsuario{
        
    private ManejadorUsuario mUsuario;
    private String nick;
    public ControladorUsuario() {
        
    }
          
    public void altaCliente(String nombre,String apellido,String nickName,String correoElec, Date f) {
        this.mUsuario = ManejadorUsuario.getInstance();
        this.nick = nickName;
        this.mUsuario.agregarCliente(nombre, apellido, nickName, correoElec, f);        
    }
    
   
    public void altaProveedor(String nickname, String nombre,
                              String apellido, String correo,Date fecha,
                              String nombreEmp, String url, Image imagen){
        
    }
    
    public DataCliente infoCliente(String nickname){
        
    }
    
    public DataCliente listarClientes(){
        
    }
    
    public Set<DataProveedor> listarProveedores(){
        
    }
        
    public void imprimirDatos() {
        String nombre = this.mUsuario.getUsuario(this.nick).getNombre();
	//deberia retornar datos, supongamos un DataUsuario, o DataCliente... - Nico
    }
    
}
