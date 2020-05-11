package ArbolB2;

public class NodoK {

    //informacion
    NodoInformacion informacion;
    int posicion;

    //elementos
    NodoK siguiente;
    NodoK anterior;

    //contructor
    public NodoK(int posicion) {        
        this.siguiente = null;
        this.anterior = null;
        this.posicion = posicion;
        informacion = new NodoInformacion();//creo la informacion
    }

    //*******************
    //metodo get y set
    public NodoInformacion getInformacion() {
        return informacion;
    }

    public void setInformacion(NodoInformacion informacion) {
        this.informacion = informacion;
    }

    public NodoK getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoK siguiente) {
        this.siguiente = siguiente;
    }

    public NodoK getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoK anterior) {
        this.anterior = anterior;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
}
