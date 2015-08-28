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
    
    public Pais encontrarPais(String nombre)
    {
        return conjPaises_.get(nombre);
    }
}
