/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author spesamosca
 */
public abstract class Publicacion {

    private String nombre_;
    private Usuario proveedor_;
    private Set<ReservaPublicacion> rp_;

    public Publicacion() {

    }

    public Publicacion(String nombre, Proveedor p) {
        this.nombre_ = nombre;
        this.rp_ = new HashSet<>();
        this.proveedor_ = p;
    }

    public void setNombre(String nombre) {
        this.nombre_ = nombre;
    }

    public String getNombre() {
        return this.nombre_;
    }

    public Usuario getProveedor() {
        return proveedor_;
    }

    public void agregarReservaPublicacion(ReservaPublicacion rp) {
        rp_.add(rp);
    }

    public void eliminarReservaPublicacion(ReservaPublicacion rp) {
        this.rp_.remove(rp);
    }

    public abstract DataPublicacion infoPublicacion();

    public int facturarReserva(int nro) {
        int idFactura = -1;
        for (ReservaPublicacion rp : rp_) {
            if ((rp.getNroReserva() == nro) && (idFactura == -1)) {
                idFactura = rp.facturarReserva();
            }
        }
        return idFactura;
    }

    Set<DataReserva> obtenerInfoReservas(String proveedor, String publicacion) {
        Set<DataReserva> reservas = new HashSet();

        for (ReservaPublicacion rp : rp_) {
            Reserva r = rp.getReserva();
            DataReserva dr = r.infoReservaProveedorPublicacion(proveedor, publicacion);
            reservas.add(dr);
        }
        return reservas;
    }
}
