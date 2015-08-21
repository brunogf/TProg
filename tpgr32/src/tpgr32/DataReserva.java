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
    private int cantidad_;
    private Date ini_;
    private Date fin_;
    private float precio_total_;
    private Set<String> publicaciones_;
    
    public DataReserva(){
    }
    
    public DataReserva(int cant, Date ini, Date fin, float total, Set<String> pub){
        cantidad_=cant;
        ini_=ini;
        fin_=fin;
        precio_total_=total;
        publicaciones_=pub;
    }
    
    public int getCantidad(){
        return this.cantidad_;
    }
    
    public Date getFechaIni(){
        return this.ini_;
    }
    
    public Date getFechaFin(){
        return this.fin_;
    }
    
    public Set<String> getPublicaciones(){
        return this.publicaciones_;
    }
}
