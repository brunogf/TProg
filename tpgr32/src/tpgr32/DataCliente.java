/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.awt.Image;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Nicolás Rostán
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DataCliente extends DataUsuario {
    private Set<DataReserva> reservas_;
    public DataCliente(){}
    public DataCliente(String nickname, String nombre, String apellido, String correo, Date fecha)
    {
        
	super(nickname, nombre, apellido, correo, fecha);
	reservas_ = new HashSet<>();
    }
    public DataCliente(String nickname, String nombre, String apellido, String correo, Date fecha, String img)
    {
	super(nickname, nombre, apellido, correo, fecha,img);
        reservas_ = new HashSet<>();
    }
    
    public Set<DataReserva> getReservas()
    {
	return reservas_;
    }
    
    public void agregarReserva(DataReserva dr)
    {
	reservas_.add(dr);
    }
    
    public void abstractMethod(){}
    
}
