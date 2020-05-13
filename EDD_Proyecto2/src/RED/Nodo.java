
package RED;

public class Nodo {
    
    //elementos 
    String ip;
    
    //punteros 
    Nodo siguiente;
    Nodo anterior;
    
    //constructor
    public Nodo(String ip){
        this.ip = ip;
    }

    //*************metodos get y set
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
    
    
    
    
}
