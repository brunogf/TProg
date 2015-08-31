/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author spesamosca
 */
public abstract class Publicacion {
    
    private String nombre_;
    private Usuario proveedor_;
    private Set<ReservaPublicacion> rp_;
    private Proveedor proveedor_;
    
    public Publicacion(){
         
    }
    
    
    public Publicacion(String nombre, Proveedor p){
        this.nombre_ = nombre;
        this.rp_ = new HashSet<>();
        this.proveedor_ = p;
    }
    
    public void setNombre(String nombre){
        this.nombre_ = nombre;
    }
    
    public String getNombre(){
        return this.nombre_;
    }
    
    public Usuario getProveedor(){
        return proveedor_;
    }
    
    public boolean disponible(DataDisponibilidad dd)
    {
	
	//Cuando esta disponible la Publicacion?
	return true;
    }
    
    public void agregarReservaPublicacion(ReservaPublicacion rp)
    {
	rp_.add(rp);
    }
    
    public Proveedor getProveedor(){
        return proveedor_;
    }
    public void eliminarReservaPublicacion(ReservaPublicacion rp){
        this.rp_.remove(rp);
    }
    
    public abstract DataPublicacion infoPublicacion();

}
