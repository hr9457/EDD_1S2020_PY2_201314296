//paquete dond esta mi tabal de dispersion 
//que es una lista doblemente enlazada
package TablaDispersion;

public class Nodo {

    int numeroCarnet;
    String nombre;
    String apellido;
    String carrera;
    String password;
    Nodo anterior;
    Nodo siguiente;
    
    
    
    //constructor con asignacion de los los parametros
    public Nodo(int num, String arg1, String arg2, String arg3, String arg4){//orden del folleto
        this.numeroCarnet=num;
        this.nombre=arg1;
        this.apellido=arg2;
        this.carrera=arg3;
        this.password=arg4;
        this.anterior=null;
        this.siguiente=null;        
    }

    //metodo get y set para cada variable
    public int getNumeroCarnet() {
        return numeroCarnet;
    }

    public void setNumeroCarnet(int numeroCarnet) {
        this.numeroCarnet = numeroCarnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
