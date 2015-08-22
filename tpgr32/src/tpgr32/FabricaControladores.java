/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author Bruno González
 */
public class FabricaControladores {
    private static FabricaControladores instancia_=null;
    
    public FabricaControladores(){}
    
    //singleton
    
    public static FabricaControladores getInstancia(){
        if (instancia_==null){
            instancia_=new FabricaControladores();
        }
        
        return instancia_;
    }
    
    public ControladorUsuario getControladorUsuario(){
        ControladorUsuario cu = new ControladorUsuario();
        return cu;
    }
    
    public ControladorReserva getControladorReserva(){
        ControladorReserva cr = new ControladorReserva();
        return cr;
    }
    public ControladorPublicacion getControladorPublicacion(){
        ControladorPublicacion cp = new ControladorPublicacion();
        return cp;
    }
}
