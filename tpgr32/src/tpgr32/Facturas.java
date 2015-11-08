/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author Nico
 */
@Entity
public class Facturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(DATE)
    private Date fecha_generada;
    private int nro_reserva;
    private float monto_total;
    private String nick_cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getFechaGenerada(){
        return fecha_generada;
    }
    
    public void setFechaGenerada(Date f){
        fecha_generada = f;
    }
    public int getNroReserva(){
        return nro_reserva;
    }
    
    public void setNroReserva(int nro){
        nro_reserva = nro;
    }
    
    public float getMontoTotal(){
        return monto_total;
    }
    
    public void setMontoTotal(float f){
        monto_total = f;
    }
    public String getNickCliente(){
        return nick_cliente;
    }
    
    public void setNickCliente(String nick){
        nick_cliente = nick;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpgr32.Facturas[ id=" + id + " ]";
    }
    
}
