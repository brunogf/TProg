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
public class Pais {
    
    private String nombre_;
    private Set<Ciudad> ciudades_;
    
    
    public Pais(){
        
    }
    
    public Pais(String nombre){
        nombre_ = nombre;
        ciudades_ = new HashSet<>();
    }
    
    public void setNombre(String nombre){
        nombre_ = nombre;
    }
    
    public void agregarCiudadAPais(Ciudad c){
        ciudades_.add(c);
    }
    
    public String getNombre(){
        return nombre_;
    }
    
    public  Set<Ciudad> getCiudades(){
        return ciudades_;
    }
}


