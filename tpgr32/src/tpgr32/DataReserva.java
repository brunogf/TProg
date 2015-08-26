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
    private Date creacion_;
    private Estado estado_;
    private float precio_total_;
    private Date ini_;
    private Date fin_;
    private Set<String> publicaciones_;
    
    public DataReserva(){
    }
    
    public DataReserva(int num, Date creacion, Estado estado, float total, Date ini, 
            Date fin, Set<String> pub){
        num_=num;
        creacion_=creacion;
        estado_=estado;
        ini_=ini;
        fin_=fin;
        precio_total_=total;
        publicaciones_=pub;
    }
    
    public int getNumero(){
        return this.num_;
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
    
    public void agregarPublicacion(String pub){
        publicaciones_.add(pub);
    }
}
