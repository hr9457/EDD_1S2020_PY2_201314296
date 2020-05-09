package ArbolAVL;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class ArbolAVL {

    //archiov dot
    PrintWriter archivo;

    //punteros
    NodoAVL root;
    NodoAVL auxRoot;

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

    //********************ROTACIONES
    public NodoAVL simpleDerecha(NodoAVL nodoRaiz) {
        //*******rotacion
        NodoAVL nodoAux = nodoRaiz.getDerecha();
        NodoAVL nodoAuxPosible = nodoAux.getIzquierda();
        nodoAux.setIzquierda(nodoRaiz);
        nodoRaiz.setDerecha(nodoAuxPosible);
        //********actualizacion de alturas
        int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodoRaiz.getDerecha()), obtenerAltura(nodoRaiz.getIzquierda()));
        nodoRaiz.setAltura(NuevaAltura);

        int NuevaAltura2 = 1 + alturaMaxima(obtenerAltura(nodoAux.getDerecha()), obtenerAltura(nodoAux.getIzquierda()));
        nodoAux.setAltura(NuevaAltura2);

        return nodoAux;
    }

    public NodoAVL simpleIzquierda(NodoAVL nodoRaiz) {
        //*******rotacion
        NodoAVL nodoAux = nodoRaiz.getIzquierda();
        NodoAVL nodoAuxPosible = nodoAux.getDerecha();
        nodoAux.setDerecha(nodoRaiz);
        nodoRaiz.setIzquierda(nodoAuxPosible);
        //*************actualizacion de alturas
        //********actualizacion de alturas
        int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodoRaiz.getDerecha()), obtenerAltura(nodoRaiz.getIzquierda()));
        nodoRaiz.setAltura(NuevaAltura);

        int NuevaAltura2 = 1 + alturaMaxima(obtenerAltura(nodoAux.getDerecha()), obtenerAltura(nodoAux.getIzquierda()));
        nodoAux.setAltura(NuevaAltura2);

        return nodoAux;
    }

    public NodoAVL dobleIzquierda(NodoAVL nodoRaiz) {//problema
        NodoAVL nodoAux = nodoRaiz.getIzquierda();
        //********primera rotacion
        //********rotacion simple        
        nodoRaiz.setIzquierda(simpleDerecha(nodoAux));

        //*************rotacion simple izquierda
        NodoAVL temporal = simpleIzquierda(nodoRaiz);

        return temporal;
    }

    public NodoAVL dobleDerecha(NodoAVL nodoRaiz) {
        NodoAVL nodoAux = nodoRaiz.getDerecha();
        //******primera rotacion es rotacion simple a la izquierda
        nodoRaiz.setDerecha(simpleIzquierda(nodoAux));

        //********segunda rotacion rotacion simple izquierda
        NodoAVL temporal = simpleDerecha(nodoRaiz);
        return temporal;
    }

    //buscar el lugar de la insercion
    //0 son iguales
    //-1 la primer es menor
    //1 la es mayor
    public void buscarInsertar(NodoAVL nodo, String categoria) {
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            System.out.println("datos iguales");
            JOptionPane.showMessageDialog(null, "categoria ya existente");

        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {
            if (nodo.getIzquierda() == null) {
                //**creo categoria con el dato
                NodoAVL nuevaCategoria = new NodoAVL(categoria);
                nodo.setIzquierda(nuevaCategoria);
                nuevaCategoria.setPadre(nodo);
                //JOptionPane.showMessageDialog(null, "padre "+nodo.getCategoria());
            } else {
                buscarInsertar(nodo.getIzquierda(), categoria);
            }

        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {
            if (nodo.getDerecha() == null) {
                NodoAVL nuevaCategoria = new NodoAVL(categoria);
                nodo.setDerecha(nuevaCategoria);
                nuevaCategoria.setPadre(nodo);
                //JOptionPane.showMessageDialog(null, "padre "+nodo.getCategoria());
            } else {
                buscarInsertar(nodo.getDerecha(), categoria);
            }
        }

        //**********ACTUALIZAR ALTURA PARA CADA NODO
        int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodo.getDerecha()), obtenerAltura(nodo.getIzquierda()));
        nodo.setAltura(NuevaAltura);

        //**********CALCULAR EL FE DE CADA NODO HACIA ARRIBA
        int FE = calcularFE(nodo.getDerecha(), nodo.getIzquierda());
        nodo.setFE(FE);//mando su fe para saber que signo y ver que caso es

        //*****************ROTACIONES DE LOS ARBOLES AVL
        if (FE > 1 && nodo.getDerecha().getFE() > 0) {//simple a la derecha
            //verifico si el nodo que voy a rotar es la raiz o un nodo a su derecha
            if (nodo == root) {
                this.root = simpleDerecha(nodo);
                
            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                if(nodo.getIzquierda()==temp){
                   nodo.setIzquierda(simpleDerecha(temp));
                } else {
                   nodo.setDerecha(simpleDerecha(temp)); 
                }                
            }

        } else if (FE < -1 && nodo.getIzquierda().getFE() < 0) {//simple a la izquierda
            //verifico si el nodo a rotar es la raiz o un nodo a su izquierda
            if (nodo == root) {
                this.root = simpleIzquierda(nodo);
                
            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                if(nodo.getIzquierda()==temp){
                    nodo.setIzquierda(simpleIzquierda(temp));
                } else {
                    nodo.setDerecha(simpleIzquierda(temp));
                }                
            }

        } else if (FE > 1 && nodo.getDerecha().getFE() < 0) {//doble derecha
            //verifico si el nodo a rotar es la raiz 
            
            if (nodo == root) {
                this.root = dobleDerecha(nodo);
                
            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                if(nodo.getIzquierda()==temp){
                    nodo.setIzquierda(dobleDerecha(temp));
                } else {
                    nodo.setDerecha(dobleDerecha(temp));
                }                
            }
            
            //problema
        } else if (FE < -1 && nodo.getIzquierda().getFE() > 0) {//doble izquierda
            //verifico si el nodo a rotar es la raiz o es un nodo a su izquierda
            /*
            if (nodo == root) {
                this.root = dobleIzquierda(nodo);
            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                if(nodo.getIzquierda()==temp){
                    nodo.setIzquierda(dobleIzquierda(temp));
                } else {
                   nodo.setDerecha(dobleIzquierda(temp));
                }                
            }
            */
        }

    }//fin del metodo insertar nodo

    //metodo para insertar en el arbol
    public void insertarCategoria(String categoria) {
        if (estadoArbol() == true) {
            NodoAVL nuevaCategoria = new NodoAVL(categoria);
            this.root = nuevaCategoria;
        } else {
            auxRoot = this.root;
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
            archivo.println("nodo" + auxRoot.getCategoria() + "[ label = \" " + auxRoot.getCategoria() + ";" + auxRoot.getAltura() + "\" ];");

            if (auxRoot.getIzquierda() != null) {
                NodoAVL siguiente = auxRoot.getIzquierda();
                archivo.println("nodo" + auxRoot.getCategoria() + "->nodo" + siguiente.getCategoria() + ";");
                recorrerAVL(auxRoot.getIzquierda());

            }

            if (auxRoot.getDerecha() != null) {
                NodoAVL nextDerecha = auxRoot.getDerecha();
                archivo.println("nodo" + auxRoot.getCategoria() + "->nodo" + nextDerecha.getCategoria() + ";");
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
