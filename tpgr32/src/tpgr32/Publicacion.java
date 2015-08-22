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
public abstract class Publicacion {
    
    private String nombre_;
    private Set<ReservaPublicacion> rp_;
    
    public Publicacion(){
        
    }
    
    public Publicacion(String nombre){
        this.nombre_ = nombre;
        this.rp_ = new HashSet<>();
    }
    
    public void setNombre(String nombre){
        this.nombre_ = nombre;
    }
    
    public String getNombre(){
        return this.nombre_;
    }
}