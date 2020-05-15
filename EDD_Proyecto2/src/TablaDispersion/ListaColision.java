package TablaDispersion;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class ListaColision {

    //elementos
    Nodo primero;
    Nodo ultimo;

    //constructor
    public ListaColision() {
        this.primero = null;
        this.ultimo = null;
    }

    //*desencriptacion de la contrasenia
    public String deencode(String secretKey, String passwordEncriptado) {
        String paswordDesencriptado = "";
        try {
            byte[] message = Base64.decodeBase64(passwordEncriptado.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-80"));
            byte[] BytesKey = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            paswordDesencriptado = new String(plainText, "UTF-8");
        } catch (Exception e) {
        }
        return paswordDesencriptado;
    }

    //estado de la lista
    public boolean estadoLista() {
        if (primero == null && ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    //agregar de ultimo en la lista de las coliciones
    //uso el metodo para agrega de ultimo en la lista
    public void agregarElemento(int carnet, String nombre, String apellido,
            String carrera, String password) {
        Nodo nuevoNodo = new Nodo(carnet, nombre, apellido, carrera, password);
        if (estadoLista() == true) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
    }

    //metod para que me devuelva la existencia del usuario si fuese positiva
    public boolean buscarUsuario(int carnet, String password) {
        Nodo auxPrimero = this.primero;
        while (auxPrimero != null && auxPrimero.getNumeroCarnet() != carnet) {
            auxPrimero = auxPrimero.getSiguiente();
        }

        //*********rebiso que los paremetro coincidan
        if (auxPrimero == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            //**********usuario encontrado
            //*******comparo la contrasenia
            //String passwordDesencriptado = deencode(""+carnet, auxPrimero.getPassword());
            if (auxPrimero.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO: " + auxPrimero.getNombre());
                return true;
                //JOptionPane.showMessageDialog(null, "Password no coincide","",JOptionPane.WARNING_MESSAGE);
            } else {
                //*****dejo entrar al usuario
                JOptionPane.showMessageDialog(null, "PASSWORD NO COINCIDEN", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
    }

    //buscar y obtener la info
    //********para la ediccion de la informaicon dentro de la app
    public Nodo buscarObtener(int carnet) {

        //*********** para la busqueda verifico primero si exite 
        //**********  algun elemento ya en la lista
        if (estadoLista() != true) {
            //busco la existencia del nodo dentro de la lista

            //para empezar a recorrer desde la primera posicion a buscar el usuario
            Nodo auxPrimero = this.primero;

            while (auxPrimero != null && auxPrimero.getNumeroCarnet() != carnet) {
                auxPrimero = auxPrimero.getSiguiente();
            }

            //*********rebiso que los paremetro coincidan
            if (auxPrimero == null) {
                JOptionPane.showMessageDialog(null, "Error al editar datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                return null;

            } else {
                return auxPrimero;

            }

        } else {
            return null;
            
        }//fin

    }//fin

    
    //*************metodo get y set
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

}
