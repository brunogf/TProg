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
        
    private String nick;
    public ControladorUsuario() {
        
    }
          
    public void altaCliente(String nombre,String apellido,String nickName,String correoElec,
            Date f) throws Exception {
        try {     
            Cliente c = new Cliente(nombre,apellido,nickName,correoElec,f);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }
    }
      
    public void altaClienteConImg(String nickname,String nombre,String apellido,String correo,
            Date fnac,String[] img,int cantImg) throws Exception {    
        try {
            Cliente c = new Cliente(nombre,apellido,nickname,correo,fnac);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
            mUsuario.agregarImagenes(c,img,cantImg);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void altaProveedor(String nickname, String nombre,
                              String apellido, String correo,Date fecha,
                              String nombreEmp, String url) throws Exception {
        
        try {   
            Proveedor c = new Proveedor(nombre,apellido,nickname,correo,fecha,nombreEmp,url);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }       
    }
    
    public void altaProveedorConImg(String nickname,String nombre,String apellido,String correo,
            Date fnac,String nombreEmp,String url,String[] img,int cantImg) throws Exception {
        
        try {   
            Proveedor c = new Proveedor(nombre,apellido,nickname,correo,fnac,nombreEmp,url/*Falta Imagen*/);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
            mUsuario.agregarImagenes(c,img,cantImg);
        } catch (Exception ex) {
            throw ex;
        }     
    }

    public DataUsuario infoCliente(String nickname) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        return mUsuario.encontrarUsuario(nickname).infoUsuario();
    }

    
    public String[] imagenesDelUsuario(String nombre) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        String[] a = mUsuario.imagenesUsuario(nombre);
     //JOptionPane.showConfirmDialog(null,a[0],a[0],JOptionPane.INFORMATION_MESSAGE);

        return a;
    }
    
      public Set<DataUsuario> listarClientes() {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        return mUsuario.listarClientes();    }

    public Set<DataUsuario> listarProveedores() {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        return mUsuario.listarProveedores();
    }
    
    public Set<DataPublicacion> listarPublicacionesProveedor(String nick)
    {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        Proveedor p = mUsuario.encontrarProveedor(nick);
        return p.listarPublicaciones();
    }
    
}
