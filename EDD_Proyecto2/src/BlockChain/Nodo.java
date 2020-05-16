package BlockChain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
 * @author joshu
 */
public class Nodo {

    int index;
    Date timesTamp;
    String data;
    int nonce;
    String previousHash;
    String hash;

    //apuntadores
    Nodo siguiente;
    Nodo anterior;

    //contructor
    public Nodo(int index, Date time, String data, int nonce, String prev, String hash) throws NoSuchAlgorithmException {
        this.index = index;
        this.timesTamp = time;
        this.data = data;
        this.nonce = nonce;
        this.previousHash = prev;
        this.hash = hash;
        this.siguiente = null;
        this.anterior = null;
        calcularSha256();
    }

    //***************************calcular hash
    private void calcularSha256() throws NoSuchAlgorithmException {
        String Calculohash = ""+this.index+""+this.timesTamp+""+this.previousHash+""+this.data+""+this.nonce;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(Calculohash.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        Calculohash = sb.toString();
        this.hash = Calculohash;
    }
    
    public void recalcularHash() throws NoSuchAlgorithmException{
        boolean estado = true;
        String cadena="";
        while(estado!=false){
            cadena = this.hash.substring(0,4);
            if(cadena.equals("0000")){
                estado = false;
            } else {
                this.nonce = nonce + 1;
                calcularSha256();
            }
        }
    }

    //*************get y set
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Date timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}
