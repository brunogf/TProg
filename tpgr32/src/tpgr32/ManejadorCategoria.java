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
    
    private Map<String,Usuario> conjCategorias_;
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
    
}
