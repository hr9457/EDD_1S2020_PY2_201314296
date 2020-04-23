

package TablaDispersion;


public class Lista {
    
    //elementos de una lista
    Nodo primero;
    Nodo ultimo;
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
    public void insertar(int posicion,int carne,String nombre,String apellido,
                     String carrera,String password){//pos,carne..
        Nodo nuevoNodo = new Nodo(posicion,carne,nombre,apellido,carrera,password);//creacion de un nuevo nodo
        if(estadoLista()==true){//si en la lista no existe ningun elemento            
            this.primero=nuevoNodo;
            this.ultimo=nuevoNodo;
            size++;
        }else{//la lista ya contien mas de un elemento
            Nodo auxPrimero = primero;//nodo auxiliar para recorrer la lista
            while (auxPrimero.getAbajo()!=null && auxPrimero.getAbajo().getPosicion()<posicion){
                auxPrimero = auxPrimero.getAbajo();//paso al siguiente si no cumple
            }
            //while me deja un nodo atras
            if(posicion==auxPrimero.getPosicion())
            {
                System.out.println("colision");
            }
            else
            {
                Nodo auxAbajo = auxPrimero.getAbajo();
                auxPrimero.setAbajo(nuevoNodo);
                nuevoNodo.setAbajo(auxAbajo);
            }
        }
    }
    
    
    //metodo para buscar dentro de la lista
    public boolean buscarUsuario(int carnet,String nombre){
        Nodo auxPrimero = primero;
        while(auxPrimero!=null){
            if(carnet==auxPrimero.getNumeroCarnet() && nombre.equals(auxPrimero.getNombre())){
                return true;
            }
            else{
                auxPrimero = auxPrimero.getAbajo();
            }
        }
        return false;
    }
    
    
    
    //metodo para imprimir la lista
    public void imprimirLista(){
        Nodo auxPrimero = primero;
        while(auxPrimero!=null){
            System.out.println("Posicion: "+auxPrimero.getPosicion()
                    +" Estudiante: "+auxPrimero.getNombre());
            auxPrimero = auxPrimero.getAbajo();//paso al siguiente nodo
        }
    }
    
    
    
    //-------------------------------------------------------------------------------
    //metodo get y set 
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
