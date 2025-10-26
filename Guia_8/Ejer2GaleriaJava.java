import java.util.*;

class Artista{
    int id;
    String nombre;
    String apellido;
    String tecnica;
    String pais;
    String telefono;
    public Artista(int id,String n,String a,String te,String p,String t){
        this.id=id;
        this.nombre=n;
        this.apellido=a;
        this.tecnica=te;
        this.pais=p;
        this.telefono=t;
    }
    public String toString(){
        return id+" "+nombre+" "+apellido+" "+tecnica+" "+pais+" "+telefono;
    }
}
class Gestor{
    private List<Artista> lista=new ArrayList<>();
    public void agregar(Artista a){
        for(Artista x:lista){
            if(x.id==a.id){
                System.out.println("ya existe");
                return;
            }
        }
        lista.add(a);
        System.out.println("agregado");
    }
    public void mostrar(){
        for(Artista a:lista){
            System.out.println(a);
        }
    }
    public void consultar(Scanner chocolate){
        System.out.println("mostrar (nombre/apellido/estilo/pais/telefono/todo)");
        String campo=chocolate.nextLine();
        System.out.println("condicion? (si/no)");
        String cond=chocolate.nextLine();
        String campoCond="";
        String valorCond="";
        if(cond.equalsIgnoreCase("si")){
            System.out.print("campo: ");
            campoCond=chocolate.nextLine();
            System.out.print("valor: ");
            valorCond=chocolate.nextLine();
        }
        System.out.println("asc o desc: ");
        String orden=chocolate.nextLine();
        System.out.println("limite de registros (0=todo): ");
        int limite=Integer.parseInt(chocolate.nextLine());

        List<Artista> filtrada=new ArrayList<>(lista);
        if(cond.equalsIgnoreCase("si")){
            filtrada=new ArrayList<>();
            for(Artista a:lista){
                if(campoCond.equalsIgnoreCase("nombre") && a.nombre.equalsIgnoreCase(valorCond)){
                    filtrada.add(a);
                }
                else if(campoCond.equalsIgnoreCase("apellido") && a.apellido.equalsIgnoreCase(valorCond)){
                    filtrada.add(a);
                }
                else if(campoCond.equalsIgnoreCase("tecnica") && a.tecnica.equalsIgnoreCase(valorCond)){
                    filtrada.add(a);
                }
                else if(campoCond.equalsIgnoreCase("pais") && a.pais.equalsIgnoreCase(valorCond)){
                    filtrada.add(a);
                }
                else if(campoCond.equalsIgnoreCase("telefono") && a.telefono.equalsIgnoreCase(valorCond)){
                    filtrada.add(a);
                }
            }
        }

        if(orden.equalsIgnoreCase("asc"))
            filtrada.sort(Comparator.comparing(a->a.nombre));
        else if(orden.equalsIgnoreCase("desc"))
            filtrada.sort((a,b)->b.nombre.compareTo(a.nombre));

        int c=0;
        for(Artista a:filtrada){
            if(limite>0 && c>=limite){
                break;
            }
            if(campo.equalsIgnoreCase("todo")){
                System.out.println(a);
            }
            else if(campo.equalsIgnoreCase("nombre")){
                System.out.println(a.nombre);
            }
            else if(campo.equalsIgnoreCase("apellido")){
                System.out.println(a.apellido);
            }
            else if(campo.equalsIgnoreCase("tecnica")){
                System.out.println(a.tecnica);
            }
            else if(campo.equalsIgnoreCase("pais")){
                System.out.println(a.pais);
            }
            else if(campo.equalsIgnoreCase("telefono")){
                System.out.println(a.telefono);
            }
            c++;
        }
    }
}

public class Ejer2GaleriaJava{
    public static void main(String[] args){
        Scanner chocolate=new Scanner(System.in);
        Gestor g=new Gestor();
        String op;
        do{
            System.out.println("1 agregar");
            System.out.println("2 mostrar");
            System.out.println("3 consulta");
            System.out.println("4 salir");
            op=chocolate.nextLine();
            switch(op){
                case "1":
                    System.out.print("id: ");
                    int id=Integer.parseInt(chocolate.nextLine());
                    System.out.print("nombre: ");
                    String n=chocolate.nextLine();
                    System.out.print("apellido: ");
                    String a=chocolate.nextLine();
                    System.out.print("tecnica: ");
                    String e=chocolate.nextLine();
                    System.out.print("pais: ");
                    String p=chocolate.nextLine();
                    System.out.print("telefono: ");
                    String t=chocolate.nextLine();
                    g.agregar(new Artista(id,n,a,e,p,t));
                    break;
                case "2": g.mostrar();
                    break;
                case "3": g.consultar(chocolate);  
                    break;
                case "4": System.out.println("adios");
                    break;
                default: System.out.println("noo");
            }
        }while(!op.equals("4"));
    }
}