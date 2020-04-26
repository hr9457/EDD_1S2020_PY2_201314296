
package ArbolB;


public class NodoK {
    
    //elementos
    int ISBN;
    String titulo,Autor,Editorial,anio,Ediccion,Categoria,Idioma;
    int carnetUsuario;
    
    //punteros
    NodoK siguiente;
    NodoK atras;
    
    //constructor
    public NodoK(int ISBN,String titulo,String autor,String editorial,
            String anio, String ediccion,String categoria, String idioma){
        this.ISBN=ISBN;
        this.titulo=titulo;
        this.Autor=autor;
        this.Editorial=editorial;
        this.anio=anio;
        this.Ediccion=ediccion;
        this.Categoria=categoria;
        this.Idioma=idioma;
        this.siguiente=null;
        this.atras=null;
    }

    //metodo get y set para los elementos de clase del nodo guardar los libros
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

    public NodoK getAtras() {
        return atras;
    }

    public void setAtras(NodoK atras) {
        this.atras = atras;
    }
    
    
    
}
