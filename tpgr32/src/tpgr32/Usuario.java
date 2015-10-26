/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.awt.Image;
import java.util.Date;
/**
 *
 * @author esteban
 */
public abstract class Usuario {
    
    protected String nombre;
    protected String apellido;
    protected String nickname;
    protected String correoElec;
    protected Date fechaNacimiento;
    protected String imagen; 
    protected String password;
    public Usuario()//Default Constructor
    {
	
    }
      
    public Usuario(String nom, String apellido, String nickName, String cElec, Date fecha, String password) {
        this.nombre = nom;
        this.apellido = apellido;
        this.nickname = nickName;
        this.correoElec = cElec.toUpperCase();
	fechaNacimiento = fecha;
        this.password = password;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nom) {
        this.nombre = nom;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    public void setApellido(String ape) {
        this.apellido = ape;
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
    public void setCorreoElectronico(String correo) {
        this.correoElec = correo;
    }
    
      public abstract DataUsuario infoUsuario();
      
    public void cambiarImagen(String img) {       
        imagen = img;
    }
    
    public String getImgUsuario() {
        return imagen;
    }
      
    
    public boolean comprobarPassword(String pass){
            if (pass.compareTo(password) == 0)
                return true;
            else
                return false;
    }
}
