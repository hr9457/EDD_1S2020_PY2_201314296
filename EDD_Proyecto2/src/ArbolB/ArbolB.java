
package ArbolB;


public class ArbolB {
    
    //elementos
    NodoB root;//raiz principal
    
    //constructor
    public ArbolB(){
        this.root=null;
    }
    
    
    //estado del arbol
    public boolean estadoArbol(){
        if(root==null){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
