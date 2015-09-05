/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author spesamosca
 */
public class Promocion extends Publicacion {
    
    private float descuento_;
    private float precioTotal_;
    private Set<Servicio> conjServicios_;
    public Promocion(){
        
    }
    
    public Promocion(String nombre, float descuento, Proveedor p){
        super(nombre,p);
        descuento_ = descuento;
        precioTotal_ = 0;
        conjServicios_ = new HashSet<>();
    }
    
    public void setDescuento(float descuento){
        descuento_ = descuento;
    }
        
    public void agregarServicioaPromocion(Servicio serv){
        conjServicios_.add(serv);
        precioTotal_ = precioTotal_ + (serv.getPrecio() * descuento_);      
    }
    
    public float getDescuento(){
        return descuento_;
    }
    
    public float getPrecioTotal(){
        return precioTotal_;
    }
    
    public Set<Servicio> getConjServicios(){
        return conjServicios_;
    }
    
    public DataPromocion infoPublicacion(){
        DataPromocion dp=new DataPromocion(super.getNombre(), descuento_, super.getProveedor().getNombre(), precioTotal_);
        for (Servicio s:conjServicios_){
            DataPublicacion ds=s.infoPublicacion();
            dp.agregarServicio(ds);
        }
        return dp;
    }
    
}
