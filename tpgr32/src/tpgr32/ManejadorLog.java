/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author spesamosca
 */
public class ManejadorLog implements IObserver{
    private Map<Integer,DataLog> logs_;
    private Map<Integer,Servicio> topVisitados_;
    private static ManejadorLog instancia_ = null;
    
    
    public ManejadorLog(){
        logs_ = new HashMap<>();
        topVisitados_ = new HashMap<>();
    }
    
    static ManejadorLog getInstance(){
        if (instancia_ == null) {
            instancia_ = new ManejadorLog();
        }
        return instancia_;
    }
    
    public Map<Integer,DataLog> getLogs(){
        return logs_;
    }
    
    public Map<Integer,Servicio> getTopVisitados(){
        return topVisitados_;
    }
    
    public int getVisitasServicioMenosVisitado(){
        return topVisitados_.get(0).getVisitas();
    }
    
    public int getCantidadLogs(){
        return logs_.size();
    }
    
    public boolean servicioEnTopVisitados(String nombreServicio, String proveedorServicio){
        boolean servicioEnTop = false;
        Iterator it = topVisitados_.keySet().iterator();
        while (it.hasNext()){
            Servicio ser = (Servicio) it.next();
            String nombre = ser.getNombre();
            String prov = ser.getProveedor().getNombre();
            if ((nombre == nombreServicio) && (prov == proveedorServicio)){
                servicioEnTop = true;
            }
        }
        return servicioEnTop;
    }
    
    
    public void agregarLog(DataLog log){
        if (logs_.size() < 10000){            
            logs_.put(logs_.size(), log);
        }
    }
    
    public void agregarTopVisitado(Servicio serv){
        if (topVisitados_.size() == 10){
            topVisitados_.put(0,serv);
        }
        else{
            topVisitados_.put(9-topVisitados_.size(),serv);
            actualizar();
        }             
    }
    
    public void agregarVisitaATopVisitado(Servicio ser){
        Iterator it = topVisitados_.keySet().iterator();
        while (it.hasNext()){
            Servicio servi = (Servicio) it.next();
            if ((servi.getNombre() == ser.getNombre()) &&
               (servi.getProveedor().getNombre() == ser.getProveedor().getNombre())){
                servi.agregarVisita();
                actualizar();
            }                        
                        
        }
    }           
    
    
    public void actualizar(){
        Integer key = 0;
        Iterator it = topVisitados_.keySet().iterator();
        while (it.hasNext()){
            Servicio servi = (Servicio) it.next();
            if (key != 9){
                if (servi.getVisitas() > topVisitados_.get(key+1).getVisitas()){ 
                        topVisitados_.put(key,topVisitados_.get(key+1));
                        topVisitados_.put(key+1,servi);
                }
            }
            key++;
        }
    }
    
}
