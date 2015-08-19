/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;
import java.util.HashMap;
import java.util.Map;
//import java.util.Iterator;

public class ManejadorUsuario {
    
    private Map<String,Usuario> conjUsuarios = new HashMap<String,Usuario>();
    private static ManejadorUsuario mUsuario = null;   
    //private Usuario u;
    
    private ManejadorUsuario() {
        //this.u = null;
    
    }
    
    static ManejadorUsuario getInstance() {
        if (mUsuario == null) {
            mUsuario = new ManejadorUsuario();
        }
        return mUsuario;
    }
    
    public void agregarUsuario(String nom, String apellido, String nickName, String cElec) {
        Usuario u = new Usuario(nom,apellido,nickName,cElec);
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
    
    public void listarUsuarios() {
        
        for(String key : this.conjUsuarios.keySet()) {
            Usuario usuario = this.conjUsuarios.get(key);
            usuario.imprimirUsuario();
        }
        
    }
   
    
    
}
