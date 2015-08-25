/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;
import java.util.Date;
import java.util.Map;
/**
 *
 * @author Nicolás Rostán
 */
public class Cliente extends Usuario{
    
    private Map<Integer,Reserva> conjReservas;
    
    public Cliente(String nom, String apellido, String nickName, String cElec, Date f) {
        super(nom,apellido,nickName,cElec,f);//llama constructor de Usuario
    }
    
    public DataUsuario infoUsuario() {
        return new DataCliente(this.nickname,this.nombre,this.apellido,this.correoElec,this.fechaNacimiento);     
    }
    
    public void agregarReserva (Reserva r) {
        this.conjReservas.put(r.getNumero(), r);
    }
    
    
}
