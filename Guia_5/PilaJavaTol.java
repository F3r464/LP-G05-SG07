class ExcepcionPilaLlena extends RuntimeException{
    public ExcepcionPilaLlena(){
        this("la pila esta llena");
    }
    public ExcepcionPilaLlena(String excepcion){
        super(excepcion);
    }
}

class ExcepcionPilaVacia extends RuntimeException{
    public ExcepcionPilaVacia(){
        this("la pila esta vacia");
    }
    public ExcepcionPilaVacia(String excepcion){
        super(excepcion);
    }
}

class Pila<E>{
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila(){
        this(5); 
    }

    public Pila(int s){
        tamanio=s>0?s:5;
        superior=-1;
        elementos=(E[]) new Object[tamanio];
    }

    public void push(E valor){
        if(superior==tamanio-1){
            throw new ExcepcionPilaLlena("la pila esta llena, no se puede meter "+valor);
        }
        elementos[++superior]=valor;
    }

    public E pop(){
        if(superior==-1){
            throw new ExcepcionPilaVacia("la pila esta vacia, no se puede sacar");
        }
        return elementos[superior--];
    }
     public void mostrarPila(){  
        if(superior==-1){  
            System.out.println("pila vacia");  
        }else{  
            for(int i=0;i<=superior;i++){  
                System.out.print(elementos[i]+" ");  
            }  
            System.out.println();  
        }  
    }
    public boolean esIgual(Pila<E> otraPila){  
        if(this.superior!=otraPila.superior){  
            return false;  
        }  
        for(int i=0;i<=superior;i++){  
            if(!this.elementos[i].equals(otraPila.elementos[i])){  
                return false;  
            }  
        }  
        return true;  
    }  
}  


public class PilaJavaTol{
    public static void main(String[] args){
        Pila<Integer> pila=new Pila<>(3);
        Pila<Integer> pila1=new Pila<>(3);

        try{
            System.out.println("metiendo elementos...");
            pila.push(1);
            pila.push(2);
            pila.push(3);
            pila.push(4);
        }catch(ExcepcionPilaLlena e){
            System.out.println("error: "+e.getMessage());
        }
        pila.mostrarPila();
        
        try{
            System.out.println("sacando elementos...");
            System.out.println(pila.pop());
            System.out.println(pila.pop());
            System.out.println(pila.pop());
            System.out.println(pila.pop());
        }catch(ExcepcionPilaVacia e){
            System.out.println("error: "+e.getMessage());
        }
    }