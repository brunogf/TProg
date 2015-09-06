/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.Set;
import javax.swing.tree.DefaultTreeModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piñe
 */
public class IControladorPublicacionTest {
    
    public IControladorPublicacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of agregarCategoriaServicio method, of class IControladorPublicacion.
     */
    //TESTS
    
    
    
    
    

    public class IControladorPublicacionImpl implements IControladorPublicacion {

        public void agregarCategoriaServicio(String cat) {
        }

        public void altaPromocion(String nombre, String proveedor, Set<DataServicio> servicios, float descuento) {
        }

        public void altaServicio(String nombre, String descripcion, Set<Image> img, float precio, Set<String> categorias, String proveedor, DataUbicacion origen, DataUbicacion destino) {
        }

        public void altaServicio(String nombre, String descripcion, Set<Image> imagenes, float precio, Set<String> categorias, String proveedor, DataUbicacion origen) {
        }

        public void eliminarCategoriaServicio(String cat) {
        }

        public DataPromocion infoPromocion(String proveedor, String promo) {
            return null;
        }

        public DataServicio infoServicio(String proveedor, String servicio) {
            return null;
        }

        public DefaultTreeModel listarCategorias() {
            return null;
        }

        public Set<DataPromocion> listarPromociones() {
            return null;
        }

        public Set<DataServicio> listarServicios() {
            return null;
        }

        public Set<DataServicio> listarServiciosDeCategoria(String cat) {
            return null;
        }

        public void modificarDescripcionServicio(String des) {
        }

        public void modificarImagenesServicio(Set<Image> imgs) {
        }

        public void modificarPrecioServicio(float precio) {
        }

        public void eliminarDestinoServicio() {
        }

        public void registrarCategoria(String nombre) {
        }

        public void registrarCategoria(String nombre, String padre) {
        }

        public void seleccionarServicio(String proveedor, String nombre) {
        }

        public Set<String> listarPaises() {
            return null;
        }

        public Set<String> listarCiudades(String pais) {
            return null;
        }

        public void altaPais(String nombre) {
        }

        public void altaCiudad(String pais, String nombre) {
        }

        public Set<DataPublicacion> listarPublicaciones() {
            return null;
        }

        public Set<DataServicio> listarServicioDeCategoriaCompleto(String cat) {
            return null;
        }

        public void modificarOrigenServicio(String pais, String ciudad) {
        }

        public void modificarDestinoServicio(String pais, String ciudad) {
        }
    }
    
}
