/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.util.HashSet;
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
        CargarDatos cd = new CargarDatos();
        try
        {
            cd.cargar();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of agregarCategoriaServicio method, of class IControladorPublicacion.
     */
    //TESTS
    
    @Test(expected=IllegalArgumentException.class)
    public void testAltaPais()
    {
        IControladorPublicacion cp = FabricaControladores.getInstancia().getControladorPublicacion();
        cp.altaPais("Uruguay");
    }
    
    @Test(expected=IllegalArgumentException.class)   // Dos servicios de un proveedor con el mismo nombre
    public void testAltaServicio()
    {
        IControladorPublicacion cp = FabricaControladores.getInstancia().getControladorPublicacion();
        Set<Image> imagenes = new HashSet<>();
        Set<String> categorias = new HashSet<>();
        DataUbicacion dtorigen = new DataUbicacion("Uruguay","Montevideo");
        cp.altaServicio("Euro-Vuelo-S","nada",imagenes,22,categorias,"remus",dtorigen);
    }
    
    /*@Test
    public void testAltaPromocion(){
        IControladorPublicacion cp = FabricaControladores.getInstancia().getControladorPublicacion();
        cp.altaPromocion("Euro-Cars-E-S","remus" , ,);
    }*/
    

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
