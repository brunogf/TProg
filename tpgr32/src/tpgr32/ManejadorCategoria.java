/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author piñe
 */
public class ManejadorCategoria {
    
    private Map<String,Categoria> conjCategorias_;
    private static ManejadorCategoria instancia_ = null;
    
    
    public ManejadorCategoria(){
        conjCategorias_ = new HashMap<>();
    }
    
    static ManejadorCategoria getInstance() {
        if (instancia_ == null) {
            instancia_ = new ManejadorCategoria();
        }
        return instancia_;
    }
    
    public void agregarCategoria(String nombre){
       Categoria c = new Categoria(nombre); 
       conjCategorias_.put(c.getNombre(),c); 
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
    
    public boolean sinPadre(String nombre){
        if (this.conjCategorias_.containsKey(nombre)){
            return (this.conjCategorias_.get(nombre) == null);
        }
        else {
            throw new IllegalArgumentException("La categoría" + nombre + "no existe");
        }
    }
    
    private class ListaOrdenada {
    
        class Nodo {
            int nivel;
            Categoria cat;
            Nodo sig;
        }

        private Nodo raiz;

        public ListaOrdenada() {
            raiz=null;
        }

        void insertar(int x, Categoria c)
        {
            Nodo nuevo = new Nodo ();
            nuevo.nivel = x;
            nuevo.cat = c;
            if (raiz==null) {
                raiz=nuevo;
            } else {
                if (x<raiz.nivel) {
                    nuevo.sig=raiz;
                    raiz=nuevo;
                } else {
                    Nodo reco=raiz;
                    Nodo atras=raiz;
                    while (x>=reco.nivel && reco.sig!=null) {
                        atras=reco;
                        reco=reco.sig;
                    }
                    if (x>=reco.nivel) {
                        reco.sig=nuevo;
                    } else {
                        nuevo.sig=reco;
                        atras.sig=nuevo;
                    }
                }
            }
        }
        
        public DefaultTreeModel insTree (DefaultTreeModel mod) {
        Nodo reco = raiz;
        while (reco != null) {
            DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode(getDato(reco).getNombre());
            DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode(getDato(reco).getPadre().getNombre());
            mod.insertNodeInto(nodo1, nodo2, 0);
            reco = reco.sig;
        }
        return mod;
        }
        
        public Categoria getDato(Nodo n){
            return n.cat;
        }
        
    }   
            
    public DefaultTreeModel crearTreeCategorias(){
       DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode("Categorias");
       DefaultTreeModel modelo = new DefaultTreeModel(nodoRaiz);
       Iterator it = conjCategorias_.keySet().iterator();
       ListaOrdenada lista = new ListaOrdenada();
       while (it.hasNext()){
            String key = it.next().toString();
            lista.insertar(conjCategorias_.get(key).getNivel(),conjCategorias_.get(key));                   
       }
       DefaultTreeModel modeloFinal = lista.insTree(modelo);
       return modeloFinal;
       }
   
    
}
