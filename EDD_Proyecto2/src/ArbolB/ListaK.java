
package ArbolB;


public class ListaK {
    
    //elementos
    int Claves;
    NodoK primero;
    NodoK ultimo;
    
    //constructor
    public ListaK(){
        this.Claves=4;
        this.primero=null;
        this.ultimo=null;
    }
    
    
    //creacion de los 4 nodos
    private void CreacionEspaciosClaves(){
    }
    
    //metodo get y set
    public int getClaves() {
        return Claves;
    }

    public void setClaves(int Claves) {
        this.Claves = Claves;
    }

    public NodoK getPrimero() {
        return primero;
    }

    public void setPrimero(NodoK primero) {
        this.primero = primero;
    }

    public NodoK getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoK ultimo) {
        this.ultimo = ultimo;
    }
    
    
}
