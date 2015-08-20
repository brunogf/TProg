/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.util.*;

/**
 *
 * @author bruno
 */
public class Reserva {
    int numero_; 
    Date fecha_creacion_; 
    Estado estado_;
    float precio_total_;
    Cliente cliente_;
    //tipo asociativo reservapublicacion
    //coleccion de publicaciones
    
    
    public Reserva(Estado estado, float precio_total){
        this.numero_=Integer.parseInt(UUID.randomUUID().toString());//id autogenerado
        this.fecha_creacion_=new Date();
        this.estado_=estado;
        this.precio_total_=precio_total;
    }
    
    //getters
    
    public int getNumero(){
        return this.numero_;
    }
    
    public Estado getEstado(){
        return this.estado_;
    }
    
    public Date getFechaCreacion(){
        return this.fecha_creacion_;
    }
    
    public float getPrecioTotal(){
        return this.precio_total_;
    }
    
    //setters
    
    public void setEstado(Estado e){
        this.estado_=e;
    }
    
    //agregar Publicacion (servicio o promocion)
    
    
}

