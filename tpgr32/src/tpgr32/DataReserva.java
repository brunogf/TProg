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
    private String publicacion_;
    
    public DataReserva(){
    }
    
    public DataReserva(int cant, Date ini, Date fin, String pub){
        cantidad_=cant;
        ini_=ini;
        fin_=fin;
        publicacion_=pub;
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
    
    public String getNombrePublicacion(){
        return this.publicacion_;
    }
}
