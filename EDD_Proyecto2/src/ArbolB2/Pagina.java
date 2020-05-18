package ArbolB2;

/**
 *
 * @author joshu
 */
public class Pagina {

    Pagina padre;
    int contadorElementos = 0;

    Nodo primero;
    Nodo ultimo;

    public Pagina() {
        this.primero = null;
        this.ultimo = null;
        this.padre = null;
    }

    //agoritmos inserta en orden
    public void insertarNodo(int isbn, String titulo, String autor,
            String editorial, String anio, String edicion, String categoria, String idioma, int carnet) {

        Informacion nevaInfo = new Informacion(isbn, titulo, autor, editorial,
                anio, edicion, categoria, idioma, carnet);

        Nodo nuevoElemento = new Nodo(nevaInfo);

        if (primero == null && ultimo == null) {
            this.primero = nuevoElemento;
            this.ultimo = nuevoElemento;
            contadorElementos++;

        } else {
            Nodo auxPrimero = this.primero;
            while (auxPrimero.getSiguiente() != null && auxPrimero.getInfo().getIsbn() < isbn) {
                auxPrimero = auxPrimero.getSiguiente();
            }
            //******3 op primero, ultimo, en medio
            if (auxPrimero == this.primero && auxPrimero == this.ultimo) {
                if (auxPrimero.getInfo().getIsbn() < isbn) {
                    this.ultimo.setSiguiente(nuevoElemento);
                    nuevoElemento.setAnterior(this.ultimo);
                    this.ultimo = nuevoElemento;
                    contadorElementos++;
                } else {
                    nuevoElemento.setSiguiente(this.primero);
                    this.primero.setAnterior(nuevoElemento);
                    this.primero = nuevoElemento;
                    contadorElementos++;
                }

            } else if (auxPrimero == this.primero) {
                if (auxPrimero.getInfo().getIsbn() < isbn) {
                    Nodo siguienteA = auxPrimero.getSiguiente();
                    this.primero.setSiguiente(nuevoElemento);
                    nuevoElemento.setAnterior(this.primero);
                    nuevoElemento.setSiguiente(siguienteA);
                    siguienteA.setAnterior(nuevoElemento);
                    contadorElementos++;
                } else {
                    nuevoElemento.setSiguiente(this.primero);
                    this.primero.setAnterior(nuevoElemento);
                    this.primero = nuevoElemento;
                    contadorElementos++;
                }
            } else if (auxPrimero == this.ultimo) {
                this.ultimo.setSiguiente(nuevoElemento);
                nuevoElemento.setAnterior(this.ultimo);
                this.ultimo = nuevoElemento;
                contadorElementos++;
            } else {
                Nodo siguiente = auxPrimero.getSiguiente();
                Nodo anterior = auxPrimero.getAnterior();
                anterior.setSiguiente(nuevoElemento);
                nuevoElemento.setAnterior(anterior);
                nuevoElemento.setSiguiente(siguiente);
                siguiente.setAnterior(nuevoElemento);
                contadorElementos++;
            }
        }

    }//fin del metodo

    //**************************************************************************
    //inserta libro
    public Pagina navegarEntreHijos(int isbn) {

        Nodo auxPrimero = this.primero;

        while (auxPrimero != null) {
            if (auxPrimero.getHijoIzquierda() != null) {
                if (isbn < auxPrimero.getInfo().getIsbn()) {
                    //retorno la pagina que tenga del lado izquierdo
                    return auxPrimero.getHijoIzquierda();
                }

            } else if (auxPrimero.getHijoDerecha() != null) {
                if (isbn > auxPrimero.getInfo().getIsbn()) {
                    //retorno la pagina que tenga del lado derecho
                    return auxPrimero.getHijoDerecha();
                }

            }

            auxPrimero = auxPrimero.getSiguiente();

        }//fin del recorrid de la lista
        return null;

    }

    //metodo para eliminar de utlimo
    public Nodo eliminarUltimoNodo() {
        Nodo auxEliminar = this.ultimo;
        this.ultimo = auxEliminar.getAnterior();
        ultimo.setSiguiente(null);
        auxEliminar.setAnterior(null);
        contadorElementos--;
        return auxEliminar;
    }

    public Nodo eliminarTercero() {
        Nodo auxprimero = this.primero;
        for (int i = 0; i < 3; i++) {
            auxprimero = auxprimero.getSiguiente();
        }
        Nodo anterior = auxprimero.getAnterior();
        Nodo siguiente = auxprimero.getSiguiente();
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);
        auxprimero.setSiguiente(null);
        auxprimero.setAnterior(null);
        return auxprimero;
    }

    public Nodo retornarElemento(int isb) {
        Nodo auxPrimero = this.primero;
        while (auxPrimero != null && auxPrimero.getInfo().getIsbn() != isb) {
            auxPrimero = auxPrimero.getSiguiente();
        }
        return auxPrimero;
    }

    public Pagina getPadre() {
        return padre;
    }

    public void setPadre(Pagina padre) {
        this.padre = padre;
    }

    public int getContadorElementos() {
        return contadorElementos;
    }

    public void setContadorElementos(int contadorElementos) {
        this.contadorElementos = contadorElementos;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

}
