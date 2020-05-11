
package ArbolB2;


public class listaK {
    
    //elementos
    NodoK primero;
    NodoK ultimo;
    
    //contructor
    public listaK(){
        this.primero=null;
        this.ultimo=null;
        creacionLista();//creo las posicion dentro del nodo
    }
    
    
    //creacion de la lista con sus 4 que guardaran la informacion
    public void creacionLista(){
        NodoK uno = new NodoK(1);
        NodoK dos = new NodoK(2);
        NodoK tres = new NodoK(3);
        NodoK cuatro = new NodoK(4);
        //****enlazando la nodos para crear la lista
        uno.setSiguiente(dos);
        dos.setAnterior(uno); 
        
        dos.setSiguiente(tres);
        tres.setAnterior(dos);
        
        tres.setSiguiente(cuatro);
        cuatro.setAnterior(tres);
        
        //primero y ultimo de la lista
        this.primero=uno;
        this.ultimo=cuatro;
    }
    
    
    //posicionar la informacion en la lista
    public void insertarLibro(){
        NodoK auxUno=this.primero;
        if(auxUno.getInformacion().isEstado()==true){
            
        } else {
            
        }
    }
    
    //*********************
    //metodos get y set

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
