/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bruno
 */
public class Reserva {
    private static int id=1;
    
    private int numero_;
    private Date fecha_creacion_; 
    private Estado estado_;
    private float precio_total_; //calculado
    private Cliente cliente_;
    private Set<ReservaPublicacion> rp_;
    private int factura_;
      
    
    public Reserva(Estado estado, Cliente cliente){
        this.numero_=id;
        this.fecha_creacion_=new Date();
        this.estado_=estado;
        this.precio_total_=0;//se calcula cada vez que se agrega una publicacion
        this.cliente_=cliente;
        this.rp_=new HashSet<>();
        factura_ = -1;
        id++;
    }
    
    //getters
    
    public static int getCurrentID()
    {
        return id;
    }
    
    public int getNumero(){
        return numero_;
    }
    
    public Estado getEstado(){
        return estado_;
    }
    
    public Date getFechaCreacion(){
        return fecha_creacion_;
    }
    
    public int getFactura(){
        return factura_;
    }
    
    public void setFechaCreacion(Date f)
    {
        fecha_creacion_=f;
    }
    
    public float getPrecioTotal(){
        return precio_total_;
    }
    
    public Cliente getCliente(){
        return cliente_;
    }
    
    //setters
            
    public void setEstado(Estado e){
        this.estado_=e;
    }
   
    public void actualizarEstadoRegistrada(Estado e) throws Exception{
        if (this.estado_==Estado.Registrada){
            this.setEstado(e);
        }
        else{
            throw new IllegalArgumentException("El estado de la reserva debe ser Registrada");
        }
    }
    
    public void agregarReservaPublicacion(ReservaPublicacion rp){
	precio_total_ = precio_total_ + rp.getPrecioTotal();
        this.rp_.add(rp);
    }
    
    public Set<ReservaPublicacion> obtenerReservasPublicaciones(){
        return this.rp_;
    }
    
    public DataReserva infoReserva(){
        Set<ParDPD> conjDPD=new HashSet<>();
        for (ReservaPublicacion rp:rp_){
            ParDPD dpd=rp.infoReservaPublicacion();
            conjDPD.add(dpd);
        }
        DataReserva dr=new DataReserva(numero_, fecha_creacion_, estado_, 
            precio_total_, conjDPD, cliente_.getNickname());
        
        return dr;
    }
    
    public boolean esEliminable(){
        return (this.estado_==Estado.Registrada||this.estado_==Estado.Cancelada);
    }
    
    public void destroy() throws Exception{
        Cliente c=this.cliente_;
        c.eliminarReserva(this);
        
        for (ReservaPublicacion rp:this.rp_){
            rp.destroy();
        }
    }
    //agregar Publicacion (servicio o promocion)
    
