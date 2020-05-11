package ArbolB2;

public class ArbolB {

    //datos
    NodoB root;

    //contructor
    public ArbolB() {
        this.root = null;
    }

    //metodo del estado del arbol
    public boolean estadoArbol() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }
    
    //metodo para crear un nodo
    public void insertarLibro(int ISBN,String titulo, String autor, String editorial, 
            String anio, String edicion, String categoria, String idioma,int carnet){
        //*************************************************
        NodoInformacion nuevoLibro = new NodoInformacion();
        nuevoLibro.asignarInforamcion(ISBN, titulo, autor, editorial, anio, edicion, categoria, idioma, carnet);
        //**************************************************
        if(estadoArbol()==true){
            NodoB nuevoNodo = new NodoB();
            this.root = nuevoNodo;
        } else {
            
        }
    }

}
