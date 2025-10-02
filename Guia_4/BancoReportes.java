import java.io.*;
import java.util.*;

class HistorialVacioException extends Exception {
    HistorialVacioException(String msg){
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
}

class ReporteTransacciones {

    static void generarReporte(CuentaBancaria cuenta, String archivo) throws IOException, HistorialVacioException {
        if(cuenta.saldo == 0) throw new HistorialVacioException("La cuenta no tiene transacciones");
        try(PrintWriter pw = new PrintWriter(new FileWriter(archivo))){
            pw.println("Cuenta: " + cuenta.numeroCuenta);
            pw.println("Titular: " + cuenta.titular);
            pw.println("Saldo: " + cuenta.saldo);
        }
    }

    static void leerReporte(String archivo) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(archivo))){
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
    }
}

public class BancoReportes {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(10100110, "Roy Quispe", 500);

        try {
            ReporteTransacciones.generarReporte(cuenta, "reporte.txt");
            System.out.println("Reporte generado exitosamente");

            ReporteTransacciones.leerReporte("reporte.txt");
        } catch(HistorialVacioException e){
            System.out.println("Error: " + e.getMessage());
        } catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch(IOException e){
            System.out.println("Error de escritura/lectura");
        }
    }
}
