import java.util.*;

class LimiteCreditoExcedidoException extends Exception {
    LimiteCreditoExcedidoException(String msg){
        super(msg);
    }
}

class CuentaBancaria {
    int numeroCuenta;
    String titular;
    double saldo;

    CuentaBancaria(int numeroCuenta, String titular, double saldo){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(double monto){
        if(monto < 0) throw new IllegalArgumentException("Monto inválido");
        saldo += monto;
    }

    void retirar(double monto) throws Exception {
        if(monto < 0) throw new IllegalArgumentException("Monto inválido");
        if(monto > saldo) throw new Exception("Saldo insuficiente");
        saldo -= monto;
    }

    void transferir(CuentaBancaria destino, double monto) throws Exception {
        if(destino == null) throw new Exception("Cuenta destino no válida");
        if(monto > saldo) throw new Exception("Saldo insuficiente");
        saldo -= monto;
        destino.saldo += monto;
    }
}

class CuentaCredito extends CuentaBancaria {
    double limiteCredito;

    CuentaCredito(int numeroCuenta, String titular, double saldo, double limiteCredito){
        super(numeroCuenta, titular, saldo);
        this.limiteCredito = limiteCredito;
    }

    @Override
    void retirar(double monto) throws LimiteCreditoExcedidoException {
        if(monto < 0) throw new IllegalArgumentException("Monto inválido");
        if(monto > saldo + limiteCredito) throw new LimiteCreditoExcedidoException("Límite de crédito excedido");
        saldo -= monto;
    }

    @Override
    void transferir(CuentaBancaria destino, double monto) throws LimiteCreditoExcedidoException {
        if(destino == null) throw new IllegalArgumentException("Cuenta destino no válida");
        if(monto > saldo + limiteCredito) throw new LimiteCreditoExcedidoException("Límite de crédito excedido");
        saldo -= monto;
        destino.saldo += monto;
    }
}

public class BancoCredito {
    public static void main(String[] args) {
        CuentaCredito cuenta = new CuentaCredito(101, "Juan Perez", 500, 200);

        try {
            cuenta.retirar(600);
            System.out.println("Retiro exitoso, saldo actual: " + cuenta.saldo);

            cuenta.retirar(200);
        } catch(LimiteCreditoExcedidoException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
