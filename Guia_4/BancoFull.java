import java.util.*;  
import java.io.*;  
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
class HistorialVacioException extends Exception{  
    HistorialVacioException(String msg){  
        super(msg);  
    }  
}  
class Cuenta{  
    int numero;  
    String cliente;  
    double saldo;  
    double limiteCredito;  
    ArrayList<String> historial;  
    boolean cerrada;  
    Cuenta(int n,String c,double lim){  
        numero=n;  
        cliente=c;  
        saldo=0;  
        limiteCredito=lim;  
        historial=new ArrayList<>();  
        cerrada=false;  
    }  
    void depositar(double monto){  
        if(monto<=0) throw new IllegalArgumentException("monto invalido");  
        saldo+=monto;  
        historial.add("Deposito: "+monto);  
    }  
    void retirar(double monto)throws SaldoInsuficienteException{  
        if(monto<=0) throw new IllegalArgumentException("monto invalido");  
        if(saldo+monto>saldo+limiteCredito){  
            throw new SaldoInsuficienteException("saldo insuficiente");  
        }  
        saldo-=monto;  
        historial.add("Retiro: "+monto);  
    }  

    void transferir(Cuenta destino,double monto)throws SaldoInsuficienteException{  
        retirar(monto);  
        destino.depositar(monto);  
        historial.add("Transferencia a "+destino.numero+" por "+monto);  
    }  

    double consultarSaldo(){  
        return saldo;  
    }  

    void cerrar()throws SaldoNoCeroException{  
        if(saldo!=0){  
            throw new SaldoNoCeroException("saldo no es cero");  
        }  
        cerrada=true;  
        historial.add("Cuenta cerrada");  
    }  

    void mostrarHistorial()throws HistorialVacioException{  
        if(historial.isEmpty()){  
            throw new HistorialVacioException("no hay transacciones");  
        }  
        for(String h:historial){  
            System.out.println(h);  
        }  
    }  
}  

public class BancoFull{  
    static ArrayList<Cuenta> cuentas=new ArrayList<>();  
    static Scanner sc=new Scanner(System.in);  

    public static void main(String[]args){  
        boolean salir=false;  
        while(!salir){  
            System.out.println("1 crear cuenta");  
            System.out.println("2 deposito");  
            System.out.println("3 retiro");  
            System.out.println("4 transferencia");  
            System.out.println("5 consultar saldo");  
            System.out.println("6 cerrar cuenta");  
            System.out.println("7 mostrar historial");  
            System.out.println("8 salir");  
            int op=sc.nextInt();  
            switch(op){  
                case 1:crearCuenta();break;  
                case 2:depositar();break;  
                case 3:retirar();break;  
                case 4:transferir();break;  
                case 5:consultar();break;  
                case 6:cerrar();break;  
                case 7:historial();break;  
                case 8:salir=true;break;  
                default:System.out.println("opcion invalida");  
            }  
        }  
    }  

    static Cuenta buscar(int num)throws CuentaNoEncontradaException{  
        for(Cuenta c:cuentas){  
            if(c.numero==num) return c;  
        }  
        throw new CuentaNoEncontradaException("cuenta no encontrada");  
    }  

    static void crearCuenta(){  
        System.out.println("numero: ");  
        int n=sc.nextInt();  
        sc.nextLine();  
        System.out.println("cliente: ");  
        String cli=sc.nextLine();  
        System.out.println("limite credito: ");  
        double lim=sc.nextDouble();  
        cuentas.add(new Cuenta(n,cli,lim));  
        System.out.println("cuenta creada");  
    }  

    static void depositar(){  
        try{  
            System.out.println("numero: ");  
            int n=sc.nextInt();  
            Cuenta c=buscar(n);  
            System.out.println("monto: ");  
            double m=sc.nextDouble();  
            c.depositar(m);  
            System.out.println("deposito hecho");  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  

    static void retirar(){  
        try{  
            System.out.println("numero: ");  
            int n=sc.nextInt();  
            Cuenta c=buscar(n);  
            System.out.println("monto: ");  
            double m=sc.nextDouble();  
            c.retirar(m);  
            System.out.println("retiro hecho");  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  

    static void transferir(){  
        try{  
            System.out.println("origen: ");  
            int o=sc.nextInt();  
            Cuenta co=buscar(o);  
            System.out.println("destino: ");  
            int d=sc.nextInt();  
            Cuenta cd=buscar(d);  
            System.out.println("monto: ");  
            double m=sc.nextDouble();  
            co.transferir(cd,m);  
            System.out.println("transferencia hecha");  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  

    static void consultar(){  
        try{  
            System.out.println("numero: ");  
            int n=sc.nextInt();  
            Cuenta c=buscar(n);  
            System.out.println("saldo: "+c.consultarSaldo());  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  

    static void cerrar(){  
        try{  
            System.out.println("numero: ");  
            int n=sc.nextInt();  
            Cuenta c=buscar(n);  
            c.cerrar();  
            System.out.println("cuenta cerrada");  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  

    static void historial(){  
        try{  
            System.out.println("numero: ");  
            int n=sc.nextInt();  
            Cuenta c=buscar(n);  
            c.mostrarHistorial();  
        }catch(Exception e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  
}  
