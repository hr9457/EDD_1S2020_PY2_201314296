
package ArbolB2;


public class ListaHijos {
    
    //apuntadores
    NodoH primero;
    NodoH ultimo;
    
    public ListaHijos(){
        this.primero=null;
        this.ultimo=null;
        creacionHijos();
    }
    
    //creacion de la posicion dentro la lista
    public void creacionHijos(){
        NodoH primero = new NodoH(1);
        NodoH segundo = new NodoH(2);
        NodoH tercero = new NodoH(3);
        NodoH cuarto = new NodoH(4);
        NodoH quinto = new NodoH(5);
        
        primero.setSiguiente(segundo);
        segundo.setAnterior(primero);
        
        segundo.setSiguiente(tercero);
        tercero.setAnterior(segundo);
        
        tercero.setSiguiente(cuarto);
        cuarto.setAnterior(tercero);
        
        cuarto.setSiguiente(quinto);
        quinto.setAnterior(cuarto);
        
        this.primero=primero;
        this.ultimo=quinto;
    }
    
    
    //**********metodo get y set

    public NodoH getPrimero() {
        return primero;
    }

    public void setPrimero(NodoH primero) {
        this.primero = primero;
    }

    public NodoH getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoH ultimo) {
        this.ultimo = ultimo;
    }
    
    
}
