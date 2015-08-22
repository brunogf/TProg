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
    private static int id=1;
    
    private int numero_; 
    private Date fecha_creacion_; 
    private Estado estado_;
    private float precio_total_;
    private Cliente cliente_;
    private Set<ReservaPublicacion> rp_;
    
    
    public Reserva(Estado estado, float precio_total, Cliente cliente){
        this.numero_=id;
        this.fecha_creacion_=new Date();
        this.estado_=estado;
        this.precio_total_=precio_total;
        this.cliente_=cliente;
        this.rp_=new HashSet<>();
        
        id++;
    }
    
    //getters
    
    public int getNumero(){
        return numero_;
    }
    
    public Estado getEstado(){
        return estado_;
    }
    
    public Date getFechaCreacion(){
        return fecha_creacion_;
    }
    
    public float getPrecioTotal(){
        return precio_total_;
    }
    
    //setters
    
    public void setEstado(Estado e){
        this.estado_=e;
    }
    
    public void agregarReservaPublicacion(ReservaPublicacion rp){
        this.rp_.add(rp);
    }
    
    public Set<ReservaPublicacion> obtenerReservasPublicaciones(){
        return this.rp_;
    }
    
    //agregar Publicacion (servicio o promocion)
    
    
}
