
package TablaDispersion;


public class NodoHash {
    
    
    
    //elementos
    int posicion;
    ListaColision lista;
    
    
    //punteros
    NodoHash arriba;
    NodoHash abajo;
    
    
    //constructor
    public NodoHash(int posicion){
        this.posicion=posicion;
        this.lista = new ListaColision();//creacion de una lista dentro de un nodo hash
    }

    
    //metodoo para insertar en la lista dentro de la lista
    public void agregarUsuario(int carnet, String nombre, String apellido, 
            String carrera, String password){
        lista.agregarElemento(carnet, nombre, apellido, carrera, password);
    }
    
    //**************************************************************************
    //metodo get y set 
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public NodoHash getArriba() {
        return arriba;
    }

    public void setArriba(NodoHash arriba) {
        this.arriba = arriba;
    }

    public NodoHash getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoHash abajo) {
        this.abajo = abajo;
    }

    public ListaColision getLista() {
        return lista;
    }

    public void setLista(ListaColision lista) {
        this.lista = lista;
    }
    
    
    
}
