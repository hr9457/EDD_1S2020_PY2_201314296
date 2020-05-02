package ArbolBV2;

public class NodoB {

    //elementos
    ListaK listaClaves;
    //elemetos
    int ElementosMinimos;
    int ElementosMaximos;
    int CantidadClaves;

    //punteros
    NodoB izquierda;
    NodoB derecha;
    NodoB padre;

    //constructor
    public NodoB() {
        this.ElementosMaximos = 3;
        this.ElementosMaximos = 1;
        this.CantidadClaves = 0;
        this.izquierda = null;
        this.derecha = null;
        this.padre = null;
        listaClaves = new ListaK();
    }

    //metodo insertar en el nodB
    public void insertarClave(int isbn, String titulo, String autor,
            String editorial, String anio, String edicion, String categoria,
            String idioma, int carnet) {
        //una vez se recibe la informacion debo de inserta en la lista de las claves
        listaClaves.insertarClave(isbn, titulo, autor, editorial, anio, edicion,
                categoria, idioma, carnet);
        this.CantidadClaves++;
    }

    //metodo para sacar los ultimos dos elementos de un nodo
    public void eliminarUltimosDos(NodoB nodoDerechaArg) {
        NodoK auxUltimo = listaClaves.getUltimo();//empiezo desde el primero
        
        NodoK auxAnterior = auxUltimo.getAnteriror();
        auxUltimo.setAnteriror(null);
        auxAnterior.setSiguiente(null);
        nodoDerechaArg.insertarClave(auxUltimo.getISBN(), auxUltimo.getTitulo(),
                auxUltimo.getAutor(), auxUltimo.getEditorial(),
                auxUltimo.getAnio(), auxUltimo.getEdiccion(), auxUltimo.getCategoria(),
                auxUltimo.getIdioma(), auxUltimo.getCarnetUsuario());
        auxAnterior.setSiguiente(null);
        listaClaves.setUltimo(auxAnterior);
        
        
        auxUltimo = listaClaves.getUltimo();//empiezo desde el primero
        auxAnterior = auxUltimo.getAnteriror();
        auxUltimo.setAnteriror(null);
        auxAnterior.setSiguiente(null);
        nodoDerechaArg.insertarClave(auxUltimo.getISBN(), auxUltimo.getTitulo(),
                auxUltimo.getAutor(), auxUltimo.getEditorial(),
                auxUltimo.getAnio(), auxUltimo.getEdiccion(), auxUltimo.getCategoria(),
                auxUltimo.getIdioma(), auxUltimo.getCarnetUsuario());
        auxAnterior.setSiguiente(null);
        listaClaves.setUltimo(auxAnterior);
        
    }

    //metodo para sace el elemento de medio que va hacia arriba
    public void eliminarTercero() {

    }

    //metodos get y set
    public int getElementosMinimos() {
        return ElementosMinimos;
    }

    public void setElementosMinimos(int ElementosMinimos) {
        this.ElementosMinimos = ElementosMinimos;
    }

    public int getElementosMaximos() {
        return ElementosMaximos;
    }

    public void setElementosMaximos(int ElementosMaximos) {
        this.ElementosMaximos = ElementosMaximos;
    }

    public int getCantidadClaves() {
        return CantidadClaves;
    }

    public void setCantidadClaves(int CantidadClaves) {
        this.CantidadClaves = CantidadClaves;
    }

    public ListaK getListaClaves() {
        return listaClaves;
    }

    public void setListaClaves(ListaK ListaClaves) {
        this.listaClaves = ListaClaves;
    }

    public NodoB getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoB izquierda) {
        this.izquierda = izquierda;
    }

    public NodoB getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoB derecha) {
        this.derecha = derecha;
    }

    public NodoB getPadre() {
        return padre;
    }

    public void setPadre(NodoB padre) {
        this.padre = padre;
    }

}
