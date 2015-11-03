/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.Date;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Nico
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProveedorBean extends DataUsuario {
    private String nombre_empresa;
    private String url;
    
    public DataProveedorBean(){}
    public DataProveedorBean(String nickname, String nombre, String apellido, String correo, Date fecha, String nombreEmp, String url)
    {
	super(nickname, nombre, apellido, correo, fecha);
	nombre_empresa = nombreEmp;
	this.url = url;
    }
    
    public String getUrl(){
        return url;
    }
    
    public String getEmpresa(){
        return nombre_empresa;
    }
    

    @Override
    public void abstractMethod() {
        
    }
}
