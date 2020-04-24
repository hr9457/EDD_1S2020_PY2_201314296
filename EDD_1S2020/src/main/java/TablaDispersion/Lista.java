    

package TablaDispersion;


public class Lista {
    
    //elementos de una lista
    NodoHash primero;
    NodoHash ultimo;
    int tamanioTabla;
    int size;
    
    //constructor
    public Lista(){
        this.primero=null;
        this.ultimo=null;
        this.tamanioTabla=45;
        this.size=0;
    }
    
    //funcion de dispersion saber la posicion en el se va agregar en la tabla
    public int funcionDispersion(int carne){
        return carne%this.tamanioTabla;//funcion= carnet mod size
    }
    
    //revision de nuestr lista contien algun elemento o no
    public boolean estadoLista(){
        return (primero==null && ultimo==null)?true:false;
    }
    
    
    //metodo para insertar en la lista
    public void insertar(int carne){
        int posicionDeNodo = funcionDispersion(carne);
        NodoHash nuevoNodo = new NodoHash(posicionDeNodo);
        if(estadoLista()==true){//si en la lista no existe ningun elemento            
            this.primero=nuevoNodo;
            this.ultimo=nuevoNodo;
        }else{//la lista ya contien mas de un elemento
            NodoHash auxPrimero = primero;
            while (auxPrimero.getAbajo()!=null && auxPrimero.getAbajo().getPosicion()<posicionDeNodo){
                auxPrimero = auxPrimero.getAbajo();//paso al siguiente si no cumple
            }
            //while me deja un nodo atras
            //el while hace que nos quedemos un nodo atras un nodo arriba de 
            if(posicionDeNodo==auxPrimero.getPosicion()){
                System.out.println("colision");
            }else{
                NodoHash auxAbajo = auxPrimero.getAbajo();
                auxPrimero.setAbajo(nuevoNodo);
                nuevoNodo.setAbajo(auxAbajo);
            }
        }
    }
    
    
    //metodo para buscar dentro de la lista
    //busqueda cuadratica
    
    
    
    //-------------------------------------------------------------------------------
    //metodo get y set
    public NodoHash getPrimero() {
        return primero;
    }

    public void setPrimero(NodoHash primero) {
        this.primero = primero;
    }

    public NodoHash getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoHash ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanioTabla() {
        return tamanioTabla;
    }

    
    public void setTamanioTabla(int tamanioTabla) {    
        this.tamanioTabla = tamanioTabla;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
