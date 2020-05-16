package ArbolAVL;

public class NodoAVL {

    //elemtos
    String categoria;
    int carnet;
    int altura, FE;//alamcenar el valor de equilibrio del nodo

    //punteros
    NodoAVL padre;
    NodoAVL derecha;
    NodoAVL izquierda;

    //constructor
    public NodoAVL(String categoria,int carnet) {
        this.categoria = categoria;
        this.carnet = carnet;
        this.altura = 1;
        this.FE = 0;
        this.padre = null;
        this.derecha = null;
        this.izquierda = null;
    }

    //metodos get y set
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
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

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public int getFE() {
        return FE;
    }

    public void setFE(int FE) {
        this.FE = FE;
    }

}
