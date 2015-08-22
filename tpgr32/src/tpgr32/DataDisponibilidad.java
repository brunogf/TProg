/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;

/**
 *
 * @author piñe
 */
public class DataDisponibilidad {
    
    private int cant_;
    private Date fechaIni_;
    private Date fechaFin_;
    
    
    public DataDisponibilidad(){
        
    }
    
    
    public DataDisponibilidad(int cant, Date fechaIni, Date fechaFin){
        
        cant_ = cant;
        fechaIni_ = fechaIni;
        fechaFin_ = fechaFin;
        
    }
    
    
    public int getCant(){
        
        return cant_;
    }
    
    
    public Date getFechaIni(){
        
        return fechaIni_;
    }
    
    
    public Date getFechaFin(){
        
        return fechaFin_;
    }
    
    
    public void setCant(int cant){
        
        cant_ = cant;
    }
    
    
    public void setFechaIni(Date fechaIni){
        
        fechaIni_ = fechaIni;
    }
    
    
    public void setFechaFin(Date fechaFin){
        
        fechaFin_ = fechaFin;
    }
    
    
    
    
    
    
}
