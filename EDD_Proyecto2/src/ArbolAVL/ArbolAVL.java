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
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            //el dato que se esta insertando ya existe
            
        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {//si es menor

            //si no tiene nada ala izquierda 
            if (nodo.getIzquierda() == null) {
                NodoAVL nuevaCategoria = new NodoAVL(categoria);
                nodo.setIzquierda(nuevaCategoria);
                
            } else {           
                //me paso hacia la izquierda
                nodo = nodo.getIzquierda();
                //mando recursividad
                buscarNodo(nodo, categoria);

            }

        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {//si es mayor

            //si no tiene nada ala derecha
            if(nodo.getDerecha()==null){
                NodoAVL nuevaCategoria = new NodoAVL(categoria);
                nodo.setDerecha(nuevaCategoria);
                
            } else {
                //me pasao hacia la derecha
                nodo = nodo.getDerecha();
                //mando lo que habia en la derecha
                buscarNodo(nodo, categoria);
            }
        }
    }

    
    //metodo para insertar en el arbol
    public void insertarCategoria(String categoria, int carnet) {
        NodoAVL nuevaCategoria = new NodoAVL(categoria);
        if (estadoArbol() == true) {
            this.root = nuevaCategoria;
        } else {
            NodoAVL auxRoot = root;
            buscarNodo(auxRoot, categoria);
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
