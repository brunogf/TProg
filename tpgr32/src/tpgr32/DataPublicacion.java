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
public abstract class DataPublicacion {
    private String nombre_;
    private String proveedor_;
    
    public DataPublicacion()
    {
	//default constructor
    }
    
    public DataPublicacion(String nombre, String proveedor)
    {
	nombre_ = nombre;
        proveedor_=proveedor; 
    }
    
    public String getNombre()
    {
	return nombre_;
    }
    
    public void setNombre(String nombre)
    {
	nombre_ = nombre;
    }
    
    public String getProveedor(){
        return proveedor_;
    }
    
    public void setProveedor(String proveedor){
        this.proveedor_=proveedor;
    }
}
