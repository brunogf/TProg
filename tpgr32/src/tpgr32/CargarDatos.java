/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author Nico
 */
public class CargarDatos {
    
    private static boolean cargado = false;
    
    public CargarDatos(){}
    
    public void cargar()
    {
        if (!cargado)
        {
            //Usuarios
            
        }
        else
            throw new IllegalArgumentException("Ya se ha realizado la carga una vez");
    }
    
}
