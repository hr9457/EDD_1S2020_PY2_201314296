

package TablaDispersion;


public class Lista {
    
    //elementos de una lista
    Nodo primero;
    Nodo ultimo;
    int size;
    
    //constructor
    public Lista(){
        this.primero=null;
        this.ultimo=null;
        this.size=0;
    }
    
    //revision de nuestr lista contien algun elemento o no
    public boolean estadoLista(){
        return (primero==null && ultimo==null)?true:false;
    }
    
    //metodo para insertar en la lista
    public void insertarFinal(){
        //si en nuestr lista no contiene elementos
        if(estadoLista()==true){
            Nodo nuevoNodo = new Nodo();
            this.primero=nuevoNodo;
            this.ultimo=nuevoNodo;
        }else{
            Nodo nuevoNodo = new Nodo();
            ultimo.setSiguiente(nuevoNodo);
            ultimo=nuevoNodo;
        }
    }
    
    
    //metodo get y set 
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
