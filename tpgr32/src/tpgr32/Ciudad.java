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
  
    
    public Ciudad(){
    
    }
    
    public Ciudad(String nombre){
        nombre_ = nombre;
    }
    
    public void setNombre(String nombre){
        nombre_ = nombre;
    }
    
    public String getNombre(){
        return nombre_;
    }
     
}
