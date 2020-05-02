package ArbolBV2;

public class ListaK {

    //elementos
    int tamanioLista,cantidadClaves;
            
    //punteros
    NodoK primero;
    NodoK ultimo;

    //constructor
    public ListaK() {
        this.tamanioLista=0;
        this.cantidadClaves=4;
        this.primero = null;
        this.ultimo = null;
    }

    //metodo para retornar el estado de la lista
    public boolean estadoLista() {
        if (this.primero == null && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    //metodo par insertar una clave en la lista
    //metod par insertar una clave
    public void insertarClave(int isbn, String titulo, String autor, String editorial,
            String anio, String Edicion, String Categoria, String idioma, int carnet) {
        //1. recibo la informacion para el elemento en el arbol 
        //2. creo un nodo en la lista de clavees
        NodoK nuevoNodo = new NodoK(isbn, titulo, autor, editorial, anio,
                Edicion, Categoria, idioma);

        //dos condiciones saber si ya existe un nodo raiz o no
        if (estadoLista() == true) {
            this.primero = nuevoNodo;
            this.ultimo=nuevoNodo;
            this.tamanioLista++;
            
        } else {
            if(getTamanioLista()<=getCantidadClaves()){
                //buscar la posicion donde guardar
                NodoK auxPrimero = this.primero;
                //uso del while para buscar la posicion donde guardar en orden
                while(auxPrimero.getSiguiente()!=null && 
                        auxPrimero.getSiguiente().getISBN()<isbn){
                    auxPrimero = auxPrimero.getSiguiente();
                }//fin del while que busca la posicion
                
                //considero las posible casos en la lista
                //1. que el libro sea el mismo tenga el mismo codigo isbn
                if(auxPrimero.getISBN()==isbn){
                    //no lo agrego
                    //por que se repite el dato
                }else if(auxPrimero.getISBN()>isbn){
                    auxPrimero.setAnteriror(nuevoNodo);
                    nuevoNodo.setSiguiente(auxPrimero);
                    //uno los enlazes de los hijos
                    nuevoNodo.setDerechaAbajo(auxPrimero.getDerechaAbajo());
                    this.primero=nuevoNodo;
                    this.tamanioLista++;
                    
                }else if(auxPrimero.getISBN()<isbn){
                    NodoK siguienteTemporal = auxPrimero.getSiguiente();
                    auxPrimero.setSiguiente(nuevoNodo);
                    nuevoNodo.setAnteriror(auxPrimero);
                    //ahora enlazo los apuntadore hacia abajo
                    nuevoNodo.setIzquierdaAbajo(auxPrimero.getDerechaAbajo());
                    
                    nuevoNodo.setSiguiente(siguienteTemporal);
                    this.ultimo=nuevoNodo;
                    this.tamanioLista++;
                    //reviso si el siguiente temporal no es nulo
                    if(siguienteTemporal!=null){
                        siguienteTemporal.setAnteriror(nuevoNodo);
                    } 
                }
                
            }//fin del primer if
        }
    }
    
    
    

    //*************************************************************************
    //METODOS GET Y SET
    public int getTamanioLista() {
        return tamanioLista;
    }
    
    public void setTamanioLista(int tamanioLista) {
        this.tamanioLista = tamanioLista;
    }

    public int getCantidadClaves() {
        return cantidadClaves;
    }

    public void setCantidadClaves(int cantidadClaves) {
        this.cantidadClaves = cantidadClaves;
    }
    
    

    public NodoK getPrimero() {
        return primero;
    }

    public void setPrimero(NodoK primero) {
        this.primero = primero;
    }

    public NodoK getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoK ultimo) {
        this.ultimo = ultimo;
    }

}
