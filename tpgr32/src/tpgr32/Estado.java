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
 * @author bruno
 */
@XmlAccessorType(XmlAccessType.FIELD)
public enum Estado {
    Registrada, Cancelada, Pagada, Facturada
}
