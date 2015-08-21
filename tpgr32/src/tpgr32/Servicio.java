/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author piñe
 */
public class Servicio extends Publicacion {
    
    private String descripcion_;
    private String[] imagenes_;
    private float precio_;
    private Ciudad ciudadOrigen_;
    private Ciudad ciudadDestino_;
    
    public Servicio(){
        
    }
    
    public Servicio(String nombre, String descripcion, String[] imagenes, float precio, Ciudad origen){
        super(nombre);
        this.descripcion_ = descripcion;
        this.imagenes_ = imagenes;
        this.precio_ = precio;
        this.ciudadOrigen_ = origen;
    }
    
    public Servicio(String nombre, String descripcion, String[] imagenes, float precio, Ciudad origen,
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
    
    /*public void setImagenes(){
        
    }*/
    
    public void setPrecio(float precio){
        this.precio_ = precio;
    }
            
    public String getDescripcion(){
        
        return descripcion_;
    }
    
    public String[] getImagenes(){
        
        return imagenes_;
    }
    
    
    public float getPrecio(){
        
        return precio_;
    } 
    
    
    
}
