package ArbolB2;

import java.io.PrintWriter;

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

        } else { //si el libro ya tiene mas de una pagina
            //miro si puedo ver la raiz para inserta o ya existen mas niveles
            //reviso si en la raiz la cantidad de nodos
            if (revisoRaiz == true) {
                if (raiz.getContadorElementos() < 3) {
                    raiz.insertarNodo(isbn, titulo, autor, editorial, anio,
                            edicion, categoria, idioma, carnet);

                } else {
                    raiz.insertarNodo(isbn, titulo, autor, editorial, anio,
                            edicion, categoria, idioma, carnet);
                    Pagina brother = new Pagina();
                    sacarUltimoElmento(raiz, brother);
                    sacarUltimoElmento(raiz, brother);
                    
                    Pagina nuevoPadre = new Pagina();
                    Nodo elementoEnPadre = sacarUltimoElmento(raiz, nuevoPadre);
                    elementoEnPadre.setHijoDerecha(brother);
                    elementoEnPadre.setHijoIzquierda(raiz);
                    this.raiz = nuevoPadre;
                }

            } else {
                Pagina paginaInsertar = raiz.navegarEntreHijos(isbn);
                paginaInsertar.insertarNodo(isbn, titulo, autor, editorial, 
                        anio, edicion, categoria, idioma, carnet);
                
            }

        }
    }

    private void recorrePagina(Pagina nodo, PrintWriter archivo) {
        Nodo auxPrimerNodo = nodo.getPrimero();
        int contadofuncion = 0;
        if (auxPrimerNodo != null) {
            archivo.print("nodo" + auxPrimerNodo.getInfo().getIsbn() + "[lable=\"");
            //************************
            while(auxPrimerNodo!=null){
                
            }
        }
    }

    //metodo para inter graficar el arbol B
    public void reporteB() {
        Pagina auxPrimero = this.raiz;
        try {
            archivo = new PrintWriter("ArchivosDot\\Hash.dot");
            archivo.println("digraph TablaHas{");
            archivo.println("nodesep=0.08;");
            archivo.println("node [shape=record,width=0.1,height=0.1];");
            recorrePagina(raiz, archivo);
            archivo.print("");
            archivo.println("label = \" ARBOL B \"; ");
            archivo.println("}");
            archivo.close();//cierre del archivo
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
