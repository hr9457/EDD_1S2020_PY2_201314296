
package ArbolB;


public class ListaK {
    
    //elementos
    int Claves;
    int tamanio;
    NodoK primero;
    NodoK ultimo;
    
    //constructor
    public ListaK(){
        this.Claves=4;
        this.tamanio=1;
        this.primero=null;
        this.ultimo=null;
    }
    
    //metodo para saber el estado de la lista
    public boolean estadoLista(){
        if(primero==null && ultimo==null){
            return true;
        }else{
            return false;
        }
    }
    
    //metod par insertar una clave
    public void insertarClave(int isbn,String titulo,String autor,String editorial,
            String anio,String Edicion,String Categoria,String idioma,int carnet){
        //1. recibo la informacion para el elemento en el arbol 
        //2. creo un nodo en la lista de clavees
        NodoK nuevoNodo = new NodoK(isbn, titulo, autor, editorial, anio, 
                Edicion, Categoria, idioma);
        
        //busco si la lista ya contiene algun elmento 
        //1. si no hay elementos inserto con primero y ultimo
        //eles 2. busco como ingresarlo en orden con el isbn
        if(estadoLista()==true){
            this.primero=nuevoNodo;
            //this.ultimo=nuevoNodo;
            tamanio++;
        }else{
            if(getTamanio()<=Claves){
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
                }else if(auxPrimero.getISBN()>isbn){
                    auxPrimero.setAtras(nuevoNodo);
                    nuevoNodo.setSiguiente(auxPrimero);
                    this.primero=nuevoNodo;
                }else if(auxPrimero.getISBN()<isbn){
                    NodoK siguienteTemporal = auxPrimero.getSiguiente();
                    auxPrimero.setSiguiente(nuevoNodo);
                    nuevoNodo.setAtras(auxPrimero);
                    nuevoNodo.setSiguiente(siguienteTemporal);
                    //reviso si el siguiente temporal no es nulo
                    if(siguienteTemporal!=null){
                        siguienteTemporal.setAtras(nuevoNodo);
                    }
                    //fin 
                }
            }
        }
    }
    
    
    //metodo buscar la posicion dentro de la lista para el puntero del hijo
    public int buscarPosicionHijo(int isbn){
        int position=0;
        NodoK auxPrimero = this.primero;//empiezo buscando desde primer elemento
        
        //verifico si el siguiente al primero es null
        //entoces se que la posicion del hijo es la 0 - le primero hijo
        if(auxPrimero.getSiguiente()!=null){
            return 1;
        }else{
            return 0;
        }        
    }
    
    //metodo para eliminar de primero
    public void eliminarClavePrimero(){}
    
    //metodo para eliminar de ultimo
    public void eliminarClaveUltimo(){}
    
    
    //metodo get y set
    public int getClaves() {
        return Claves;
    }

    public void setClaves(int Claves) {
        this.Claves = Claves;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
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
