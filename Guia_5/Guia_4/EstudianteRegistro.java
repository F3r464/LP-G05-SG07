import java.util.*;  
class RegistroEstudiantes{  
    String[] estudiantes;  
    int count;  
    RegistroEstudiantes(int tam){  
        estudiantes=new String[tam];  
        count=0;  
    }
    void agregarEstudiante(String nombre){
        if(nombre==null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("nombre invalido");
        }  
        if(count<estudiantes.length){  
            estudiantes[count]=nombre;
            count++;  
        }else{
            System.out.println("no hay espacio, fuera estudiantes");
        }
    }
    String buscarEstudiante(String nombre){
        for(int i=0;i<count;i++){
            if(estudiantes[i].equalsIgnoreCase(nombre)){
                return estudiantes[i];  
            }  
        }  
        throw new NoSuchElementException("no hay alumnos!!!!");  
    }  
}
public class EstudianteRegistro{  
    public static void main(String[] args){  
        Scanner sc=new Scanner(System.in);  
        RegistroEstudiantes registro=new RegistroEstudiantes(5);
        try{
            System.out.println("agregar estudiante: ");
            String e1=sc.nextLine();  
            registro.agregarEstudiante(e1);  
            System.out.println("estudiante agregado");
        }catch(IllegalArgumentException e){  
            System.out.println("error: "+e.getMessage());  
        }
        try{  
            System.out.println("buscar estudiante: ");  
            String b=sc.nextLine();  
            String encontrado=registro.buscarEstudiante(b);  
            System.out.println("estudiante encontrado: "+encontrado);  
        }catch(NoSuchElementException e){  
            System.out.println("error: "+e.getMessage());  
        }
        sc.close();  
    }  
}  
