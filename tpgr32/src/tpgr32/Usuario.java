/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author esteban
 */
public class Usuario {
    
    protected String nombre;
    protected String apellido;
    protected String nickname;
    protected String correoElec;
    protected String imagenes;
      
    public Usuario(String nom, String apellido, String nickName, String cElec) {
        this.nombre = nom;
        this.apellido = apellido;
        this.nickname = nickName;
        this.correoElec = cElec;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    public void setApellido(String a) {
        this.apellido = a;
    }
    
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickN) {
        this.nickname = nickN;
    }
    
    public String getCorreoElectronico() {
        return this.correoElec;
    }
    public void setCorreoElectronico(String ce) {
        this.correoElec = ce;
    }
    
 
   
}
