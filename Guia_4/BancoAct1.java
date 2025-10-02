import java.util.*;
class IlegalArgumentException extends Exception{  
    IlegalArgumentException(String msg){  
        super(msg);  
    }  
}
class SaldoInsuficienteException extends Exception{  
    SaldoInsuficienteException(String msg){  
        super(msg);  
    }  
}
class CuentaBancaria{  
    int numeroCuenta;  
    String titular;  
    double saldo;    
    CuentaBancaria(int numeroCuenta,String titular,double saldo){  
        this.numeroCuenta=numeroCuenta;  
        this.titular=titular;  
        this.saldo=saldo;
    }
    void depositar(double monto){  
        if(monto<0){
            throw new IllegalArgumentException("monto invalido");
        }    
    }
    void retirar(double monto)throws SaldoInsuficienteException{  
        if(monto<0){
            throw new IllegalArgumentException("monto invalido");
        }  
        if(monto>saldo){  
            throw new SaldoInsuficienteException("saldo insuficiente");  
        }
    } 
}
public class BancoAct1{    
    public static void main(String[]args){ 
    Scanner sc=new Scanner(System.in);
    System.out.println("numero de cuenta: ");  
    int n=sc.nextInt();  
    sc.nextLine();  
    System.out.println("titular: ");  
    String ti=sc.nextLine();  
    System.out.println("saldo: ");  
    double sal=sc.nextDouble();  
    CuentaBancaria b1=new CuentaBancaria(n,ti,sal);  
    System.out.println("cuenta creada");  
    System.out.println("\n\ningrese monto a depositar: ");
    double dep=sc.nextDouble();
    b1.depositar(dep);
    System.out.println(" se deposito "+dep+"\n");
    System.out.println("\n ingrese monto a retirar");
    double ret=sc.nextDouble();
    try{  
            b1.retirar(ret);  
            System.out.println(" se retiro "+ret+"\n");  
        }catch(SaldoInsuficienteException e){  
            System.out.println("error: "+e.getMessage());  
        }
    }
}
