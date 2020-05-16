
package BlockChain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;


public class Lista {
    
    //contador de bloques
    int numeroBlock = 0;
    
    Nodo primero;
    Nodo ultimo;
    
    public Lista(){
        this.primero=null;
        this.ultimo=null;
    }
    
    
    private boolean estadoLista(){
        if(this.primero==null && this.ultimo==null){
            return true;
        } else {
            return false;
        }
    }
    
    //****************obtener hor de creacion del blockchain
    public Timestamp obtenerHora(){
        Timestamp fechaHora;
        Date date = new Date();
        long millis = date.getTime();
        Timestamp timestamp = new Timestamp(millis);
        fechaHora = timestamp;
        return fechaHora;
    }
    
    private String calcularSha256(String cadena) throws NoSuchAlgorithmException{
        String hash="";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(cadena.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b:digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        hash = sb.toString();
        return hash;
    }
    
    //**************************************************************************
    public void insertarBloque(String data) throws NoSuchAlgorithmException{
        Timestamp horaCreacion = obtenerHora();        
        if(estadoLista()==true){     
            Nodo nuevoBlock = new Nodo(numeroBlock, horaCreacion, data, 0, "0000", "");
            //String hash = calcularSha256(nuevoBlock.getData());
            //nuevoBlock.setHash(hash);
            this.primero = nuevoBlock;
            this.ultimo = nuevoBlock;
            numeroBlock ++;
        } else {
            Nodo nuevoBlock = new Nodo(numeroBlock, horaCreacion, data, 0, "", "");
            //String hash = calcularSha256(nuevoBlock.getData());
            //nuevoBlock.setHash(hash);
            nuevoBlock.recalcularHash();
            
            String prevHash = this.ultimo.getHash();
            nuevoBlock.setPreviousHash(prevHash);
            //union de bloques
            nuevoBlock.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(nuevoBlock);
            this.ultimo = nuevoBlock;
        }
    }
    
    
    public void generarImagenBlock(){
        
    }
    
    public void reporteBloque(){
        
    }

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

    public int getNumeroBlock() {
        return numeroBlock;
    }

    public void setNumeroBlock(int numeroBlock) {
        this.numeroBlock = numeroBlock;
    }
    
    
    
}
