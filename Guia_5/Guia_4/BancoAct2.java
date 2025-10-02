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
class CuentaNoEncontradaException extends Exception{  
    CuentaNoEncontradaException(String msg){  
        super(msg);  
    }  
}
class SaldoNoCeroException extends Exception{  
    SaldoNoCeroException(String msg){  
        super(msg);  
    }  
}
class CuentaBancaria{
    int numeroCuenta;
    String titular;
    double saldo;
    boolean activa;
    CuentaBancaria(int numeroCuenta,String titular,double saldo){
        this.numeroCuenta=numeroCuenta;
        this.titular=titular;
        this.saldo=saldo;
        this.activa=true;
    }
    void depositar(double monto){
        if(monto<0){
            throw new IllegalArgumentException("monto invalido");
        }
        saldo+=monto;
    }
    void retirar(double monto)throws SaldoInsuficienteException{  
        if(monto<0){  
            throw new IllegalArgumentException("monto invalido");  
        }  
        if(monto>saldo){
            throw new SaldoInsuficienteException("saldo insuficiente");  
        }  
        saldo-=monto;  
    } 

    void transferir(CuentaBancaria destino,double monto)throws CuentaNoEncontradaException,SaldoInsuficienteException{  
        if(destino==null||!destino.activa){
            throw new CuentaNoEncontradaException("cuenta destino no existe");  
        }  
        if(monto>saldo){  
            throw new SaldoInsuficienteException("saldo insuficiente para transferir");  
        }  
        saldo-=monto;  
        destino.saldo+=monto;  
    }
    void cerrarCuenta()throws SaldoNoCeroException{  
        if(saldo!=0){  
            throw new SaldoNoCeroException("no se puede cerrar, saldo no es cero");  
        }  
        activa=false;  
        System.out.println("cuenta cerrada con exito");  
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
        System.out.println("\n ingrese numero de cuenta destino: ");  
        int n2=sc.nextInt();
        sc.nextLine();
        System.out.println("titular destino: ");
        String ti2=sc.nextLine();
        CuentaBancaria b2=new CuentaBancaria(n2,ti2,0);  
        System.out.println("cuenta destino creada");  
        System.out.println("\n ingrese monto a depositar: ");
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
        System.out.println("\n ingrese monto a transferir a la segunda cuenta: ");
        double trans=sc.nextDouble();
        try{  
            b1.transferir(b2,trans);  
            System.out.println(" transferencia realizada a "+b2.titular+" por "+trans);  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }
        try{  
            b1.cerrarCuenta();  
        }catch(SaldoNoCeroException e){  
            System.out.println("error al cerrar cuenta: "+e.getMessage());  
        }
        sc.close();
    }
}
