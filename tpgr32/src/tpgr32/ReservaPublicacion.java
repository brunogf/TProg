/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;

/**
 *
 * @author spesamosca
 */
public class ReservaPublicacion {
    
    private Date fechaIni_;
    private Date fechaFin_;
    private int cant_;
    private Publicacion pub_;
    private Reserva res_;
    
    
    public ReservaPublicacion()
    {
	//default constructor
    }
    
    public ReservaPublicacion(Reserva r, Publicacion p, Date inicio, Date fin, int cant)
    {
	res_ = r;
        pub_ = p;
        fechaIni_ = inicio;
        fechaFin_ = fin;
        cant_ = cant;
    }
    
    public ReservaPublicacion(Reserva r, Publicacion p, DataDisponibilidad d)
    {
	this(r,p,d.getFechaIni(),d.getFechaFin(),d.getCant());
    }

    public Date getFechaIni() {
        return fechaIni_;
    }

    public Date getFechaFin() {
        return fechaFin_;
    }
    
    public String getNombrePublicacion(){
        return pub_.getNombre();
    }
    
    public float getPrecioTotal()
    {
	if (pub_ instanceof Servicio)
            return (((Servicio)pub_).getPrecio() * cant_);
        else
            return (((Promocion)pub_).getPrecioTotal() * cant_); 
    }
    
    public ParDPD infoReservaPublicacion(){
        DataDisponibilidad d=new DataDisponibilidad(cant_, fechaIni_, fechaFin_);
        DataPublicacion dp=pub_.infoPublicacion();
        
        ParDPD dpd=new ParDPD(dp, d);
        return dpd;
    }
    
    public void destroy(){
        this.pub_.eliminarReservaPublicacion(this);
        this.res_=null;        
    }

     public int getCant () {
        return this.cant_;
    }
}


