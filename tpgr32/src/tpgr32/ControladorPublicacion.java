/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.awt.Image;
import java.util.HashSet;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author piñe
 */
public class ControladorPublicacion implements IControladorPublicacion{
    
    private Servicio instServicio;
    private Promocion instPromocion;
    private ManejadorCategoria mCategoria;
   
    // comiste
   public ControladorPublicacion(){
    
   } 
    
   public void agregarCategoriaServicio(String cat){
       
   }
   
   public void altaPromocion(String nombre, Set<DataServicio> servicios, float descuento){
       
   }
   
 
   
   // ALTA SERVICO CON DESTINO
   public void altaServicio(String nombre, String descripcion,
                          Set<Image> imagenes, float precio, Set<String>categorias,
                          String proveedor, DataUbicacion origen, DataUbicacion destino){
       
       ManejadorUsuario mu;
       mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       Servicio serv = new Servicio(nombre,descripcion,imagenes,precio,categorias,origen, destino,p);
       p.agregarPublicacion(serv);
   }
   
  
   // ALTA SERVICIO SIN DESTINO 
   public void altaServicio(String nombre, String descripcion,
                          Set<Image> imagenes, float precio, Set<String>categorias,
                          String proveedor, DataUbicacion origen){
       
       ManejadorUsuario mu;
       mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       Servicio serv = new Servicio(nombre,descripcion,imagenes,precio,categorias,origen,p);
       p.agregarPublicacion(serv);
   }
   
   public void eliminarCategoriaServicio(String cat){
       
   }
   
   public DataPromocion infoPromocion(String proveedor, String promo){
              return new DataPromocion(); 
   }
   
   public DataServicio infoServicio(String proveedor, String servicio){
       ManejadorUsuario mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       DataServicio ser = p.infoServicio(servicio);
       return ser;
   }
      
   
   public DefaultTreeModel listarCategorias(){
       mCategoria = ManejadorCategoria.getInstance();
       return mCategoria.crearArbolCategorias();
   }
   
   public Set<DataPromocion> listarPromociones(){
       return new HashSet<>(); 
   }
   
   public Set<DataServicio> listarServicios(){
       return new HashSet<>(); 
   }
   
   public Set<DataServicio> listarServiciosDeCategoria(String cat){
       ManejadorCategoria mc = ManejadorCategoria.getInstance();
       Categoria c = mc.encontrarCategoria(cat);
       Set<DataServicio> servicios = c.listarServicios();
       return servicios;
   }
   
   public void modificarDescripcionServicio(String nuevaDescripcion){
       
   }
   
   public void modificarImagenesServicio(Set<Image> imagenes){
       
   }
   
   public void modificarOrigenServicio(String origen){
       
   }
   
   public void modificarPrecioServicio(float nuevo){
       
   }
   
   public void registrarCategoria(String nombre){
       mCategoria = ManejadorCategoria.getInstance();
       mCategoria.agregarCategoria(nombre);
   }
   
   public void registrarCategoria(String nombre, String padre){
       mCategoria = ManejadorCategoria.getInstance();
       mCategoria.agregarCategoria(nombre, padre);
   }
   
   public void seleccionarServicio(String proveedor, String nombre){
       
   }
   
   
   public Set<String> listarPaises()
   {
       ManejadorPais mp = ManejadorPais.getInstance();
       return mp.listarPaises();
   }
   
   public Set<String> listarCiudades(String pais){
       ManejadorPais mp = ManejadorPais.getInstance();
       Pais p = mp.encontrarPais(pais);
       Set<String> ciudades = p.listarCiudades();
       return ciudades;
   }
   
   public void altaPais(String nombre)
   {
       Pais p = new Pais(nombre);
       ManejadorPais mp = ManejadorPais.getInstance();
       mp.agregarPais(p);
   }
   
   public void altaCiudad(String pais, String nombre)
   {
       ManejadorPais mp = ManejadorPais.getInstance();
       Pais p = mp.encontrarPais(pais);
       Ciudad c = new Ciudad(nombre,p);
       p.agregarCiudadAPais(c);
   }
   
   
   public Set<DataPublicacion> listarPublicaciones()
   {
       Set<DataPromocion> promociones = this.listarPromociones();
       Set<DataServicio> servicios = this.listarServicios();
       Set<DataPublicacion> publicaciones = new HashSet<>();
       for(DataPromocion p : promociones)
           publicaciones.add(p);
       for (DataServicio s : servicios)
           publicaciones.add(s);
       return publicaciones;
   }
}
