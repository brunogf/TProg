/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author spesamosca
 */
public class Ciudad {
    
    private String nombre_;
    private Pais pais_; 
    private Set<Servicio> conjServicios_;
    
    public Ciudad(){
    
    }
    
    public Ciudad(String nombre, Pais p){
        nombre_ = nombre;
        pais_ = p;
        conjServicios_ = new HashSet<>();
    }
    
    public void setNombre(String nombre){
        nombre_ = nombre;
        
    }
    
    public void setPais(Pais p){
        pais_ = p;
    }
    
    public void agregarServicio(Servicio serv){
        conjServicios_.add(serv);
    }
    
    public String getNombre(){
        return nombre_;
    }
    
    public Pais getPais(){
        return pais_;
    }
    
    public Set<Servicio> getServicios(){
        return conjServicios_;
    }
}
