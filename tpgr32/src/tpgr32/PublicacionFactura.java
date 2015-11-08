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
public class PublicacionFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipo;
    private String nombre;
    private int cant;
    private float precio;
    private String nick_proveedor;
    private Facturas factura;
    
    @Temporal(DATE)
    private Date f_ini;
    @Temporal(DATE)
    private Date f_fin;
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tpo){
        tipo = tpo;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nmbr){
        nombre = nmbr;
    }
    
    public int getCant(){
        return cant;
    }
    
    public void setCant(int cantidad){
        cant = cantidad;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float prc){
        precio = prc;
    }
    
    public String getNickProveedor(){
        return nick_proveedor;
    }
    
    public void setNickProveedor(String nick){
        nick_proveedor = nick;
    }
    
    public Facturas getFactura(){
        return factura;
    }
    
    public void setFactura(Facturas fct){
        factura = fct;
    }
    
    public Date getFechaInicio(){
        return f_ini;
    }
    
    public void setFechaInicio(Date fecha){
         f_ini = fecha;
    }
    
    public Date getFechaFin(){
        return f_fin;
    }
    
    public void setFechaFin(Date fecha){
         f_fin = fecha;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof PublicacionFactura)) {
            return false;
        }
        PublicacionFactura other = (PublicacionFactura) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpgr32.PublicacionFactura[ id=" + id + " ]";
    }
    
}
