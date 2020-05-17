package RED;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Lista {
    
   PrintWriter archivo; 

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
    public void insertaNodoRed(String ip, int puerto) {
        Nodo nuevaConexion = new Nodo(ip, puerto);
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

    //******************************************
    public void generarReporteRed() {

    }

    public void recorrerRed(PrintWriter archivo){
        int contador=0;
        Nodo auxPrimero = this.primero;
        while(auxPrimero!=null){
            archivo.println("nodo"+contador+"[label=\" IP: "+auxPrimero.getIp()
                    +"\nPUERTO: "+auxPrimero.getPuerto()+"\"];");
            contador++;
        }
        archivo.println("");
        //********
        for(int i=0;i<contador-1;i++){
            archivo.print("nodo"+i+"->nodo"+(i+1));
        }
        archivo.print(";");
        
    }
    
    public void reporteRed() {
        try {
            archivo = new PrintWriter("ArchivosDot\\RED.dot");
            archivo.println("digraph RED{");
            archivo.println("rankdir=LR;");
            archivo.println("node [shape=record];");
            recorrerRed(archivo);
            archivo.print("");
            archivo.println("label = \" Nodos en Red \"; ");
            archivo.println("}");
            archivo.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se genero el reporte");
        }
    }

}
