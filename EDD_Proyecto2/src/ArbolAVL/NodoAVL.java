
package ArbolAVL;


public class NodoAVL {
    
    //elemtos
    String categoria;
    int balance,FE;//alamcenar el valor de equilibrio del nodo
    
    //punteros
    NodoAVL padre;
    NodoAVL derecha;
    NodoAVL izquierda;
    
    //constructor
    public NodoAVL(String categoria){
        this.categoria=categoria;
        this.balance=1;
        this.padre=null;
        this.derecha=null;
        this.izquierda=null;
    }
    
    
    //metodos get y set

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }

    public NodoAVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAVL getPadre() {
        return padre;
    }

    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }
    
    
    
}
