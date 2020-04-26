
package ArbolB;


public class NodoHijo {
    
    //elementos
    //puntero
    NodoHijo siguiente;
    NodoHijo atras;
    NodoB abajo;
    
    //constructor
    public NodoHijo(){
        this.siguiente=null;
        this.atras=null;
        this.abajo=null;    
    }
    
    
    //metodos get y set
    public NodoHijo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHijo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoHijo getAtras() {
        return atras;
    }

    public void setAtras(NodoHijo atras) {
        this.atras = atras;
    }

    public NodoB getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoB abajo) {
        this.abajo = abajo;
    }
    
    
}
