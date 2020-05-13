/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB2;

/**
 *
 * @author joshu
 */
public class Nodo {
    
    Informacion info;
    
    Nodo siguiente;
    Nodo anterior;
    Pagina hijoDerecha;
    Pagina hijoIzquierda;

    public Nodo(Informacion info) {
        this.info = info;
        this.siguiente = null;
        this.anterior = null;
    }
    
    
    

    public Informacion getInfo() {
        return info;
    }

    public void setInfo(Informacion info) {
        this.info = info;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Pagina getHijoDerecha() {
        return hijoDerecha;
    }

    public void setHijoDerecha(Pagina hijoDerecha) {
        this.hijoDerecha = hijoDerecha;
    }

    public Pagina getHijoIzquierda() {
        return hijoIzquierda;
    }

    public void setHijoIzquierda(Pagina hijoIzquierda) {
        this.hijoIzquierda = hijoIzquierda;
    }
    
    
    
}
