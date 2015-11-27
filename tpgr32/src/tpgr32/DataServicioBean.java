/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Nico
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataServicioBean extends DataPublicacion{

    private String descripcion_;
    private float precio_;
    private String paisOrigen_;
    private String ciudadOrigen_;
    private String paisDestino_;
    private String ciudadDestino_;
    private byte[][] imagenes_; 
    private String[] categorias_;
    private int cantVisitas_;
    
    public DataServicioBean(){
        
    }
    public DataServicioBean(String nombre, String descripcion, float precio, String proveedor,
                            String[] categorias, int cantVisitas, String paisO, String paisD, String ciudadO, String ciudadD){
        super(nombre, proveedor);
	descripcion_ = descripcion;
	precio_ = precio;
	categorias_= categorias;
        cantVisitas_ = cantVisitas;
        paisOrigen_ = paisO;
        paisDestino_ = paisD;
        ciudadOrigen_ = ciudadO;
        ciudadDestino_ = ciudadD;               
    }
    
    public void setImagenes(byte[][] imagenes){
        imagenes_ = imagenes;
    }
    
    public String getDescripcion(){
        return descripcion_;
    }
    
    public float getPrecio(){
        return precio_;
    }
    
    public String[] getCategorias(){
        return categorias_;
    }
    
    public byte[][] getImagenes(){
        return imagenes_;
    }
    
    public int getCantVisitas(){
        return cantVisitas_;
    }
        
    @Override
    public void setProveedor(String proveedor) {
        this.proveedor_ = proveedor;
    }
    
}
