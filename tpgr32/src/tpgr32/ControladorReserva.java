/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.HashSet;
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
       return new DataReserva();         
    }
    
    public Set<DataReserva> listarReservas(){
    return new HashSet<>(); 
    }
    
    public Set<DataReserva> listarReservasEliminables(){
	return new HashSet<>(); 
    }
    
    public void seleccionarCliente(String cliente){
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
	try
	{
	    cliente_ = mu.encontrarCliente(cliente);
	}catch(Exception ex)
	{
	    //ex.getMessage();
	    throw ex;
	}
    }
    
    public void seleccionarPublicacion(String nombre, String proveedor,
                                       int cantidad, Date inicio, Date fin){
	
	ManejadorUsuario mu = ManejadorUsuario.getInstance();
	Proveedor p;
	try
	{
	     p = mu.encontrarProveedor(proveedor);
	     Publicacion pub = p.encontrarPublicacion(nombre);
	     if (pub == null)
		 throw new IllegalArgumentException("No se encontro la publicacion");
	     DataDisponibilidad dd = new DataDisponibilidad(cantidad, inicio, fin);
	     boolean disponible = pub.disponible(dd);
	     if (disponible)
		 colPub_.add(pub);
	     else
		 throw new IllegalArgumentException("La publicacion no está disponible");	     
	}catch(Exception ex)
	{
	    //ex.getMessage();
	    throw ex;
	}
	
	
        
    }
}
