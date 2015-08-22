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
public class Proveedor extends Usuario {
    private String nomEmpresa_;
    private String url_;
    private Map<String, Publicacion> publicaciones_;
    
    public Proveedor(String nom, String apellido, String nickName, String cElec, Date f,String empresa, String url)
    {
	super(nom,apellido,nickName,cElec,f);
	nomEmpresa_ = empresa;
	url_ = url;
    }
    
    public String getNombreEmpresa()
    {
	return nomEmpresa_;
    }
    
    public String getURL()
    {
	return url_;
    }
    
    public void setNombreEmpresa(String n)
    {
	nomEmpresa_ = n;
    }
    
    public void setURL(String u)
    {
	url_ = u;
    }
}
