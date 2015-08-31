/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author piñe
 */
public class ControladorReserva implements IControladorReserva{
    
    private Cliente cliente_;
    private Set<ParPD> colPub_;
    private Proveedor proveedor_;
    
    
    
    public ControladorReserva(){
        colPub_=new HashSet<>();        
    }
    
    public void actualizarEstado(int nro, Estado estado) throws Exception{
        ManejadorReserva mr=ManejadorReserva.getInstance();
        Reserva r=mr.encontrarReserva(nro);
        r.actualizarEstadoRegistrada(estado);
    }
    
    public void bajaReserva(int nro){
        ManejadorReserva mr=ManejadorReserva.getInstance();
        Reserva r=mr.encontrarReserva(nro);
        
        r.destroy();
        //TO DO
    }
    
    public void confirmarReserva()
    {
        Reserva r = new Reserva(Estado.Registrada, cliente_);
	Iterator<ParPD> it = colPub_.iterator();
	ReservaPublicacion rp;
	ParPD par;
	while(it.hasNext())
	{
	     par = it.next();
	     rp = new ReservaPublicacion(r,par.getPublicacion(),par.getDisponibilidad());
	     //agrega la publicacion a la reserva
	     r.agregarReservaPublicacion(rp);
	     //agrega la reserva a la publicacion
	     par.getPublicacion().agregarReservaPublicacion(rp);
	}
	//agrega la reserva al cliente
	cliente_.agregarReserva(r);
	
	
	
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
    
    public void seleccionarPublicacion(String nombre,
                                       int cantidad, Date inicio, Date fin){
	
	try
        {
	     Publicacion pub = proveedor_.encontrarPublicacion(nombre);
	     if (pub == null)
		 throw new IllegalArgumentException("No se encontro la publicacion");
	     DataDisponibilidad dd = new DataDisponibilidad(cantidad, inicio, fin);
	     boolean disponible = pub.disponible(dd);
	     if (disponible)
		 colPub_.add(new ParPD(pub,dd));//Guarda el PAR de la publicaicon y su disponibilidad
	     else
		 throw new IllegalArgumentException("La publicacion no está disponible");	     
	}catch(Exception ex)
	{
	    //ex.getMessage();
	    throw ex;
	}               
    }
    public void seleccionarProveedor(String nickname)
    {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        proveedor_ = mu.encontrarProveedor(nickname);
    }
    
    public String getNickProveedorSeleccionado()
    {
        return proveedor_.getNickname();
    }
    
}
