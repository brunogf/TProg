/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
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
    
    static ManejadorUsuario getInstance() {
        if (mUsuario == null) {
            mUsuario = new ManejadorUsuario();
        }
        return mUsuario;
    }
    
    public void agregarUsuario(Usuario u) throws Exception {
        if (this.conjUsuarios.containsKey(u.getNickname())) {
            Exception e = new Exception("El nickName ingresado ya esta utilizado");
            throw e;
        }
        else {
            boolean existeCElec = false;
            Iterator it = this.conjUsuarios.keySet().iterator();
            while ((it.hasNext()) && (!existeCElec)) {
                String key = it.next().toString();
                if (u.getCorreoElectronico().equals(this.conjUsuarios.get(key).getCorreoElectronico())) {
                    existeCElec = true;
                }
            }
            
            if (!existeCElec) {
                 this.conjUsuarios.put(u.getNickname(), u);
            }
            else { 
                Exception e = new Exception("El Correo Electronico ingresado ya esta utilizado");
                throw e;               
            }
        }        
    }
    
    public Usuario encontrarUsuario(String nickName) {
        if (this.conjUsuarios.containsKey(nickName)) {
            //Exception e = new Exception("El nickName ingresado no existe");
            throw new IllegalArgumentException("no se encontro usuario");
        }
        else {
            return this.conjUsuarios.get(nickName);
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
    
}
