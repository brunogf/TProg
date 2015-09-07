/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.awt.Image;
import java.util.HashSet;
import java.util.Iterator;
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
   
   public void altaPromocion(String nombre,String proveedor, Set<DataServicio> servicios, float descuento){
       ManejadorUsuario mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       Publicacion publ = p.encontrarPublicacion(nombre);
       if ((publ != null) && (publ instanceof Promocion))
           throw new IllegalArgumentException("Proveedor ya tiene Promocion con nombre "+nombre);
       else{
            instPromocion = new Promocion(nombre, descuento, p);
            Iterator<DataServicio> it = servicios.iterator();
            while (it.hasNext()){
                 DataServicio dataS = it.next();
                 Publicacion pub = mu.encontrarProveedor(proveedor).encontrarPublicacion(dataS.getNombre());
                 Servicio ser = (Servicio) pub;   
                 instPromocion.agregarServicioaPromocion(ser);
            }
            p.agregarPublicacion(instPromocion);
       }
   }
   
 
   
   // ALTA SERVICO CON DESTINO
   public void altaServicio(String nombre, String descripcion,
                          Set<Image> imagenes, float precio, Set<String>categorias,
                          String proveedor, DataUbicacion origen, DataUbicacion destino){
       
       ManejadorUsuario mu;
       mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       Publicacion pub = p.encontrarPublicacion(nombre);
       if ((pub != null) && (pub instanceof Servicio))
           throw new IllegalArgumentException("Proveedor ya tiene Servicio con nombre "+nombre);
       else{
         Servicio serv = new Servicio(nombre,descripcion,imagenes,precio,categorias,origen, destino,p);
         p.agregarPublicacion(serv);
       }
   }
   
  
   // ALTA SERVICIO SIN DESTINO 
   public void altaServicio(String nombre, String descripcion,
                          Set<Image> imagenes, float precio, Set<String>categorias,
                          String proveedor, DataUbicacion origen){
       
       ManejadorUsuario mu;
       mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       Publicacion pub = p.encontrarPublicacion(nombre);
       if ((pub != null) && (pub instanceof Servicio))
           throw new IllegalArgumentException("Proveedor ya tiene Servicio con nombre "+nombre);
       else{
         Servicio serv = new Servicio(nombre,descripcion,imagenes,precio,categorias,origen,p);
         p.agregarPublicacion(serv);
       }
   }
   
   public void eliminarCategoriaServicio(String cat){
       
   }
   
   public DataPromocion infoPromocion(String proveedor, String promo){
              ManejadorUsuario mu = ManejadorUsuario.getInstance();
              Proveedor prov = mu.encontrarProveedor(proveedor);
              return prov.infoPromocion(promo);
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
       Set<DataPromocion> setPromo = new HashSet<>();
       ManejadorUsuario mu = ManejadorUsuario.getInstance();
       Set<DataUsuario> setProv = mu.listarProveedores();
       Iterator itProv = setProv.iterator();
       while (itProv.hasNext()){
           DataProveedor dataProv = (DataProveedor) itProv.next();
           Set<DataPublicacion> setPub = dataProv.getPublicaciones();
           Iterator itPub = setPub.iterator();
           while (itPub.hasNext()){
               DataPublicacion dataPub = (DataPublicacion) itPub.next();
               if (dataPub instanceof DataPromocion){
                   setPromo.add((DataPromocion) dataPub);
               }
           }
       }
       return setPromo;
   }
   
   public Set<DataServicio> listarServicios(){
       Set<DataServicio> setS = new HashSet<>();
       ManejadorUsuario mu = ManejadorUsuario.getInstance();
       Set<DataUsuario> setProv = mu.listarProveedores();
       Iterator itProv = setProv.iterator();
       while (itProv.hasNext()){
           DataProveedor dataProv = (DataProveedor) itProv.next();
           Set<DataPublicacion> setPub = dataProv.getPublicaciones();
           Iterator itPub = setPub.iterator();
           while (itPub.hasNext()){
               DataPublicacion dataPub = (DataPublicacion) itPub.next();
               if (dataPub instanceof DataServicio){
                   setS.add((DataServicio) dataPub);
               }
           }
       }
       return setS;
   }
   
   public Set<DataServicio> listarServiciosDeCategoria(String cat){
       ManejadorCategoria mc = ManejadorCategoria.getInstance();
       Categoria c = mc.encontrarCategoria(cat);
       Set<DataServicio> servicios = c.listarServicios();
       return servicios;
   }
   
   public void modificarDescripcionServicio(String nuevaDescripcion){
       instServicio.setDescripcion(nuevaDescripcion);
   }
   
   public void modificarImagenesServicio(Set<Image> imagenes){
       instServicio.setImagenes(imagenes);
   }
   
   public void eliminarDestinoServicio()
   {
       instServicio.eliminarDestino();
   }
   
   public void modificarPrecioServicio(float nuevo){
       instServicio.setPrecio(nuevo);
   }
   
   public void modificarOrigenServicio(String pais, String ciudad)          
   {
       ManejadorPais mp = ManejadorPais.getInstance();
       instServicio.setCiudadOrigen(mp.encontrarPais(pais).encontrarCiudad(ciudad));
   }
   
   public void modificarDestinoServicio(String pais, String ciudad)
   {
        ManejadorPais mp = ManejadorPais.getInstance();
       instServicio.setCiudadDestino(mp.encontrarPais(pais).encontrarCiudad(ciudad));
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
       ManejadorUsuario mu = ManejadorUsuario.getInstance();
       Proveedor p = mu.encontrarProveedor(proveedor);
       Publicacion pub = p.encontrarPublicacion(nombre);
       if (pub instanceof Servicio)
           instServicio = (Servicio)pub;
       else
           throw new IllegalArgumentException("La publicacion encontrada no es un servicio");
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
       ManejadorPais mp = ManejadorPais.getInstance();
       Pais p = mp.encontrarPais(nombre);
       if (p == null)
       {
           p = new Pais(nombre);
           mp.agregarPais(p);
       }
       else
           throw new IllegalArgumentException();
       
       
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
   
   public Set<DataServicio> listarServicioDeCategoriaCompleto(String cat){
       ManejadorCategoria mc = ManejadorCategoria.getInstance();
       Categoria c = mc.encontrarCategoria(cat);
       Set<DataServicio> servicios = c.listarServiciosCompleto();
       return servicios;
   }

    private Exception IllegalArgumentException(String la_publicacion_encontrada_no_es_un_servic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
