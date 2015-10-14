/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author spesamosca
 */
public class Categoria {
    
    private String nombre_;
    private Map<String, Categoria> conjSubCategorias_;
    private Map<String, Servicio> conjServicios_;
    private Categoria padre_;
            
 //2 a 1       
    public Categoria(){
        
    }
    
    public Categoria(String nombre){    
        this.nombre_ = nombre;
        this.conjSubCategorias_ = new HashMap<>();
        this.conjServicios_ = new HashMap<>();
        this.padre_ = null;
        //a
    }
    
    public Categoria(String nombre, Categoria padre){
        this.nombre_ = nombre;
        this.padre_ = padre;
        this.conjSubCategorias_ = new HashMap<>();
        this.conjServicios_ = new HashMap<>();
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
    
    public Set<String> getConjSubCategoriasString(){
        Set<String> setCSC = new HashSet<>();
        Iterator it = conjSubCategorias_.keySet().iterator();
        while (it.hasNext()){
            setCSC.add(it.next().toString());
        }
        return setCSC;
    }
    
    public Set<String> getConjServiciosString(){
        Set<String> setCS = new HashSet<>();
        Iterator it = conjServicios_.keySet().iterator();
        while (it.hasNext()){
            setCS.add(it.next().toString());
        }
        return setCS;
    }
    
    public String getPadreString(){
        return this.padre_.getNombre();
    }
    
    
    public Categoria getPadre(){
        return this.padre_;
    }
    
    
    public Set<DataServicio> listarServicios(){
        Set<DataServicio> servicios = new HashSet<>();
        for(Servicio s: conjServicios_.values()){
            DataServicio servicio = (DataServicio)s.infoPublicacion();
            servicios.add(servicio);
        }
        
        return servicios;
        
    }
    
    public Set<DataServicio> listarServiciosCompleto(){
        Set<DataServicio> servicios = new HashSet<>();
        for(Servicio s: conjServicios_.values()){
            DataServicio servicio = (DataServicio)s.infoPublicacionCompleto();
            servicios.add(servicio);
        }
        
        return servicios;
    }
    
}

