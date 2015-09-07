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
import java.util.Set;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nico
 */
public class IControladorUsuarioTest {
    
    public IControladorUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CargarDatos cd = new CargarDatos();
        try{
        cd.cargar();}catch(Exception e){
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
        IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
        cu.altaCliente("mHooch", "Madam", "Hooch", "Correo", new Date());
        }
    
    @Test
    public void testInfoCliente() throws ParseException {
        IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
        DataUsuario du = cu.infoCliente("eWatson");
        assertEquals("eWatson", du.getNickname());
        assertEquals("Emma", du.getNombre());
        assertEquals("Watson", du.getApellido());
        assertEquals("e.watson@gmail.com",du.getCorreo());
        Assert.assertNotSame("",du.getImage());
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try{
        assertEquals(du.getFecha(),df.parse("15-04-1990"));
        }catch(Exception e){}
    }
    
    @Test(expected=IllegalArgumentException.class)//DEBERIA DAR EXCEPCION PORQUE TCOOK ES PROVEEDOR!
    public void TestInfoCliente2(){
        IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
        DataUsuario du = cu.infoCliente("tCook");
    }

    @Test
    public void testAltaProveedor() throws ParseException
    {
       IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date f = df.parse("01-01-1990");
       try{
       cu.altaProveedor("NicknameASD", "NombreASD", "ApellidoASD", "correo@correo", f, "EmpresaASD", "URLASD");}
       catch(Exception e){}
    }

    @Test(expected=Exception.class)//DEBE TIRAR EXCEPCION PORQUE CORREO ESTA EN SISTEMA
    public void testAltaProveedor2() throws ParseException, Exception
    {
       IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date f = df.parse("01-01-1990");
       cu.altaProveedor("NicknameASB", "NombreASD", "ApellidoASD", "e.watson@gmail.com", f, "EmpresaASD", "URLASD");
    }
    
    @Test(expected=Exception.class)//DEBE TIRAR EXCEPCION PORQUE NICKNAME ESTA EN SISTEMA
    public void testAltaProveedor3() throws ParseException, Exception
    {
       IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       Date f = df.parse("01-01-1990");
       cu.altaProveedor("eWatson", "NombreASD", "ApellidoASD", "correo", f, "EmpresaASD", "URLASD");
    }
    

    public class IControladorUsuarioImpl implements IControladorUsuario {

        public void altaCliente(String nickname, String nombre, String apellido, String correo, Date fnac) throws Exception {
        }

        public void altaClienteConImg(String nickname, String nombre, String apellido, String correo, Date fnac, String img) throws Exception {
        }

        public void altaProveedor(String nickname, String nombre, String apellido, String correo, Date fnac, String nombreEmp, String url) throws Exception {
        }

        public void altaProveedorConImg(String nickname, String nombre, String apellido, String correo, Date fnac, String nombreEmp, String url, String img) throws Exception {
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

        public String getImagenDelUsuario(String nombre) {
            return "";
        }
    }
    
}
