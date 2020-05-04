package ArbolAVL;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class ArbolAVL {

    //archiov dot
    PrintWriter archivo;

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

    //******************OBTENER ALTURA DE UN NODO
    public int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getAltura();
        }
    }

    //*****************SABER CUAL ES EL MAX
    public int alturaMaxima(int primero, int segundo) {
        if (primero > segundo) {
            return primero;
        } else if (segundo > primero) {
            return segundo;
        } else {
            return primero;
        }
    }

    //*****************CALCULAR EL FE
    public int calcularFE(NodoAVL nododerecha, NodoAVL nodoizquierda) {
        int derecha = obtenerAltura(nododerecha);
        int izquierda = obtenerAltura(nodoizquierda);
        return derecha - izquierda;
    }

    //buscar el lugar de la insercion
    //0 son iguales
    //-1 la primer es menor
    //1 la es mayor
    public void buscarInsertar(NodoAVL nodo, String categoria) {
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            System.out.println("datos iguales");
        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {
            if (nodo.getIzquierda() == null) {
                NodoAVL nuevaCategoria = new NodoAVL(categoria);
                nodo.setIzquierda(nuevaCategoria);
            } else {
                buscarInsertar(nodo.getIzquierda(), categoria);
            }
        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {
            if (nodo.getDerecha() == null) {
                NodoAVL nuevaCategoria = new NodoAVL(categoria);
                nodo.setDerecha(nuevaCategoria);
            } else {
                buscarInsertar(nodo.getDerecha(), categoria);
            }
        }

        //**********ACTUALIZAR ALTURA PARA CADA NODO
        int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodo.getDerecha()), obtenerAltura(nodo.getIzquierda()));
        nodo.setAltura(NuevaAltura);

        //**********CALCULAR EL FE DE CADA NODO HACIA ARRIBA
        int FE = calcularFE(nodo.getDerecha(), nodo.getIzquierda());
        if (FE > 2) {
            JOptionPane.showMessageDialog(null, "" + nodo.getCategoria() + "\ndesequilibrio derecha");
        } else if (FE < -2) {
            JOptionPane.showMessageDialog(null, "" + nodo.getCategoria() + "\ndesequilibrio izquierda");
        }

    }

    //metodo para insertar en el arbol
    public void insertarCategoria(String categoria) {
        if (estadoArbol() == true) {
            NodoAVL nuevaCategoria = new NodoAVL(categoria);
            this.root = nuevaCategoria;
        } else {
            NodoAVL auxRoot = this.root;
            buscarInsertar(auxRoot, categoria);
        }
    }

    //*************************************************************************
    //GRAFO DEL ARBOL AVL
    //metodo para genera la imagen del AVL
    public void generarPng() {
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\ArbolAVL.dot -o Reportes\\ArbolAVL.png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se genero la imagen");
        }
    }

    //metodo para abrir el archivo png
    public void abrirPngAVL() {
        try {
            String archivo = "Reportes\\ArbolAVL.png";
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("cmd /c start " + archivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede arbir la imagen");
        }
    }

    //metodo para recorrer el arbol e ir enlazado en el archivo dot
    public void recorrerAVL(NodoAVL auxRoot) {
        if (auxRoot != null) {
            archivo.println("nodo" + auxRoot.getCategoria() + "[ label = \" " + auxRoot.getCategoria() + "\n" + auxRoot.getAltura() + "\" ];");

            if (auxRoot.getIzquierda() != null) {
                NodoAVL siguiente = auxRoot.getIzquierda();
                archivo.println("nodo" + auxRoot.getCategoria() + "->nodo" + siguiente.getCategoria());
                recorrerAVL(auxRoot.getIzquierda());

            }

            if (auxRoot.getDerecha() != null) {
                NodoAVL nextDerecha = auxRoot.getDerecha();
                archivo.println("nodo" + auxRoot.getCategoria() + "->nodo" + nextDerecha.getCategoria());
                recorrerAVL(auxRoot.getDerecha());
            }
        }//fin del primer if
    }

    //metodo para generar el archivo dot
    public void generarDotAVL() {
        NodoAVL auxRoot = root;
        try {
            archivo = new PrintWriter("ArchivosDot\\ArbolAVL.dot");
            archivo.println("digraph arbolAVL{");
            archivo.println("rankdir=TB;");
            recorrerAVL(auxRoot);
            archivo.println("");
            archivo.println("label = \" Arbol AVL \"; ");
            archivo.println("}");
            archivo.close();
            //*************
            //GENERO LA IMAGEN, Y LA ABRO
            generarPng();
            abrirPngAVL();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede generar el Dot");
        }
    }

    public void prueba() {
        NodoAVL auxRoot = this.root;
        inorden(auxRoot);
    }

    public void inorden(NodoAVL root) {
        if (estadoArbol() != true) {
            if (root.getIzquierda() != null) {
                inorden(root.getIzquierda());
            }

            System.out.print("categoria: " + root.getCategoria() + "->");
            System.out.println("");

            if (root.getDerecha() != null) {
                inorden(root.getDerecha());
            }
        }
    }

}
