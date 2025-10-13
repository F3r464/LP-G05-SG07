package mvcpq;
import java.io.*;
class Empleado{
    private int numero;
    private String nombre;
    private double sueldo;
    public Empleado(int numero,String nombre,double sueldo){
        this.numero=numero;
        this.nombre=nombre;
        this.sueldo=sueldo;
    }
    public int getNumero(){
        return numero;
    }
    public String getNombre(){
        return nombre;
    }
    public double getSueldo(){
        return sueldo;
    }
    public void setNumero(int n){
        if(n>0)this.numero=n;
    }
    public void setNombre(String nom){
        this.nombre=nom;
    }
    public void setSueldo(double s){
        if(s>0){
            this.sueldo=s;
        }
    }
    public String toString(){
        return numero+","+nombre+","+sueldo;
    }
}
