
package ArbolBV2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class ArbolB {
    
    
    //elementos
    NodoB root;
    
    //constructor
    public ArbolB(){
        this.root=null;
    }
    
    
    public boolean estadoArbol(){
        if(root==null){
            return true;
        } else {
            return false;
        }
    }
    
    
    public NodoB buscarNodoInsertar(NodoB nodo,int isbn){
        NodoB tienePadre = nodo.getPadre();
        NodoB tieneHijos = nodo.getListaClaves().getPrimero().getIzquierdaAbajo();
        if(tieneHijos==null && nodo.getCantidadClaves()<=3){
            return nodo;
        } else if(tieneHijos==null && nodo.getCantidadClaves()>3) {
            return nodo;
        }
        return null;
    }
    
    //metodo para insertar o verificar
    public void insertarEnArbol(int isbn,String titulo,String autor,
            String editorial,String anio,String edicion,String categoria,
            String idioma,int carnet){
        if(estadoArbol()==true){
            NodoB nuevoNodo = new NodoB();
            nuevoNodo.insertarClave(isbn, titulo, autor, editorial, anio, 
                    edicion, categoria, idioma, carnet);
            this.root=nuevoNodo;
        } else {
            //creo un axu para el root
            NodoB auxRoot=root;
            NodoB nodoEncontrado = buscarNodoInsertar(auxRoot, isbn);
            
            if(nodoEncontrado.getCantidadClaves()<=3){
                
                nodoEncontrado.insertarClave(isbn, titulo, autor, editorial, anio, 
                    edicion, categoria, idioma, carnet);
                
            } else if(nodoEncontrado.getCantidadClaves()>3){
                
                nodoEncontrado.insertarClave(isbn, titulo, autor, editorial, anio, 
                    edicion, categoria, idioma, carnet);
                //reviso si tiene padre para enviar arriba
                NodoB tienePadre = nodoEncontrado.getPadre();
                //verifico si tiene padre
                //si no tiene padre
                if(tienePadre==null){
                    //creo dos nodos nuevos
                    NodoB nuevaRaiz = new NodoB();
                    NodoB nodoDerecha = new NodoB();
                    //saco los elementos del nodo actual para mandarlos a los otros
                    //1. saco los utlimos dos para mandarlo a su nodo hermano
                    //paso por referencia el nodo hermano
                    nodoDerecha.eliminarUltimosDos(nodoDerecha);
                    
                }
            }
            
        }
    }
    
    
    
    //--------------------------------------------------------------------------
    //metodo para recorrer el arbol 
    public void recorreArbol(PrintWriter archivo,NodoB nodo,int numeroNodo){
        if(nodo!=null){
            archivo.print("nodo"+numeroNodo+
                    "[ shape=record, label= \" ");
            NodoK auxListaK = nodo.getListaClaves().getPrimero();
            
            //contador 
            int espacio=0;
            while(auxListaK!=null){
                archivo.print("|");
                archivo.print(""+auxListaK.getISBN()+";"+auxListaK.getTitulo());
                archivo.print("|");
                //espacio++;
                
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
            archivo.println("");
            archivo.println("label = \" Arbol B \"; ");
            archivo.println("}");
            archivo.close();
            generarImagen();//genero la imagen
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null,"Erro en archivo Dot");
        }
    }//fin del metodo
    
    
    //metodo para ejecutar comando desde del cmd y genera el grafo
    public void generarImagen(){
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\ArbolB.dot -o Reportes\\ArbolB.png");            
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro imagen Dot ArbolB");
        }
    }
}
