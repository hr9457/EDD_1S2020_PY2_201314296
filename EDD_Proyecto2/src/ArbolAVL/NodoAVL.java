package ArbolAVL;

import ArbolB2.ArbolB;

public class NodoAVL {
    
    //cada nodo debe tener un arbol B
    ArbolB2.ArbolB arbolLibros;

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
        arbolLibros = new ArbolB();///creo arbol por nodo
    }

    
    public void insertarLibro(int isbn, String titulo, String autor,
            String editorial, String anio, String edicion, String categoria, String idioma, int carnet){
        arbolLibros.agregarLibro(isbn, titulo, autor, editorial, anio, edicion, 
                categoria, idioma, carnet);
        
    }
    
    public void report(){
        arbolLibros.reporteB();
        //arbolLibros.abrirImagen();
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
