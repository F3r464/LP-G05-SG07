import java.util.*;  
class InvalidSubscriptException extends Exception{  
    InvalidSubscriptException(String msg){  
        super(msg);  
    }  
}  
public class ImprimirArreglo{  
    public static <T> void imprimirArreglo(T[] arregloEntrada){  
        for(T elemento: arregloEntrada){  
            System.out.println(elemento);  
        }  
    }  
    public static <T> void imprimirArreglo(T[] arregloEntrada,int subindiceInferior,int subindiceSuperior)throws InvalidSubscriptException{  
        if(subindiceInferior<0||subindiceSuperior>=arregloEntrada.length||subindiceInferior>subindiceSuperior){  
            throw new InvalidSubscriptException("indices invalidos");  
        }  
        for(int i=subindiceInferior;i<=subindiceSuperior;i++){  
            System.out.println(arregloEntrada[i]);  
        }  
    }  
    public static void main(String args[]){  
        Integer[] arregloInteger={1,2,3,4,5,6};  
        Double[] arregloDouble={1.1,2.2,3.3,4.4,5.5,6.6,7.7};
        Character[] arregloCharacter={'H','O','L','A'};
        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger);  
        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble);
        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter);  
        System.out.println("\nSubarreglo de Integer 1 a 3:");
        try{
            imprimirArreglo(arregloCharacter,1,3);  
        }catch(InvalidSubscriptException e){  
            System.out.println("error: "+e.getMessage());  
        }
        System.out.println("\n");  
        try{  
            imprimirArreglo(arregloDouble,2,10);  
        }catch(InvalidSubscriptException e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  
}