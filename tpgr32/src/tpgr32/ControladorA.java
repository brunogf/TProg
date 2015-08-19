/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;


public class ControladorA {
        
    private ManejadorUsuario mUsuario;
    private String nick;
        
    public ControladorA() {
        
    }
          
    public void registrarCliente(String nombre,String apellido,String nickName,String correoElec) {
        this.mUsuario = ManejadorUsuario.getInstance();
        this.nick = nickName;
        this.mUsuario.agregarUsuario(nombre, apellido, nickName, correoElec);        
    }
    
    public void imprimirDatos() {
        String nombre = this.mUsuario.getUsuario(this.nick).getNombre();
	//deberia retornar datos, supongamos un DataUsuario, o DataCliente... - Nico
    }
    
}
