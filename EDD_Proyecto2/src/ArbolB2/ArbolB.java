package ArbolB2;

import java.io.PrintWriter;

public class ArbolB {

    //archiov dot
    PrintWriter archivo;
    
    //contador
    int contador = 0;
    Pagina raiz;

    public ArbolB() {
        this.raiz = null;
    }

    public void insertar(int isbn, String titulo, String autor, String editorial,
            String anio, String edicion, String categoria, String idioma, int carnet) {

        if (raiz == null) {
            Pagina nuevaPagina = new Pagina();
            nuevaPagina.insertarNodo(isbn, titulo, autor, editorial, anio,
                    edicion, categoria, idioma, carnet);
            this.raiz = nuevaPagina;
            contador++;

        } else if (raiz != null && contador < 3) {
            raiz.insertarNodo(isbn, titulo, autor, editorial, anio,
                    edicion, categoria, idioma, carnet);
            contador++;

        } else if (raiz != null && contador > 3) {
            raiz.insertarNodo(isbn, titulo, autor, editorial, anio,
                    edicion, categoria, idioma, carnet);
            contador++;
            Pagina nuevoPadre = new Pagina();
            Pagina hermano = new Pagina();

            //paso su info a su hermano
            for (int i = 0; i < 2; i++) {
                Nodo elementoHermano = raiz.eliminarUltimoNodo();
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
            }

            //paso info al nuevo padre
            Nodo elementoPadre = raiz.eliminarUltimoNodo();
            int isbnP = elementoPadre.getInfo().getIsbn();
            String titP = elementoPadre.getInfo().getTitulo();
            String autP = elementoPadre.getInfo().getTitulo();
            String ediP = elementoPadre.getInfo().getEditorial();
            String aniP = elementoPadre.getInfo().getAnio();
            String EditP = elementoPadre.getInfo().getEditorial();
            String catP = elementoPadre.getInfo().getCategoria();
            String idioP = elementoPadre.getInfo().getIdioma();
            int carP = elementoPadre.getInfo().getCarnet();
            nuevoPadre.insertarNodo(isbnP, titP, autP, ediP, aniP, 
                    EditP, catP, idioP, carP);
            contador=1;
            nuevoPadre.getPrimero().setHijoIzquierda(this.raiz);
            nuevoPadre.getPrimero().setHijoDerecha(hermano);
            raiz.setPadre(nuevoPadre);
            hermano.setPadre(nuevoPadre);
            this.raiz=nuevoPadre;

        }//
    }
    
    public void agregarLibro(){
        if(raiz==null){// si el libro no tiene paginas
            
        } else { //si el libro ya tiene mas de una pagina
            
        }
    }
    
    private void recorrePagina(Pagina nodo,PrintWriter archivo){
        Nodo auxPrimerNodo = nodo.getPrimero();
        int contadofuncion = 0;
        if(auxPrimerNodo!=null){
            archivo.print("nodo"+auxPrimerNodo.getInfo().getIsbn()+"[lable=\"");
            //************************
            while(auxPrimerNodo!=null){
                
                auxPrimerNodo = auxPrimerNodo.getSiguiente();
            }
        }
    }
    
    //metodo para inter graficar el arbol B
    public void reporteB(){
        Pagina auxPrimero = this.raiz;
        try {
            archivo = new PrintWriter("ArchivosDot\\Hash.dot");
            archivo.println("digraph TablaHas{");
            archivo.println("nodesep=0.08;");
            archivo.println("node [shape=record,width=0.1,height=0.1];");
            recorrePagina(raiz, archivo);
            archivo.print("");
            archivo.println("label = \" Tabla Hash \"; ");
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
