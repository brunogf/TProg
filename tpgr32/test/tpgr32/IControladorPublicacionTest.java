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
    @Test
    public void testAgregarCategoriaServicio() {
        System.out.println("agregarCategoriaServicio");
        String cat = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.agregarCategoriaServicio(cat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaPromocion method, of class IControladorPublicacion.
     */
    @Test
    public void testAltaPromocion() {
        System.out.println("altaPromocion");
        String nombre = "";
        String proveedor = "";
        Set<DataServicio> servicios = null;
        float descuento = 0.0F;
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.altaPromocion(nombre, proveedor, servicios, descuento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testAltaServicio_8args() {
        System.out.println("altaServicio");
        String nombre = "";
        String descripcion = "";
        Set<Image> img = null;
        float precio = 0.0F;
        Set<String> categorias = null;
        String proveedor = "";
        DataUbicacion origen = null;
        DataUbicacion destino = null;
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.altaServicio(nombre, descripcion, img, precio, categorias, proveedor, origen, destino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testAltaServicio_7args() {
        System.out.println("altaServicio");
        String nombre = "";
        String descripcion = "";
        Set<Image> imagenes = null;
        float precio = 0.0F;
        Set<String> categorias = null;
        String proveedor = "";
        DataUbicacion origen = null;
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.altaServicio(nombre, descripcion, imagenes, precio, categorias, proveedor, origen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCategoriaServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testEliminarCategoriaServicio() {
        System.out.println("eliminarCategoriaServicio");
        String cat = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.eliminarCategoriaServicio(cat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoPromocion method, of class IControladorPublicacion.
     */
    @Test
    public void testInfoPromocion() {
        System.out.println("infoPromocion");
        String proveedor = "";
        String promo = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        DataPromocion expResult = null;
        DataPromocion result = instance.infoPromocion(proveedor, promo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testInfoServicio() {
        System.out.println("infoServicio");
        String proveedor = "";
        String servicio = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        DataServicio expResult = null;
        DataServicio result = instance.infoServicio(proveedor, servicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCategorias method, of class IControladorPublicacion.
     */
    @Test
    public void testListarCategorias() {
        System.out.println("listarCategorias");
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        DefaultTreeModel expResult = null;
        DefaultTreeModel result = instance.listarCategorias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPromociones method, of class IControladorPublicacion.
     */
    @Test
    public void testListarPromociones() {
        System.out.println("listarPromociones");
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<DataPromocion> expResult = null;
        Set<DataPromocion> result = instance.listarPromociones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServicios method, of class IControladorPublicacion.
     */
    @Test
    public void testListarServicios() {
        System.out.println("listarServicios");
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<DataServicio> expResult = null;
        Set<DataServicio> result = instance.listarServicios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServiciosDeCategoria method, of class IControladorPublicacion.
     */
    @Test
    public void testListarServiciosDeCategoria() {
        System.out.println("listarServiciosDeCategoria");
        String cat = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<DataServicio> expResult = null;
        Set<DataServicio> result = instance.listarServiciosDeCategoria(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarDescripcionServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testModificarDescripcionServicio() {
        System.out.println("modificarDescripcionServicio");
        String des = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.modificarDescripcionServicio(des);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarImagenesServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testModificarImagenesServicio() {
        System.out.println("modificarImagenesServicio");
        Set<Image> imgs = null;
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.modificarImagenesServicio(imgs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarPrecioServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testModificarPrecioServicio() {
        System.out.println("modificarPrecioServicio");
        float precio = 0.0F;
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.modificarPrecioServicio(precio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarDestinoServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testEliminarDestinoServicio() {
        System.out.println("eliminarDestinoServicio");
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.eliminarDestinoServicio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCategoria method, of class IControladorPublicacion.
     */
    @Test
    public void testRegistrarCategoria_String() {
        System.out.println("registrarCategoria");
        String nombre = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.registrarCategoria(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCategoria method, of class IControladorPublicacion.
     */
    @Test
    public void testRegistrarCategoria_String_String() {
        System.out.println("registrarCategoria");
        String nombre = "";
        String padre = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.registrarCategoria(nombre, padre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testSeleccionarServicio() {
        System.out.println("seleccionarServicio");
        String proveedor = "";
        String nombre = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.seleccionarServicio(proveedor, nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPaises method, of class IControladorPublicacion.
     */
    @Test
    public void testListarPaises() {
        System.out.println("listarPaises");
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<String> expResult = null;
        Set<String> result = instance.listarPaises();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCiudades method, of class IControladorPublicacion.
     */
    @Test
    public void testListarCiudades() {
        System.out.println("listarCiudades");
        String pais = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<String> expResult = null;
        Set<String> result = instance.listarCiudades(pais);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaPais method, of class IControladorPublicacion.
     */
    @Test
    public void testAltaPais() {
        System.out.println("altaPais");
        String nombre = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.altaPais(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaCiudad method, of class IControladorPublicacion.
     */
    @Test
    public void testAltaCiudad() {
        System.out.println("altaCiudad");
        String pais = "";
        String nombre = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.altaCiudad(pais, nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPublicaciones method, of class IControladorPublicacion.
     */
    @Test
    public void testListarPublicaciones() {
        System.out.println("listarPublicaciones");
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<DataPublicacion> expResult = null;
        Set<DataPublicacion> result = instance.listarPublicaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServicioDeCategoriaCompleto method, of class IControladorPublicacion.
     */
    @Test
    public void testListarServicioDeCategoriaCompleto() {
        System.out.println("listarServicioDeCategoriaCompleto");
        String cat = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        Set<DataServicio> expResult = null;
        Set<DataServicio> result = instance.listarServicioDeCategoriaCompleto(cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarOrigenServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testModificarOrigenServicio() {
        System.out.println("modificarOrigenServicio");
        String pais = "";
        String ciudad = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.modificarOrigenServicio(pais, ciudad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarDestinoServicio method, of class IControladorPublicacion.
     */
    @Test
    public void testModificarDestinoServicio() {
        System.out.println("modificarDestinoServicio");
        String pais = "";
        String ciudad = "";
        IControladorPublicacion instance = new IControladorPublicacionImpl();
        instance.modificarDestinoServicio(pais, ciudad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
