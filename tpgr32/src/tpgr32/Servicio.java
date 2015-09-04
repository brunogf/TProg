/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author piñe
 */
public class Servicio extends Publicacion {
    
    private String descripcion_;
    private Set<Image> imagenes_;
    private float precio_;
    private Ciudad ciudadOrigen_;
    private Ciudad ciudadDestino_;
    private Map<String,Categoria> categorias_;
    
    public Servicio(){
        
    }
    
    public Servicio(String nombre, String descripcion, Set<Image> imagenes, float precio, Ciudad origen, Proveedor p){
        super(nombre,p);
        this.descripcion_ = descripcion;
        this.imagenes_ = imagenes;
        this.precio_ = precio;
        this.ciudadOrigen_ = origen;
    }
    
    
    //CONSTRUCTOR CON DESTINO
    public Servicio(String nombre, String descripcion, Set<Image> imagenes, float precio, Set<String> categorias, DataUbicacion origen,
            DataUbicacion destino, Proveedor p){
       super(nombre,p);
       this.descripcion_ = descripcion;
       this.imagenes_ = imagenes;
       this.precio_ = precio;
       this.categorias_ = new HashMap<>();
       
       ManejadorCategoria mc;
       mc = ManejadorCategoria.getInstance();
       
       
       for(String cat: categorias){
           Categoria c;
           c = mc.encontrarCategoria(cat);
           categorias_.put(cat, c);
           
           c.agregarServicio(this); 
       }
       
       ManejadorPais mp;
       mp = ManejadorPais.getInstance();
       
       Pais porigen = mp.encontrarPais(origen.getPais());
       Ciudad corigen = porigen.encontrarCiudad(origen.getCiudad());
       
       Pais pdestino = mp.encontrarPais(destino.getPais());
       Ciudad cdestino = pdestino.encontrarCiudad(destino.getCiudad());
       
       ciudadOrigen_ = corigen;
       ciudadDestino_ = cdestino;
    }
    
    
    // CONSTRUCTOR SIN DESTINO
    public Servicio(String nombre, String descripcion, Set<Image> imagenes, float precio, Set<String> categorias, DataUbicacion origen, Proveedor p){
       super(nombre,p);
       this.descripcion_ = descripcion;
       this.imagenes_ = imagenes;
       this.precio_ = precio;
       this.categorias_ = new HashMap<>();
       
       ManejadorCategoria mc;
       mc = ManejadorCategoria.getInstance();
       
       
       ManejadorPais mp;
       mp = ManejadorPais.getInstance();
       
       Pais porigen = mp.encontrarPais(origen.getPais());
       Ciudad corigen = porigen.encontrarCiudad(origen.getCiudad());
       
       ciudadOrigen_ = corigen;
       
       for(String cat: categorias){
           Categoria c;
           c = mc.encontrarCategoria(cat);
           categorias_.put(cat, c);
           
           c.agregarServicio(this); 
       } 
    }
    
    
    public void setDescripcion(String descripcion){
        this.descripcion_ = descripcion;
    }
    
    public void setImagenes(Set<Image> imagenes){
        imagenes_ = imagenes;
    }
    
    public void setPrecio(float precio){
        this.precio_ = precio;
    }
            
    public String getDescripcion(){
        
        return descripcion_;
    }
    
    public Set<Image> getImagenes(){
        
        return imagenes_;
    }
    
    
    public float getPrecio(){
        
        return precio_;
    } 
    
    
    public DataPublicacion infoPublicacion(){
        DataPublicacion servicio = new DataServicio(this.getNombre(),descripcion_,precio_,this.getProveedor().getNombre());
        return servicio;
    }
    
    
    public DataPublicacion infoPublicacionCompleto(){
        DataPublicacion servicio = new DataServicio(this.getNombre(),descripcion_,precio_,this.getProveedor().getNombre()+" "+this.getProveedor().getApellido()+" (nickname: "+this.getProveedor().getNickname()+")");
        return servicio;
    }
    
    
}
