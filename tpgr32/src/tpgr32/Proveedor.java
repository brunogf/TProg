/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nicolás Rostán
 */
public class Proveedor extends Usuario {
    private String nomEmpresa_;
    private String url_;
    private Map<String, Publicacion> publicaciones_;
    
    public Proveedor(String nom, String apellido, String nickName, String cElec, Date f,String empresa, String url, String pass)
    {
	super(nom,apellido,nickName,cElec,f,pass);
	nomEmpresa_ = empresa;
        publicaciones_ = new HashMap<>();
	url_ = url;
    }
    
    public Proveedor(String nom, String apellido, String nickName, String cElec, Date f,String empresa, String url, String img, String pass)
    {
	super(nom,apellido,nickName,cElec,f,pass);
	nomEmpresa_ = empresa;
        publicaciones_ = new HashMap<>();
        super.cambiarImagen(img);
	url_ = url;
    }
    
    public String getNombreEmpresa()
    {
	return nomEmpresa_;
    }
    
    public String getURL()
    {
	return url_;
    }
    
    public void setNombreEmpresa(String n)
    {
	nomEmpresa_ = n;
    }
    
    public void setURL(String u)
    {
	url_ = u;
    }
    
    public Publicacion encontrarPublicacion(String pub)
    {
	Publicacion p = publicaciones_.get(pub);
	return p;
    }
    
    // al retornar el dt del Proveedor ya le agrego los dtPublicaciones de sus Publicaciones
    @Override
     public DataUsuario infoUsuario() {
        DataProveedor dtProv = new DataProveedor(this.nickname,this.nombre,this.apellido,this.correoElec,this.fechaNacimiento,
        this.nomEmpresa_,this.url_, this.imagen); 
        for(String key : this.publicaciones_.keySet()) {
            Publicacion p = this.publicaciones_.get(key);
            dtProv.agregarPublicacion(p.infoPublicacion());
        }
        return dtProv;     
    }
         
    public void agregarPublicacion(Publicacion p){
        publicaciones_.put(p.getNombre(), p);
    }
    
    public DataServicio infoServicio(String nombre){
        Publicacion pub = publicaciones_.get(nombre);
	if (!(pub instanceof Servicio))
	    throw new IllegalArgumentException("No se encontro el servicio");
	Servicio ser = (Servicio)pub;
        DataServicio servicio =(DataServicio) ser.infoPublicacionCompleto();
        return servicio;
    }
    
    public Set<DataPublicacion> listarPublicaciones()
    {
        Set<DataPublicacion> publicaciones = new HashSet<>();
        for(Map.Entry<String, Publicacion> entry : publicaciones_.entrySet())
        {
            publicaciones.add(entry.getValue().infoPublicacion());
        }
        return publicaciones;
    }
 
    // servicios del proveedor
    public Set<DataPublicacion> listarServicios()
    {
         Set<DataPublicacion> s = new HashSet<>();
        for(String key : this.publicaciones_.keySet()) {
            Publicacion p = this.publicaciones_.get(key);
            s.add(p.infoPublicacion());
        }
        return s;
    }
    
    public DataPromocion infoPromocion(String promo){
        Promocion p = (Promocion) encontrarPublicacion(promo);
        Set<DataServicio> servicios = p.getConjDataServicios();
        DataPromocion dataP = new DataPromocion(p.getNombre(), p.getDescuento(), super.nickname, p.getPrecioTotal());             
        for (DataServicio pub: servicios){             
                    dataP.agregarServicio((DataServicio)pub);
                }       
        return dataP;
    }
  
    public DataPublicacion getInfoServicioCompleto(String nombre) {
        Servicio p = (Servicio)this.publicaciones_.get(nombre);
        return p.infoPublicacionCompleto();
    }
    
    public int facturarReserva(int nro){
        int idFactura = -1;
        Set<String> keys = publicaciones_.keySet();
        Iterator iter = keys.iterator();
        while(iter.hasNext() && (idFactura == -1)) {
            Publicacion p = this.publicaciones_.get(iter.next());
            idFactura = p.facturarReserva(nro);
        }
        return idFactura;
    }
    
}
