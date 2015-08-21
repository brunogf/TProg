/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author spesamosca
 */
public class Promocion extends Publicacion {
    
    private float descuento_;
    private float precioTotal_;
    private Map<String, Servicio> conjServicios_;
    
    public Promocion(){
        
    }
    
    public Promocion(String nombre, float descuento){
        super(nombre);
        descuento_ = descuento;
        precioTotal_ = 0;
        conjServicios_ = new HashMap<>();
    }
    
    public void setDescuento(float descuento){
        descuento_ = descuento;
    }
    
    
    public void agregarServicioaPromocion(Servicio serv){
        conjServicios_.put(serv.getNombre(), serv);
        precioTotal_ = precioTotal_ + serv.getPrecio();      
    }
    
    public float getDescuento(){
        return descuento_;
    }
    
    public float getPrecioTotal(){
        return precioTotal_;
    }
    
    public Map<String, Servicio> getConjServicios(){
        return conjServicios_;
    }
    
    
}
