/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;

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
            cargado = true;
            IControladorPublicacion cp = new ControladorPublicacion();
            IControladorReserva cr = new ControladorReserva();
            IControladorUsuario cu = new ControladorUsuario();
            
            
            //carga usuarios
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            cu.altaProveedorConImg("tCook", "Tim", "Cook", "air.f@gmail.com", df.parse("01-11-1960"),"AirFrance", "http://www.airfrance.com/", ((new File("Imagenes/tCook.jpg")).getAbsolutePath()) );
            cu.altaProveedorConImg("moody", "Alastor", "Moody", "eu.car@eucar.com", df.parse("02-09-1965"), "EuropCar", "http://www.europcar.com.uy/", ((new File("Imagenes/moody.jpeg")).getAbsolutePath()));
            cu.altaProveedorConImg("remus", "Remus", "Lupin", "iberia@gmail.com", df.parse("04-05-1970"),"Iberia", "http://www.iberia.com/uy/", ((new File("Imagenes/remus.jpg")).getAbsolutePath()));
            cu.altaProveedorConImg("adippet", "Armando", "Dippet", "tam@outlook.com", df.parse("12-02-1967"),"Tam", "http://www.tam.com.br/", ((new File("Imagenes/adippet.png")).getAbsolutePath()));
            cu.altaProveedorConImg("mHooch", "Madam", "Hooch", "seghogar@gmail.com", df.parse("05-08-1963"),"Segundo Hogar", "http://www.segundohogar.com/", ((new File("Imagenes/mHooch.jpg")).getAbsolutePath()));
            cu.altaClienteConImg("oWood", "Oliver", "Wood", "quidditch28@gmail.com", df.parse("28-12-1988"), ((new File("Imagenes/oWood.jpg")).getAbsolutePath()),"oWood");
            cu.altaClienteConImg("eWatson", "Emma", "Watson", "e.watson@gmail.com", df.parse("15-04-1990"), ((new File("Imagenes/eWatson.jpg")).getAbsolutePath()),"eWatson");
            cu.altaCliente("BruceS", "Bruce", "Sewell", "bruce.sewell@gmail.com", df.parse("03-12-1978"),"BruceS");
            cu.altaCliente("JeffW", "Jeff", "Wiliams", "jeff.williams@gmail.com", df.parse("27-11-1984"),"JeffW");
            
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
            cp.registrarCategoria("Tipo Alojamiento", "Alojamientos");
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
            
            //Paises
            cp.altaPais("Uruguay");
            cp.altaPais("Argentina");
            cp.altaPais("Colombia");
            cp.altaPais("EEUU");
            cp.altaPais("España");
            cp.altaPais("Francia");
            cp.altaPais("Alemania");
            cp.altaPais("Suiza");
            cp.altaPais("Australia");
            cp.altaPais("Brasil");
            cp.altaPais("China");
            cp.altaCiudad("Uruguay", "Montevideo");
            cp.altaCiudad("Argentina", "Buenos Aires");
            cp.altaCiudad("Colombia", "Bogotá");
            cp.altaCiudad("EEUU", "Miami");
            cp.altaCiudad("España", "Valencia");
            cp.altaCiudad("España", "Madrid");
            cp.altaCiudad("Francia", "Paris");
            cp.altaCiudad("Alemania", "Berlín");
            cp.altaCiudad("Suiza", "Ginebra");
            cp.altaCiudad("Australia", "Sidney");
            cp.altaCiudad("China", "Pekín");
            cp.altaCiudad("China", "Cantón");
            cp.altaCiudad("Brasil", "Florianópolis");
            cp.altaCiudad("Argentina", "Bariloche");
            
            //Servicios
            Set<Image> hs = new HashSet<>();
            Set<String> cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM7.jpg")));
            cat.add("Iberia");
            cat.add("Standard");
            cp.altaServicio("Euro-Vuelo-S", "Vuelo con excelente atención y comodidad.",
                    hs, 1100 , cat, "remus", new DataUbicacion("Uruguay", "Montevideo"), new DataUbicacion("España","Valencia"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM7.jpg")));
            cat.add("Iberia");
            cat.add("LowCost");
            cp.altaServicio("Euro-Vuelo-LC", "Vuelo con excelente atención y comodidad a un precio accesible.",
                    hs, 850 , cat, "remus", new DataUbicacion("Uruguay", "Montevideo"), new DataUbicacion("España","Valencia"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM7.jpg")));
            cat.add("Iberia");
            cat.add("First Class");
            cp.altaServicio("Euro-Vuelo-FC", "Vuelo de primera clase. Excelente atención, comodidad y servicio.",
                    hs, 1300 , cat, "remus", new DataUbicacion("Uruguay", "Montevideo"), new DataUbicacion("España","Valencia"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM8.png")));
            cat.add("Económico");
            cat.add("Auto");
            cat.add("Chevrolet");
            cp.altaServicio("Euro-Car-1", "Euro-Car. Autos de buena calidad y comodidad. Versión Económica",
                    hs, 300 , cat, "moody", new DataUbicacion("España", "Madrid"), new DataUbicacion("España","Valencia"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM9.jpg")));
            cat.add("Standard");
            cat.add("Auto");
            cat.add("Chevrolet");
            cp.altaServicio("Euro-Car-2", "Euro-Car. Autos de buena calidad y comodidad. Versión Standard.",
                    hs, 300 , cat, "moody", new DataUbicacion("España", "Madrid"), new DataUbicacion("España","Valencia"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM10.jpg")));
            cat.add("Full");
            cat.add("Camioneta");
            cat.add("Chevrolet");
            cp.altaServicio("Euro-Car-3", "Euro-Car. Autos de buena calidad y comodidad. Una camioneta para toda la familia.",
                    hs, 300 , cat, "moody", new DataUbicacion("España", "Valencia"));

            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM1.jpg")));
            hs.add(ImageIO.read(new File("Imagenes/IM2.jpg")));        
            cat.add("Casa");
            cat.add("2 dormitorios");
            cp.altaServicio("Casa para p4 BsAs", "Esta hermosa casa, se encuentra ubicada en el corazón de Buenos Aires y ofrece una capacidad\n" +
                            "para cuatro personas. La propiedad cuenta con un dormitorio con dos camas simples, que pueden\n" +
                            "transformarse en una matrimonial y dos baños completos, que incluyen toallas.",
                    hs, 80 , cat, "mHooch", new DataUbicacion("Argentina", "Buenos Aires"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM3.jpg")));
            hs.add(ImageIO.read(new File("Imagenes/IM4.jpg")));      
            hs.add(ImageIO.read(new File("Imagenes/IM5.jpg")));  
            cat.add("Casa");
            cat.add("2 dormitorios");
            cp.altaServicio("Floripa G. House", "Estamos a sólo unos pasos de un supermercado, restaurantes, cajero automático, gasolinera,\n" +
                            "farmacia, gimnasio, etc. Lagoa da Conceição es 7 km de nuestra casa de huéspedes y tarda sólo 10-\n" +
                            "15 minutos en el transporte público. Allí se encuentra una buena vida nocturna con bares y música\n" +
                            "en vivo.",
                    hs, 190 , cat, "mHooch", new DataUbicacion("Brasil", "Florianópolis"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM6.jpg")));
            cat.add("Air France");
            cat.add("First Class");
            cp.altaServicio("Air-France-FC", "¡Un vuelo de primera! Excelencia y experiencia en mejorar sus viajes.",
                    hs, 100 , cat, "tCook", new DataUbicacion("Francia", "Paris"), new DataUbicacion("Alemania","Berlín"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM11.jpg")));
            cat.add("TAM");
            cat.add("First Class");
            cp.altaServicio("TAM-FC", "¡Un vuelo de primera! Excelencia y experiencia.",
                    hs, 150 , cat, "adippet", new DataUbicacion("Brasil", "Florianópolis"), new DataUbicacion("China","Pekín"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM12.jpg")));
            cat.add("Hotel");
            cat.add("Playa");
            cat.add("2 dormitorios");
            cp.altaServicio("Luxury south beach corner apartment", "Beautiful large 2 bedrooms 2 bathrooms apartment CORNER UNIT. Marble floor throughout,\n" +
                            "beautiful open kitchen, granite counter top, spacious dining room area and living room area.\n" +
                            "Spectacular views of Miami from all windows and balcony",
                    hs, 300 , cat, "mHooch", new DataUbicacion("EEUU", "Miami"));
            
            hs = new HashSet<>();
            cat = new HashSet<>();
            hs.add(ImageIO.read(new File("Imagenes/IM8.png")));
            cat.add("Económico");
            cat.add("Auto");
            cat.add("Chevrolet");
            cp.altaServicio("Coche-Miami", "A useful car to travel around Miami.",
                    hs, 360 , cat, "mHooch", new DataUbicacion("EEUU", "Miami"));
            
            //Promociones
            Set<DataServicio> servicios = new HashSet<>();
            servicios.add(cp.infoServicio("moody", "Euro-Car-1"));
            servicios.add(cp.infoServicio("moody", "Euro-Car-2"));
            cp.altaPromocion("Euro-Cars-E-S", "moody", servicios, 30);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("moody", "Euro-Car-1"));
            servicios.add(cp.infoServicio("moody", "Euro-Car-3"));
            cp.altaPromocion("Euro-Cars-E-F", "moody", servicios, 30);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("moody", "Euro-Car-2"));
            servicios.add(cp.infoServicio("moody", "Euro-Car-3"));
            cp.altaPromocion("Euro-Cars-S-F", "moody", servicios, 30);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("remus", "Euro-Vuelo-S"));
            servicios.add(cp.infoServicio("remus", "Euro-Vuelo-LC"));
            cp.altaPromocion("Euro-Vuelos-S-LC", "remus", servicios, 40);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("remus", "Euro-Vuelo-S"));
            servicios.add(cp.infoServicio("remus", "Euro-Vuelo-FC"));
            cp.altaPromocion("Euro-Vuelos-S-FC", "remus", servicios, 40);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("remus", "Euro-Vuelo-LC"));
            servicios.add(cp.infoServicio("remus", "Euro-Vuelo-FC"));
            cp.altaPromocion("Euro-Vuelos-LC-FC", "remus", servicios, 40);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("mHooch", "Casa para p4 BsAs"));
            servicios.add(cp.infoServicio("mHooch", "Floripa G. House"));
            cp.altaPromocion("Sudamerica-Casas", "mHooch", servicios, 50);
            
            servicios = new HashSet<>();
            servicios.add(cp.infoServicio("mHooch", "Luxury south beach corner apartment"));
            servicios.add(cp.infoServicio("mHooch", "Coche-Miami"));
            cp.altaPromocion("Miami-Viaje", "mHooch", servicios, 30);
            
            //Reservas  
            int nro;
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("oWood");
            cr.seleccionarProveedor("remus");
            cr.seleccionarPublicacion("Euro-Vuelo-S", 1, df.parse("01-01-2015"), df.parse("01-01-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("01-01-2015"), nro);
            cr.actualizarEstado(nro, Estado.Facturada);
            
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("eWatson");
            cr.seleccionarProveedor("remus");
            cr.seleccionarPublicacion("Euro-Vuelo-S", 2, df.parse("01-01-2015"), df.parse("01-01-2015"));
            cr.seleccionarPublicacion("Euro-Vuelo-LC", 1, df.parse("01-01-2015"), df.parse("01-01-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("01-01-2015"), nro);
            cr.actualizarEstado(nro, Estado.Cancelada);
            
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("BruceS");
            cr.seleccionarProveedor("mHooch");
            cr.seleccionarPublicacion("Sudamerica-Casas", 1, df.parse("05-03-2015"), df.parse("02-04-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("05-03-2015"), nro);
            cr.actualizarEstado(nro, Estado.Pagada);
            
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("JeffW");
            cr.seleccionarProveedor("moody");
            cr.seleccionarPublicacion("Euro-Car-2", 1, df.parse("08-05-2015"), df.parse("12-05-2015"));
            cr.seleccionarPublicacion("Euro-Car-3", 1, df.parse("08-05-2015"), df.parse("12-05-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("08-05-2015"), nro);
            cr.actualizarEstado(nro, Estado.Pagada);
            
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("oWood");
            cr.seleccionarProveedor("tCook");
            cr.seleccionarPublicacion("Air-France-FC", 2, df.parse("07-08-2015"), df.parse("10-08-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("07-08-2015"), nro);
            
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("JeffW");
            cr.seleccionarProveedor("mHooch");
            cr.seleccionarPublicacion("Miami-Viaje", 1, df.parse("07-08-2015"), df.parse("14-08-2015"));
            cr.seleccionarPublicacion("Casa para p4 BsAs", 1, df.parse("14-08-2015"), df.parse("21-08-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("07-08-2015"), nro);
            
            cr.borrarPublicacionesSeleccionadas();
            cr.seleccionarCliente("BruceS");
            cr.seleccionarProveedor("remus");
            cr.seleccionarPublicacion("Euro-Vuelo-LC", 2, df.parse("07-08-2015"), df.parse("07-08-2015"));
            nro = cr.confirmarReserva();
            cr.cambiarFechaCreacionReserva(df.parse("07-08-2015"), nro);
        }
        else
            throw new IllegalArgumentException("Ya se ha realizado la carga una vez");
    }
    
}
