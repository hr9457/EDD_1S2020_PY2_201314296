package ArbolBV2;

public class NodoK {

    //elementos 
    int ISBN;
    String titulo, Autor, Editorial, anio, Ediccion, Categoria, Idioma;
    int carnetUsuario;

    //punteros
    NodoK siguiente;
    NodoK anteriror;
    NodoB izquierdaAbajo;
    NodoB derechaAbajo;
    

    //constructor
    public NodoK(int ISBN, String titulo, String autor, String editorial,
            String anio, String ediccion, String categoria, String idioma) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.Autor = autor;
        this.Editorial = editorial;
        this.anio = anio;
        this.Ediccion = ediccion;
        this.Categoria = categoria;
        this.Idioma = idioma;
        this.siguiente = null;
        this.anteriror = null;
    }
    
    
    //--------------------------------------------------------------------------
    //METODO GET Y SETT
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEdiccion() {
        return Ediccion;
    }

    public void setEdiccion(String Ediccion) {
        this.Ediccion = Ediccion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public int getCarnetUsuario() {
        return carnetUsuario;
    }

    public void setCarnetUsuario(int carnetUsuario) {
        this.carnetUsuario = carnetUsuario;
    }

    public NodoK getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoK siguiente) {
        this.siguiente = siguiente;
    }

    public NodoK getAnteriror() {
        return anteriror;
    }

    public void setAnteriror(NodoK anteriror) {
        this.anteriror = anteriror;
    }

    public NodoB getIzquierdaAbajo() {
        return izquierdaAbajo;
    }

    public void setIzquierdaAbajo(NodoB izquierdaAbajo) {
        this.izquierdaAbajo = izquierdaAbajo;
    }

    public NodoB getDerechaAbajo() {
        return derechaAbajo;
    }

    public void setDerechaAbajo(NodoB derechaAbajo) {
        this.derechaAbajo = derechaAbajo;
    }
    

    
}
