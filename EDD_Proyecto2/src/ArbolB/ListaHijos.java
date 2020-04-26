
package ArbolB;



public class ListaHijos {
    
    //elementos
    int hijos;
    NodoHijo primero;
    NodoHijo ultimo;
    
    //constructor
    public ListaHijos(){
        this.hijos=5;
        this.primero=null;
        this.ultimo=null;
        CreacionEspaciosHijos();//creo espacio establecidos en  la lista
    }
    
    //creacion de los espacios para anidor a los hijs del nodo arbol b
    private void CreacionEspaciosHijos(){
        NodoHijo espacio1 = new NodoHijo();
        NodoHijo espacio2 = new NodoHijo();
        NodoHijo espacio3 = new NodoHijo();
        NodoHijo espacio4 = new NodoHijo();
        espacio1.setSiguiente(espacio2);
        espacio2.setSiguiente(espacio3);
        espacio3.setSiguiente(espacio4);
    }
    
    
    //metodos get y set 
    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public NodoHijo getPrimero() {
        return primero;
    }

    public void setPrimero(NodoHijo primero) {
        this.primero = primero;
    }

    public NodoHijo getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoHijo ultimo) {
        this.ultimo = ultimo;
    }
    
    
}
