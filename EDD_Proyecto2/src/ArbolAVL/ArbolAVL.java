package ArbolAVL;

public class ArbolAVL {

    //punteros
    NodoAVL root;

    //contructor
    public ArbolAVL() {
        this.root = null;
    }

    //saber cual es el estado del arbol actual
    public boolean estadoArbol() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    //buscar el lugar de la insercion
    //0 son iguales
    //-1 la primer es menor
    //1 la es mayor
    public void buscarNodo(NodoAVL nodo, String categoria) {
    }

    
    
    //metodo para insertar en el arbol
    public void insertarCategoria(String categoria, int carnet) {        
        if (estadoArbol() == true) {
            NodoAVL nuevaCategoria = new NodoAVL(categoria);
            this.root = nuevaCategoria;
        } else {
            buscarNodo(root, categoria);
        }
    }
    
    
    
    //metodo para recorrer el arbol e ir enlazado en el archivo dot
    public void recorrerAVL(){
        
    }
    
    //metodo para generar el archivo dot
    public void generarDotAVL(){
        
    }
    
    //metodo para genera la imagen del AVL
    public void generarPng(){
        
    }

    //metodo para abrir el archivo png
    public void abrirPngAVL(){
        
    }
}
