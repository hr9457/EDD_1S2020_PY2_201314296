
package TablaDispersion;


public class ListaColision {
    
    
    //elementos
    Nodo primero;
    Nodo ultimo;
    
    //constructor
    public ListaColision(){
        this.primero=null;
        this.ultimo=null;
    }
    
    
    //estado de la lista
    public boolean estadoLista(){
        if(primero==null && ultimo==null){
            return true;
        }else{
            return false;
        }
    }
    
    
    //agregar de ultimo en la lista de las coliciones
    //uso el metodo para agrega de ultimo en la lista
    public void agregarElemento(int carnet, String nombre, String apellido, 
            String carrera, String password){
        Nodo nuevoNodo = new Nodo(carnet, nombre, apellido, carrera, password);
        if(estadoLista()==true){
            this.primero=nuevoNodo;
            this.ultimo=nuevoNodo;
        }else{
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo=nuevoNodo;
        }
    }
    
    //*************metodo get y set
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
    

    
}
