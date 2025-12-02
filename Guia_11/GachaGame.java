import java.util.*;
interface Observador{
    void actualizar(String msg);
}
class Pantalla implements Observador{
    public void actualizar(String msg){
        System.out.println("PANTALLA: "+msg);
    }
}
class Luces implements Observador{
    public void actualizar(String msg){
        System.out.println("LUCES: "+msg);
    }
}
class Sonido implements Observador{
    public void actualizar(String msg){
        System.out.println("SONIDO: "+msg);
    }
}

class GachaSubject{
    ArrayList<Observador>obs=new ArrayList<>();
    public void addObs(Observador o){
        obs.add(o);
    }
    public void notifyAll(String msg){
        for(Observador o:obs){
            o.actualizar(msg);
        }
    }
}

interface Probabilidad{
    String generar();
}
class NormalProb implements Probabilidad{
    Random r=new Random();
    public String generar(){
        int n=r.nextInt(100);
        if(n<5){
            return "RARO";
        }
        return "NORMAL";
    }
}
class EventoProb implements Probabilidad{
    Random r=new Random();
    public String generar(){
        int n=r.nextInt(100);
        if(n<20){
            return "RARO";
        }
        if(n<25){
            return "ULTRA";
        }
        return "NORMAL";
    }
}
class CataclismoProb implements Probabilidad{
    Random r=new Random();
    public String generar(){
        int n=r.nextInt(100);
        if(n<70){
            return "SSSSR";
        }
        return "ULTRA";
    }
}

interface Comando{
    void ejecutar();
}
class GodMode implements Comando{
    Gacha g;
    public GodMode(Gacha g){
        this.g=g;
    }
    public void ejecutar(){
        g.setProb(new CataclismoProb());
        System.out.println("GODMODE ACTIVADO");
    }
}
class SetEvento implements Comando{
    Gacha g;
    public SetEvento(Gacha g){
        this.g=g;
    }
    public void ejecutar(){
        g.setProb(new EventoProb());
        System.out.println("MODO EVENTO ON");
    }
}
class SetNormal implements Comando{
    Gacha g;
    public SetNormal(Gacha g){
        this.g=g;
    }
    public void ejecutar(){
        g.setProb(new NormalProb());
        System.out.println("MODO NORMAL");
    }
}
class Gacha{
    GachaSubject sujeto=new GachaSubject();
    Probabilidad prob=new NormalProb();
    public void addObs(Observador o){
        sujeto.addObs(o);
    }
    public void setProb(Probabilidad p){
        prob=p;
    }
    public void girar(){
        String premio=prob.generar();
        if(premio.equals("NORMAL")){
            sujeto.notifyAll("Premio comun");
        }
        else if(premio.equals("RARO")){
            sujeto.notifyAll("¡PREMIO RARO!");
        }
        else if(premio.equals("ULTRA")){
            sujeto.notifyAll("¡¡ULTRA RARE!!");
        }
        else if(premio.equals("SSSSR")){
            sujeto.notifyAll("¡¡¡SE VIENE UN CATACLISMO SSSSR!!!");
        }
    }
}
public class GachaGame{
    public static void main(String[]args){
        Gacha g=new Gacha();
        g.addObs(new Pantalla());
        g.addObs(new Luces());
        g.addObs(new Sonido());
        Comando normal=new SetNormal(g);
        Comando evento=new SetEvento(g);
        Comando god=new GodMode(g);
        System.out.println("=== GIRADA NORMAL ===");
        g.girar();
        System.out.println("\n=== ACTIVAR EVENTO ===");
        evento.ejecutar();
        g.girar();
        System.out.println("\n=== ACTIVAR GODMODE ===");
        god.ejecutar();
        g.girar();
        System.out.println("\n=== VOLVER A NORMAL ===");
        normal.ejecutar();
        g.girar();
    }
}
