/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Set;
import java.util.Date;
import java.util.List;

/**
 *
 * @author spesamosca
 */
public interface IControladorReserva {
    
    public void actualizarEstado(int num, Estado est) throws Exception;
    public void bajaReserva(int num) throws Exception;
    public int confirmarReserva();
    public DataReserva infoReserva(int num);
    public DataReserva infoReservaProveedor(int nro, String nick);
    public List<DataReserva> listarReservas();
    public void seleccionarCliente(String nickname);
    public void seleccionarPublicacion(String nombre,
            int cantidad, Date inicio, Date fin); 
    public void seleccionarProveedor(String nickname);
    public String getNickProveedorSeleccionado();
    public DataCliente getInfoClienteSeleccionado();
    public DataUsuario getInfoClienteReserva(int nro);
    public DataProveedor getInfoProveedorSeleccionado();
    public void borrarPublicacionesSeleccionadas();
    public int getNumeroReservas();//retorna el ultimo numero usado por una reserva
    public void cambiarFechaCreacionReserva(Date fecha, int res);   
    public int facturarReserva(String nickname, int nro);
    public byte[] obtenerFactura(int id);
    public int obtenerFacturaReserva(int nro);
    public boolean proveedorFacturoReserva(String nick, int nro);
    
    
}
