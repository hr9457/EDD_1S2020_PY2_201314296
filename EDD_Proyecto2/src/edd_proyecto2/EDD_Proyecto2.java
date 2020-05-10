
package edd_proyecto2;
import TablaDispersion.Lista;
import java.util.Scanner;
//import ArbolB.*;
import ArbolAVL.*;

public class EDD_Proyecto2 {

    
    public static void main(String[] args) {
        
        //estructuras
        Lista tablaDispersion = new Lista();//usuarios tabla hash
        ArbolAVL arbolCategorias = new ArbolAVL();//para categorias arbolAVL
       
        //VENTANAS
        //IngresoLibros ventanaIngresoLibros = new IngresoLibros();
        //Principal ventanaArranque = new Principal(tablaDispersion);
        IngresoCategoria ventanaCategorias = new IngresoCategoria(arbolCategorias);
        
        
        
        
    }//fin del main
    
}//fin de la clase principal
