/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author spesamosca
 */
public class ManejadorLog implements IObserver{
    private LinkedList<DataLog> logs_;
    private Map<Integer,Servicio> topVisitados_;
    private static ManejadorLog instancia_ = null;
    
    
    public ManejadorLog(){
        logs_ = new LinkedList();
        topVisitados_ = new HashMap<>();
    }
    
    static ManejadorLog getInstance(){
        if (instancia_ == null) {
            instancia_ = new ManejadorLog();
        }
        return instancia_;
    }
    
    public LinkedList<DataLog> getLogs(){
        return logs_;
    }
    
    public Map<Integer,Servicio> getTopVisitados(){
        return topVisitados_;
    }
    
    public int getVisitasServicioMenosVisitado(){
        int visitas = 0;
        if (topVisitados_.containsKey(0)){
            visitas = topVisitados_.get(0).getVisitas();
        }
        return visitas;
    }
    
    public int getCantidadLogs(){
        return logs_.size();
    }
    
    public boolean servicioEnTopVisitados(String nombreServicio, String proveedorServicio){
        boolean servicioEnTop = false;
        int k = 9;
        while (topVisitados_.containsKey(k) && k>=0){
            Servicio ser = topVisitados_.get(k);
            String nombre = ser.getNombre();
            String prov = ser.getProveedor().getNombre();
            if ((nombreServicio.equals(nombre)) && (proveedorServicio).equals(prov)){
                servicioEnTop = true;
            }
            k--;
        }
        return servicioEnTop;
    }
    
    
    public void agregarLog(DataLog log){
        if (logs_.size() < 10000){            
            logs_.addFirst(log);
        }
        else{
            logs_.removeLast();
            logs_.add(log);
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
        int k = 9;
        while (topVisitados_.containsKey(k) && k>=0){
            Servicio servi = (Servicio) topVisitados_.get(k);
            if ((servi.getNombre() == ser.getNombre()) &&
               (servi.getProveedor().getNombre() == ser.getProveedor().getNombre())){
                servi.agregarVisita();
                actualizar();
            }                        
            k--;           
        }
    }           
    
    
    public void actualizar(){
        int k = 0;
        while (k<=9){
            if (topVisitados_.containsKey(k)){           
                Servicio servi = topVisitados_.get(k);
                if (k != 9){
                    if (servi.getVisitas() > topVisitados_.get(k+1).getVisitas()){ 
                            topVisitados_.put(k,topVisitados_.get(k+1));
                            topVisitados_.put(k+1,servi);
                    }
                }
            }
            k++;
        }      
    }
    
}
