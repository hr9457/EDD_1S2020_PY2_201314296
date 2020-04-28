
package ArbolB;


public class ArbolB {
    
    //elementos
    NodoB root;//raiz principal
    
    //constructor
    public ArbolB(){
        this.root=null;
    }
    
    
    //estado del arbol
    public boolean estadoArbol(){
        if(root==null){
            return true;
        }else{
            return false;
        }
    }
    
    //metodo para buscar la posicion donde insertar en el arbol
    public void buscarNodoInsertar(NodoB nodo){
        
    }
    
    //metodo para inserte en el arbol
    public void insertarEnArbol(int isbn,String titulo,String autor,
            String editorial,String anio,String edicion,String categoria,
            String idioma,int carnet){
        if(estadoArbol()==true){
            NodoB nuevoNodo = new NodoB();
            nuevoNodo.insertarElemento(isbn, titulo, autor, editorial, anio, 
                    edicion, categoria, idioma, carnet);//mando la informacion al nodo B
            this.root=nuevoNodo;//el nuevo nodo se convierte en la raiz del arbol B
        }else{
            
        }
    }
    
}
