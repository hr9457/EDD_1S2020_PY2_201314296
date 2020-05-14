
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
        Principal ventanaArranque = new Principal(tablaDispersion,arbolCategorias);
        
        
        //IngresoCategoria ventanaCategorias = new IngresoCategoria(arbolCategorias);
        //IngresoLibros v = new IngresoLibros();
        
        
        
    }//fin del main
    
}//fin de la clase principal
