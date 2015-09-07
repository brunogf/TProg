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
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author piñe
 */
public class ManejadorPais {
    
    private Map<String, Pais> conjPaises_;
    private static ManejadorPais instancia_ = null;
    
    
    public ManejadorPais(){
        conjPaises_ = new HashMap<>();
    }
    
    
    static ManejadorPais getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorPais();
        }
        return instancia_;
    }
    
    
    public void agregarPais(Pais p)
    {
        conjPaises_.put(p.getNombre(), p);
    }
    
    
    public Pais encontrarPais(String nombre){
        if (this.conjPaises_.containsKey(nombre)) {
            return this.conjPaises_.get(nombre);
        }
        else {
            return null;
        }    
    }
    
    public Set<String> listarPaises()
    {
        Set<String> r;
        r = new HashSet<>();
        Entry thisE;
        for(Iterator it = conjPaises_.entrySet().iterator();it.hasNext();)
        {
             thisE = (Entry) it.next();
             r.add((String)thisE.getKey());
        }
        return r;
    }
}
