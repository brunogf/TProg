/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
/**
 *
 * @author Bruno González
 */
public class TreeCategoria {
   
    private String cat_;
    private TreeCategoria padre_;
    private Set<TreeCategoria> hijos_;
    
    public TreeCategoria(){}
    
    public TreeCategoria(String cat, TreeCategoria padre, Set<TreeCategoria> hijos){
        this.cat_=cat;
        this.padre_=padre;
        this.hijos_=hijos;
    }

    public String getCategoria() {
        return cat_;
    }

    public TreeCategoria getPadre() {
        return padre_;
    }

    public Set<TreeCategoria> getHijos() {
        return hijos_;
    }
    
}
