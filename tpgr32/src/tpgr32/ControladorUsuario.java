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
          
    public void altaCliente(String nombre,String apellido,String nickName,String correoElec,
            Date f) throws Exception {
        try {     
            Cliente c = new Cliente(nombre,apellido,nickName,correoElec,f);
            this.mUsuario = ManejadorUsuario.getInstance();
            this.mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }
    }
      
    public void altaClienteConImg(String nickname,String nombre,String apellido,String correo,
            Date fnac,Image img) throws Exception {    
        try {
            Cliente c = new Cliente(nombre,apellido,nickname,correo,fnac);
            this.mUsuario = ManejadorUsuario.getInstance();
            this.mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void altaProveedor(String nickname, String nombre,
                              String apellido, String correo,Date fecha,
                              String nombreEmp, String url) throws Exception {
        
        try {   
            Proveedor c = new Proveedor(nombre,apellido,nickname,correo,fecha,nombreEmp,url);
            this.mUsuario = ManejadorUsuario.getInstance();
            this.mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }       
    }
    
    public void altaProveedorConImg(String nickname,String nombre,String apellido,String correo,
            Date fnac,String nombreEmp,String url,Image img) throws Exception {
        
        try { 
            Cliente c = new Cliente(nombre,apellido,nickname,correo,fnac);
            this.mUsuario = ManejadorUsuario.getInstance();
            this.mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public DataUsuario infoCliente(String nickname) {
        this.mUsuario = ManejadorUsuario.getInstance();
        return this.mUsuario.encontrarUsuario(nickname).infoUsuario();
    }
    
      public Set<DataUsuario> listarClientes() {
        this.mUsuario = ManejadorUsuario.getInstance();
        return this.mUsuario.listarClientes();    }

    public Set<DataUsuario> listarProveedores() {
        this.mUsuario = ManejadorUsuario.getInstance();
        return this.mUsuario.listarProveedores();
    }
    
}
