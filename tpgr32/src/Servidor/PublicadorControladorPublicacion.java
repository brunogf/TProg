/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.ws.Endpoint;
import tpgr32.CatTree;
import tpgr32.DataLog;
import tpgr32.DataPromocion;
import tpgr32.DataPublicacion;
import tpgr32.DataServicio;
import tpgr32.DataServicioBean;
import tpgr32.DataUbicacion;
import tpgr32.FabricaControladores;
import tpgr32.IControladorPublicacion;
import tpgr32.Servicio;

/**
 *
 * @author Nico
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PublicadorControladorPublicacion {
    private Endpoint endpoint = null;
    //private IControladorPublicacion cpub = null;
    
    
    public PublicadorControladorPublicacion(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
        String srv = "http://";
        Properties config = new Properties();
        try{
            FileInputStream input;
            if(System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                input = new FileInputStream(System.getProperty("user.home") + "/Documents/server.properties");
            else
                input = new FileInputStream(System.getProperty("user.home") + "/Quick Order/server.properties");
            config.load(input);
            srv = srv + config.getProperty("host") +":"+ config.getProperty("port");
        }catch(Exception e){
            srv = "http://localhost:9128";
        }
        
        endpoint = Endpoint.publish(srv + "/controlador_publicacion", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    
    
    @WebMethod
    public void altaPromocion(String nombre, String proveedor, DataServicioBean[] servicios, float descuento){
        Set<DataServicio> serv = new HashSet<DataServicio>();
        for(int i = 0; i < servicios.length; i++){
            Set<String> cats = new HashSet<String>();
            for (int j = 0; j < servicios[i].getCategorias().length; j++)
                cats.add(servicios[i].getCategorias()[i]);
            DataServicio dts = new DataServicio(servicios[i].getNombre(),servicios[i].getDescripcion(), servicios[i].getPrecio(), servicios[i].getProveedor(), cats, servicios[i].getCantVisitas());
            serv.add(dts);
        }
        FabricaControladores.getInstancia().getControladorPublicacion().altaPromocion(nombre, proveedor, serv, descuento);
    }
    
    
    @WebMethod
    public void altaServicioSinDestino(String nombre, String descripcion, byte[][] imagenes, float precio, String[] categorias, String proveedor, DataUbicacion origen){
        Set<Image> imgs= new HashSet<Image>();
        BufferedImage bimg = null;
        for(int i = 0; i < imagenes.length; i++){
            try{
                bimg = ImageIO.read(new ByteArrayInputStream(imagenes[i]));
            }catch(Exception e){
                System.out.print("Error al leer una imagen en altaServicioSinDestino linea 81");
            }
            imgs.add(bimg);
        }
        Set<String> cats = new HashSet<String>();
        for(int i = 0; i < categorias.length; i++){
            cats.add(categorias[i]);
        }
                
        FabricaControladores.getInstancia().getControladorPublicacion().altaServicio(nombre, descripcion, imgs, precio, cats, proveedor, origen);
    }
    
    @WebMethod
    public void altaServicioConDestino(String nombre, String descripcion,byte[][] imagenes, float precio, String[] categorias, String proveedor, DataUbicacion origen, DataUbicacion destino){
        Set<Image> imgs= new HashSet<Image>();
        BufferedImage bimg = null;
        for(int i = 0; i < imagenes.length; i++){
            try{
                bimg = ImageIO.read(new ByteArrayInputStream(imagenes[i]));
            }catch(Exception e){
                System.out.print("Error al leer una imagen en altaServicioSinDestino linea 81");
            }
            imgs.add(bimg);
        }
        Set<String> cats = new HashSet<String>();
        for(int i = 0; i < categorias.length; i++){
            cats.add(categorias[i]);
        }
        
        FabricaControladores.getInstancia().getControladorPublicacion().altaServicio(nombre, descripcion, imgs, precio, cats, proveedor, origen, destino);
    }
    
    
    /*@WebMethod
    public void eliminarCategoriaServicio(String cat){
        cpub.eliminarCategoriaServicio(cat);
    }*/
    
    @WebMethod
    public DataPromocion infoPromocion(String proveedor, String promo){
        return FabricaControladores.getInstancia().getControladorPublicacion().infoPromocion(proveedor, promo);
    }
    
    @WebMethod
    public DataServicioBean infoServicio(String proveedor, String servicio){
        DataServicio dts = FabricaControladores.getInstancia().getControladorPublicacion().infoServicio(proveedor, servicio);
        String[] cats = new String[dts.getCategorias().size()];
        int iter = 0;
        for (String cat : dts.getCategorias()){
            cats[iter] = cat;
            iter++;
        }       
        DataServicioBean dtsb = new DataServicioBean(dts.getNombre(), dts.getDescripcion(), dts.getPrecio(),
                                                     dts.getProveedor(), cats, dts.getCantVisitas(),dts.getPaisOrigen(),
                                                     dts.getPaisDestino(), dts.getCiudadOrigen(), dts.getCiudadDestino());
        
        Set<Image> simg = dts.getImagenes();
        byte[][] imagenes = new byte[simg.size()][];
        iter = 0;
        BufferedImage bimg = null;
        ByteArrayOutputStream bArray = new ByteArrayOutputStream();
        for(Image img : simg){
            if (img != null){
                try{
                    ImageIO.write((BufferedImage)img, "jpg", bArray);
                    imagenes[iter] = bArray.toByteArray();
                    bArray = new ByteArrayOutputStream();
                }catch(Exception e){
                    imagenes[iter] = null;
                }
            }
            iter++;
        }
        dtsb.setImagenes(imagenes);
        return dtsb;
    }
    
    @WebMethod
    public DataPromocion[] listarPromociones(){
        Set<DataPromocion> sdtp = FabricaControladores.getInstancia().getControladorPublicacion().listarPromociones();
        DataPromocion[] ret = new DataPromocion[sdtp.size()];
        int iter = 0;
        for(DataPromocion dtp : sdtp){
            ret[iter] = dtp;
            iter++;
        }
        return ret;
    }
    
    @WebMethod
    public DataServicioBean[] listarServicios(){
        Set<DataServicio> sdts = FabricaControladores.getInstancia().getControladorPublicacion().listarServicios();
        DataServicioBean[] ret = new DataServicioBean[sdts.size()];
        int iter = 0;
        String[] cats;
        for(DataServicio dts : sdts){
            cats = new String[dts.getCategorias().size()];
            int iter2 = 0;
            for (String cat : dts.getCategorias()){
                cats[iter2] = cat;
            iter2++;
            }
            
            ret[iter] = new DataServicioBean(dts.getNombre(), dts.getDescripcion(), dts.getPrecio(), dts.getProveedor(),cats, dts.getCantVisitas(),
                                             dts.getPaisOrigen(),dts.getPaisDestino(), dts.getCiudadOrigen(), dts.getCiudadDestino());
            
            iter2 = 0;                
            Set<Image> simg = dts.getImagenes();
            if ((simg != null) &&(simg.size() > 0)){
                byte[][] imagenes = new byte[simg.size()][];
                ByteArrayOutputStream bArray = new ByteArrayOutputStream();
                for(Image img : simg){
                    if (img != null){
                        try{
                            ImageIO.write((BufferedImage)img, "jpg", bArray);
                            imagenes[iter2] = bArray.toByteArray();
                            bArray = null;
                        }catch(Exception e){
                            imagenes[iter2] = null;
                        }
                    }
                    iter2++;
                }
            }
            iter++;
            
        }
        return ret;
    }
    
    @WebMethod
    public DataServicioBean[] listarServiciosDeCategoria(String cat){
        Set<DataServicio> sdts = FabricaControladores.getInstancia().getControladorPublicacion().listarServiciosDeCategoria(cat);
        DataServicioBean[] ret = new DataServicioBean[sdts.size()];
        int iter = 0;
        String[] cats;
        for(DataServicio dts : sdts){
            cats = new String[dts.getCategorias().size()];
            int iter2 = 0;
            for (String categoria : dts.getCategorias()){
                cats[iter2] = categoria;
            iter2++;
            }
            
            ret[iter] = new DataServicioBean(dts.getNombre(), dts.getDescripcion(), dts.getPrecio(), dts.getProveedor(),cats, dts.getCantVisitas(),
                                             dts.getPaisOrigen(),dts.getPaisDestino(), dts.getCiudadOrigen(), dts.getCiudadDestino());
            
            iter2 = 0;                
            Set<Image> simg = dts.getImagenes();
            if ((simg != null) &&(simg.size() > 0)){
                byte[][] imagenes = new byte[simg.size()][];
                ByteArrayOutputStream bArray = new ByteArrayOutputStream();
                for(Image img : simg){
                    if (img != null){
                        try{
                            ImageIO.write((BufferedImage)img, "jpg", bArray);
                            imagenes[iter2] = bArray.toByteArray();
                            bArray = null;
                        }catch(Exception e){
                            imagenes[iter2] = null;
                        }
                    }
                    iter2++;
                }
                ret[iter].setImagenes(imagenes);
            }
            iter++;
            
        }
        return ret;
    }
    
    /*@WebMethod
    public void modificarDescripcionServicio(String des){
        cpub.modificarDescripcionServicio(des);
    }
    
    @WebMethod
    public void modificarImagenesServicio(byte[][] imagenes){
        Set<Image> imgs= new HashSet<Image>();
        BufferedImage bimg = null;
        for(int i = 0; i < imagenes.length; i++){
            try{
                bimg = ImageIO.read(new ByteArrayInputStream(imagenes[i]));
            }catch(Exception e){
                System.out.print("Error al leer una imagen en altaServicioSinDestino linea 81");
            }
            imgs.add(bimg);
        }
        
        cpub.modificarImagenesServicio(imgs);
    }
    
    @WebMethod
    public void modificarPrecioServicio(float precio){
        cpub.modificarPrecioServicio(precio);
    }
    
    @WebMethod
    public void eliminarDestinoServicio(){
        cpub.eliminarDestinoServicio();
    }*/
    
    @WebMethod
    public void registrarCategoria(String nombre){
        FabricaControladores.getInstancia().getControladorPublicacion().registrarCategoria(nombre);
    }
    
    @WebMethod
    public void registrarCategoriaConPadre(String nombre, String padre){
        FabricaControladores.getInstancia().getControladorPublicacion().registrarCategoria(nombre, padre);
    }
    /*
    @WebMethod
    public void seleccionarServicio(String proveedor, String nombre){
        cpub = FabricaControladores.getInstancia().getControladorPublicacion();
        cpub.seleccionarServicio(proveedor, nombre);
    }*/
    
    @WebMethod
    public DataPublicacion[] buscarPublicacion(String criterio){
        Set<DataPublicacion> sdtp = FabricaControladores.getInstancia().getControladorPublicacion().buscarPublicacion(criterio);
        DataPublicacion[] adtp = new DataPublicacion[sdtp.size()];
        int iter = 0;
        for(DataPublicacion dtp : sdtp){
            if(dtp instanceof DataServicio){
                String[] cats;
                cats = new String[((DataServicio)dtp).getCategorias().size()];
                int iter2 = 0;
                for (String categoria : ((DataServicio)dtp).getCategorias()){
                    cats[iter2] = categoria;
                iter2++;
                }
                adtp[iter] = new DataServicioBean(dtp.getNombre(), ((DataServicio)dtp).getDescripcion(), ((DataServicio)dtp).getPrecio(),((DataServicio)dtp).getProveedor(), cats, ((DataServicio)dtp).getCantVisitas(),
                                                 ((DataServicio)dtp).getPaisOrigen(),((DataServicio)dtp).getPaisDestino(), ((DataServicio)dtp).getCiudadOrigen(), ((DataServicio)dtp).getCiudadDestino());
            }
            else
                adtp[iter] = dtp;
            iter++;
        }
        return adtp;
    }
    
    @WebMethod
    public DataPublicacion[] buscarPublicacionCompleta(String criterio){
        Set<DataPublicacion> sdtp = FabricaControladores.getInstancia().getControladorPublicacion().buscarPublicacionCompleta(criterio);
        DataPublicacion[] adtp = new DataPublicacion[sdtp.size()];
        int iter = 0;
        for(DataPublicacion dtp : sdtp){
            if(dtp instanceof DataServicio){
                String[] cats;
                cats = new String[((DataServicio)dtp).getCategorias().size()];
                int iter2 = 0;
                for (String categoria : ((DataServicio)dtp).getCategorias()){
                    cats[iter2] = categoria;
                iter2++;
                }
                adtp[iter] = new DataServicioBean(dtp.getNombre(), ((DataServicio)dtp).getDescripcion(), ((DataServicio)dtp).getPrecio(),((DataServicio)dtp).getProveedor(), cats, ((DataServicio)dtp).getCantVisitas(),
                                                  ((DataServicio)dtp).getPaisOrigen(),((DataServicio)dtp).getPaisDestino(), ((DataServicio)dtp).getCiudadOrigen(), ((DataServicio)dtp).getCiudadDestino());
                //Si es necsario ver imagenes en datatypes de este metodo borrar comentario
                /*
                Set<Image> simg = ((DataServicio)dtp).getImagenes();
                iter2 = 0;                
                if ((simg != null) &&(simg.size() > 0)){
                    byte[][] imagenes = new byte[simg.size()][];
                    ByteArrayOutputStream bArray = new ByteArrayOutputStream();
                    for(Image img : simg){
                        if (img != null){
                            try{
                                ImageIO.write((BufferedImage)img, "jpg", bArray);
                                imagenes[iter2] = bArray.toByteArray();
                                bArray = null;
                            }catch(Exception e){
                                imagenes[iter2] = null;
                            }
                        }
                        iter2++;
                    }
                    
                    ((DataServicioBean)adtp[iter]).setImagenes(imagenes);
                }*/
            }
            else
                adtp[iter] = dtp;
            iter++;
        }
        return adtp;
    }
    
    
    @WebMethod
     public CatTree getCatTree(){
         return FabricaControladores.getInstancia().getControladorPublicacion().getCatTree();
     }
     
     @WebMethod
     public DataServicioBean[] listarServiciosDePromocion(String proveedor, String promo){
         DataPromocion dtp = FabricaControladores.getInstancia().getControladorPublicacion().infoPromocion(proveedor, promo);
         Set<DataServicio> sdts = dtp.getServicios();
         DataServicioBean[] dtsba = null;
         if ((sdts != null)|| (!sdts.isEmpty())){
             int iter = 0;
             dtsba = new DataServicioBean[sdts.size()];
             for(DataServicio dts : sdts){
                String[] cats;
                cats = new String[dts.getCategorias().size()];
                int iter2 = 0;
                for (String categoria : dts.getCategorias()){
                    cats[iter2] = categoria;
                iter2++;
                }
                dtsba[iter] = new DataServicioBean(dts.getNombre(), dts.getDescripcion(), dts.getPrecio(), dts.getProveedor(), cats, dts.getCantVisitas(),
                dts.getPaisOrigen(),dts.getPaisDestino(), dts.getCiudadOrigen(), dts.getCiudadDestino());
                iter++;
             }
             
         }
         return dtsba;
     }
     
    @WebMethod
    public void agregarLog(String  IP, String browser, String URL, String SO, String fecha, String nombre, String proveedor) throws ParseException{
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");       
        DataLog log = new DataLog(IP, browser, URL, SO, df.parse(fecha));
        FabricaControladores.getInstancia().getControladorPublicacion().agregarLog(log,nombre,proveedor);        
    }
    
    
}