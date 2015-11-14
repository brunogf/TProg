/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author spesamosca
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DataLog {
    private int nro_;
    private String ip_;
    private String browser_;
    private String URL_;
    private String OS_;
    private Date fecha_;
    private static int nroActual_ = 0;
        
    public DataLog(){}
    public DataLog(String ip, String browser, String url, String OS, Date fecha)
    {
	nro_ = nroActual_;
        nroActual_++;
        ip_ = ip;
        browser_ = browser;
        URL_ = url;
        OS_ = OS;
        fecha_ = fecha;      
    }
    
    public int getNro(){
        return nro_;
    }
    
    public String getIp(){
        return ip_;
    }
    
    public String getBrowser(){
        return browser_;
    }
    
    public String getUrl(){
        return URL_;
    }
    
    public String getOs(){
        return OS_;
    }
    
    public Date getFecha(){
        return fecha_;
    }
    
    public void setNro(int nro){
        nro_ = nro;
    }
    
    public void setIp(String ip){
        ip_ = ip;
    }
    
    public void setBrowser(String browser){
        browser_ = browser;
    }
    
    public void setUrl(String URL){
        URL_ = URL;
    }
    
    public void setOs(String OS){
        OS_ = OS;
    }
    
    public void setFecha(Date fecha){
        fecha_ = fecha;
    }
    
}