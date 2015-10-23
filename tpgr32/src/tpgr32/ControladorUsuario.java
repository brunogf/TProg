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

    private String nick;

    public ControladorUsuario() {

    }

    public void altaCliente(String nickName, String nombre, String apellido, String correoElec,
            Date f, String pass) throws Exception {
        try {
            Cliente c = new Cliente(nombre, apellido, nickName, correoElec, f, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
        } catch (IllegalArgumentException ia) {
            throw ia;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void altaClienteConImg(String nickname, String nombre, String apellido, String correo,
            Date fnac, String img, String pass) throws Exception {
        try {
            Cliente c = new Cliente(nombre, apellido, nickname, correo, fnac, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
            c.cambiarImagen(img);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void altaProveedor(String nickname, String nombre,
            String apellido, String correo, Date fecha,
            String nombreEmp, String url, String pass) throws Exception {
        try {
            Proveedor c = new Proveedor(nombre, apellido, nickname, correo, fecha, nombreEmp, url, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void altaProveedorConImg(String nickname, String nombre, String apellido, String correo,
            Date fnac, String nombreEmp, String url, String img, String pass) throws Exception {

        try {
            Proveedor c = new Proveedor(nombre, apellido, nickname, correo, fnac, nombreEmp, url, img, pass);
            ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
            mUsuario.agregarUsuario(c);
            c.cambiarImagen(img);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public DataUsuario infoCliente(String nickname) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        DataUsuario du = mUsuario.encontrarUsuario(nickname).infoUsuario();
        if (!(du instanceof DataCliente)) {
            throw new IllegalArgumentException("No se encontro el usuario");
        }
        return du;
    }
    
    public DataUsuario infoProveedor(String nickname) {
        ManejadorUsuario mUsuario = ManejadorUsuario.getInstance();
        DataUsuario du = mUsuario.encontrarUsuario(nickname).infoUsuario();
        if (!(du instanceof DataProveedor)) {
            throw new IllegalArgumentException("No se encontro el proveedor");
        }
        return du;
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
        Proveedor p = mUsuario.encontrarProveedor(nick);
        return p.listarPublicaciones();
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
