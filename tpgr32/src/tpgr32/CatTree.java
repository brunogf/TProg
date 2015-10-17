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
 * @author Nico
 */

public class CatTree {
   private String cat_;
   private Set<CatTree> hijos_;


    public CatTree(String cat){
        cat_ = cat;
        hijos_ = new HashSet<CatTree>();
    }
    
    public void agregarHijo(CatTree ct)
    {
        hijos_.add(ct);
    }
    
    public Set<CatTree> getHijos()
    {
        return hijos_;
    }
    
    public boolean tieneHijos()
    {
        return !(hijos_.isEmpty());
    }
    
    public String nombre(){
        return cat_;
    }
}
