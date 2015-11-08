/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author piñe
 */
public class ControladorReserva implements IControladorReserva{
    
    private Cliente cliente_;
    private Set<ParPD> colPub_;
    private Proveedor proveedor_;
    
    
    
    public ControladorReserva(){
        colPub_=new HashSet<>();        
    }
    
    public void actualizarEstado(int nro, Estado estado) throws Exception{
        ManejadorReserva mr=ManejadorReserva.getInstance();
        Reserva r=mr.encontrarReserva(nro);
        r.actualizarEstadoRegistrada(estado);
    }
    
    public void bajaReserva(int nro) throws Exception{
        ManejadorReserva mr=ManejadorReserva.getInstance();
        Reserva r=mr.encontrarReserva(nro);
        
        if (r.esEliminable()){
            mr.eliminarReserva(nro);
            r.destroy();
        }else throw new IllegalArgumentException("La reserva no se puede eliminar");
    }
    
    public int confirmarReserva()
    {
        Reserva r = new Reserva(Estado.Registrada, cliente_);
	Iterator<ParPD> it = colPub_.iterator();
	ReservaPublicacion rp;
	ParPD par;
	while(it.hasNext())
	{
	     par = it.next();
	     rp = new ReservaPublicacion(r,par.getPublicacion(),par.getDisponibilidad());
	     //agrega la publicacion a la reserva
	     r.agregarReservaPublicacion(rp);
	     //agrega la reserva a la publicacion
	     par.getPublicacion().agregarReservaPublicacion(rp);
	}
	//agrega la reserva al cliente
	cliente_.agregarReserva(r);
	ManejadorReserva mr=ManejadorReserva.getInstance();
        mr.agregarReserva(r);
        return r.getNumero();
    }
    
    public DataReserva infoReserva(int nro){
        ManejadorReserva mr=ManejadorReserva.getInstance();
        Reserva r=mr.encontrarReserva(nro);
        
        return r.infoReserva();
    }
    
    public List<DataReserva> listarReservas(){
        ManejadorReserva mr=ManejadorReserva.getInstance();
        List<DataReserva> lista=mr.listarReservas();
        
        Collections.sort(lista, new Comparator<DataReserva>() {
            public int compare(DataReserva d1, DataReserva d2) {
                return (d1.getNum() < d2.getNum() ? -1 : (d1.getNum() == d2.getNum() ? 0 : 1));
            }
        });
        return lista;
    }
    
    public void seleccionarCliente(String cliente){
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
	try
	{
	    cliente_ = mu.encontrarCliente(cliente);
	}catch(Exception ex)
	{
	    //ex.getMessage();
	    throw ex;
	}
    }
    
    public void seleccionarPublicacion(String nombre,
                                       int cantidad, Date inicio, Date fin){
	
	try
        {
	     Publicacion pub = proveedor_.encontrarPublicacion(nombre);
	     if (pub == null)
		 throw new IllegalArgumentException("No se encontro la publicacion");
	     DataDisponibilidad dd = new DataDisponibilidad(cantidad, inicio, fin);
               colPub_.add(new ParPD(pub,dd));//Guarda el PAR de la publicaicon y su disponibilidad	     
	}catch(Exception ex)
	{
	    //ex.getMessage();
	    throw ex;
	}               
    }
    public void seleccionarProveedor(String nickname)
    {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        proveedor_ = mu.encontrarProveedor(nickname);
    }
    
    public String getNickProveedorSeleccionado()
    {
        return proveedor_.getNickname();
    }
    
    public DataProveedor getInfoProveedorSeleccionado()
    {
        if (!(proveedor_ instanceof Proveedor))
            throw new IllegalArgumentException("No se encuentra proveedor seleccionado.");
        return (DataProveedor)proveedor_.infoUsuario();
    }
    
    public DataCliente getInfoClienteSeleccionado()
    {
        if(!(cliente_ instanceof Cliente))
            throw new IllegalArgumentException("No se encontro el cliente seleccionado");
        return (DataCliente)cliente_.infoUsuario();
    }
    
    public void borrarPublicacionesSeleccionadas()
    {
        colPub_ = new HashSet<>();
    }
    
    public int getNumeroReservas()
    {
        return Reserva.getCurrentID();
    }
    
    public DataUsuario getInfoClienteReserva(int nro){
        ManejadorReserva mr=ManejadorReserva.getInstance();
        Reserva r=mr.encontrarReserva(nro);
        
        return r.getCliente().infoUsuario();
    }
    
    public void cambiarFechaCreacionReserva(Date f, int r)
    {
        ManejadorReserva mr = ManejadorReserva.getInstance();
        Reserva res = mr.encontrarReserva(r);
        res.setFechaCreacion(f);
    }
    
    public void facturarReserva(String nickname, int nro){
        ManejadorReserva mr = ManejadorReserva.getInstance();
        if (mr.encontrarReserva(nro).getEstado() == Estado.Pagada){
            ManejadorUsuario mu = ManejadorUsuario.getInstance();
            Usuario prov = mu.encontrarProveedor(nickname);
            ((Proveedor)prov).facturarReserva(nro);
        }       
    }
    
    public byte[] obtenerFactura(int id){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tpgr32PU");
            EntityManager em = emf.createEntityManager();
            Facturas factura = em.find(Facturas.class, id);
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();
            DateFormat df = new SimpleDateFormat("dd-MM-yyy");
            String infoFactura = "Nro: " + factura.getNroReserva() + "\n";
            infoFactura = infoFactura + "Cliente: " + factura.getNickCliente() + "\n";
            infoFactura = infoFactura + "Fecha: " + df.format(factura.getFechaGenerada()) + "\n";
            infoFactura = infoFactura + "Precio total: $" + String.format("%.2f", factura.getMontoTotal());
            document.add(new Paragraph(infoFactura));
            //Query query = em.createNamedQuery("SELECT pf FROM PublicacionFactura pf", PublicacionFactura.class);
            //List<PublicacionFactura> lista = query.getResultList();
            document.close();
            
            //FileOutputStream fos = new FileOutputStream("D://generated.pdf");
            //fos.write(baos.toByteArray());
            //fos.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return baos.toByteArray();
    }
    
}