    public int notificarFacturacion(){
        Iterator iter = rp_.iterator();
        int idFactura = -1;
        boolean flag = true;
        while(iter.hasNext() && flag){
            flag = ((ReservaPublicacion)iter.next()).estaFacturada();
        }
        if(flag){//Facturar
            estado_ = Estado.Facturada;
            //NOTIFICAR A CLIENTE Y CREAR COLUMNA EN DTB!
            //DATABASE 
            ManejadorFacturas mfc = ManejadorFacturas.getInstancia();
            try{
                idFactura = mfc.agregarFactura(fecha_creacion_, precio_total_, cliente_.getNickname(), numero_);
                if (idFactura != -1){
                    for(ReservaPublicacion rsp : rp_){
                        ParDPD pdpd = rsp.infoReservaPublicacion();
                        if(pdpd.getDpub() instanceof DataServicio)
                            mfc.agregarPublicacionAFactura(idFactura, pdpd.getDd().getCant(), pdpd.getDd().getFechaIni(), pdpd.getDd().getFechaFin(), pdpd.getDpub().getProveedor(), pdpd.getDpub().getNombre(), "Servicio",((DataServicio)pdpd.getDpub()).getPrecio());
                        else if(pdpd.getDpub() instanceof DataPromocion)
                            mfc.agregarPublicacionAFactura(idFactura, pdpd.getDd().getCant(), pdpd.getDd().getFechaIni(), pdpd.getDd().getFechaFin(), pdpd.getDpub().getProveedor(), pdpd.getDpub().getNombre(), "Promocion",((DataPromocion)pdpd.getDpub()).getPrecioTotal());
                    }
                factura_ = idFactura;
                }
            }catch(Exception e){
                System.out.print(e.getMessage());
            }
            // Recipient's email ID needs to be mentioned.
            String to = cliente_.getCorreoElectronico().toLowerCase();

            // Sender's email ID needs to be mentioned
            boolean configFlag = true;
            Properties config = new Properties();
            try{
                FileInputStream input;
                if(System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                    input = new FileInputStream(System.getProperty("user.home") + "/Documents/server.properties");
                else
                    input = new FileInputStream(System.getProperty("user.home") + "/Quick Order/server.properties");
                config.load(input);
            }catch(Exception e){
                configFlag = false;
            }
            String from = "do_not_respond@h4t.com";
            if(configFlag)
                from = config.getProperty("dirEmailFacturas");

            // Assuming you are sending email from localhost
            String host = "localhost";
            if(configFlag)
                host = config.getProperty("emailSmtpHost");

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            
            //Protocolo
            if(configFlag){
                properties.setProperty("mail.smtp.auth", config.getProperty("emailAuthentification"));
                properties.setProperty("mail.smtp.port", config.getProperty("emailPort"));
                if(config.getProperty("emailProtocol").equals("tls"))
                    properties.setProperty("mail.smtp.starttls.enable", "true");
                else if(config.getProperty("emailProtocol").equals("ssl")){
                    properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
                    properties.setProperty("mail.smtp.port", config.getProperty("emailPort"));
                }
                
            }
          
            Session session;
            // Get the default Session object.
            if(configFlag){
                if(config.getProperty("emailAuthentification").equals("true")){
                    session = Session.getDefaultInstance(properties,
			new javax.mail.Authenticator() {
                                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(config.getProperty("usuarioEmail"),config.getProperty("passwordEmail"));
				}
			});
                }
                else
                    session = Session.getDefaultInstance(properties); 
            }
            else
                session = Session.getDefaultInstance(properties);
            try{
               // Create a default MimeMessage object.
               MimeMessage message = new MimeMessage(session);

               // Set From: header field of the header.
               message.setFrom(new InternetAddress(from));

               // Set To: header field of the header.
               message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

               // Set Subject: header field
               DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
               message.setSubject("[Help4Traveling] [" + df.format(new Date()) + "]");

               // Now set the actual message
               String Message = "Estimado " + cliente_.getNombre() + " " + cliente_.getApellido();
               Message = Message + ". Su compra ha sido facturada con exito: \n\n";
               Message = Message + "--Detalles de la compra\n";
               for(ReservaPublicacion rsp : rp_){
                   ParDPD pdpd = rsp.infoReservaPublicacion();
                   if(pdpd.getDpub() instanceof DataServicio){
                       Message = Message + "-Nombre: " + pdpd.getDpub().getNombre();
                       Message = Message + " -Tipo: Servicio";
                       Message = Message + " -Cantidad: " + Integer.toString(pdpd.getDd().getCant());
                       Message = Message + " -$" + String.format("%.2f",(pdpd.getDd().getCant() * ((DataServicio)pdpd.getDpub()).getPrecio()));
                       IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
                       DataUsuario dtu = cu.infoProveedor(pdpd.getDpub().getProveedor());
                       Message = Message + " -Proveedor: " + dtu.getNombre() + " " + dtu.getApellido() + "\n";
                   }
                   if(pdpd.getDpub() instanceof DataPromocion){
                       Message = Message + "-Nombre: " + pdpd.getDpub().getNombre();
                       Message = Message + " -Tipo: Promoción";
                       Message = Message + " -Cantidad: " + Integer.toString(pdpd.getDd().getCant());
                       Message = Message + " -$" + String.format("%.2f",(pdpd.getDd().getCant() * ((DataPromocion)pdpd.getDpub()).getPrecioTotal()));
                       IControladorUsuario cu = FabricaControladores.getInstancia().getControladorUsuario();
                       DataUsuario dtu = cu.infoProveedor(pdpd.getDpub().getProveedor());
                       
                       Message = Message + " -Proveedor: " + dtu.getNombre() + " " + dtu.getApellido() + "\n";
                   }
               }
                
                
                Message = Message + "-Precio total: $" + String.format("%.2f", precio_total_) + "\n";
                
                if(idFactura != -1)
                    Message = Message + " Puedes ver la factura siguiendo este link: <a href='http://localhost:8080/t2tpgr32/VerFactura?id=" + idFactura + "'>Ver factura</a>\n";
                
                Message = Message + "\n\nGracias por preferirnos,\nSaludos.\nHelp4Traveling";
               
               message.setText(Message);

               // Send message
               Transport.send(message);
               
            }catch (MessagingException mex) {
               System.out.println("Error al enviar el correo... revisar el servidor.\n" + mex.getMessage());
            }
            
        }
        return idFactura;
        
    }
    
}