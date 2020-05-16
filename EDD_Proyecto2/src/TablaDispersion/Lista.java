package TablaDispersion;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

//*******importaciones para el uso del MD5
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class Lista {

    //archiov dot
    PrintWriter archivo;

    //elementos de una lista
    NodoHash primero;
    NodoHash ultimo;
    int tamanioTabla;
    int size;

    //constructor
    public Lista() {
        this.primero = null;
        this.ultimo = null;
        this.tamanioTabla = 45;
        this.size = 0;
    }

    //funcion de dispersion saber la posicion en el se va agregar en la tabla
    public int funcionDispersion(int carne) {
        return carne % this.tamanioTabla;//funcion= carnet mod size
    }

    //revision de nuestr lista contien algun elemento o no
    public boolean estadoLista() {
        return (primero == null && ultimo == null) ? true : false;
    }

    //meteodo para el uso del MD5
    public String encode(String secretkey, String password) {
        String passwordEncriptado = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretkey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = password.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            passwordEncriptado = new String(base64Bytes);
        } catch (Exception e) {
        }
        return passwordEncriptado;
    }

    //*desencriptacion de la contrasenia
    public String deencode(String secretKey, String passwordEncriptado) {
        String paswordDesencriptado = "";
        try {
            byte[] message = Base64.decodeBase64(passwordEncriptado.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
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
    //*********************************

    //metodo para insertar en la lista
    public void insertar(int carne, String nombre, String apellido, String carrera, String password) {
        int posicionDeNodo = funcionDispersion(carne);//obtengo la posicion que le corresponde en la lista
        //*********encriptando contrasenia
        password = encode("" + carne, password);//recibe una llave y la contrasenia
        //JOptionPane.showMessageDialog(null, "password"+password);

        //JOptionPane.showMessageDialog(null, "pas: "+password);
        NodoHash nuevoNodo = new NodoHash(posicionDeNodo);//creo el nuevo nodo en la lista dispersion

        if (estadoLista() == true) {//si en la lista no existe ningun elemento            
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
            //insertar en la lista de colision
            nuevoNodo.agregarUsuario(carne, nombre, apellido, carrera, password);

        } else {//la lista ya contien mas de un elemento
            NodoHash auxPrimero = primero;

            while (auxPrimero.getAbajo() != null && auxPrimero.getAbajo().getPosicion() <= posicionDeNodo) {
                auxPrimero = auxPrimero.getAbajo();//paso al siguiente si no cumple
            }
            //while me deja un nodo atras
            //el while hace que nos quedemos un nodo atras un nodo arriba de 
            //si se va insertar en la primera posicion
            if (posicionDeNodo == auxPrimero.getPosicion()) {
                System.out.println("colision");
                JOptionPane.showMessageDialog(null, "Colision en Posicion: " + nuevoNodo.getPosicion());
                //insertar en la lista de colision
                auxPrimero.agregarUsuario(carne, nombre, apellido, carrera, password);

            } else if (posicionDeNodo == ultimo.getPosicion()) {
                ultimo.setAbajo(nuevoNodo);
                ultimo = nuevoNodo;
                //insertar en la lista de colision
                nuevoNodo.agregarUsuario(carne, nombre, apellido, carrera, password);

            } else {
                NodoHash auxAbajo = auxPrimero.getAbajo();
                auxPrimero.setAbajo(nuevoNodo);
                nuevoNodo.setAbajo(auxAbajo);
                //insertar en la lista de colision
                nuevoNodo.agregarUsuario(carne, nombre, apellido, carrera, password);
            }
        }
    }

    //metod para buscar usuario dentro de la lista
    public boolean buscarUsuario(int carnet, String password) {
        boolean resultado;
        //**********saber que posicion esta el nodo del auxiliar
        int posicionBuscar = funcionDispersion(carnet);
        //***********encripoto passwor para la comparacion
        password = encode("" + carnet, password);

        //JOptionPane.showMessageDialog(null, "pas: "+password);
        //********auxiliar del primer nodo
        NodoHash auxPrimero = this.primero;
        while (auxPrimero != null && auxPrimero.getPosicion() != posicionBuscar) {
            auxPrimero = auxPrimero.getAbajo();
        }

        if (auxPrimero != null) {
            //JOptionPane.showMessageDialog(null, "usuario econtrado");
            resultado = auxPrimero.buscarUsuarioEnLista(carnet, password);
            return resultado;
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            resultado = false;
            return resultado;
        }
    }

    //*************************buscar datos para la ediccion
    public Nodo retornarDatos(int carnet) {
        //**********saber que posicion esta el nodo del auxiliar
        int posicionBuscar = funcionDispersion(carnet);

        //********auxiliar del primer nodo
        NodoHash auxPrimero = this.primero;
        while (auxPrimero != null && auxPrimero.getPosicion() != posicionBuscar) {
            auxPrimero = auxPrimero.getAbajo();
        }

        if (auxPrimero != null) {
            //JOptionPane.showMessageDialog(null, "usuario econtrado");
            //auxPrimero.buscarUsuarioEnLista(carnet, password);
            Nodo datos = auxPrimero.buscarDatos(carnet);
            return datos;

        } else {
            JOptionPane.showMessageDialog(null, "Erro en la busqueda del usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    ///eliminacion de un usuario de la tabla has
    public void buscarEliminar(int carnet) {
        //**********saber que posicion esta el nodo del auxiliar
        int posicionBuscar = funcionDispersion(carnet);

        //********auxiliar del primer nodo
        NodoHash auxPrimero = this.primero;
        while (auxPrimero != null && auxPrimero.getPosicion() != posicionBuscar) {
            auxPrimero = auxPrimero.getAbajo();
        }

        if (auxPrimero != null) {
            //JOptionPane.showMessageDialog(null, "usuario econtrado");
            //auxPrimero.buscarUsuarioEnLista(carnet, password);
            auxPrimero.eliminarDato(carnet);

        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    //metodo para genera la imagen png
    public void generarPNG() {
        try {
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("dot.exe -Tpng ArchivosDot\\Hash.dot -o Reportes\\Hash.png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se genero la imagen del reporte");
        }
    }

    //metodo para abrir la imgen del archvio dot
    public void abrirPNG() {
        try {
            String archivo = "Reportes\\Hash.png";
            Runtime ejecuccion = Runtime.getRuntime();
            ejecuccion.exec("cmd /c start " + archivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede arbir la imagen");
        }
    }

    //metodo para recorre todo la tabla de dispersion
    public void recorreTabla(PrintWriter archivo) {
        NodoHash auxPrimero = this.primero;
        if (auxPrimero != null) {
            int contadorFunciones = 0;
            int contadorLista = 1;//el siguiente la nodo0
            archivo.print("nodo0 [label = \" ");
            while (auxPrimero.getAbajo() != null) {
                archivo.print(" <f" + contadorFunciones + ">" + auxPrimero.getPosicion() + "|");//creo una funcion en el nodos
                auxPrimero = auxPrimero.getAbajo();
                contadorFunciones++;//aumento en uno
            }
            archivo.print(" <f" + contadorFunciones + ">" + auxPrimero.getPosicion());
            archivo.print(" \" , height=2.5];");//alto de separcion del nodo 0

            archivo.println("");
            //regreso hasta arriba de la tabla
            auxPrimero = this.primero;
            //********obtengo el primer los varloes de la lista del primer nodo hash
            TablaDispersion.Nodo auxPrimeroLista;
            //*********primer while sirve para ver la lista hash hacia abajo
            while (auxPrimero != null) {
                auxPrimeroLista = auxPrimero.getLista().getPrimero();
                //******segundo while rebisa la lista dentro del nodo hash
                archivo.print("nodo" + contadorLista + "[label = \" {");
                while (auxPrimeroLista != null) {
                    archivo.print("" + auxPrimeroLista.getNumeroCarnet() + "--" + auxPrimeroLista.getNombre() + "\\n" + auxPrimeroLista.getPassword() + "|");
                    auxPrimeroLista = auxPrimeroLista.getSiguiente();
                }
                contadorLista++;//aumento en uno
                archivo.print("}\"];");//cierre del label
                archivo.println("");
                //*****paso el siguiente nodo de abajo de la tabla hash
                auxPrimero = auxPrimero.getAbajo();
            }

            archivo.println("");
            //**********anidacion de los nodos
            //reinicio el contador de funciones
            for (int i = 0; i < contadorLista - 1; i++) {
                archivo.println("nodo0:f" + i + "->nodo" + (i + 1));
            }
        }

    }

    //metodo para graficar la tabla hash
    public void reporteHash() {

        try {
            archivo = new PrintWriter("ArchivosDot\\Hash.dot");
            archivo.println("digraph TablaHas{");
            archivo.println("nodesep=0.08;");
            archivo.println("rankdir=LR;");
            archivo.println("node [shape=record,width=0.1,height=0.1];");
            recorreTabla(archivo);
            archivo.print("");
            archivo.println("label = \" Tabla Hash \"; ");
            archivo.println("}");
            archivo.close();//cierre del archivo
            generarPNG();//genero la imagen
            //abrirPNG();//abro la imagen
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se genero el reporte");
        }
    }

    //metodo para buscar dentro de la lista
    //busqueda cuadratica
    //-------------------------------------------------------------------------------
    //metodo get y set
    public NodoHash getPrimero() {
        return primero;
    }

    public void setPrimero(NodoHash primero) {
        this.primero = primero;
    }

    public NodoHash getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoHash ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanioTabla() {
        return tamanioTabla;
    }

    public void setTamanioTabla(int tamanioTabla) {
        this.tamanioTabla = tamanioTabla;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
