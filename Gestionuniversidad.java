import java.util.*;
class Persona{
 String nombre;
 Persona(String n){
 nombre=n;
 }
 void mostrar(){
 System.out.println(nombre);
 }
}
class Estudiante extends Persona{
 Estudiante(String n){
 super(n);
 }
 void mostrar(){
 System.out.println("Estudiante: "+nombre);
 }
}
class Profesor extends Persona{
 Profesor(String n){
 super(n);
 }
 void mostrar(){
 System.out.println("Profesor: "+nombre);
 }
}
class Curso{
 String nombre;
 Profesor profesor;
 int cupo;
 ArrayList<Estudiante> estudiantes=new ArrayList<>();
 Curso(String n,int c){
 nombre=n;cupo=c;
 }
 void asignarProfesor(Profesor p){
 profesor=p;
 }
 void inscribir(Estudiante e){
 if(estudiantes.size()<cupo){
 estudiantes.add(e);
 }
 else System.out.println("Cupo lleno en "+nombre+" para "+e.nombre);
 }
 void mostrar(){
 System.out.println("Curso: "+nombre);
 if(profesor!=null){
profesor.mostrar();
 }
 for(Estudiante e:estudiantes){
 e.mostrar();
 }
 }
}
public class Gestionuniversidad{
 public static void main(String[] args){
 Estudiante e1=new Estudiante("Alanna SOlis");
 Estudiante e2=new Estudiante("Yaretzi Ancajima");
 Profesor p1=new Profesor("Sophia Zuñiga");
 Curso c1=new Curso("Lenguajes de Programacion 3",2);
 Curso c2=new Curso("Investigacion formativa",2);
 Curso c3=new Curso("Estructuras discretas",2);
 c2.asignarProfesor(new Profesor("Francois Valenzuela"));
 c3.asignarProfesor(new Profesor("Laura Carbajal"));
 c1.asignarProfesor(p1);
 c2.inscribir(e1);
 c2.inscribir(new Estudiante("Cesar Sanchez"));
 c1.inscribir(e2);
 c1.inscribir(new Estudiante("Fernando Alarcon"));
 c1.mostrar();
 c2.mostrar();
 c3.mostrar();
 }
}
