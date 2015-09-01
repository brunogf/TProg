/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nicolás Rostán
 */
public class Proveedor extends Usuario {
    private String nomEmpresa_;
    private String url_;
    private Map<String, Publicacion> publicaciones_;
    
    public Proveedor(String nom, String apellido, String nickName, String cElec, Date f,String empresa, String url)
    {
	super(nom,apellido,nickName,cElec,f);
	nomEmpresa_ = empresa;
	url_ = url;
    }
    
    public String getNombreEmpresa()
    {
	return nomEmpresa_;
    }
    
    public String getURL()
    {
	return url_;
    }
    
    public void setNombreEmpresa(String n)
    {
	nomEmpresa_ = n;
    }
    
    public void setURL(String u)
    {
	url_ = u;
    }
    
    public Publicacion encontrarPublicacion(String pub)
    {
	Publicacion p = publicaciones_.get(pub);
	return p;
    }
    
    @Override
     public DataUsuario infoUsuario() {
        return new DataProveedor(this.nickname,this.nombre,this.apellido,this.correoElec,this.fechaNacimiento,
        this.nomEmpresa_,this.url_);     
    }
     
     
    public void agregarPublicacion(Publicacion p){
        if (publicaciones_ == null)
            publicaciones_ = new HashMap<>();
        publicaciones_.put(p.getNombre(), p);
    }
    
    public DataServicio infoServicio(String nombre){
        Publicacion pub = publicaciones_.get(nombre);
	if (!(pub instanceof Servicio))
	    throw new IllegalArgumentException("No se encontro el servicio");
	Servicio ser = (Servicio)pub;
        DataServicio servicio = ser.infoPublicacion();
        return servicio;
    }
    
    public Set<DataPublicacion> listarPublicaciones()
    {
        Set<DataPublicacion> publicaciones = new HashSet<>();
        for(Map.Entry<String, Publicacion> entry : publicaciones_.entrySet())
        {
            publicaciones.add(entry.getValue().infoPublicacion());
        }
        return publicaciones;
    }
     
}
