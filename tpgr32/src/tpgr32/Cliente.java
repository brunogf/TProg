/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Nicolás Rostán
 */
public class Cliente extends Usuario{

    private Set<Reserva> reservas_;

    
    public Cliente(String nom, String apellido, String nickName, String cElec, Date f, String pass) {
        super(nom,apellido,nickName,cElec,f,pass);//llama constructor de Usuario
	reservas_ = new HashSet<>();
    }
    
    public DataUsuario infoUsuario() {
        return new DataCliente(this.nickname,this.nombre,this.apellido,this.correoElec,this.fechaNacimiento,this.imagen);     
    }
    
    public void agregarReserva(Reserva r)
    {
	reservas_.add(r);
    }
    
    public Set<Reserva> getReservas() {
        return this.reservas_;
    }
    
    public void eliminarReserva(Reserva r){
        reservas_.remove(r);
    }
   
     public Set<DataReserva> infoReservas() {
         
        Set<DataReserva> conjRes = new HashSet<>();
        for(Reserva r : this.reservas_) {
            conjRes.add(r.infoReserva());
        }
        return conjRes;
    }
}
