import java.util.*;  
public class Act4Contenedor<F,S>{  
    private ArrayList<Par<F,S>> pares;  

    public Contenedor(){  
        pares=new ArrayList<>();  
    }  
    public void agregarPar(F primero, S segundo){  
        pares.add(new Par<>(primero,segundo));  
    }  
    public Par<F,S> obtenerPar(int indice){  
        return pares.get(indice);  
    }  
    public ArrayList<Par<F,S>> obtenerTodosLosPares(){  
        return pares;  
    }  
    public void mostrarPares(){  
        for(Par<F,S> p:pares){  
            System.out.println(p);  
        }  
    }    public static void main(String[] args){  
        Contenedor<String,Integer> c=new Contenedor<>();  
        c.agregarPar("ichi",1);  
        c.agregarPar("nii",2);  
        c.agregarPar("san",3);  
        c.mostrarPares();  
    }  
}  
