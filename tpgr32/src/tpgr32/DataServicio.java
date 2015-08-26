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
public class DataServicio extends DataPublicacion {
    private String descripcion_;
    private float precio_;
    private String proveedor_;
    
    public DataServicio()
    {
	//default constructor
    }
    public DataServicio(String nombre, String descripcion, float precio, String proveedor)
    {
	super(nombre);
	descripcion_ = descripcion;
	precio_ = precio;
	proveedor_ = proveedor;
    }
    
    
    //getters
    
    public String getDescripcion()
    {
	return descripcion_;
    }
    
    public float getPrecio()
    {
	return precio_;
    }
    
    public String getProveedor()
    {
	return proveedor_;
    }
    
    //setters
    
    
    public void setDescripcion(String descripcion)
    {
	descripcion_ = descripcion;
    }
    
    public void setPrecio(float precio)
    {
	precio_ = precio;
    }
    
    public void setProveedor(String proveedor)
    {
	proveedor_ = proveedor;
    }
}
