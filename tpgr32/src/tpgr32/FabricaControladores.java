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
    private ControladorUsuario cu_;
    private ControladorPublicacion cp_;
    private ControladorReserva cr_;
    
    public FabricaControladores()
    {
                    cu_ = null;
                    cp_ = null;
                    cr_ = null;
    }
    
    //singleton
    
    public static FabricaControladores getInstancia(){
        if (instancia_==null){
            instancia_=new FabricaControladores();
        }
        return instancia_;
    }
    
    public ControladorUsuario getControladorUsuario(){
        if (cu_ == null)
            cu_ = new ControladorUsuario();
        return cu_;
    }
    
    public ControladorReserva getControladorReserva(){
        if (cr_ == null)
            cr_ = new ControladorReserva();
        return cr_;
    }
    public ControladorPublicacion getControladorPublicacion(){
        if (cp_ == null)
            cp_ = new ControladorPublicacion();
        return cp_;
    }
}
