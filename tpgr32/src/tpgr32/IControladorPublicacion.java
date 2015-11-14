/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.awt.Image;
import java.util.Map;
import java.util.Stack;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author spesamosca
 */

public interface IControladorPublicacion {

    public void agregarCategoriaServicio(String cat);
    public void altaPromocion(String nombre, String proveedor, Set<DataServicio> servicios, float descuento);
    public void altaServicio(String nombre, String descripcion, Set<Image> img, float precio, Set <String> categorias, String proveedor, DataUbicacion origen, DataUbicacion destino);
    public void altaServicio(String nombre, String descripcion, Set<Image> imagenes, float precio, Set<String>categorias, String proveedor, DataUbicacion origen);
    public void eliminarCategoriaServicio(String cat);
    public DataPromocion infoPromocion(String proveedor, String promo);
    public DataServicio infoServicio(String proveedor, String servicio);
    public DefaultTreeModel listarCategorias();
    public Set<DataCategoria> listarDataCategorias();
    public DataCategoria encontrarDataCategoria(String nombre);
    public Set<DataPromocion> listarPromociones();
    public Set<DataServicio> listarServicios();
    public Set<DataServicio> listarServiciosDeCategoria(String cat);
    public void modificarDescripcionServicio(String des);
    public void modificarImagenesServicio(Set<Image> imgs);
    public void modificarPrecioServicio(float precio);
    public void eliminarDestinoServicio();
    public void registrarCategoria(String nombre);
    public void registrarCategoria(String nombre, String padre);
    public void seleccionarServicio(String proveedor, String nombre);
    public Set<String> listarPaises();
    public Set<String> listarCiudades(String pais);
    public void altaPais(String nombre);
    public void altaCiudad(String pais, String nombre);
    public Set<DataPublicacion> listarPublicaciones();
    public Set<DataServicio> listarServicioDeCategoriaCompleto(String cat);
    public void modificarOrigenServicio(String pais, String ciudad);
    public void modificarDestinoServicio(String pais, String ciudad);
    public Set<DataPublicacion> buscarPublicacion(String criterio);
    public Set<DataPublicacion> buscarPublicacionCompleta(String criterio);
    public CatTree getCatTree();
    public void agregarLog(DataLog log, String nombre, String proveedor); 
    public Map<Integer, DataServicio> listarTopServicios();
    public Stack<DataLog> listarLogs();
}
