package RED;

public class Lista {

    //punteros
    Nodo primero;
    Nodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    private boolean estadoLista() {
        if (primero == null && ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    //metedo para insertar nodo en la red
    public void insertaNodoRed(String ip) {
        Nodo nuevaConexion = new Nodo(ip);
        if (estadoLista() == true) {
            this.primero = nuevaConexion;
            this.ultimo = nuevaConexion;
        } else {
            this.ultimo.setSiguiente(nuevaConexion);
            nuevaConexion.setAnterior(ultimo);
            this.ultimo = nuevaConexion;
        }
    }

    //metodo para eliminar un nodo de la red
    public void eliminarNodoRed(String ip) {
        Nodo auxPrimero = this.primero;
        while (auxPrimero != null) {
            if (auxPrimero.getIp().equals(ip)) {
                if (auxPrimero == this.primero) {

                } else if (auxPrimero == this.ultimo) {

                } else {

                }
                break;
            }
            auxPrimero = auxPrimero.getSiguiente();
        }
    }

}
