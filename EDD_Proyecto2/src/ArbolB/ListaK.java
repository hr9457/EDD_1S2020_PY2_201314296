
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
        NodoK nuevoNodo = new NodoK(isbn, titulo, autor, editorial, anio, Edicion, Categoria, idioma);
        if(estadoLista()==true){
            this.primero=nuevoNodo;
            this.ultimo=nuevoNodo;
            tamanio++;
        }else{
            if(getTamanio()<=Claves){
                //buscar la posicion donde guardar
                NodoK auxPrimero = this.primero;
            }
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
