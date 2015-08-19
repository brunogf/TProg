/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.awt.Image;
/**
 *
 * @author Nicolás Rostán
 */
public abstract class Usuario {
    private String nickname_;
    private String nombre_;
    private String apellido_;
    private String correo_;
    private Date fecha_nac_;
    private Image imagen_;
    
    public Usuario(String nick, String nombre, String apellido, String correo, Date fecha, Image img)
    {
	nickname_ = nick;
	nombre_ = nombre; 
	apellido_ = apellido;
	correo_ = correo;
	fecha_nac_ = fecha;
	imagen_ = img;
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
    
    public Date getFechaNac()
    {
	return fecha_nac_;
    }
    
    public Image getImagen()
    {
	return imagen_;
    }
}