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
 * @author piñe
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataUbicacion {
    
    private String pais_;
    private String ciudad_;
    
    public DataUbicacion(){
        
    }
    
    
    public DataUbicacion(String pais, String ciudad){
        
        pais_ = pais;
        ciudad_ = ciudad;
    }
    
    
    public String getCiudad(){
        
        return ciudad_;
    }
    
    
    public String getPais(){
        
        return pais_;
    }
    
    
    public void setPais(String pais){
        
        pais_ = pais;
    }
    
    
    public void setCiudad(String ciudad){
        
        ciudad_ = ciudad;
    }
    
}
