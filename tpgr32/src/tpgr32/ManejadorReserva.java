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
public class ManejadorReserva {
    
    private Map<Integer,Usuario> conjReservas_;
    private static ManejadorReserva instancia_ = null;
    
    
    private ManejadorReserva() {
        //this.u = null;
      conjReservas_ = new HashMap<>();
    }
    
    
    static ManejadorReserva getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorReserva();
        }
        return instancia_;
    }
}
