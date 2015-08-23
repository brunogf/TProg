/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
    
    public void agregarUsuario(String nickName,Usuario u) {
        this.conjUsuarios.put(nickName, u);
    }
    
    public Usuario getUsuario(String nickName) {
        /*if (this.conjUsuarios.containsKey(nickName)) {
            
        }
        else {
            return this.conjUsuarios.get(nickName);
        }*/
        return this.conjUsuarios.get(nickName);
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
    
}
