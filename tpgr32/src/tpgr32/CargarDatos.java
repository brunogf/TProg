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
            
            cargado = true;
        }
        else
            throw new IllegalArgumentException("Ya se ha realizado la carga una vez");
    }
    
}
