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
 * @author Nicolás Rostán
 */
public abstract class DataUsuario {
    private String nickname_;
    private String nombre_;
    private String apellido_;
    private String correo_;
    private Date fecha_;
    private String img_;
    
    public DataUsuario(){}
    public DataUsuario(String nickname, String nombre, String apellido, String correo, Date fecha)
    {
	nickname_ = nickname;
	nombre_ = nombre;
	apellido_ = apellido;
	correo_ = correo;
	fecha_ = fecha;
    }
    public DataUsuario(String nickname, String nombre, String apellido, String correo, Date fecha, String img)
    {
	this(nickname, nombre, apellido, correo, fecha);//llama constructor anterior
	img_ = img;	
    }
    
    public String getNickname()
    {
	return nickname_;
    }
    
    public String getNombre()
    {
	return nombre_;
    }
    
    public String getApellido()
    {
	return apellido_;
    }
    
    public String getCorreo()
    {
	return correo_;
    }
    
    public Date getFecha()
    {
	return fecha_;
    }
    
    public String getImage()
    {
	return img_;
    }
    
    public void setNickname(String nick)
    {
	nickname_ = nick;
    }
    
    public void setNombre(String nombre)
    {
	nombre_ = nombre;
    }
    
    public void setApellido(String ap)
    {
	apellido_ = ap;
    }
    
    public void setCorreo(String c)
    {
	correo_ = c;
    }
    
    public void setFecha(Date f)
    {
	fecha_ = f;
    }
    
    public void setImage(String i)
    {
	img_ = i;
    }
    
     public String toString (){
        String mensaje= ""+this.nombre_+" "+this.apellido_;
        return mensaje;
    }
}
