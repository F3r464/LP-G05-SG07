import java.util.*;  
class Jugador{  
    private String nombre;  
    private int salud;  
    private int nivel;  
    private String arma;  
    private List<String> inventario;  
    public Jugador(String nombre){  
        this.nombre=nombre;  
        this.salud=100;  
        this.nivel=1;  
        this.arma="espada";  
        inventario=new ArrayList<>();  
        inventario.add("pocion");  
        inventario.add("lanza");  
    }  
    public String getNombre(){  
        return nombre;  
    }  
    public int getSalud(){  
        return salud;  
    }  
    public int getNivel(){  
        return nivel;  
    }  
    public String getArma(){  
        return arma;  
    }  
    public void cambiarArma(String nueva){  
        if(inventario.contains(nueva)){  
            arma=nueva;  
            System.out.println("arma en persoanje: "+arma);  
        }else{  
            System.out.println("compra arma");  
        }  
    }  
    public void usarObjeto(String obj){  
        if(inventario.contains(obj)){  
            if(obj.equals("pocion")){  
                salud+=30;  
                if(salud>100)salud=100;  
                System.out.println("pocion electrotormenta HP+: "+salud);  
            }else{  
                System.out.println("no se puede usar aqui");  
            }  
        }else{  
            System.out.println("no hay nada");  
        }  
    }  
    public int atacar(){  
        int dano=0;  
        switch(arma){  
            case "espada":
                dano=20;
                break;  
            case "lanza":
                dano=25;
                break;
            default:
                dano=10;  
        }  
        System.out.println(nombre+" ataca con "+arma+" dañop "+dano+" HP");  
        return dano;  
    }  
    public void recibirDano(int cantidad){  
        salud-=cantidad;  
        if(salud<0)salud=0;  
        System.out.println(nombre+" recibió "+cantidad+" -HP (vida: "+salud+")");  
    }  
    public boolean estaVivo(){  
        return salud>0;  
    }  
}  
class Enemigo{
    private String nombre;  
    private int salud;  
    private int nivel;  
    private String tipo;  
    public Enemigo(String nombre,String tipo){  
        this.nombre=nombre;  
        this.tipo=tipo;  
        this.salud=280;  
        this.nivel=1;  
    }
    public String getNombre(){
        return nombre;  
    }
    public String getTipo(){
        return tipo;
    }
    public int getSalud(){  
        return salud;  
    }  
    public void recibirDano(int cantidad){  
        salud-=cantidad;  
        if(salud<0)salud=0;  
        System.out.println(nombre+" daño "+cantidad+" -HP(salud: "+salud+")");  
    }  
    public int atacar(){  
        Random r=new Random();  
        int dano=r.nextInt(15)+5;  
        System.out.println(nombre+" electroeclipse "+dano+" daño");  
        return dano;  
    }  
    public boolean estaVivo(){  
        return salud>0;  
    }  
}  
class CombateModelo{  
    private Jugador jugador;  
    private Enemigo enemigo;  
    public CombateModelo(Jugador j,Enemigo e){  
        this.jugador=j;  
        this.enemigo=e;  
    }  
    public Jugador getJugador(){  
        return jugador;  
    }  
    public Enemigo getEnemigo(){  
        return enemigo;  
    }  
    public boolean combateTerminado(){  
        return !jugador.estaVivo() || !enemigo.estaVivo();  
    }  
}  
class CombateVista{  
    private Scanner sc;  
    public CombateVista(){  
        sc=new Scanner(System.in);  
    }  
    public void mostrarEstado(Jugador j,Enemigo e){  
        System.out.println("\n----- Estado -----");  
        System.out.println(j.getNombre()+" salud:"+j.getSalud()+" arma:"+j.getArma());  
        System.out.println(e.getNombre()+" salud:"+e.getSalud()+" tipo:"+e.getTipo());  
    }  
    public void mostrarMenu(){  
        System.out.println("\n1.atacar 2.usar pocion 3.cambiar arma 4.salir");  
    }  
    public String pedir(String t){  
        System.out.print(t);  
        return sc.nextLine();  
    }  
    public void mostrarMensaje(String m){  
        System.out.println(m);  
    }  
    public void cerrar(){  
        sc.close();  
    }  
}  
class CombateControlador{  
    private CombateModelo modelo;  
    private CombateVista vista;  
    public CombateControlador(CombateModelo modelo,CombateVista vista){  
        this.modelo=modelo;  
        this.vista=vista;  
    }  
    public void iniciar(){  
        Jugador j=modelo.getJugador();  
        Enemigo e=modelo.getEnemigo();  
        String op;  
        vista.mostrarMensaje("Inicia desafio");  
        do{  
            vista.mostrarEstado(j,e);  
            vista.mostrarMenu();  
            op=vista.pedir("elige: ");  
            switch(op){  
                case "1":  
                    int d=j.atacar();  
                    e.recibirDano(d);  
                    break;  
                case "2":  
                    j.usarObjeto("pocion");  
                    break;  
                case "3":  
                    String nueva=vista.pedir("arma equipar: ");  
                    j.cambiarArma(nueva);  
                    break;  
                case "4":  
                    vista.mostrarMensaje("corres");  
                    return;  
                default:  
                    vista.mostrarMensaje("que!!!!!");  
            }  
            if(e.estaVivo()){  
                int danoEnemigo=e.atacar();  
                j.recibirDano(danoEnemigo);  
            }  
        }while(j.estaVivo() && e.estaVivo());  
        if(j.estaVivo()){  
            vista.mostrarMensaje("Xp de combate +");  
        }else{  
            vista.mostrarMensaje("Regresando a punto de teletraspote");  
        }  
        vista.cerrar();  
    }  
}  
public class Ejer3Genshin{  
    public static void main(String[] args){  
        Jugador j=new Jugador("Aether");  
        Enemigo e=new Enemigo("Heraldo de abismo","general");  
        CombateModelo m=new CombateModelo(j,e);  
        CombateVista v=new CombateVista();  
        CombateControlador c=new CombateControlador(m,v);  
        c.iniciar();  
    }  
}  
