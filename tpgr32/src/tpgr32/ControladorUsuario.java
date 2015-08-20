/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;


public class ControladorUsuario {
        
    private ManejadorUsuario mUsuario;
    private String nick;
    public ControladorUsuario() {
        
    }
          
    public void registrarCliente(String nombre,String apellido,String nickName,String correoElec, Date f) {
        this.mUsuario = ManejadorUsuario.getInstance();
        this.nick = nickName;
        this.mUsuario.agregarCliente(nombre, apellido, nickName, correoElec, f);        
    }
    
    
    public void imprimirDatos() {
        String nombre = this.mUsuario.getUsuario(this.nick).getNombre();
	//deberia retornar datos, supongamos un DataUsuario, o DataCliente... - Nico
    }
    
}
