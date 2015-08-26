/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author Nicolás Rostán
 */

public class ParPD {
    private final Publicacion pub_;
    private final DataDisponibilidad d_;
    
    
    public ParPD(Publicacion p, DataDisponibilidad d)
    {
	pub_ = p;
	d_ = d;
    }
    
    public Publicacion getPublicacion()
    {
	return pub_;
    }
    
    public DataDisponibilidad getDisponibilidad()
    {
	return d_;
    }
    
}
