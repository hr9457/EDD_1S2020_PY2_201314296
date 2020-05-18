package ArbolB2;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class ArbolB {

    boolean revisoRaiz = true;

    //archiov dot
    PrintWriter archivo;

    //contador
    int contador = 0;
    Pagina raiz;

    public ArbolB() {
        this.raiz = null;
    }

    public Nodo sacarUltimoElmento(Pagina nodo, Pagina hermano) {
        //paso su info a su hermano
        Nodo elementoHermano = nodo.eliminarUltimoNodo();
        int isbn2 = elementoHermano.getInfo().getIsbn();
        String tit = elementoHermano.getInfo().getTitulo();
        String aut = elementoHermano.getInfo().getTitulo();
        String edi = elementoHermano.getInfo().getEditorial();
        String ani = elementoHermano.getInfo().getAnio();
        String Edit = elementoHermano.getInfo().getEditorial();
        String cat = elementoHermano.getInfo().getCategoria();
        String idio = elementoHermano.getInfo().getIdioma();
        int car = elementoHermano.getInfo().getCarnet();
        hermano.insertarNodo(isbn2, tit, aut, edi, ani,
                Edit, cat, idio, car);
        Nodo elementoInsertado = hermano.retornarElemento(isbn2);
        return elementoInsertado;
    }

    public void agregarLibro(int isbn, String titulo, String autor,
            String editorial, String anio, String edicion, String categoria, String idioma, int carnet) {

        if (raiz == null) {// si el libro no tiene paginas
            //creo una nueva pagina
            Pagina nuevaPagina = new Pagina();
            //inserto un nodo
            nuevaPagina.insertarNodo(isbn, titulo, autor, editorial, anio, edicion,
                    categoria, idioma, carnet);
            this.raiz = nuevaPagina;

        } else { //si el libro ya tiene mas de una pagina
            //miro si puedo ver la raiz para inserta o ya existen mas niveles
            //reviso si en la raiz la cantidad de nodos
            if (revisoRaiz == true) {
                if (raiz.getContadorElementos() < 4) {
                    raiz.insertarNodo(isbn, titulo, autor, editorial, anio,
                            edicion, categoria, idioma, carnet);

                } else {
                    raiz.insertarNodo(isbn, titulo, autor, editorial, anio,
                            edicion, categoria, idioma, carnet);
                    //********pagina hermano
                    Pagina brother = new Pagina();
                    sacarUltimoElmento(raiz, brother);
                    sacarUltimoElmento(raiz, brother);
                    //*********pagina arriba nuevo padre
                    Pagina nuevoPadre = new Pagina();
                    Nodo elementoEnPadre = sacarUltimoElmento(raiz, nuevoPadre);
                    elementoEnPadre.setHijoDerecha(brother);
                    elementoEnPadre.setHijoIzquierda(raiz);
                    //********************
                    raiz.setPadre(nuevoPadre);
                    this.raiz = nuevoPadre;
                    //********************
                    brother.setPadre(raiz);
                    this.revisoRaiz = false;
                }

            } else {
                Pagina paginaInsertar = raiz.navegarEntreHijos(isbn);

                if (paginaInsertar.getContadorElementos() < 4) {
                    paginaInsertar.insertarNodo(isbn, titulo, autor, editorial,
                            anio, edicion, categoria, idioma, carnet);
                } else {
                    paginaInsertar.insertarNodo(isbn, titulo, autor, editorial,
                            anio, edicion, categoria, idioma, carnet);
                    //***********pagina brother
                    Pagina newBrother = new Pagina();
                    sacarUltimoElmento(paginaInsertar, newBrother);
                    sacarUltimoElmento(paginaInsertar, newBrother);
                    //****************************
                    Nodo elemento = sacarUltimoElmento(paginaInsertar, raiz);
                    elemento.setHijoIzquierda(paginaInsertar);
                    elemento.setHijoDerecha(newBrother);
                }

            }

        }
    }
    
    public void abrirImagen(){
       try {
            String archivo = "Reportes\\B.png";
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("cmd /c start " + archivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede arbir la imagen");
        } 
    }

    public void crearImagen() {
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\B.dot -o Reportes\\B.png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se genero la imagen del reporte");
        }
    }

    private void recorrePagina(Pagina nodo, PrintWriter archivo) {
        Nodo auxPrimerNodo = nodo.getPrimero();
        int contadorHijos = 0;
        if (nodo != null) {
            archivo.print("nodo" + auxPrimerNodo.getInfo().getIsbn() + "[label=\"");
            //************************
            while (auxPrimerNodo != null) {
                archivo.print("<h" + contadorHijos + ">| " + auxPrimerNodo.getInfo().getIsbn() + "| ");
                auxPrimerNodo = auxPrimerNodo.getSiguiente();
                contadorHijos++;
            }
            archivo.print("<h" + contadorHijos + ">");
            archivo.print("\" ];");
            archivo.println("");
        }
        auxPrimerNodo = nodo.getPrimero();
        while(auxPrimerNodo!=null){
            if (auxPrimerNodo.getHijoIzquierda() != null) {
                recorrePagina(auxPrimerNodo.getHijoIzquierda(), archivo);
            }
            if (auxPrimerNodo.getHijoDerecha() != null) {
                recorrePagina(auxPrimerNodo.getHijoDerecha(), archivo);
            }
            auxPrimerNodo = auxPrimerNodo.getSiguiente();
        }
    }

    public void apuntadores(Pagina nodo, PrintWriter archivo) {
        int ContadorHijos = 0;
        Nodo auxPrimerNodo = nodo.getPrimero();
        int numnodo = auxPrimerNodo.getInfo().getIsbn();
        if (nodo != null) {
            while (auxPrimerNodo != null) {
                if (auxPrimerNodo.getHijoIzquierda() != null) {
                    archivo.print("nodo" + numnodo+ ":h" + ContadorHijos + "->");
                    int hijoizq = auxPrimerNodo.getHijoIzquierda().getPrimero().getInfo().getIsbn();
                    archivo.print("nodo" + hijoizq + ";");
                    archivo.println("");
                    ContadorHijos++;
                }
                if (auxPrimerNodo.getHijoDerecha() != null) {
                    archivo.print("nodo" + numnodo + ":h" + ContadorHijos + "->");
                    int hijoDer = auxPrimerNodo.getHijoDerecha().getPrimero().getInfo().getIsbn();
                    archivo.print("nodo" + hijoDer + ";");
                    archivo.println("");
                    ContadorHijos++;
                }
                ContadorHijos--;
                auxPrimerNodo = auxPrimerNodo.getSiguiente();
            }
        }
    }

    //metodo para inter graficar el arbol B
    public void reporteB() {
        Pagina auxRaiz = this.raiz;
        try {
            archivo = new PrintWriter("ArchivosDot\\B.dot");
            archivo.println("digraph B{");
            archivo.println("nodesep=0.08;");
            archivo.println("node [shape=record,width=0.1,height=0.1];");
            if (auxRaiz != null) {
                recorrePagina(auxRaiz, archivo);
            }
            if (auxRaiz != null) {
                apuntadores(auxRaiz, archivo);
            }
            archivo.print("");
            archivo.println("label = \" ARBOL B \"; ");
            archivo.println("}");
            archivo.close();//cierre del archivo
            crearImagen();
        } catch (Exception e) {
        }
    }

    public Pagina getRaiz() {
        return raiz;
    }

    public void setRaiz(Pagina raiz) {
        this.raiz = raiz;
    }

}
