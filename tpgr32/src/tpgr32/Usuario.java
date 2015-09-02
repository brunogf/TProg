/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
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
    protected String imagenes;
    protected Date fechaNacimiento;
    protected int cantImg;
    protected String listaImagenes[]; 
    public Usuario()//Default Constructor
    {
	
    }
      
    public Usuario(String nom, String apellido, String nickName, String cElec, Date f) {
        this.nombre = nom;
        this.listaImagenes = new String[3];
        this.cantImg = 0;
        this.apellido = apellido;
        this.nickname = nickName;
        this.correoElec = cElec;
	fechaNacimiento = f;
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
    
      public abstract DataUsuario infoUsuario();
      
    public void agregarImagen(String img) {       
        this.listaImagenes[this.cantImg] = img;        
        this.cantImg++;
    }
    
    public String[] ImgUsuario() {
        return this.listaImagenes;
    }
      
      
}
