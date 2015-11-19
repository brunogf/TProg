/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        CargarDatos cdt = new CargarDatos();
        try{
            cdt.cargar();
        }
        catch(Exception e){
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
    public void testActualizarEstado() throws Exception{
        IControladorReserva cres = FabricaControladores.getInstancia().getControladorReserva();
        cres.actualizarEstado(5, Estado.Pagada);
        DataReserva dtr = cres.infoReserva(5);
        assertEquals(Estado.Pagada,dtr.getEstado());
    }
    
    
    
    @Test
    public void altaReserva() throws ParseException, Exception{
        IControladorReserva cres = FabricaControladores.getInstancia().getControladorReserva();
        List<DataReserva> reservas = cres.listarReservas();
        assertEquals(7,reservas.size());
        cres.bajaReserva(7);
        reservas = cres.listarReservas();
        assertEquals(6,reservas.size());
        cres.seleccionarCliente("eWatson");
        cres.seleccionarProveedor("remus");
        DateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
        cres.seleccionarPublicacion("Euro-Vuelo-S", 1, dtf.parse("01-01-2015"), dtf.parse("01-01-2015"));
        cres.confirmarReserva();
        assertEquals("remus",cres.getNickProveedorSeleccionado());
        DataUsuario dtc = cres.getInfoClienteSeleccionado();
        assertEquals("eWatson", dtc.getNickname());
        dtc = cres.getInfoClienteReserva(5);
        assertEquals(dtc.getNickname(),"oWood");
        dtc = cres.getInfoProveedorSeleccionado();
        assertEquals(dtc.getNickname(),"remus");
        cres.borrarPublicacionesSeleccionadas();
        assertEquals(cres.getNumeroReservas(),9);
        cres.cambiarFechaCreacionReserva(dtf.parse("07-09-2015"),1);
        assertEquals(cres.infoReserva(1).getCreacion(),dtf.parse("07-09-2015"));
    }
    
    
    

    
    

    public class IControladorReservaImpl implements IControladorReserva {

        public void actualizarEstado(int num, Estado est) throws Exception {
        }

        public void bajaReserva(int num) throws Exception {
        }

        public int confirmarReserva() {
            return 0;
        }

        public DataReserva infoReserva(int num) {
            return null;
        }
        
        public DataReserva infoReservaProveedor(int nro, String nick){
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

        public void cambiarFechaCreacionReserva(Date fecha, int res) {
        }
        
        public int facturarReserva(String nickname, int nro){
            return -1;
        }
        
        public byte[] obtenerFactura(int id){
            return null;
        }
        
        public int obtenerFacturaReserva(int nro){
        return -1;
    }
    }
    
    
    
}
