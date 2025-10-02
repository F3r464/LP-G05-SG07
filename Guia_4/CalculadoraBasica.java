import java.util.*;  
class DivisionPorCeroException extends Exception{  
    DivisionPorCeroException(String msg){  
        super(msg);  
    }  
}  
class Calculadora{  
    double sumar(double a,double b){  
        return a+b;  
    }  
    double restar(double a,double b){  
        return a-b;  
    }  
    double multiplicar(double a,double b){  
        return a*b;  
    }  
    double dividir(double a,double b)throws DivisionPorCeroException{  
        if(b==0){  
            throw new DivisionPorCeroException("no se puede dividir entre cero");  
        }  
        return a/b;  
    }  
}  
public class CalculadoraBasica{  
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Calculadora calc=new Calculadora();
        System.out.println("ingrese primer numero: ");
        double n1=sc.nextDouble();
        System.out.println("ingrese segundo numero: ");
        double n2=sc.nextDouble();  
        try{  
            System.out.println("suma: "+calc.sumar(n1,n2));  
            System.out.println("resta: "+calc.restar(n1,n2));  
            System.out.println("multiplicacion: "+calc.multiplicar(n1,n2));  
            System.out.println("division: "+calc.dividir(n1,n2));  
        }catch(DivisionPorCeroException e){  
            System.out.println("error: "+e.getMessage());  
        }catch(IllegalArgumentException e){  
            System.out.println("error argumento: "+e.getMessage());  
        }catch(ArithmeticException e){  
            System.out.println("error aritmetico: "+e.getMessage());  
        }  
        sc.close();
    }
}