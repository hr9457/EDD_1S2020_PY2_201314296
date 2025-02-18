
package ArbolB;


public class NodoB {
    
    //elemetos
    int ElementosMinimos;
    int ElementosMaximos;
    int CantidadClaves;
    boolean existenciaPadre;
    boolean existenciaHijos;
    //elementos las dos listas para guardar los elementos
    //y guardar los apuntadores que peude tenera cada nodo
    ListaK listaClaves;
    ListaHijos listaEnlazesHijos;
    
    //constructor
    public NodoB(){
        this.ElementosMinimos=2;
        this.ElementosMaximos=4;
        this.CantidadClaves=0;
        this.existenciaPadre=false;
        this.existenciaHijos=false;//inicializo el nodo sin hijos
        listaClaves = new ListaK();
        listaEnlazesHijos = new ListaHijos();
    }
    
    
    //metodo para modificar datos en la posiciones del nodo del arbol B
    public void insertarElemento(int isbn,String titulo,String autor,
            String editorial,String anio,String edicion,String categoria,
            String idioma,int carnet){
        //una vez se recibe la informacion debo de inserta en la lista de las claves
        listaClaves.insertarClave(isbn, titulo, autor, editorial, anio, edicion,
                categoria, idioma, carnet);
    }
    
    //metodo para sber el tamanio de la lista
    public int tamanioClaves(){
        return listaClaves.getTamanio();
    }
    
    //metodo para eleminar claves
    public void eliminarClaves(){
        NodoK primero,segundo;
        primero= listaClaves.eliminarClaves();
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

    public boolean isExistenciaPadre() {
        return existenciaPadre;
    }

    public void setExistenciaPadre(boolean existenciaPadre) {
        this.existenciaPadre = existenciaPadre;
    }  
    
    
    public boolean isExistenciaHijos() {
        return existenciaHijos;
    }

    public void setExistenciaHijos(boolean existenciaHijos) {
        this.existenciaHijos = existenciaHijos;
    }

    //metodos get y set para las listas de las claves y hijos
    public ListaK getListaClaves() {
        return listaClaves;
    }

    public void setListaClaves(ListaK listaClaves) {
        this.listaClaves = listaClaves;
    }

    public ListaHijos getListaEnlazesHijos() {
        return listaEnlazesHijos;
    }

    public void setListaEnlazesHijos(ListaHijos listaEnlazesHijos) {
        this.listaEnlazesHijos = listaEnlazesHijos;
    }
    
    
 
    
}
