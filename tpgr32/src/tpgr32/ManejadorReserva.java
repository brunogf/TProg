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
import java.util.Iterator;

/**
 *
 * @author piñe
 */
public class ManejadorReserva {
    
    private Map<Integer,Reserva> conjReservas_;
    private static ManejadorReserva instancia_ = null;
    
    
    private ManejadorReserva() {
        //this.u = null;
        conjReservas_=new HashMap<>();
    }
    
    
    static ManejadorReserva getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorReserva();
        }
        return instancia_;
    }
    
    public void agregarReserva(Reserva r){
        conjReservas_.put(r.getNumero(), r);
    }
    
    public Reserva encontrarReserva(int nro){
        return conjReservas_.get(nro);
    }
    
    public Set<DataReserva> listarReservas(){
        Iterator<Reserva> it=conjReservas_.values().iterator();
        Set<DataReserva> lista=new HashSet<>();
        DataReserva dr;
        while (it.hasNext()){
            Reserva r=it.next();
            dr=r.infoReserva();
            lista.add(dr);
        }
        return lista;
    }
    
}
