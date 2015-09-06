/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esteban
 */
public class IControladorUsuarioTest {
    
    public IControladorUsuarioTest() {
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
            
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of altaCliente method, of class IControladorUsuario.
     * @throws java.lang.Exception
     */
    
    //En @Before setup se cargaron los datos genericos
    
    @Test(expected=IllegalArgumentException.class) //El nick ya está registrado
    public void testAltaCliente() throws Exception {
        IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
        cu.altaCliente("mHooch", "Madam", "Hooch", "Correo", new Date());
        }

    
    /*
    @Test
    public void testAltaCliente() throws Exception {
        System.out.println("altaCliente");
        String nickName = "JeffW";
        String nombre = "Jeff";
        String apellido = "Wiliams";
        String correoElec = "";
        Date f = new Date(27/11/1984);
        
        String nickName2 = "BruceS";
        String nombre2 = "Bruce";
        String apellido2 = "Sewell";
        String correoElec2 = "bruce.sewell@gmail.com";
        Date f2 = new Date(3/12/1978);
     
        ControladorUsuario instance = new ControladorUsuario();
        instance.altaCliente(nickName, nombre, apellido, correoElec, f);
        instance.altaCliente(nickName2, nombre2, apellido2, correoElec2, f2);
        
        ManejadorUsuario mU = ManejadorUsuario.getInstance();
        // pruebo si estan los clientes
        assertNotNull("Valor Nulo",mU.encontrarCliente(nickName));
        assertNotNull("Valor Nulo",mU.encontrarCliente(nickName2));
 }

    
    @Test
    public void testAltaClienteConImg() throws Exception {
              System.out.println("altaClienteConImg");
        
        String nickName = "eWaston";
        String nombre = "Emma";
        String apellido = "Watson";
        String correoElec = "e.watson@gmail.com";
        Date f = new Date(15/4/1990);
        String img = "http://bit.ly/1hEGTcq";
        
        String nickName2 = "oWood";
        String nombre2 = "Oliver";
        String apellido2 = "Wood";
        String correoElec2 = "quidditch28@gmail.com"; 
        Date f2 = new Date(28/12/1988);           
        String img2 = "http://bit.ly/1Kifw2J";
        
        ControladorUsuario instance = new ControladorUsuario();
        instance.altaClienteConImg(nickName, nombre, apellido, correoElec, f, img);
        instance.altaClienteConImg(nickName2, nombre2, apellido2, correoElec2, f2, img2);
        
        ManejadorUsuario mU = ManejadorUsuario.getInstance();
        
        // pruebo si estan los clientes
        assertNotNull("Valor Nulo",mU.encontrarCliente(nickName));
        assertNotNull("Valor Nulo",mU.encontrarCliente(nickName2));
        
        // pruebo si tienen las imagenes
        Cliente c = mU.encontrarCliente(nickName);
        Cliente c2 = mU.encontrarCliente(nickName2);
        assertNotNull("Valor Nulo",c.getImgUsuario());
        assertNotNull("Valor Nulo",c2.getImgUsuario());


}

    @Test
    public void testAltaProveedor() throws Exception {
              System.out.println("altaProveedor");
        String nickname = "tCook";
        String nombre = "Tim";
        String apellido = "Cook";
        String correo = "air.f@gmail.com";
        Date fecha = new Date(15/4/1990);
        String nombreEmp = "AirFrance";
        String url = "http://www.airfrance.com/";
        
        String nickName2 = "moody";
        String nombre2 = "Alastor";
        String apellido2 = "Moondy";
        String correoElec2 = "eu.car@eucar.com";
        Date f2 = new Date(2/9/1965);
        String nomEmpresa2 = "EuropCar";
        String url2 = "http://www.europcar.com.uy/";
            
        ControladorUsuario instance = new ControladorUsuario();
        instance.altaProveedor(nickname, nombre, apellido, correo, fecha, nombreEmp, url);
        instance.altaProveedor(nickName2, nombre2, apellido2, correoElec2, f2, nomEmpresa2, url2);
        
        ManejadorUsuario mU = ManejadorUsuario.getInstance();
        // pruebo si estan los clientes
        assertNotNull("Valor Nulo",mU.encontrarProveedor(nickname));
        assertNotNull("Valor Nulo",mU.encontrarProveedor(nickName2));
       
}

    @Test
    public void testAltaProveedorConImg() throws Exception {
                System.out.println("altaProveedorConImg");
        String nickname = "adippet";
        String nombre = "Armando";
        String apellido = "Dippet";
        String correo = "tam@outlook.com";
        Date fnac = new Date(12/2/1967);
        String nombreEmp = "Tam";
        String url = "http://www.tam.com.br/";
        String img = "http://bit.ly/1hcs2os";
        
        String nickname2 = "mHooch";
        String nombre2 = "Madam";
        String apellido2 = "Hooch";
        String correo2 = "segHogar@gmail.com";
        Date fnac2 = new Date(5/8/1963);
        String nombreEmp2 = "Segundo Hogar";
        String url2 = "http://www.segundohogar.com/";
        String img2 = "http://bit.ly/1hEGDdb";
        
        ControladorUsuario instance = new ControladorUsuario();
        instance.altaProveedorConImg(nickname, nombre, apellido, correo, fnac, nombreEmp, url, img);
        instance.altaProveedorConImg(nickname2, nombre2, apellido2, correo2, fnac2, nombreEmp2, url2, img2);
        
        ManejadorUsuario mU = ManejadorUsuario.getInstance();
        
        // pruebo si estan los proveedores
        assertNotNull("Valor Nulo",mU.encontrarProveedor(nickname));
        assertNotNull("Valor Nulo",mU.encontrarProveedor(nickname2));
        
        Proveedor p = mU.encontrarProveedor(nickname);
        Proveedor p2 = mU.encontrarProveedor(nickname2);
        assertNotNull("Valor Nulo",p.getImgUsuario());
        assertNotNull("Valor Nulo",p2.getImgUsuario());


    }

    /*@Test
    public void testInfoCliente() {
                System.out.println("infoCliente");
        String nickname = "eWaston";
        String nickname2 = "BruceS";
        
        ControladorUsuario instance = new ControladorUsuario();
        
        DataUsuario result = instance.infoCliente(nickname);
        DataUsuario result2 = instance.infoCliente(nickname2);
      
        //chequeo los nombres
        assertEquals("Emma",result.getNombre());
        assertEquals("Bruce",result2.getNombre());
        
        //chequeo los apellidos
        assertEquals("Watson",result.getApellido());
        assertEquals("Sewell",result2.getApellido());
        
        //chequeo los correos
        assertEquals("e.watson@gmail.com",result.getCorreo());
        assertEquals("bruce.sewell@gmail.com",result2.getCorreo());
        
        //chequeo la fecha de nacimiento
        //PASAR AL FORMATO CORRECTO.
        //assertEquals("15/4/1990",result.getFecha());
        //assertEquals("3/12/1978",result2.getFecha());
        
    }

    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        IControladorUsuario instance = new IControladorUsuarioImpl();
        Set<DataUsuario> expResult = null;
        Set<DataUsuario> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarProveedores() {
        System.out.println("listarProveedores");
        IControladorUsuario instance = new IControladorUsuarioImpl();
        Set<DataUsuario> expResult = null;
        Set<DataUsuario> result = instance.listarProveedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarPublicacionesProveedor() {
        System.out.println("listarPublicacionesProveedor");
        String nick = "";
        IControladorUsuario instance = new IControladorUsuarioImpl();
        Set<DataPublicacion> expResult = null;
        Set<DataPublicacion> result = instance.listarPublicacionesProveedor(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetImagenDelUsuario() {
        System.out.println("getImagenDelUsuario");
        String nombre = "";
        IControladorUsuario instance = new IControladorUsuarioImpl();
        String expResult = "";
        String result = instance.getImagenDelUsuario(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    */
}
