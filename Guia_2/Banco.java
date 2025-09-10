import java.util.Scanner;

abstract class Cuenta{
    protected String numeroCuenta;
    protected double saldo;

    public Cuenta(String cuennum, double sald){
        this.numeroCuenta=cuennum;
        this.saldo=sald;
    }
    public void depositar(double monto){
        saldo += monto;
        System.out.println("Depósito realizado. Saldo actual: " + saldo);
    }

    public boolean retirar(double monto){
        if(monto <=saldo){
            saldo-=monto;
            System.out.println("Retiro con exito | saldo: "+saldo);
            return true;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }
    public double getSaldo(){
        return saldo;
    }
    public String getNumeroCuenta(){
        return numeroCuenta;
    }
    public abstract void consultar();
}

class CuentaAhorro extends Cuenta{
    private double tasaInteres;
    private double saldoMinimo;

    public CuentaAhorro(String numcuenta, double saldoini, double tasainte){
        super(numcuenta, saldoini);
        this.tasaInteres =tasainte;
        this.saldoMinimo=saldoini;
    }
    @Override
    public boolean retirar(double monto){
        boolean exito=super.retirar(monto);
        if(exito && saldo < saldoMinimo){
            saldoMinimo = saldo;
        }
        return exito;
    }
    @Override
    public void consultar(){
        double interes=saldoMinimo*tasaInteres;
        depositar(interes);
        System.out.println("Intereses: "+interes);
        saldoMinimo=saldo;
    }
}
class CuentaCorriente extends Cuenta{
    private int retiros;
    private final int retirosGratis = 3;
    private final double costoRetiroExtra = 3;
    public CuentaCorriente(String numcuent, double salinic){
        super(numcuent, salinic);
        this.retiros =0;
    }
    @Override
    public boolean retirar(double monto){
        boolean exito = super.retirar(monto);
        if(exito){
            retiros++;
            if(retiros>retirosGratis){
                saldo -=costoRetiroExtra;
                System.out.println("Se añadio " +costoRetiroExtra+" | Saldo :" + saldo);
            }
        }
        return exito;
    }
    @Override
    public void consultar(){
        retiros = 0;
        System.out.println("Reiniciando.");
        System.out.println("Reiniciando..");
        System.out.println("Reiniciando...");
    }
}

public class Banco{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Cuenta[] cuentas=new Cuenta[10];
        for(int i=0;i<5;i++){
            cuentas[i]=new CuentaAhorro("AHO"+(i+1),1000,0.02);
        }
        for(int i=5;i<10;i++){
            cuentas[i]=new CuentaCorriente("COR"+(i+1),1000);
        }
        char opcion;
        do{
            System.out.println("\n--- MENU BANCO ---");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar");
            System.out.println("S) Salir");
            System.out.print("Digite una opcion: ");
            opcion = sc.next().toUpperCase().charAt(0);

            switch(opcion){
                case 'D':
                    System.out.print("N° Cuenta: ");
                    String numDep=sc.next();
                    Cuenta cuentaDep =buscarCuenta(cuentas,numDep);
                    if(cuentaDep!=null){
                        System.out.print("Deposito: ");
                        double montoDep = sc.nextDouble();
                        cuentaDep.depositar(montoDep);
                    } else {
                        System.out.println("No tienes cuenta");
                        System.out.println("Fuera de aqui (o abre una cuenta 👍)");
                    }
                    break;

                case 'R':
                    System.out.print("Número cuenta: ");
                    String numRet =sc.next();
                    Cuenta cuentaRet=buscarCuenta(cuentas,numRet);
                    if(cuentaRet!=null){
                        System.out.print("Retirar: ");
                        double montoRet = sc.nextDouble();
                        cuentaRet.retirar(montoRet);
                    } else {
                        System.out.println("No hay cuenta!!!!!!!!");
                    }
                    break;

                case 'C':
                    for(Cuenta c: cuentas){
                        c.consultar();
                        System.out.println("Cuenta "+c.getNumeroCuenta()+" saldo: "+c.getSaldo());
                    }
                    break;

                case 'S':
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion falsa ");
            }
        }while(opcion!='S');

        sc.close();
    }
    public static Cuenta buscarCuenta(Cuenta[] cuentas,String numero){
        for(Cuenta c: cuentas){
            if(c.getNumeroCuenta().equals(numero)){
                return c;
            }
        }
        return null;
    }
}
