
package ArbolB;
import java.io.*;//para la escritura del archivo dot


public class ArbolB {
    
    //--------------------------------------------------------------------------
    //elementos
    NodoB root;//raiz principal
    
    //--------------------------------------------------------------------------
    //constructor
    public ArbolB(){
        this.root=null;
    }
    
    //--------------------------------------------------------------------------
    //estado del arbol
    public boolean estadoArbol(){
        if(root==null){
            return true;
        }else{
            return false;
        }
    }
    
    //--------------------------------------------------------------------------
    //metodo para buscar la posicion donde insertar en el arbol
    public NodoB buscarNodoInsertar(NodoB nodo,int isbn){
        boolean tieneHijos = nodo.isExistenciaHijos();//pregunto si el nodo tiene hijos
        boolean tienePadre = nodo.isExistenciaPadre();//pregunto si el nodo tiene pare
        //si el nodo no tiene hijos puedo agregar el nodo en el nodo 
        //siempre que halla espacio

        //1. si el nodo no tiene hijo solo inserto
        //2. si el nodo tiene hijos hay que buscar dentro de sus ramos donde insertar
        if (tieneHijos == false){
            //ahora reviso si tiene espacio para insertar
            return nodo;            
        }else{
           //debo de realizar una busqueda en la lista del nodo para ver en que
           //hijo debo de irme, me ayudo del isbn
           return nodo; 
        }
    }
    
    
    
    //--------------------------------------------------------------------------
    //metodo para inserte en el arbol
    public void insertarEnArbol(int isbn,String titulo,String autor,
            String editorial,String anio,String edicion,String categoria,
            String idioma,int carnet){
        if(estadoArbol()==true){
            NodoB nuevoNodo = new NodoB();//creo el nodo por no existe en el arbol
            nuevoNodo.insertarElemento(isbn, titulo, autor, editorial, anio, 
                    edicion, categoria, idioma, carnet);//mando la informacion al nodo B
            this.root=nuevoNodo;//el nuevo nodo se convierte en la raiz del arbol B
        }else{
            //falta insertar cuando existe las demas condiciones
            //si tiene hijos, si tiene espacio, si tiene padre
            //creo un nodo auxiliar para empezar desde la raiz
            NodoB auxRoot = root;
            //busco la poisicion donde puedo insertar en el arbol
            NodoB nodoEncontrado = buscarNodoInsertar(auxRoot, isbn);//empiezo a buscar desde la el ndodo raiz
            //reviso si el nodo tiene o no espacion para insertar
            if(nodoEncontrado.getElementosMaximos()<=4){
                nodoEncontrado.insertarElemento(isbn, titulo, autor, editorial, 
                        anio, edicion, categoria, idioma, carnet);
            }else{
                //si ya no hay espacio lo inserto para tener en orden la lista de claves
                nodoEncontrado.insertarElemento(isbn, titulo, autor, editorial, 
                        anio, edicion, categoria, idioma, carnet);
            }
        }
    }//fin del metodo par insertar en un arbol B
    
    
    //--------------------------------------------------------------------------
    //metodo para recorrer el arbol 
    public void recorreArbol(PrintWriter archivo,NodoB nodo,int numeroNodo){
        if(nodo!=null){
            archivo.print("nodo"+numeroNodo+
                    "[ shape=record, label= \" ");
            NodoK auxListaK = nodo.getListaClaves().getPrimero();
            while(auxListaK!=null){
                archivo.print(""+auxListaK.getISBN()+","+auxListaK.getTitulo());
                if(auxListaK.getSiguiente()!=null){
                    archivo.print("|");
                }
                auxListaK = auxListaK.getSiguiente();
            }
            archivo.print(" \" ];");
        }
    }
    
    //--------------------------------------------------------------------------
    //metodo para generar DOT del arbol B
    public void generarDotB(){
        NodoB auxRoot = root;
        int numeroNodo=0;
        try {
            PrintWriter archivo = new PrintWriter("ArchivosDot\\ArbolB.dot");
            archivo.println("digraph arbol{");
            recorreArbol(archivo,auxRoot,numeroNodo);
            archivo.println("label = \" Arbol B \"; ");
            archivo.println("}");
            archivo.close();
        } catch (Exception error) {
        }
    }//fin del metodo
    
    
    
}//fin de la clase del arbol B
