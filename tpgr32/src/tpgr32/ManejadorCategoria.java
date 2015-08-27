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
 * @author piñe
 */
public class ManejadorCategoria {
    
    private Map<String,Categoria> conjCategorias_;
    private static ManejadorCategoria instancia_ = null;
    
    
    public ManejadorCategoria(){
        conjCategorias_ = new HashMap<>();
    }
    
    static ManejadorCategoria getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorCategoria();
        }
        return instancia_;
    }
    
    public void agregarCategoria(String nombre){
       Categoria c = new Categoria(nombre); 
       conjCategorias_.put(c.getNombre(),c); 
    }
    
    public void agregarCategoria(String nombre, String padre){
        if (this.conjCategorias_.containsKey(padre)){
            Categoria p = encontrarCategoria(padre);
            Categoria c = new Categoria(nombre, p);
            conjCategorias_.put(c.getNombre(),c);
            p.agregarSubCategoria(c);
        }
        
    }
 
    public Categoria encontrarCategoria(String nombre){
        if (this.conjCategorias_.containsKey(nombre)) {
            return this.conjCategorias_.get(nombre);
        }
        else {
            throw new IllegalArgumentException("La categoría" + nombre + "no existe");
        }    
    }
    
    public boolean sinPadre(String nombre){
        if (this.conjCategorias_.containsKey(nombre)){
            return (this.conjCategorias_.get(nombre) == null);
        }
        else {
            throw new IllegalArgumentException("La categoría" + nombre + "no existe");
        }
    }
    
    
    
}
