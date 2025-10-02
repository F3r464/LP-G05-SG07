import java.util.*;  
class IlegalArgumentException extends Exception{  
    IlegalArgumentException(String msg){  
        super(msg);  
    }  
}
class Numero{  
    private double valor;  
    void setValor(double v){  
        if(v < 0){  
            throw new IllegalArgumentException("no se numeros negativos");  
        }  
        this.valor=v;  
    }  
    double getValor(){  
        return valor;  
    }  
}  
public class GestionNegativos{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Numero num=new Numero();
        System.out.println("ingrese un numero: ");  
        double n=sc.nextDouble();  
        try{
            num.setValor(n);
            System.out.println("numero guardado: "+num.getValor());  
        }catch(IllegalArgumentException e){  
            System.out.println("error: "+e.getMessage());  
        }  
        sc.close();  
    }  
}  
