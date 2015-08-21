/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.*;

/**
 *
 * @author Nicolás Rostán
 */
public class DataProveedor extends DataUsuario{
    private String nombre_empresa_;
    private String url_;
    private Set<DataPublicacion> publicaciones_;
    
    public DataProveedor(){}
    public DataProveedor(String nickname, String nombre, String apellido, String correo, Date fecha, String nombreEmp, String url)
    {
	super(nickname, nombre, apellido, correo, fecha);
	nombre_empresa_ = nombreEmp;
	url_ = url;
	publicaciones_ = new HashSet<>();
    }
    public DataProveedor(String nickname, String nombre, String apellido, String correo, Date fecha, String nombreEmp, String url, Image img)
    {
	super(nickname, nombre, apellido, correo, fecha,img);
	nombre_empresa_ = nombreEmp;
	url_ = url;	
	publicaciones_ = new HashSet<>();
    }
    
    public String getEmpresa()
    {
	return nombre_empresa_;
    }
    
    public String getURL()
    {
	return url_;
    }
    
    public Set<DataPublicacion> getPublicaciones()
    {
	return publicaciones_;
    }
    
    public void setEmpresa(String nombre)
    {
	nombre_empresa_ = nombre;
    }
    
    public void setURL(String u)
    {
	url_ = u;
    }
    
    public void agregarPublicacion(DataPublicacion dp)
    {
	publicaciones_.add(dp);
    }
}
