/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nico
 */
public class CargarDatos {
    
    private static boolean cargado = false;
    
    public CargarDatos(){}
    
    public void cargar() throws Exception
    {
        if (!cargado)
        {
            //Usuarios
            FabricaControladores fabrica = FabricaControladores.getInstancia();
            IControladorPublicacion cp = fabrica.getControladorPublicacion();
            IControladorReserva cr = fabrica.getControladorReserva();
            IControladorUsuario cu = fabrica.getControladorUsuario();
            
            
            //carga usuarios
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            cu.altaProveedorConImg("tCook", "Tim", "Cook", "air.f@gmail.com", df.parse("01-11-1960"),"AirFrance", "http://www.airfrance.com/", ((new File("Imagenes/tCook.jpg")).getAbsolutePath()) );
            cu.altaProveedorConImg("moody", "Alastor", "Moody", "eu.car@eucar.com", df.parse("02-09-1965"), "EuropCar", "http://www.europcar.com.uy/", ((new File("Imagenes/moody.jpeg")).getAbsolutePath()));
            cu.altaProveedorConImg("remus", "Remus", "Lupin", "iberia@gmail.com", df.parse("04-05-1970"),"Iberia", "http://www.iberia.com/uy/", ((new File("Imagenes/remus.jpg")).getAbsolutePath()));
            cu.altaProveedorConImg("adippet", "Armando", "Dippet", "tam@outlook.com", df.parse("12-02-1967"),"Tam", "http://www.tam.com.br/", ((new File("Imagenes/adippet.png")).getAbsolutePath()));
            cu.altaProveedorConImg("mHooch", "Madam", "Hooch", "seghogar@gmail.com", df.parse("05-08-1963"),"Segundo Hogar", "http://www.segundohogar.com/", ((new File("Imagenes/mHooch.jpg")).getAbsolutePath()));
            cu.altaClienteConImg("oWood", "Oliver", "Wood", "quidditch28@gmail.com", df.parse("28-12-1988"), ((new File("Imagenes/oWood.jpg")).getAbsolutePath()));
            cu.altaClienteConImg("eWatson", "Emma", "Watson", "e.watson@gmail.co", df.parse("15-04-1990"), ((new File("Imagenes/eWatson.jpg")).getAbsolutePath()));
            cu.altaCliente("BruceS", "Bruce", "Sewell", "bruce.sewell@gmail.com", df.parse("03-12-1978"));
            cu.altaCliente("JeffW", "Jeff", "Wiliams", "jeff.williams@gmail.com", df.parse("27-11-1984"));
            
            //Categorias
            cp.registrarCategoria("Vuelos");
            cp.registrarCategoria("Alojamientos");
            cp.registrarCategoria("Automóviles");
            cp.registrarCategoria("Cruceros");
            cp.registrarCategoria("Empresas", "Vuelos");
            cp.registrarCategoria("Iberia", "Empresas");
            cp.registrarCategoria("American Airlines", "Empresas");
            cp.registrarCategoria("Air France", "Empresas");
            cp.registrarCategoria("TAM", "Empresas");
            cp.registrarCategoria("Tipo Vuelo", "Vuelos");
            cp.registrarCategoria("LowCost", "Tipo Vuelo");
            cp.registrarCategoria("Standard", "Tipo Vuelo");
            cp.registrarCategoria("First Class", "Tipo Vuelo");
            cp.registrarCategoria("Tipo A   lojamiento", "Alojamientos");
            cp.registrarCategoria("Ubicación", "Alojamientos");
            cp.registrarCategoria("Habitaciones", "Alojamientos");
            cp.registrarCategoria("Hotel", "Tipo Alojamiento");
            cp.registrarCategoria("Hostal", "Tipo Alojamiento");
            cp.registrarCategoria("Apartamento", "Tipo Alojamiento");
            cp.registrarCategoria("Casa", "Tipo Alojamiento");
            cp.registrarCategoria("Playa", "Ubicación");
            cp.registrarCategoria("Rural", "Ubicación");
            cp.registrarCategoria("Montaña", "Ubicación");
            cp.registrarCategoria("1 ambiente", "Habitaciones");
            cp.registrarCategoria("1 dormitorio", "Habitaciones");
            cp.registrarCategoria("2 dormitorios", "Habitaciones");
            cp.registrarCategoria("Tarifa", "Automóviles");
            cp.registrarCategoria("Tipo Vehículo", "Automóviles");
            cp.registrarCategoria("Marca", "Automóviles");
            cp.registrarCategoria("Mini", "Tarifa");
            cp.registrarCategoria("Económico", "Tarifa");
            cp.registrarCategoria("Standard", "Tarifa");
            cp.registrarCategoria("Full", "Tarifa");
            cp.registrarCategoria("Auto", "Tipo Vehículo");
            cp.registrarCategoria("Camioneta", "Tipo Vehículo");
            cp.registrarCategoria("Camión", "Tipo Vehículo");
            cp.registrarCategoria("Moto", "Tipo Vehículo");
            cp.registrarCategoria("Chevrolet", "Marca");
            cp.registrarCategoria("Peugeot", "Marca");
            cp.registrarCategoria("Daihatsu", "Marca");
            cp.registrarCategoria("Fiat", "Marca");
            cp.registrarCategoria("Ford", "Marca");
            cp.registrarCategoria("Mediterráneo", "Cruceros");
            cp.registrarCategoria("Mar Negro", "Cruceros");
            cp.registrarCategoria("Caribe", "Cruceros");
            cp.registrarCategoria("Nilo", "Cruceros");
            cp.registrarCategoria("Alaska", "Cruceros");
            
            
            
            
            
            
            
            
            
            
            
            
            cargado = true;
        }
        else
            throw new IllegalArgumentException("Ya se ha realizado la carga una vez");
    }
    
}
