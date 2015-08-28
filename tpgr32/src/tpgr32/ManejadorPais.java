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
 * @author piñe
 */
public class ManejadorPais {
    
    private Set<Pais> conjPaises_;
    private static ManejadorPais instancia_ = null;
    
    
    public ManejadorPais(){
        conjPaises_ = new HashSet<>();
    }
    
    
    static ManejadorPais getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorPais();
        }
        return instancia_;
    }
    
    public void agregarPais(Pais p)
    {
        conjPaises_.add(p);
    }
}
