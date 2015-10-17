/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nicolás Rostán
 */
public class DataServicio extends DataPublicacion {
    private String descripcion_;
    private float precio_;
    private String paisOrigen_;
    private String ciudadOrigen_;
    private String paisDestino_;
    private String ciudadDestino_;
    private Set<Image> imagenes_; 
    private Set<String> categorias_;
    
    public DataServicio()
    {
	//default constructor
    }
    public DataServicio(String nombre, String descripcion, float precio, String proveedor, Set<String> categorias)
    {
	super(nombre, proveedor);
	descripcion_ = descripcion;
	precio_ = precio;
	categorias_= categorias;
    }
    
    
    public DataServicio(String nombre, String descripcion, float precio, String proveedor, String paisOrigen,
                        String ciudadOrigen, String paisDestino, String ciudadDestino, Set<Image> imagenes, Set<String> categorias)
    {
	super(nombre, proveedor);
	descripcion_ = descripcion;
	precio_ = precio;
        paisOrigen_ = paisOrigen;
        ciudadOrigen_ = ciudadOrigen;
        paisDestino_ = paisDestino;
        ciudadDestino_ = ciudadDestino;
        imagenes_ = new HashSet<>();
        imagenes_ = imagenes;
        categorias_ = categorias;
    }
    
    
    
    //getters
    
    public String getDescripcion()
    {
	return descripcion_;
    }
    
    public float getPrecio()
    {
	return precio_;
    }
    
    public String getPaisOrigen(){
        return paisOrigen_;
    }
    
    public String getCiudadOrigen(){
        return ciudadOrigen_;
    }
    
    public String getPaisDestino(){
        return paisDestino_;
    }
    
    public String getCiudadDestino(){
        return ciudadDestino_;
    }
    
    public Set<Image> getImagenes(){
        return imagenes_;
    }
    
    
    
    //setters
    
    
    public void setDescripcion(String descripcion)
    {
	descripcion_ = descripcion;
    }
    
    public void setPrecio(float precio)
    {
	precio_ = precio;
    }
    
    public Set<String> getCategorias()
    {
        return categorias_;
    }
    
}
