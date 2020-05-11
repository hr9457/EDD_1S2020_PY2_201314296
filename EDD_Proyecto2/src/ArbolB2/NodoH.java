
package ArbolB2;


public class NodoH {
    
    //info
    NodoH siguiente;
    NodoH anterior;
    int posicion;
    
    //apuntador
    NodoK hijo;
    
    //contructor
    public NodoH(int posicion){
        this.siguiente=null;
        this.anterior=null;
        this.hijo=null;
        this.posicion=posicion;
    }
    
    //*********
    //metodo get y set

    public NodoH getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoH siguiente) {
        this.siguiente = siguiente;
    }

    public NodoH getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoH anterior) {
        this.anterior = anterior;
    }

    public NodoK getHijo() {
        return hijo;
    }

    public void setHijo(NodoK hijo) {
        this.hijo = hijo;
    }
    
}
