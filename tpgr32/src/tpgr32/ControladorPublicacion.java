/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.awt.Image;
import java.util.HashSet;
/**
 *
 * @author piñe
 */
public class ControladorPublicacion implements IControladorPublicacion{
    
    private Servicio instServicio;
    private Promocion instPromocion;
    
    
  
    
    
    
    
    public ControladorPublicacion(){
    
    }
    
   public void agregarCategoriaServicio(String cat){
       
   }
   
   public void altaPromocion(String nombre, Set<DataServicio> servicios, float descuento){
       
   }
   
   public void altaServicio(String nombre, String descripcion,
           Set<Image> imagenes, float precio, Set<String> categorias,
           String proveedor, DataUbicacion origen, DataUbicacion destino){
       
   }
   
   public void eliminarCategoriaServicio(String cat){
       
   }
   
   public DataPromocion infoPromocion(String proveedor, String promo){
              return new DataPromocion(); 
   }
   
   public DataServicio infoServicio(String proveedor, String servicio){
       return new DataServicio();
   }
      
   
   public TreeCategoria listarCategorias(){
       return new TreeCategoria(); 
   }
   
   public Set<DataPromocion> listarPromociones(){
       return new HashSet<>(); 
   }
   
   public Set<DataServicio> listarServicios(){
       return new HashSet<>(); 
   }
   
   public Set<DataServicio> listarServiciosDeCategoria(String cat){
       return new HashSet<>();
   }
   
   public void modificarDescripcionServicio(String nuevaDescripcion){
       
   }
   
   public void modificarImagenesServicio(Set<Image> imagenes){
       
   }
   
   public void modificarOrigenServicio(String origen){
       
   }
   
   public void modificarPrecioServicio(float nuevo){
       
   }
   
   public void registrarCategoria(String nombre, String padre){
       
   }
   
   public void seleccionarServicio(String proveedor, String nombre){
       
   }
   
}
