/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//import java.util.Iterator;

public class ManejadorUsuario {
    
    private Map<String,Usuario> conjUsuarios;
    private static ManejadorUsuario mUsuario = null;   
    //private Usuario u;
    
    private ManejadorUsuario() {
        //this.u = null;
      conjUsuarios = new HashMap<String,Usuario>();
    }
    
    static ManejadorUsuario getInstance() {
        if (mUsuario == null) {
            mUsuario = new ManejadorUsuario();
        }
        return mUsuario;
    }
    
    public void agregarCliente(String nom, String apellido, String nickName, String cElec, Date f) {
        Usuario u = new Cliente(nom,apellido,nickName,cElec,f);
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
        
        //No puede listar directamente, deberia retornar un set(DataUsuario) - Nico
        
    }
   
    
    
}
