
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
    
    //metod para buscar dentor de la list
    public boolean buscarUsuarioEnLista(int carnet,String Password){
        boolean resultado = lista.buscarUsuario(carnet, Password);
        return resultado;
    }
    
    //metodo para buscar datos en la lista y obtener sus datos
    public Nodo buscarDatos(int carnet){
        Nodo datos = lista.buscarObtener(carnet);
        return datos;
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
