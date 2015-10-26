/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;

public class ControladorUsuario implements IControladorUsuario {


    public ControladorUsuario() {

    }

    public void altaCliente(String nickName, String nombre, String apellido, String correoElec,
            Date fecha, String pass) throws Exception {
        try {
            Cliente cli = new Cliente(nombre, apellido, nickName, correoElec, fecha, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(cli);
        } catch (IllegalArgumentException ia) {
            throw ia;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void altaClienteConImg(String nickname, String nombre, String apellido, String correo,
            Date fnac, String img, String pass) throws Exception {
        try {
            Cliente cli = new Cliente(nombre, apellido, nickname, correo, fnac, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(cli);
            cli.cambiarImagen(img);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void altaProveedor(String nickname, String nombre,
            String apellido, String correo, Date fecha,
            String nombreEmp, String url, String pass) throws Exception {
        try {
            Proveedor prov = new Proveedor(nombre, apellido, nickname, correo, fecha, nombreEmp, url, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(prov);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void altaProveedorConImg(String nickname, String nombre, String apellido, String correo,
            Date fnac, String nombreEmp, String url, String img, String pass) throws Exception {

        try {
            Proveedor prov = new Proveedor(nombre, apellido, nickname, correo, fnac, nombreEmp, url, img, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(prov);
            prov.cambiarImagen(img);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public DataUsuario infoCliente(String nickname) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        DataUsuario dtu = mUsuario.encontrarUsuario(nickname).infoUsuario();
        if (!(dtu instanceof DataCliente)) {
            throw new IllegalArgumentException("No se encontro el usuario");
        }
        return dtu;
    }
    
    public DataUsuario infoProveedor(String nickname) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        DataUsuario dtu = mUsuario.encontrarUsuario(nickname).infoUsuario();
        if (!(dtu instanceof DataProveedor)) {
            throw new IllegalArgumentException("No se encontro el proveedor");
        }
        return dtu;
    }

    public Image getImagenDelUsuario(String nombre) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(mUsuario.encontrarUsuario(nombre).getImgUsuario()));
        }catch(Exception ex){
        }
        return img;
    }

    public Set<DataUsuario> listarClientes() {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        return mUsuario.listarClientes();
    }

    public Set<DataUsuario> listarProveedores() {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        return mUsuario.listarProveedores();
    }

    public Set<DataPublicacion> listarPublicacionesProveedor(String nick) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        Proveedor prov = mUsuario.encontrarProveedor(nick);
        return prov.listarPublicaciones();
    }

    public int comprobarUsuario(String usuario, String password) {
        return ManejadorUsuario.getInstance().comprobarUsuario(usuario, password);
    }

    public String getNickUsuario(String usuario) {
        return ManejadorUsuario.getInstance().getNickUsuario(usuario);
    }
    
    public DataUsuario infoUsuario(String nickname)
    {
        DataUsuario info;
        try{
            info = infoCliente(nickname);
        }catch(Exception e)
        {
            info = infoProveedor(nickname);
        }
        return info;
    }
    
    public boolean existeMail(String email)
    {
        ManejadorUsuario manejador_usuario = ManejadorUsuario.getInstance();
        Set<DataUsuario> usuarios = manejador_usuario.listarClientes();
        Iterator itr = usuarios.iterator();
        boolean encontrado = false;
        while ((itr.hasNext())&&(!encontrado))
        {
            if ((((DataUsuario)itr.next()).getCorreo().toUpperCase()).equals(email.toUpperCase()))
                encontrado = true;
        }
        if(!encontrado){
            usuarios = manejador_usuario.listarProveedores();
            itr = usuarios.iterator();
            while ((itr.hasNext())&&(!encontrado))
            {
                if ((((DataUsuario)itr.next()).getCorreo().toUpperCase()).equals(email.toUpperCase()))
                    encontrado = true;
            }   
        }
        return encontrado;
        
    }
}
