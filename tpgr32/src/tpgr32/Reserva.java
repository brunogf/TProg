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
    private float precio_total_; //calculado
    private Cliente cliente_;
    private Set<ReservaPublicacion> rp_;
      
    
    public Reserva(Estado estado, Cliente cliente){
        this.numero_=id;
        this.fecha_creacion_=new Date();
        this.estado_=estado;
        this.precio_total_=0;//se calcula cada vez que se agrega una publicacion
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
    
    public Cliente getCliente(){
        return cliente_;
    }
    
    //setters
            
    public void setEstado(Estado e){
        this.estado_=e;
    }
    
    public void agregarReservaPublicacion(ReservaPublicacion rp){
	precio_total_ = precio_total_ + rp.getPrecioTotal();
        this.rp_.add(rp);
    }
    
    public Set<ReservaPublicacion> obtenerReservasPublicaciones(){
        return this.rp_;
    }
    
    public DataReserva infoReserva(){
        DataReserva dr=new DataReserva();
        Set<String> publicaciones=new HashSet<>();
        for (ReservaPublicacion rp:rp_){
            publicaciones.add(rp.getNombrePublicacion());
        }
        //para cada Publicacion asociada hay una fecha de inicio, fecha de fin y cant,
        //esto debería estar reflejado en DataReserva
        
        return dr;
    }
    
    public boolean esEliminable(){
        return true;
    }   
    //agregar Publicacion (servicio o promocion)
    
    
}
