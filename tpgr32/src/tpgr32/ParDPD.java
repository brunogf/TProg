/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Bruno González
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParDPD {
    
    private DataPublicacion dpub_;
    private final DataDisponibilidad dd_;
    
    public ParDPD(DataPublicacion dtp, DataDisponibilidad dtd){
	dpub_ = dtp;
	dd_ = dtd;
    }

    public DataPublicacion getDpub() {
        return dpub_;
    }

    public DataDisponibilidad getDd() {
        return dd_;
    }
    
    public void setDataPub(DataPublicacion dt){
        dpub_ = dt;
    }
}
