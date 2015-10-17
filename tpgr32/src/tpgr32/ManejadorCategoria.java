/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author piñe
 */
public class ManejadorCategoria {
    
    private Map<String,Categoria> conjCategorias_;
    private Set<Categoria> conjCategoriasPadre_;
    private static ManejadorCategoria instancia_ = null;
    
    public ManejadorCategoria(){
        conjCategorias_ = new HashMap<>();
        conjCategoriasPadre_ = new HashSet<>();
    }
    
    static ManejadorCategoria getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorCategoria();
        }
        return instancia_;
    }
    
    public Map<String, Categoria> getConjCategorias(){
        return conjCategorias_;
    }
    
    public void agregarCategoria(String nombre){
       Categoria c = new Categoria(nombre); 
       conjCategorias_.put(c.getNombre(),c);
       conjCategoriasPadre_.add(c);
    }
    
    public void agregarCategoria(String nombre, String padre){
        if (this.conjCategorias_.containsKey(padre)){
            Categoria p = encontrarCategoria(padre);
            Categoria c = new Categoria(nombre, p);
            conjCategorias_.put(c.getNombre(),c);
            p.agregarSubCategoria(c);
        }
        
    }
 
    public Categoria encontrarCategoria(String nombre){
        if (this.conjCategorias_.containsKey(nombre)) {
            return this.conjCategorias_.get(nombre);
        }
        else {
            throw new IllegalArgumentException("La categoría" + nombre + "no existe");
        }    
    }
    
    public DataCategoria encontrarDataCategoria(String nombre){
        if (this.conjCategorias_.containsKey(nombre)){
            DataCategoria dt = new DataCategoria(this.conjCategorias_.get(nombre).getNombre(),this.conjCategorias_.get(nombre).getConjSubCategoriasString(),
                    this.conjCategorias_.get(nombre).getConjServiciosString(), this.conjCategorias_.get(nombre).getPadreString());
            return dt;
        }
        else {
            throw new IllegalArgumentException("La categoría" + nombre + "no existe");
        }    
    }
    
    public DefaultTreeModel agregarHijos(DefaultTreeModel mod, DefaultMutableTreeNode nodoPadre, Categoria c){
        Iterator it = c.getConjSubCategorias().keySet().iterator();
        int pos = 0;
        while (it.hasNext()){
            String key = it.next().toString();
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(key);
            mod.insertNodeInto(nodo, nodoPadre, pos); 
            pos = pos+1;
            mod = agregarHijos(mod, nodo, conjCategorias_.get(key));
        }
        return mod;
    }
    
    public DefaultTreeModel crearArbolCategorias(){
       DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode("Categorias");
       DefaultTreeModel modelo = new DefaultTreeModel(nodoRaiz);
       Iterator<Categoria> it = conjCategoriasPadre_.iterator();
       int pos = 0;
       while (it.hasNext()){
            String key = it.next().getNombre();
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(key);
            modelo.insertNodeInto(nodo, nodoRaiz, pos);
            pos = pos + 1;          
            modelo = agregarHijos(modelo, nodo, conjCategorias_.get(key));
       }
       return modelo;
    }
    
    public Set<Categoria> getPadres()
    {
        return conjCategoriasPadre_;
    }
}
