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
public class DataReserva {
    private int num_;
    private String cliente_;
    private Date creacion_;
    private Estado estado_;
    private float precio_total_;
    private Set<ParDPD> dpd_;   
    
    public DataReserva(){
    }

    public DataReserva(int num_, Date creacion_, Estado estado_, float precio_total_, Set<ParDPD> dpd_, String cliente) {
        this.num_ = num_;
        this.creacion_ = creacion_;
        this.estado_ = estado_;
        this.precio_total_ = precio_total_;
        this.dpd_ = dpd_;
        cliente_ = cliente;
    }

    public int getNum() {
        return num_;
    }

    public Date getCreacion() {
        return creacion_;
    }

    public Estado getEstado() {
        return estado_;
    }

    public float getPrecio_total() {
        return precio_total_;
    }

    public Set<ParDPD> getdpd(){
        return dpd_;
    }
    
    public void agregarParDPD(ParDPD dpd){
        dpd_.add(dpd);
    }
    
    public String getCliente(){
        return cliente_;
    }
    
    public String getStringEstado()
    {
        String est = "";
        if (estado_ == Estado.Registrada)
            est = "Registrada";
        else if (estado_ == Estado.Cancelada)
            est = "Cancelada";
        else if (estado_ == Estado.Pagada)
            est = "Pagada";
        else
            est = "Facturada";
        return est;
    }
   public String toString (){
        String mensaje= "Reserva numero "+this.num_+" ";
        return mensaje;
    } 
}
