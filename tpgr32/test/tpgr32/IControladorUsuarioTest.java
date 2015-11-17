/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Nico
 */
public class IControladorUsuarioTest {
    
    public IControladorUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CargarDatos cdt = new CargarDatos();
        try{
        cdt.cargar();}catch(Exception e){
            System.out.println(e.getMessage());
        }
        
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
     * Test of altaCliente method, of class IControladorUsuario.
     */
    @Test(expected=IllegalArgumentException.class) //El nick ya está registrado
    public void testAltaCliente() throws Exception {
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        cusr.altaCliente("mHooch", "Madam", "Hooch", "Correo", new Date(),"mHooch");
        }
    
    @Test
    public void testInfoCliente() throws ParseException {
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        DataUsuario dusr = cusr.infoCliente("eWatson");
        assertEquals("eWatson", dusr.getNickname());
        assertEquals("Emma", dusr.getNombre());
        assertEquals("Watson", dusr.getApellido());
        assertEquals("e.watson@gmail.com",dusr.getCorreo());
        Assert.assertNotSame("",dusr.getImage());
        DateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
        try{
        assertEquals(dusr.getFecha(),dtf.parse("15-04-1990"));
        }catch(Exception e){}
    }
    
    @Test(expected=IllegalArgumentException.class)//DEBERIA DAR EXCEPCION PORQUE TCOOK ES PROVEEDOR!
    public void TestInfoClienteB(){
        IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
        DataUsuario dusr = cusr.infoCliente("tCook");
    }

    @Test
    public void testAltaProveedor() throws ParseException{
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       DateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
       Date fecha = dtf.parse("01-01-1990");
       try{
       cusr.altaProveedor("NicknameASD", "NombreASD", "ApellidoASD", "correo@correo", fecha, "EmpresaASD", "URLASD", "123");}
       catch(Exception e){}
    }

    @Test(expected=Exception.class)//DEBE TIRAR EXCEPCION PORQUE CORREO ESTA EN SISTEMA
    public void testAltaProveedor2() throws ParseException, Exception{
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       DateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
       Date fecha = dtf.parse("01-01-1990");
       cusr.altaProveedor("NicknameASB", "NombreASD", "ApellidoASD", "e.watson@gmail.com", fecha, "EmpresaASD", "URLASD", "123");
    }
    
    @Test(expected=Exception.class)//DEBE TIRAR EXCEPCION PORQUE NICKNAME ESTA EN SISTEMA
    public void testAltaProveedor3() throws ParseException, Exception{
       IControladorUsuario cusr = FabricaControladores.getInstancia().getControladorUsuario();
       DateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
       Date fecha = dtf.parse("01-01-1990");
       cusr.altaProveedor("eWatson", "NombreASD", "ApellidoASD", "correo", fecha, "EmpresaASD", "URLASD", "123");
    }
    

    public class IControladorUsuarioImpl implements IControladorUsuario {

        public void altaCliente(String nickname, String nombre, String apellido, String correo, Date fnac, String password) throws Exception {
        }

        public void altaClienteConImg(String nickname, String nombre, String apellido, String correo, Date fnac, String img, String password) throws Exception {
        }

        public void altaProveedor(String nickname, String nombre, String apellido, String correo, Date fnac, String nombreEmp, String url, String pass) throws Exception {
        }

        public void altaProveedorConImg(String nickname, String nombre, String apellido, String correo, Date fnac, String nombreEmp, String url, String img, String pass) throws Exception {
        }

        public DataUsuario infoCliente(String nickname) {
            return null;
        }

        public Set<DataUsuario> listarClientes() {
            return null;
        }

        public Set<DataUsuario> listarProveedores() {
            return null;
        }

        public Set<DataPublicacion> listarPublicacionesProveedor(String nick) {
            return null;
        }
        
        public Set<DataReserva> listarReservasProveedor(String nick) {
            return null;
        }

        public Image getImagenDelUsuario(String nombre) {
            return null;
        }
        
        public int comprobarUsuario(String nick, String password){
            return 0;
        }
        
        public String getNickUsuario(String nick){
            return "";
        }
        
        public DataUsuario infoProveedor(String nickname){
            return null;
        }
        
        public DataUsuario infoUsuario(String nickname){
            return null;
        }
        
        public boolean existeMail(String email){
            return false;
        }
    }
    
}
