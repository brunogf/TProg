/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;


import java.util.Set;

/**
 *
 * @author spesamosca
 */
public class DataCategoria {
    private String nombre_;
    private Set<String> conjSubCategorias_;
    private Set<String> conjServicios_;
    private String padre_;
    
    public DataCategoria(){}
 
    public DataCategoria(String nombre, Set<String> SubCategorias, Set<String> Servicios, String padre){
        nombre_ = nombre;
        conjSubCategorias_ = SubCategorias;
        conjServicios_ = Servicios;
        padre_ = padre;
    }
    
    public String getNombre(){
        return nombre_;
    }
    
    public Set<String> getSubCategorias(){
        return conjSubCategorias_;
    }
    
    public Set<String> getConjServicios(){
        return conjServicios_;
    }
    
    public String getPadre(){
        return padre_;
    }
}
