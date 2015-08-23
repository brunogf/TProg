/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author piñe
 */
public class ControladorReserva implements IControladorReserva{
    
    private Cliente cliente_;
    private Set<Publicacion> colPub_;
    
    
    
    public ControladorReserva(){
        
    }
    
    public void actualizarEstado(int nro, Estado estado){
        
    }
    
    public void bajaReserva(int nro){
        
    }
    
    public void confirmarReserva(){
        
    }
    
    public DataReserva infoReserva(int nro){
        
    }
    
    public Set<DataReserva> listarReservas(){
        
    }
    
    public Set<DataReserva> listarReservasEliminables(){
        
    }
    
    public void seleccionarCliente(String cliente){
        
    }
    
    public void seleccionarPublicacion(String nombre, String proveedor,
                                       int cantidad, Date inicio, Date fin){
        
    }
}
