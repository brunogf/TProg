/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author spesamosca
 */
public class Ciudad {
    
    private String nombre_;
    private Pais pais_; 
    
    public Ciudad(){
    
    }
    
    public Ciudad(String nombre, Pais p){
        nombre_ = nombre;
        pais_ = p;
    }
    
    public void setNombre(String nombre){
        nombre_ = nombre;
        
    }
    
    public void setPais(Pais p){
        pais_ = p;
    }
    
    
    public String getNombre(){
        return nombre_;
    }
    
    public Pais getPais(){
        return pais_;
    }
     
}
