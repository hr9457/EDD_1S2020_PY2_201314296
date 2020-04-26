
package edd_proyecto2;
import TablaDispersion.Lista;
import java.util.Scanner;

public class EDD_Proyecto2 {

    
    public static void main(String[] args) {
        
        //estructuras
        Lista tablaDispersion = new Lista();
        
        
        int op=0;
        Scanner entrada = new Scanner(System.in);
        //Lista tablaDispersion = new Lista();
        
        
        do{
            System.out.println("1. Ingresear usuario");
            System.out.println("2. Imprimir listado");
            System.out.println("3. Salir");
            op=Integer.parseInt(entrada.next());
            System.out.println("");
            
            switch(op){
                 case 1:
                    System.out.print("carne: ");
                    int carnet = entrada.nextInt();
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = entrada.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = entrada.nextLine();
                    System.out.print("pass: ");
                    String pass = entrada.nextLine();
                    int posicioon = tablaDispersion.funcionDispersion(carnet);
                    //tablaDispersion.insertar(posicioon, carnet, nombre, apellido, carrera, pass);
                    System.out.println("");
                    break;
                 
                 case 2:
                    //tablaDispersion.imprimirLista();
                     System.out.println("");
                    break;
                    
                 default:
                     System.out.println("error");
            }
            
        }while(op!=3);
        
        
    }//fin del main
    
}//fin de la clase principal
