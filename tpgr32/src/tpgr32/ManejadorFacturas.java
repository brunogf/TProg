/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nico
 */
public class ManejadorFacturas {
    private static ManejadorFacturas instancia_ = null;
    private EntityManagerFactory emf;

    private ManejadorFacturas(){
        emf = javax.persistence.Persistence.createEntityManagerFactory("tpgr32PU");
    }
    
    public static ManejadorFacturas getInstancia(){
        if (instancia_ == null)
            instancia_ = new ManejadorFacturas();
        return instancia_;
    }
    
    public int agregarFactura(Date creacion, float monto, String nickCliente, int nroReserva){
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        Facturas factura = new Facturas();
        int id = -1;
        factura.setFechaGenerada(creacion);
        factura.setMontoTotal(monto);
        factura.setNickCliente(nickCliente);
        factura.setNroReserva(nroReserva);
        try{
            em.persist(factura);
            em.getTransaction().commit();
            id = factura.getId();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }finally{
            em.close();
        }
        return id;
    }
    
    public Facturas encontrarFactura(int id) throws IllegalArgumentException{
        EntityManager em = emf.createEntityManager();  
        TypedQuery<Facturas> query1 = em.createQuery("SELECT f FROM Facturas f WHERE f.id = " + String.valueOf(id),Facturas.class);
        List<Facturas> lista1 = query1.getResultList();
        Facturas factura = null;
        if (lista1.size() < 1)
            throw new IllegalArgumentException("No se encontro la factura");
        for(Facturas fac : lista1)
            factura = fac;
        return factura;
    }
    
    public List<PublicacionFactura> encontrarServiciosFactura(int idFactura){
        EntityManager em = emf.createEntityManager();  
        TypedQuery<PublicacionFactura> query = em.createQuery("SELECT p FROM PublicacionFactura p WHERE p.tipo = 'Servicio' AND p.factura.id = " + String.valueOf(idFactura),PublicacionFactura.class);
        return query.getResultList();
    }
    
    public List<PublicacionFactura> encontrarPromocionesFactura(int idFactura){
        EntityManager em = emf.createEntityManager();  
        TypedQuery<PublicacionFactura> query = em.createQuery("SELECT p FROM PublicacionFactura p WHERE p.tipo = 'Servicio' AND p.factura.id = " + String.valueOf(idFactura),PublicacionFactura.class);
        return query.getResultList();
    }
    
    public void agregarPublicacionAFactura(int factura, int cant, Date fini, Date ffin, String nickProveedor, String nombrePub, String tipo, float precio) throws IllegalArgumentException{
        EntityManager em = emf.createEntityManager();  
        Facturas fac = encontrarFactura(factura);
        PublicacionFactura pubf = new PublicacionFactura();
        pubf.setCant(cant);
        pubf.setFechaInicio(fini);
        pubf.setFechaFin(ffin);
        pubf.setNickProveedor(nickProveedor);
        pubf.setNombre(nombrePub);
        pubf.setTipo(tipo);
        pubf.setFactura(fac);
        pubf.setPrecio(precio);
        try{
        em.getTransaction().begin();
        em.persist(pubf);
        em.getTransaction().commit();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }finally{
            em.close();
        }
    }
    
}
