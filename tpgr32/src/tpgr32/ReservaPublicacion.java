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
	//FALTA IMPLEMENTAR
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
	return 0; //DEBERIA RETORNA EL PRECIO CALCULADO DE LA PUBLICACION x CANTIDAD
    }

}
