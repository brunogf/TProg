/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.awt.Image;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author spesamosca
 */

public interface IControladorPublicacion {
    
    void agregarCategoriaServicio(String cat);
    void altaPromocion(String nombre, String proveedor, Set<DataServicio> servicios, float descuento);
    void altaServicio(String nombre, String descripcion, Set<Image> img, float precio,
        Set <String> categorias, String proveedor, DataUbicacion origen, DataUbicacion destino);
    void altaServicio(String nombre, String descripcion, Set<Image> imagenes, float precio, Set<String>categorias,
                          String proveedor, DataUbicacion origen);
    void eliminarCategoriaServicio(String cat);
    DataPromocion infoPromocion(String proveedor, String promo);
    DataServicio infoServicio(String proveedor, String servicio);
    DefaultTreeModel listarCategorias();
    Set<DataPromocion> listarPromociones();
    Set<DataServicio> listarServicios();
    Set<DataServicio> listarServiciosDeCategoria(String cat);
    void modificarDescripcionServicio(String des);
    void modificarImagenesServicio(Set<Image> imgs);
    void modificarPrecioServicio(float precio);
    void eliminarDestinoServicio();
    void registrarCategoria(String nombre);
    void registrarCategoria(String nombre, String padre);
    void seleccionarServicio(String proveedor, String nombre);    
    Set<String> listarPaises();
    Set<String> listarCiudades(String pais);
    void altaPais(String nombre);
    void altaCiudad(String pais, String nombre);
    Set<DataPublicacion> listarPublicaciones();
    Set<DataServicio> listarServicioDeCategoriaCompleto(String cat);
    public void modificarOrigenServicio(String pais, String ciudad);
    public void modificarDestinoServicio(String pais, String ciudad);
}
