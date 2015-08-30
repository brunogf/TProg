/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;

/**
 *
 * @author piñe
 */
public class Servicio extends Publicacion {
    
    private String descripcion_;
    private Image[] imagenes_;
    private float precio_;
    private Ciudad ciudadOrigen_;
    private Ciudad ciudadDestino_;
    
    public Servicio(){
        
    }
    
    public Servicio(String nombre, String descripcion, Image[] imagenes, float precio, Ciudad origen){
        super(nombre);
        this.descripcion_ = descripcion;
        this.imagenes_ = imagenes;
        this.precio_ = precio;
        this.ciudadOrigen_ = origen;
    }
    
    public Servicio(String nombre, String descripcion, Image[] imagenes, float precio, Ciudad origen,
                    Ciudad destino){
        super(nombre);
        this.descripcion_ = descripcion;
        this.imagenes_ = imagenes;
        this.precio_ = precio;
        this.ciudadOrigen_ = origen;
        this.ciudadDestino_ = destino;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion_ = descripcion;
    }
    
    public void setImagenes(Image[] imagenes){
        imagenes_ = imagenes;
    }
    
    public void setPrecio(float precio){
        this.precio_ = precio;
    }
            
    public String getDescripcion(){
        
        return descripcion_;
    }
    
    public Image[] getImagenes(){
        
        return imagenes_;
    }
    
    
    public float getPrecio(){
        
        return precio_;
    } 
    
    public DataServicio infoPublicacion(){
        DataServicio ds=new DataServicio(super.getNombre(), descripcion_, precio_, super.getProveedor().nombre);
        return ds;
    }
      
}
