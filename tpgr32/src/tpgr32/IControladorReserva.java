/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.util.Date;

/**
 *
 * @author spesamosca
 */
public interface IControladorReserva {
    
    public void actualizarEstado(int num, Estado e);
    public void bajaReserva(int num);
    public void confirmarReserva();
    public DataReserva infoReserva(int num);
    public Set<DataReserva> listarReservas();
    public Set<DataReserva> listarReservasEliminables();
    public void seleccionarCliente(String nickname);
    public void seleccionarPublicacion(String nombre, String nombreProveedor,
            int cantidad, Date inicio, Date fin);    
}
