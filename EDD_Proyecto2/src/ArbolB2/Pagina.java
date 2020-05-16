package ArbolB2;

/**
 *
 * @author joshu
 */
public class Pagina {

    Pagina padre;
    int contadorNodo = 0;

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
        } else {
            Nodo auxPrimero = this.primero;
            while (auxPrimero.getSiguiente() != null && auxPrimero.getInfo().getIsbn() < isbn) {
                auxPrimero = auxPrimero.getSiguiente();
            }
            //******3 op primero, ultimo, en medio
            if (auxPrimero == this.ultimo) {
                this.ultimo.setSiguiente(nuevoElemento);
                nuevoElemento.setAnterior(this.ultimo);
                this.ultimo = nuevoElemento;
            } else if (auxPrimero == this.primero) {
                if (auxPrimero.getInfo().getIsbn() > isbn) {
                    auxPrimero.setAnterior(nuevoElemento);
                    nuevoElemento.setSiguiente(auxPrimero);
                    this.primero = nuevoElemento;
                } else if (auxPrimero.getInfo().getIsbn() < isbn) {
                    Nodo auxAdelante = auxPrimero.getSiguiente();
                    auxPrimero.setSiguiente(nuevoElemento);
                    nuevoElemento.setAnterior(auxPrimero);
                    nuevoElemento.setSiguiente(auxAdelante);
                    if (auxAdelante != null) {
                        auxAdelante.setAnterior(nuevoElemento);
                    }
                }
            } else {
                Nodo auxAdelante = auxPrimero.getSiguiente();
                auxPrimero.setSiguiente(nuevoElemento);
                nuevoElemento.setAnterior(auxPrimero);
                nuevoElemento.setSiguiente(auxAdelante);
                if (auxAdelante != null) {
                    auxAdelante.setAnterior(nuevoElemento);
                }
            }
        }

    }//fin del metodo

    //inserta libro
    public Pagina insert(int isbn) {
        if (this.primero == null && this.ultimo == null) {
            //insertar nodo
            return null;
            
        } else {
            //buscar nodo por nodo si hay un hijo
            Nodo auxPrimero = this.primero;
            while (auxPrimero != null) {
                if (auxPrimero != null) {
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
                }
                auxPrimero = auxPrimero.getSiguiente();

            }//fin del recorrid de la lista
            return null;
        }
    }

    //metodo para eliminar de utlimo
    public Nodo eliminarUltimoNodo() {
        Nodo axuUltimo = this.ultimo;
        this.ultimo = axuUltimo.getAnterior();
        this.ultimo.setSiguiente(null);
        axuUltimo.setAnterior(null);
        return axuUltimo;
    }

    public Pagina getPadre() {
        return padre;
    }

    public void setPadre(Pagina padre) {
        this.padre = padre;
    }

    public int getContadorNodo() {
        return contadorNodo;
    }

    public void setContadorNodo(int contadorNodo) {
        this.contadorNodo = contadorNodo;
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
