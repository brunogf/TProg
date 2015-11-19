/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;

/**
 *
 * @author spesamosca
 */
public class ReservaPublicacion {

    private Date fechaIni_;
    private Date fechaFin_;
    private int cant_;
    private Publicacion pub_;
    private Reserva res_;
    boolean facturada;

    public ReservaPublicacion() {
        //default constructor
        facturada = false;
    }

    public ReservaPublicacion(Reserva res, Publicacion pub, Date inicio, Date fin, int cant) {
        res_ = res;
        pub_ = pub;
        fechaIni_ = inicio;
        fechaFin_ = fin;
        cant_ = cant;
        facturada = false;
    }

    public ReservaPublicacion(Reserva res, Publicacion pub, DataDisponibilidad dtd) {
        this(res, pub, dtd.getFechaIni(), dtd.getFechaFin(), dtd.getCant());
    }

    public Date getFechaIni() {
        return fechaIni_;
    }

    public Date getFechaFin() {
        return fechaFin_;
    }

    public String getNombrePublicacion() {
        return pub_.getNombre();
    }

    public Reserva getReserva() {
        return res_;
    }

    public float getPrecioTotal() {
        if (pub_ instanceof Servicio) {
            return (((Servicio) pub_).getPrecio() * cant_);
        } else {
            return (((Promocion) pub_).getPrecioTotal() * cant_);
        }
    }

    public ParDPD infoReservaPublicacion() {
        DataDisponibilidad dtd = new DataDisponibilidad(cant_, fechaIni_, fechaFin_);
        DataPublicacion dtp = pub_.infoPublicacion();

        ParDPD dpd = new ParDPD(dtp, dtd);
        return dpd;
    }

    public void destroy() {
        this.pub_.eliminarReservaPublicacion(this);
        this.res_ = null;
    }

    public int getCant() {
        return this.cant_;
    }

    public int getNroReserva() {
        return res_.getNumero();
    }

    public boolean estaFacturada() {
        return facturada;
    }

    public int facturarReserva() {
        facturada = true;
        if (res_.getEstado() != Estado.Facturada) {
            return res_.notificarFacturacion();
        }
        return -1;
    }

    ParDPD infoReservaPublicacionPorProveedor(String proveedor, String publicacion) {
        if (pub_.getProveedor().getNickname().equals(proveedor) && pub_.getNombre().equals(publicacion)) {
            DataDisponibilidad dtd = new DataDisponibilidad(cant_, fechaIni_, fechaFin_);
            DataPublicacion dtp = pub_.infoPublicacion();
            ParDPD dpd = new ParDPD(dtp, dtd);
            return dpd;
        } 
        return null;
    }

    ParDPD infoReservaPorProveedor(String nick) {
        if (pub_.getProveedor().getNickname().equalsIgnoreCase(nick)){
            DataDisponibilidad dtd = new DataDisponibilidad(cant_, fechaIni_, fechaFin_);
            DataPublicacion dtp = pub_.infoPublicacion();
            ParDPD dpd = new ParDPD(dtp, dtd);
            return dpd;
        }
        return null;
    }
}
