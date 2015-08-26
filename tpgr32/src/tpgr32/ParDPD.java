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
public class ParDPD {
    
    private final DataPublicacion dpub_;
    private final DataDisponibilidad dd_;
    
    public ParDPD(DataPublicacion p, DataDisponibilidad d)
    {
	dpub_ = p;
	dd_ = d;
    }

    public DataPublicacion getDpub_() {
        return dpub_;
    }

    public DataDisponibilidad getDd_() {
        return dd_;
    }
}
