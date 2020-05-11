package ArbolB2;

public class NodoInformacion {

    //inforamcion del nodo 
    int ISBN;
    String titulo, autor, editorial, anio, edicion, categoria, idioma;
    int carnet;
    boolean estado;

    //contructor
    public NodoInformacion(){
        this.estado=true;
    }
    
    public void asignarInforamcion(int ISBN,String titulo, String autor, String editorial, 
            String anio, String edicion, String categoria, String idioma,int carnet){
        this.ISBN=ISBN;
        this.titulo=titulo;
        this.autor=autor;
        this.editorial=editorial;
        this.anio=anio;
        this.edicion=edicion;
        this.categoria=categoria;
        this.idioma=idioma;
        this.carnet=carnet;
        this.estado=true;
    }

    //************************************
    //metodo get y set
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
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
