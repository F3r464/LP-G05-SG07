import java.util.*;
interface Observador{
    void recibir(String mensaje);
}
class Usuario implements Observador{
    String nombre;
    public Usuario(String n){
        nombre=n;
    }
    public void recibir(String mensaje){
        System.out.println("-> "+nombre+" <-  Mail.Web::"+mensaje);
    }
}
class Notificador{
    ArrayList<Observador> usuarios=new ArrayList<>();
    public void suscribir(Observador o){
        usuarios.add(o);
        System.out.println("Suscrito");
    }
    public void desuscribir(Observador o){
        usuarios.remove(o);
        System.out.println("Desuscrito");
    }

    public void enviar(String msg){
        for(Observador u:usuarios){
            u.recibir(msg);
        }
    }
}
class Notificacion{
    String titulo;
    public Notificacion(String t){titulo=t;}
    public String getMsg(){
        return "NOTIFICACIÓN: "+titulo;
    }
}
public class NotificacionesSMTP{
    public static void main(String[]args){

        Notificador sistema=new Notificador();

        Usuario u1=new Usuario("Chevreuse");
        Usuario u2=new Usuario("Lauma");
        Usuario u3=new Usuario("Nefer");

        sistema.suscribir(u1);
        sistema.suscribir(u2);

        Notificacion n1=new Notificacion("Nueva promoción 4x1!");
        sistema.enviar(n1.getMsg());

        System.out.println("\n-- Lauma bye bye --");
        sistema.desuscribir(u2);

        Notificacion n2=new Notificacion("Novedades en productos");
        sistema.enviar(n2.getMsg());

        System.out.println("\n-- Milim se une --");
        sistema.suscribir(u3);

        Notificacion n3=new Notificacion("Black Friday");
        sistema.enviar(n3.getMsg());
    }
}
