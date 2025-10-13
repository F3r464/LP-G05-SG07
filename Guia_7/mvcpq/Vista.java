import java.util.*;

class Vista{
    private Scanner sc=new Scanner(System.in);

    public int menu(){
        System.out.println("\nMenu suer moderno (=0)");
        System.out.println("1. asistencia");
        System.out.println("2. contrata");
        System.out.println("3. mas buscados");
        System.out.println("4. descartar");
        System.out.println("5. exit");
        System.out.print("opcion: ");
        return sc.nextInt();
    }

    public void mostrarEmpleados(List<Empleado> lista){
        if(lista.isEmpty()){
            System.out.println("no hay nadie trabajando");
        }else{
            for(Empleado e:lista){
                System.out.println(e.toString());
            }
        }
    }

    public Empleado nuevoEmpleado(){
        System.out.print("numero: ");
        int num=sc.nextInt();
        sc.nextLine();
        System.out.print("nombre: ");
        String nom=sc.nextLine();
        System.out.print("sueldo: ");
        double sue=sc.nextDouble();
        return new Empleado(num,nom,sue);
    }

    public int pedirNumero(){
        System.out.print("numero empleado: ");
        return sc.nextInt();
    }

    public void mostrarEmpleado(Empleado e){
        if(e==null){
            System.out.println("no encontrado");
        }else{
            System.out.println(e.toString());
        }
    }

    public void mensaje(String m){
        System.out.println(m);
    }
}
