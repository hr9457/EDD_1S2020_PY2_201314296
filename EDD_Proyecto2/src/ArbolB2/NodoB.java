package ArbolB2;

public class NodoB {

    //info del nodo
    int maximos=4;
    int minimos=1;
    int contadorInfo;
    
    //importaciones de listas
    listaK listaElementos;
    ListaHijos listaHijos;
    
    //elementos
    NodoB padre;

    //constructor
    public NodoB() {
        this.contadorInfo=1;
        this.padre = null;
        listaElementos = new listaK();
        listaHijos = new ListaHijos();
    }

    
    //insertar un libro 
    public void insertarLibro(NodoInformacion informacion){
        if( this.contadorInfo < this.maximos ){
            
        } else {
            
        }
    }
    
    
    //**********
    //metodos get y set
    public NodoB getPadre() {
        return padre;
    }

    public void setPadre(NodoB padre) {
        this.padre = padre;
    }

    public int getMaximos() {
        return maximos;
    }

    public void setMaximos(int maximos) {
        this.maximos = maximos;
    }

    public int getMinimos() {
        return minimos;
    }

    public void setMinimos(int minimos) {
        this.minimos = minimos;
    }

    public int getContadorInfo() {
        return contadorInfo;
    }

    public void setContadorInfo(int contadorInfo) {
        this.contadorInfo = contadorInfo;
    }

    public listaK getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(listaK listaElementos) {
        this.listaElementos = listaElementos;
    }

    public ListaHijos getListaHijos() {
        return listaHijos;
    }

    public void setListaHijos(ListaHijos listaHijos) {
        this.listaHijos = listaHijos;
    }
    
    

}
