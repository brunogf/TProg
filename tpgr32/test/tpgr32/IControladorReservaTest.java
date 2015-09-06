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
     * Test of actualizarEstado method, of class IControladorReserva.
     */
    //TESTS
    
    @Test
    public void testActualizarEstado() throws Exception
    {
        IControladorReserva cr = FabricaControladores.getInstancia().getControladorReserva();
        cr.actualizarEstado(5, Estado.Pagada);
        DataReserva dr = cr.infoReserva(5);
        assertEquals(Estado.Pagada,dr.getEstado());
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
