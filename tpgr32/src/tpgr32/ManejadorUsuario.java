/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.awt.Image;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.IOException;

//import java.util.Iterator;

public class ManejadorUsuario {
    
    private Map<String,Usuario> conjUsuarios;
    private static ManejadorUsuario mUsuario = null;   
    //private Usuario u;
    
    private ManejadorUsuario() {
        //this.u = null;
      conjUsuarios = new HashMap<>();
    }
    
    static public ManejadorUsuario getInstance() {
        if (mUsuario == null) {
            mUsuario = new ManejadorUsuario();
        }
        return mUsuario;
    }
    
    public void agregarUsuario(Usuario u) throws Exception {
        if (this.conjUsuarios.containsKey(u.getNickname().toUpperCase())) {
            Exception e = new IllegalArgumentException("El nickName ingresado ya existe en el Sistema");
            throw e;
        }
        else {
            boolean existeCElec = false;
            Iterator it = this.conjUsuarios.keySet().iterator();
            while ((it.hasNext()) && (!existeCElec)) {
                String key = it.next().toString();
                if (u.getCorreoElectronico().equals(this.conjUsuarios.get(key).getCorreoElectronico().toUpperCase())) {
                    existeCElec = true;
                }
            }
            
            if (!existeCElec) {
                 this.conjUsuarios.put(u.getNickname().toUpperCase(), u);
            }
            else { 
                Exception e = new IllegalArgumentException("El Correo Electrónico ingresado ya existe en el Sistema");
                throw e;               
            }
        }        
    }
    
    
    public String getImagenUsuario(String nombre) {
        return this.encontrarUsuario(nombre).getImgUsuario();
    }

    
    
    
    public Usuario encontrarUsuario(String nickName) {
        if (!this.conjUsuarios.containsKey(nickName.toUpperCase())) {
            
            throw new IllegalArgumentException("No se encontró usuario");
        }
        else {
            return this.conjUsuarios.get(nickName.toUpperCase());
        }
        //return this.conjUsuarios.get(nickName);
    }
    
    public Map<String,Usuario> getUsuarios() {
        return this.conjUsuarios;
    }
    
    public Set<DataUsuario> listarClientes() {
        
        Set<DataUsuario> conjDtUsuario = new HashSet<>();
        for(String key : this.conjUsuarios.keySet()) {
            Usuario usuario = this.conjUsuarios.get(key);
            if (usuario instanceof Cliente) {
                conjDtUsuario.add(usuario.infoUsuario());
            }
        }
        return conjDtUsuario;
    }
   
    public Set<DataUsuario> listarProveedores() {
        
        Set<DataUsuario> conjDtProveedores = new HashSet<>();
        for(String key : this.conjUsuarios.keySet()) {
            Usuario usuario = this.conjUsuarios.get(key);
            if (usuario instanceof Proveedor) {
                conjDtProveedores.add(usuario.infoUsuario());
            }
        }
        return conjDtProveedores;
    }
    
    public Cliente encontrarCliente(String cliente)
    {
	Usuario usr = encontrarUsuario(cliente);
	if (!(usr instanceof Cliente))//SI O SI ANTES DE HACER DOWNCAST HACER CHECKEO QUE ES ESA CLASE!
	    throw new IllegalArgumentException("No se encontro el cliente");
	return (Cliente) usr;
    }
    
    public Proveedor encontrarProveedor(String proveedor)
    {
	Usuario usr = encontrarUsuario(proveedor);
	if (!(usr instanceof Proveedor))//SI O SI ANTES DE HACER DOWNCAST HACER CHECKEO QUE ES ESA CLASE!
	    throw new IllegalArgumentException("No se encontro el proveedor");
	return (Proveedor) usr;
    }
    
    public Usuario encontrarUsuarioViaMail(String mail)
    {
        Usuario usr = null;
        for(Map.Entry<String, Usuario> e : conjUsuarios.entrySet())
        {
            if (e.getValue().getCorreoElectronico().compareTo(mail.toUpperCase()) == 0)
                usr = e.getValue();
        }
        return usr;
    }
    
    public String getNickUsuario(String usuario)
    {
        try{
            Usuario usr = encontrarUsuario(usuario);
            return usr.getNickname();
        }catch(IllegalArgumentException ex)
        {
            Usuario usre = this.encontrarUsuarioViaMail(usuario);
            if (usre != null)
                return usre.getNickname();
            else
                return null;
        }
    }
    
    public int comprobarUsuario(String usuario, String password)
    {
        String nick = this.getNickUsuario(usuario);
        if (nick != null)
        {
            if (this.encontrarUsuario(nick).comprobarPassword(password))
                return 0;//OK
            else
                return 2;//ERROR PASSWORD
        }
        else
            return 1;//ERROR NICK
    }
}
