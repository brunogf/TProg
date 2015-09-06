/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
public class IControladorReservaTest {
    
    public IControladorReservaTest() {
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
     * Test of actualizarEstado method, of class IControladorReserva.
     */
    @Test
    public void testActualizarEstado() throws Exception {
        System.out.println("actualizarEstado");
        int num = 0;
        Estado e = null;
        IControladorReserva instance = new IControladorReservaImpl();
        instance.actualizarEstado(num, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bajaReserva method, of class IControladorReserva.
     */
    @Test
    public void testBajaReserva() throws Exception {
        System.out.println("bajaReserva");
        int num = 0;
        IControladorReserva instance = new IControladorReservaImpl();
        instance.bajaReserva(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmarReserva method, of class IControladorReserva.
     */
    @Test
    public void testConfirmarReserva() {
        System.out.println("confirmarReserva");
        IControladorReserva instance = new IControladorReservaImpl();
        int expResult = 0;
        int result = instance.confirmarReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoReserva method, of class IControladorReserva.
     */
    @Test
    public void testInfoReserva() {
        System.out.println("infoReserva");
        int num = 0;
        IControladorReserva instance = new IControladorReservaImpl();
        DataReserva expResult = null;
        DataReserva result = instance.infoReserva(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarReservas method, of class IControladorReserva.
     */
    @Test
    public void testListarReservas() {
        System.out.println("listarReservas");
        IControladorReserva instance = new IControladorReservaImpl();
        List<DataReserva> expResult = null;
        List<DataReserva> result = instance.listarReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarReservasEliminables method, of class IControladorReserva.
     */
    @Test
    public void testListarReservasEliminables() {
        System.out.println("listarReservasEliminables");
        IControladorReserva instance = new IControladorReservaImpl();
        Set<DataReserva> expResult = null;
        Set<DataReserva> result = instance.listarReservasEliminables();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarCliente method, of class IControladorReserva.
     */
    @Test
    public void testSeleccionarCliente() {
        System.out.println("seleccionarCliente");
        String nickname = "";
        IControladorReserva instance = new IControladorReservaImpl();
        instance.seleccionarCliente(nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarPublicacion method, of class IControladorReserva.
     */
    @Test
    public void testSeleccionarPublicacion() {
        System.out.println("seleccionarPublicacion");
        String nombre = "";
        int cantidad = 0;
        Date inicio = null;
        Date fin = null;
        IControladorReserva instance = new IControladorReservaImpl();
        instance.seleccionarPublicacion(nombre, cantidad, inicio, fin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarProveedor method, of class IControladorReserva.
     */
    @Test
    public void testSeleccionarProveedor() {
        System.out.println("seleccionarProveedor");
        String nickname = "";
        IControladorReserva instance = new IControladorReservaImpl();
        instance.seleccionarProveedor(nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNickProveedorSeleccionado method, of class IControladorReserva.
     */
    @Test
    public void testGetNickProveedorSeleccionado() {
        System.out.println("getNickProveedorSeleccionado");
        IControladorReserva instance = new IControladorReservaImpl();
        String expResult = "";
        String result = instance.getNickProveedorSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoClienteSeleccionado method, of class IControladorReserva.
     */
    @Test
    public void testGetInfoClienteSeleccionado() {
        System.out.println("getInfoClienteSeleccionado");
        IControladorReserva instance = new IControladorReservaImpl();
        DataCliente expResult = null;
        DataCliente result = instance.getInfoClienteSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoClienteReserva method, of class IControladorReserva.
     */
    @Test
    public void testGetInfoClienteReserva() {
        System.out.println("getInfoClienteReserva");
        int nro = 0;
        IControladorReserva instance = new IControladorReservaImpl();
        DataUsuario expResult = null;
        DataUsuario result = instance.getInfoClienteReserva(nro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoProveedorSeleccionado method, of class IControladorReserva.
     */
    @Test
    public void testGetInfoProveedorSeleccionado() {
        System.out.println("getInfoProveedorSeleccionado");
        IControladorReserva instance = new IControladorReservaImpl();
        DataProveedor expResult = null;
        DataProveedor result = instance.getInfoProveedorSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPublicacionesSeleccionadas method, of class IControladorReserva.
     */
    @Test
    public void testBorrarPublicacionesSeleccionadas() {
        System.out.println("borrarPublicacionesSeleccionadas");
        IControladorReserva instance = new IControladorReservaImpl();
        instance.borrarPublicacionesSeleccionadas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroReservas method, of class IControladorReserva.
     */
    @Test
    public void testGetNumeroReservas() {
        System.out.println("getNumeroReservas");
        IControladorReserva instance = new IControladorReservaImpl();
        int expResult = 0;
        int result = instance.getNumeroReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarFechaCreacionReserva method, of class IControladorReserva.
     */
    @Test
    public void testCambiarFechaCreacionReserva() {
        System.out.println("cambiarFechaCreacionReserva");
        Date f = null;
        int r = 0;
        IControladorReserva instance = new IControladorReservaImpl();
        instance.cambiarFechaCreacionReserva(f, r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IControladorReservaImpl implements IControladorReserva {

        public void actualizarEstado(int num, Estado e) throws Exception {
        }

        public void bajaReserva(int num) throws Exception {
        }

        public int confirmarReserva() {
            return 0;
        }

        public DataReserva infoReserva(int num) {
            return null;
        }

        public List<DataReserva> listarReservas() {
            return null;
        }

        public Set<DataReserva> listarReservasEliminables() {
            return null;
        }

        public void seleccionarCliente(String nickname) {
        }

        public void seleccionarPublicacion(String nombre, int cantidad, Date inicio, Date fin) {
        }

        public void seleccionarProveedor(String nickname) {
        }

        public String getNickProveedorSeleccionado() {
            return "";
        }

        public DataCliente getInfoClienteSeleccionado() {
            return null;
        }

        public DataUsuario getInfoClienteReserva(int nro) {
            return null;
        }

        public DataProveedor getInfoProveedorSeleccionado() {
            return null;
        }

        public void borrarPublicacionesSeleccionadas() {
        }

        public int getNumeroReservas() {
            return 0;
        }

        public void cambiarFechaCreacionReserva(Date f, int r) {
        }
    }
    
}
