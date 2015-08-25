/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author piñe
 */
public class ManejadorReserva {
    
    private Map<Integer,Reserva> conjReservas_;
    private static ManejadorReserva instancia_ = null;
    
    
    private ManejadorReserva() {
        //this.u = null;
    }
    
    
    static ManejadorReserva getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorReserva();
        }
        return instancia_;
    }
    
    public Reserva encontrarReserva(int nro){
        return conjReservas_.get(nro);
    }
    
    public Set<DataReserva> listarReservas(){
        return new HashSet<>();
    }
}
