package ArbolAVL;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class ArbolAVL {

    //archiov dot
    PrintWriter archivo;

    //punteros
    NodoAVL root;
    NodoAVL auxRoot;

    //
    int nodoPreorden = 0;
    int nodoInorden = 0;
    int nodoPostorden = 0;

    //contructor
    public ArbolAVL() {
        this.root = null;
    }

    //****************************************************
    //*********************************************************
    public void Actualizar(NodoAVL nodo) {
        if (nodo != null) {
            Actualizar(nodo.getIzquierda());
            Actualizar(nodo.getDerecha());

            //raiz
            //**********ACTUALIZAR ALTURA PARA CADA NODO
            int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodo.getDerecha()), obtenerAltura(nodo.getIzquierda()));
            nodo.setAltura(NuevaAltura);
            //**********CALCULAR EL FE DE CADA NODO HACIA ARRIBA
            int FE = calcularFE(nodo.getDerecha(), nodo.getIzquierda());
            nodo.setFE(FE);//mando su fe para saber que signo y ver que caso es

        }//fin
    }//fin del metodo

    public void act() {
        NodoAVL aux = this.root;
        Actualizar(aux);
    }

    //********************************************
    //***********************************************************
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
    public NodoAVL simpleDerecha(NodoAVL nodoRaiz, NodoAVL nuevoPadre) {
        //*******rotacion
        NodoAVL nodoAux = nodoRaiz.getDerecha();
        NodoAVL nodoAuxPosible = nodoAux.getIzquierda();
        //******giro
        nodoAux.setIzquierda(nodoRaiz);
        nodoRaiz.setPadre(nodoAux);
        nodoAux.setPadre(null);

        nodoRaiz.setDerecha(nodoAuxPosible);
        if (nodoAuxPosible != null) {
            nodoAuxPosible.setPadre(nodoRaiz);
        }
        //********actualizacion de alturas
        int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodoRaiz.getDerecha()), obtenerAltura(nodoRaiz.getIzquierda()));
        nodoRaiz.setAltura(NuevaAltura);

        int NuevaAltura2 = 1 + alturaMaxima(obtenerAltura(nodoAux.getDerecha()), obtenerAltura(nodoAux.getIzquierda()));
        nodoAux.setAltura(NuevaAltura2);

        //**nuevo padre
        nodoAux.setPadre(nuevoPadre);
        return nodoAux;
    }

    public NodoAVL simpleIzquierda(NodoAVL nodoRaiz, NodoAVL nuevoPadre) {
        //*******rotacion
        NodoAVL nodoAux = nodoRaiz.getIzquierda();
        NodoAVL nodoAuxPosible = nodoAux.getDerecha();

        //*****giro
        nodoAux.setDerecha(nodoRaiz);
        nodoRaiz.setPadre(nodoAux);
        nodoAux.setPadre(null);

        nodoRaiz.setIzquierda(nodoAuxPosible);
        if (nodoAuxPosible != null) {
            nodoAuxPosible.setPadre(nodoRaiz);
        }
        //*************actualizacion de alturas
        //********actualizacion de alturas
        int NuevaAltura = 1 + alturaMaxima(obtenerAltura(nodoRaiz.getDerecha()), obtenerAltura(nodoRaiz.getIzquierda()));
        nodoRaiz.setAltura(NuevaAltura);

        int NuevaAltura2 = 1 + alturaMaxima(obtenerAltura(nodoAux.getDerecha()), obtenerAltura(nodoAux.getIzquierda()));
        nodoAux.setAltura(NuevaAltura2);

        //**nuevo padre
        nodoAux.setPadre(nuevoPadre);
        return nodoAux;
    }

    public NodoAVL dobleIzquierda(NodoAVL nodoRaiz, NodoAVL padre) {//problema
        NodoAVL nodoAux = nodoRaiz.getIzquierda();
        //******nuevo padre
        NodoAVL nuevoPadre = nodoRaiz;
        //********primera rotacion
        //********rotacion simple        
        nodoRaiz.setIzquierda(simpleDerecha(nodoAux, nuevoPadre));
        //nodoAux.setPadre(nodoRaiz);

        //*************rotacion simple izquierda
        NodoAVL temporal = simpleIzquierda(nodoRaiz, padre);
        //temporal.setPadre(null);
        return temporal;
    }

    public NodoAVL dobleDerecha(NodoAVL nodoRaiz, NodoAVL padre) {
        NodoAVL nodoAux = nodoRaiz.getDerecha();
        //******nuevo padre
        NodoAVL nuevoPadre = nodoRaiz;
        //******primera rotacion es rotacion simple a la izquierda
        nodoRaiz.setDerecha(simpleIzquierda(nodoAux, nuevoPadre));
        //nodoAux.setPadre(nodoRaiz);

        //********segunda rotacion rotacion simple izquierda
        NodoAVL temporal = simpleDerecha(nodoRaiz, padre);
        //temporal.setPadre(null);
        return temporal;
    }

    //buscar el lugar de la insercion
    //0 son iguales
    //-1 la primer es menor
    //1 la es mayor
    public void buscarInsertar(NodoAVL nodo, String categoria, int carnet) {
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            System.out.println("datos iguales");
            JOptionPane.showMessageDialog(null, "categoria ya existente");

        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {
            if (nodo.getIzquierda() == null) {
                //**creo categoria con el dato
                NodoAVL nuevaCategoria = new NodoAVL(categoria, carnet);
                nodo.setIzquierda(nuevaCategoria);
                nuevaCategoria.setPadre(nodo);
                //JOptionPane.showMessageDialog(null, "padre "+nodo.getCategoria());
            } else {
                buscarInsertar(nodo.getIzquierda(), categoria, carnet);
            }

        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {
            if (nodo.getDerecha() == null) {
                NodoAVL nuevaCategoria = new NodoAVL(categoria, carnet);
                nodo.setDerecha(nuevaCategoria);
                nuevaCategoria.setPadre(nodo);
                //JOptionPane.showMessageDialog(null, "padre "+nodo.getCategoria());
            } else {
                buscarInsertar(nodo.getDerecha(), categoria, carnet);
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
                this.root = simpleDerecha(nodo, null);

            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                NodoAVL nuevoPadre = nodo;
                if (nodo.getIzquierda() == temp) {
                    nodo.setIzquierda(simpleDerecha(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                } else {
                    nodo.setDerecha(simpleDerecha(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                }
            }

        } else if (FE < -1 && nodo.getIzquierda().getFE() < 0) {//simple a la izquierda
            //verifico si el nodo a rotar es la raiz o un nodo a su izquierda
            if (nodo == root) {
                this.root = simpleIzquierda(nodo, null);

            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                NodoAVL nuevoPadre = nodo;
                if (nodo.getIzquierda() == temp) {
                    nodo.setIzquierda(simpleIzquierda(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                } else {
                    nodo.setDerecha(simpleIzquierda(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                }
            }

        } else if (FE > 1 && nodo.getDerecha().getFE() < 0) {//doble derecha
            //verifico si el nodo a rotar es la raiz 

            if (nodo == root) {
                this.root = dobleDerecha(nodo, null);

            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                NodoAVL nuevoPadre = nodo;
                if (nodo.getIzquierda() == temp) {
                    nodo.setIzquierda(dobleDerecha(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                } else {
                    nodo.setDerecha(dobleDerecha(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                }
            }

            //problema
        } else if (FE < -1 && nodo.getIzquierda().getFE() > 0) {//doble izquierda
            //verifico si el nodo a rotar es la raiz o es un nodo a su izquierda

            if (nodo == root) {
                this.root = dobleIzquierda(nodo, null);
            } else {
                NodoAVL temp = nodo;
                nodo = nodo.getPadre();
                NodoAVL nuevoPadre = nodo;
                if (nodo.getIzquierda() == temp) {
                    nodo.setIzquierda(dobleIzquierda(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                } else {
                    nodo.setDerecha(dobleIzquierda(temp, nuevoPadre));
                    //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                }
            }

        }

    }//fin del metodo insertar nodo

    //metodo para insertar en el arbol
    public void insertarCategoria(String categoria, int carnet) {
        if (estadoArbol() == true) {
            NodoAVL nuevaCategoria = new NodoAVL(categoria, carnet);
            this.root = nuevaCategoria;
        } else {
            auxRoot = this.root;
            buscarInsertar(auxRoot, categoria, carnet);
            act();
        }
    }

    //********************************metodo para eliminar nodo de un arbol avl
    public void quitraHijos(NodoAVL nodo) {
        nodo.setDerecha(null);
        nodo.setIzquierda(null);
    }

    public void remplazarNodo(NodoAVL nodo, NodoAVL nuevoNodo) {
        if (nodo.getPadre() != null) {
            //asignacion de su nuevo hijo
            if (nodo == nodo.getPadre().getIzquierda()) {
                nodo.getPadre().setIzquierda(nuevoNodo);

            } else if (nodo == nodo.getPadre().getDerecha()) {
                nodo.getPadre().setDerecha(nuevoNodo);

            }
        }
        if (nuevoNodo != null) {
            //asigna su nuevo padre
            nuevoNodo.setPadre(nodo.getPadre());
        } else {
            nodo.setPadre(null);
        }
    }

    public NodoAVL encontrarMinimo(NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getIzquierda() != null) {
            return encontrarMinimo(nodo.getIzquierda());//buscamos la parte mas izquierda del arbol 
        } else {
            return nodo;
        }
    }

    public void elimiarNodo(NodoAVL nodo) {
        if (nodo.getIzquierda() != null && nodo.getDerecha() != null) {
            NodoAVL nodoMenor = encontrarMinimo(nodo.getDerecha());
            nodo.setCategoria(nodoMenor.getCategoria());
            elimiarNodo(nodoMenor);

        } else if (nodo.getIzquierda() != null && nodo.getDerecha() == null) {//solo hay hijo izquieda
            remplazarNodo(nodo, nodo.getIzquierda());
            quitraHijos(nodo);

        } else if (nodo.getDerecha() != null && nodo.getIzquierda() == null) {//solo hay hijo derecha
            remplazarNodo(nodo, nodo.getDerecha());
            quitraHijos(nodo);

        } else {
            remplazarNodo(nodo, null);
            quitraHijos(nodo);
        }
    }

    public void buscarNodo(NodoAVL nodo, String categoria, int carnet) {
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            //********nodo eonctrado para eliminar
            //JOptionPane.showMessageDialog(null, "nodo encontrado");
            //***********verifico si el nodo le pertenece al usuario
            if (carnet == nodo.getCarnet()) {
                elimiarNodo(nodo);
            } else {
                JOptionPane.showMessageDialog(null, "Usted no puede eliminar esta categoria", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }

        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {
            if (nodo.getIzquierda() != null) {
                buscarNodo(nodo.getIzquierda(), categoria, carnet);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {
            if (nodo.getDerecha() != null) {
                buscarNodo(nodo.getDerecha(), categoria, carnet);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//finS

    public void balanceo(NodoAVL nodo) {
        if (nodo != null) {

            balanceo(nodo.getIzquierda());

            balanceo(nodo.getDerecha());

            //**********CALCULAR EL FE DE CADA NODO HACIA ARRIBA
            int FE = nodo.getFE();

            //*****************ROTACIONES DE LOS ARBOLES AVL
            if (FE > 1 && nodo.getDerecha().getFE() > 0) {//simple a la derecha
                //verifico si el nodo que voy a rotar es la raiz o un nodo a su derecha
                if (nodo == root) {
                    this.root = simpleDerecha(nodo, null);

                } else {
                    NodoAVL temp = nodo;
                    nodo = nodo.getPadre();
                    NodoAVL nuevoPadre = nodo;
                    if (nodo.getIzquierda() == temp) {
                        nodo.setIzquierda(simpleDerecha(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    } else {
                        nodo.setDerecha(simpleDerecha(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    }
                }

            } else if (FE < -1 && nodo.getIzquierda().getFE() <= 0) {//simple a la izquierda
                //verifico si el nodo a rotar es la raiz o un nodo a su izquierda
                if (nodo == root) {
                    this.root = simpleIzquierda(nodo, null);

                } else {
                    NodoAVL temp = nodo;
                    nodo = nodo.getPadre();
                    NodoAVL nuevoPadre = nodo;
                    if (nodo.getIzquierda() == temp) {
                        nodo.setIzquierda(simpleIzquierda(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    } else {
                        nodo.setDerecha(simpleIzquierda(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    }
                }

            } else if (FE > 1 && nodo.getDerecha().getFE() < 0) {//doble derecha
                //verifico si el nodo a rotar es la raiz 

                if (nodo == root) {
                    this.root = dobleDerecha(nodo, null);

                } else {
                    NodoAVL temp = nodo;
                    nodo = nodo.getPadre();
                    NodoAVL nuevoPadre = nodo;
                    if (nodo.getIzquierda() == temp) {
                        nodo.setIzquierda(dobleDerecha(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    } else {
                        nodo.setDerecha(dobleDerecha(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    }
                }

                //problema
            } else if (FE < -1 && nodo.getIzquierda().getFE() >= 0) {//doble izquierda
                //verifico si el nodo a rotar es la raiz o es un nodo a su izquierda

                if (nodo == root) {
                    this.root = dobleIzquierda(nodo, null);
                } else {
                    NodoAVL temp = nodo;
                    nodo = nodo.getPadre();
                    NodoAVL nuevoPadre = nodo;
                    if (nodo.getIzquierda() == temp) {
                        nodo.setIzquierda(dobleIzquierda(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    } else {
                        nodo.setDerecha(dobleIzquierda(temp, nuevoPadre));
                        //JOptionPane.showMessageDialog(null, "nodo "+temp.getCategoria()+"" +"padre "+temp.getPadre());
                    }
                }

            }

        }//fin
    }//fin

    public void eliminarCategoria(String categoria, int carnet) {
        NodoAVL auxRoot = this.root;
        if (estadoArbol() == true) {
            JOptionPane.showMessageDialog(null, "Arbol no contiene categoria");
        } else {
            buscarNodo(auxRoot, categoria, carnet);
            act();//actualizacion de niveles y FE
            balanceo(auxRoot);
        }
    }

    public NodoAVL buscarCategoriaLibros(NodoAVL nodo,String categoria) {
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            JOptionPane.showMessageDialog(null, "nodo encontrado");
            return nodo;

        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {
            if (nodo.getIzquierda() != null) {
                buscarCategoriaLibros(nodo.getIzquierda(), categoria);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {
            if (nodo.getDerecha() != null) {
                buscarCategoriaLibros(nodo.getDerecha(), categoria);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        return null;
    }

    public NodoAVL agregarLibroCategoria(String categoria) {
        NodoAVL auxRoot = this.root;
        if (estadoArbol() == true) {
            JOptionPane.showMessageDialog(null, "Arbol  no contiene categorias");
            return null;
        } else {
            NodoAVL nodoEcontrado = buscarCategoriaLibros(auxRoot,categoria);
            return nodoEcontrado;
        }
    }
    
    public NodoAVL searchCategoria(NodoAVL nodo,String categoria){
        if (categoria.compareTo(nodo.getCategoria()) == 0) {
            JOptionPane.showMessageDialog(null, "nodo encontrado");
            return nodo;

        } else if (categoria.compareTo(nodo.getCategoria()) < 0) {
            if (nodo.getIzquierda() != null) {
                searchCategoria(nodo.getIzquierda(), categoria);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else if (categoria.compareTo(nodo.getCategoria()) > 0) {
            if (nodo.getDerecha() != null) {
                searchCategoria(nodo.getDerecha(), categoria);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        return null;
    }
    
    public NodoAVL buscarCategoria(String categoria){
        NodoAVL auxRoot = this.root;
        if(estadoArbol()==true){
            JOptionPane.showMessageDialog(null, "Arbol  no contiene categorias");
            return null;
        } else {
            NodoAVL nodoEcontrado = searchCategoria(auxRoot,categoria);
            return nodoEcontrado;
        }
    }

    //*************************************************************************
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
            archivo.println("nodo" + auxRoot.getCategoria() + "[ label = \" " + auxRoot.getCategoria() + "\nN:" + auxRoot.getAltura() + "\" ];");

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
            //abrirPngAVL();
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

            System.out.print("categoria: " + root.getCategoria() + "----");
            if (root.getPadre() != null) {
                System.out.print("PADRE: " + root.getPadre().getCategoria());
            }
            System.out.println("");

            if (root.getDerecha() != null) {
                inorden(root.getDerecha());
            }
        }
    }

    public void inordenPadres(NodoAVL root) {
        if (estadoArbol() != true) {
            if (root.getIzquierda() != null) {
                inorden(root.getIzquierda());
            }

            System.out.println("categoria: " + root.getCategoria() + " -- Padre: " + root.getPadre().getCategoria());
            System.out.println("");

            if (root.getDerecha() != null) {
                inorden(root.getDerecha());
            }
        }
    }

    //****************reportes graficos con los diferente tipo de recorrido para el arbol
    public void generarPngPreorden() {
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\ArbolPreorden.dot -o Reportes\\ArbolPreorden.png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se genero la imagen pre");
        }
    }

    private void Preorden(NodoAVL nodo, PrintWriter archivo) {
        if (nodo != null) {
            archivo.println("nodo" + nodoPreorden + "[label=\"" + nodo.getCategoria() + "\"];");
            nodoPreorden++;
            Preorden(nodo.getIzquierda(), archivo);
            Preorden(nodo.getDerecha(), archivo);
        }
    }

    public void generarDotPreorden() {
        NodoAVL auxPrimero = this.root;
        nodoPreorden = 0;
        if (estadoArbol() != true) {
            try {
                archivo = new PrintWriter("ArchivosDot\\ArbolPreorden.dot");
                archivo.println("digraph arbolpreorden {");
                archivo.println("node [shape = record];");
                archivo.println("rankdir=LR;");
                //creo los nodos con sub indice 0,1,2,3 etc
                Preorden(auxPrimero, archivo);
                //anido los nodos ya creados segun el orden indicado
                for (int numeroNodo = 0; numeroNodo < nodoPreorden; numeroNodo++) {
                    archivo.print("nodo" + numeroNodo);
                    if (numeroNodo + 1 < nodoPreorden) {
                        archivo.print("->");
                    }
                }
                archivo.print(";");
                archivo.println("");
                archivo.println("label = \"Arbol AVL - Preorden \"");
                archivo.println("}");
                archivo.close();
                generarPngPreorden();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error dot preorden");
            }
        }
    }

    //*********************************
    public void generarPngInorden() {
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\ArbolInorden.dot -o Reportes\\ArbolInorden.png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se genero la imagen in");
        }
    }

    private void Inorden(NodoAVL nodo, PrintWriter archivo) {
        if (nodo != null) {
            Inorden(nodo.getIzquierda(), archivo);
            archivo.println("nodo" + nodoPreorden + "[label=\"" + nodo.getCategoria() + "\"];");
            nodoPreorden++;
            Inorden(nodo.getDerecha(), archivo);
        }
    }

    public void generarDotInorden() {
        NodoAVL auxPrimero = this.root;
        nodoPreorden = 0;
        if (estadoArbol() != true) {
            try {
                archivo = new PrintWriter("ArchivosDot\\ArbolInorden.dot");
                archivo.println("digraph arbolinorden {");
                archivo.println("node [shape = record];");
                archivo.println("rankdir=LR;");
                //creo los nodos con sub indice 0,1,2,3 etc
                Inorden(auxPrimero, archivo);
                //anido los nodos ya creados segun el orden indicado
                for (int numeroNodo = 0; numeroNodo < nodoPreorden; numeroNodo++) {
                    archivo.print("nodo" + numeroNodo);
                    if (numeroNodo + 1 < nodoPreorden) {
                        archivo.print("->");
                    }
                }
                archivo.print(";");
                archivo.println("");
                archivo.println("label = \"Arbol AVL - Inorden \"");
                archivo.println("}");
                archivo.close();
                generarPngInorden();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error dot inorden");
            }
        }
    }

    //********************************
    public void generarPngPostorden() {
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\ArbolPostorden.dot -o Reportes\\ArbolPostorden.png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se genero la imagen pos");
        }
    }

    private void PostOrden(NodoAVL nodo, PrintWriter archivo) {
        if (nodo != null) {
            PostOrden(nodo.getIzquierda(), archivo);
            PostOrden(nodo.getDerecha(), archivo);
            archivo.println("nodo" + nodoPreorden + "[label=\"" + nodo.getCategoria() + "\"];");
            nodoPreorden++;

        }
    }

    public void generarDotPostorden() {
        NodoAVL auxPrimero = this.root;
        nodoPreorden = 0;
        if (estadoArbol() != true) {
            try {
                archivo = new PrintWriter("ArchivosDot\\ArbolPostorden.dot");
                archivo.println("digraph arbolpostorden {");
                archivo.println("node [shape = record];");
                archivo.println("rankdir=LR;");
                //creo los nodos con sub indice 0,1,2,3 etc
                PostOrden(auxPrimero, archivo);
                //anido los nodos ya creados segun el orden indicado
                for (int numeroNodo = 0; numeroNodo < nodoPreorden; numeroNodo++) {
                    archivo.print("nodo" + numeroNodo);
                    if (numeroNodo + 1 < nodoPreorden) {
                        archivo.print("->");
                    }
                }
                archivo.print(";");
                archivo.println("");
                archivo.println("label = \"Arbol AVL - Postorden \"");
                archivo.println("}");
                archivo.close();
                generarPngPostorden();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error dot postorden");
            }
        }
    }

}
