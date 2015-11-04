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
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import tpgr32.DataServicio;
import tpgr32.DataServicioBean;
import tpgr32.DataUbicacion;
import tpgr32.FabricaControladores;

/**
 *
 * @author Nico
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PublicadorControladorPublicacion {
    private Endpoint endpoint = null;
    
    public PublicadorControladorPublicacion(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
        String srv = "";
        try{
            BufferedReader in = new BufferedReader(new FileReader("server.txt"));
            srv = in.readLine();
            in.close();
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
    public void agregarCategoriaServicio(String cat){
        FabricaControladores.getInstancia().getControladorPublicacion().agregarCategoriaServicio(cat);
    }
    
    @WebMethod
    public void altaPromocion(String nombre, String proveedor, DataServicioBean[] servicios, float descuento){
        Set<DataServicio> serv = new HashSet<DataServicio>();
        for(int i = 0; i < servicios.length; i++){
            Set<String> cats = new HashSet<String>();
            for (int j = 0; j < servicios[i].getCategorias().length; j++)
                cats.add(servicios[i].getCategorias()[i]);
            DataServicio dts = new DataServicio(servicios[i].getNombre(),servicios[i].getDescripcion(), servicios[i].getPrecio(), servicios[i].getProveedor(), cats);
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
    
    
    @WebMethod
    public void eliminarCategoriaServicio(String cat){
        FabricaControladores.getInstancia().getControladorPublicacion().eliminarCategoriaServicio(cat);
    }
    
    
}
