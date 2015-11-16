/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
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
    
    
    @Test
    public void testAltaCategoria()
    {
        IControladorPublicacion cp = FabricaControladores.getInstancia().getControladorPublicacion();
        cp.registrarCategoria("Kawasaki","Moto");
    }
    
    @Test
    public void testInfoPromocion()
    {
        IControladorPublicacion cp = FabricaControladores.getInstancia().getControladorPublicacion();
        DataPromocion dp = cp.infoPromocion("moody", "Euro-Cars-E-F");
        assertEquals(Float.toString(dp.getDescuento()),"30.0");
        dp.getPrecioTotal();
        assertEquals(dp.getProveedor(),"moody");
    }
    
    @Test
    public void testControlador()
    {
        IControladorPublicacion cp = FabricaControladores.getInstancia().getControladorPublicacion();
        cp.seleccionarServicio("remus", "Euro-Vuelo-S");
        cp.agregarCategoriaServicio("2 dormitorios");
        cp.listarServiciosDeCategoria("2 dormitorios");
        DataServicio ds = cp.infoServicio("remus", "Euro-Vuelo-S");
        assertEquals(ds.getNombre(),"Euro-Vuelo-S");
        assertEquals(ds.getDescripcion(),"Vuelo con excelente atención y comodidad.");
        assertEquals(ds.getCiudadOrigen(),"Montevideo");
        assertEquals(ds.getCiudadDestino(),"Valencia");
        assertEquals(ds.getPaisOrigen(),"Uruguay");
        assertEquals(ds.getPaisDestino(),"España");
        assertEquals(Float.toString(ds.getPrecio()),"1100.0");
        assertEquals(ds.getProveedor(),"Remus Lupin (nickname: remus)");
        assertEquals(cp.listarPromociones().size(),8);
        cp.seleccionarServicio("remus", "Euro-Vuelo-S");
        cp.modificarDescripcionServicio("Hola");
        cp.modificarDestinoServicio("Argentina", "Buenos Aires");
        cp.modificarOrigenServicio("España", "Valencia");
        cp.modificarPrecioServicio(20);
        ds = cp.infoServicio("remus", "Euro-Vuelo-S");
        assertEquals(ds.getCiudadDestino(),"Buenos Aires");
        assertEquals(ds.getDescripcion(),"Hola");
        assertEquals(cp.listarPaises().size(),11);
        assertEquals(cp.listarCiudades("Uruguay").size(), 1);
        assertEquals(cp.listarPublicaciones().size(),20);
        assertEquals(cp.listarServicioDeCategoriaCompleto("2 dormitorios").size(),3);
        
        
        
        
        
        
        
        
        
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
        
        public Set<DataPublicacion> buscarPublicacion(String criterio)
        {
            return null;
        }
        
        public DataCategoria encontrarDataCategoria(String nombre){
            
            return null;
        }
        
        public Set<DataCategoria> listarDataCategorias(){
            
            return null;
        }
        public Set<DataPublicacion> buscarPublicacionCompleta(String criterio)
        {
            return null;
        }
        
        public CatTree getCatTree()
        {
            return null;
        }
        
        public void agregarLog(DataLog log, String nombre, String proveedor){}
    public Map<Integer, DataServicio> listarTopServicios(){return null;}
    public Map<Integer,DataLog> listarLogs(){return null;}
    }
    
}
