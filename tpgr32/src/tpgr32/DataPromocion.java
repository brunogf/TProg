/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.util.*;

/**
 *
 * @author Nicolás Rostán
 */
public class DataPromocion extends DataPublicacion{
    private float descuento_;
    private float precioTotal_;
    private Set<DataServicio> servicios_;

    public DataPromocion(){}
    public DataPromocion(String nombre, float descuento)
    {
	super(nombre);
	descuento_ = descuento;
	precioTotal_ = 0;
	servicios_ = new HashSet<>();
    }
    
    public float getDescuento()
    {
	return descuento_;
    }
    
    public float getPrecioTotal()
    {
	return precioTotal_;
    }
    
    public Set<DataServicio> getServicios()
    {
	return servicios_;
    }
    
    public void setDescuento(float descuento)
    {
	descuento_ = descuento;
    }
    
    public void agregarServicio(DataServicio ds)
    {
	servicios_.add(ds);
    }
}
