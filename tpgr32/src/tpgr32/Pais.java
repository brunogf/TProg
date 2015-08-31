/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author spesamosca
 */
public class Pais {
    
    private String nombre_;
    private Map<String,Ciudad> ciudades_;
    
    
    public Pais(){
        
    }
    
    public Pais(String nombre){
        nombre_ = nombre;
        ciudades_ = new HashMap<>();
    }
    
    public void setNombre(String nombre){
        nombre_ = nombre;
    }
    
    public void agregarCiudadAPais(Ciudad c){
        ciudades_.put(c.getNombre(),c);
    }
    
    public String getNombre(){
        return nombre_;
    }
    
    public  Map<String,Ciudad> getCiudades(){
        return ciudades_;
    }
    
    public Ciudad encontrarCiudad(String nombre){
        if (this.ciudades_.containsKey(nombre)) {
            return this.ciudades_.get(nombre);
        }
        else {
            throw new IllegalArgumentException("La ciudad " + nombre + " no existe");
        }    
    }
    
    public Set<String> listarCiudades(){
       Set<String> ciudades = new HashSet<>();
       for(Ciudad c: ciudades_.values()){
           ciudades.add(c.getNombre());
       }
       return ciudades;
    }
}


