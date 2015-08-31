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
    
    public void actualizarEstadoRegistrada(Estado e) throws Exception{
        if (this.estado_==Estado.Registrada){
            this.estado_=e;
        }
        else{
            throw new IllegalArgumentException("El estado de la reserva no es Registradao e");
        }
    }
    
    public void agregarReservaPublicacion(ReservaPublicacion rp){
	precio_total_ = precio_total_ + rp.getPrecioTotal();
        this.rp_.add(rp);
    }
    
    public Set<ReservaPublicacion> obtenerReservasPublicaciones(){
        return this.rp_;
    }
    
    public DataReserva infoReserva(){
        Set<ParDPD> conjDPD=new HashSet<>();
        for (ReservaPublicacion rp:rp_){
            ParDPD dpd=rp.infoReservaPublicacion();
            conjDPD.add(dpd);
        }
        DataReserva dr=new DataReserva(numero_, fecha_creacion_, estado_, 
            precio_total_, conjDPD);
        
        return dr;
    }
    
    public boolean esEliminable(){
        return true;
    }
    
    public void destroy(){
        Cliente c=this.cliente_;
        c.eliminarReserva(this);
        
        for (ReservaPublicacion rp:this.rp_){
            rp.destroy();
        }
    }
    //agregar Publicacion (servicio o promocion)
    
    
}