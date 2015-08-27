/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spesamosca
 */
public class Categoria {
    
    private String nombre_;
    private Map<String, Categoria> conjSubCategorias_;
    private Map<String, Servicio> conjServicios_;
    private Categoria padre_;
    private int nivel_;
            
        
    public Categoria(){
        
    }
    
    public Categoria(String nombre){    
        this.nombre_ = nombre;
        this.conjSubCategorias_ = new HashMap<>();
        this.conjServicios_ = new HashMap<>();
        this.padre_ = null;
        this.nivel_ = 0;
    }
    
    public Categoria(String nombre, Categoria padre){
        this.nombre_ = nombre;
        this.padre_ = padre;
        this.conjSubCategorias_ = new HashMap<>();
        this.conjServicios_ = new HashMap<>();
        this.nivel_ = this.padre_.getNivel() + 1;
    }
    
    public void setNombre(String nombre){
        this.nombre_ = nombre;
    }
    
    
    public void agregarSubCategoria(Categoria Cat){
        this.conjSubCategorias_.put(Cat.getNombre(), Cat);       
    }
    
    public void agregarServicio(Servicio Ser)
    {
        this.conjServicios_.put(Ser.getNombre(), Ser);
    }
    
    public void setPadre(Categoria padre){
        this.padre_ = padre;
    }
    
    public String getNombre(){
        return this.nombre_;
    }
    
    public Map<String, Categoria> getConjSubCategorias(){
        return this.conjSubCategorias_;
    }
    
    public Map<String, Servicio> getConjServicios(){
        return this.conjServicios_;
    }
    
    public Categoria getPadre(){
        return this.padre_;
    }
    
    public int getNivel(){
        return nivel_;
    }
    
}

