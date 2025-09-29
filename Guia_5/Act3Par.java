class Persona{  
    String nombre;  
    Persona(String nombre){  
        this.nombre=nombre;  
    }  
    public String toString(){  
        return nombre;  
    }  
}  
public class Act3Par{  
    public static <F,S> void imprimirPar(Par<F,S> par){  
        System.out.println(par);  
    }  

    public static void main(String[] args){  
        Par<String,Integer> p1=new Par<>("edad",20);  
        Par<Double,Boolean> p2=new Par<>(9.11,true);  
        Par<Persona,Integer> p3=new Par<>(new Persona("Carbajal"),30);  

        imprimirPar(p1);  
        imprimirPar(p2);  
        imprimirPar(p3);  
    }  
}  
