import java.util.Scanner;
interface Arma{
    int danioArma();
    String getNombre();
}
class Espada implements Arma{
    public int danioArma(){
        return 30;
    }
    public String getNombre(){
        return "Espada";
    }
}
class Bufanda implements Arma{
    public int danioArma(){
        return 20;
    }
    public String getNombre(){
        return "Bufanda";
    }
}
class Hacha implements Arma{
    public int danioArma(){
        return 40;
    }
    public String getNombre(){
        return "Hacha";
    }
}
class Personaje {
    private String nombre;
    private int vida;

    public Personaje(String nombre, int vida){
        this.nombre =nombre;
        this.vida=vida;
    }
    public String getNombre(){
        return nombre;
    }
    public int getVida(){
        return vida;
    }
    public boolean estaVivo(){
        return vida > 0;
    }
    public void recibirDanio(int danio){
        vida -=danio;
        if(vida < 0){
            vida = 0;
        }
        System.out.println(nombre+" recibio "+ danio +" de daño | vida restante: " + vida);
    }
    public void atacar(Personaje enemigo, Arma arma){
        int danio = arma.danioArma();
        System.out.println(nombre + " ataca con " + arma.getNombre()+" hace "+danio+" de daño");
        enemigo.recibirDanio(danio);
    }
    public void magia(Personaje enemigo){
        int danio = 25;
        System.out.println(nombre+" usa magia y hace "+danio+" de daño!!");
        enemigo.recibirDanio(danio);
    }
}
class Enemigo extends Personaje{
    public Enemigo(String nombre, int vida){
        super(nombre, vida);
    }
}

public class Deltarune2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Personaje humano= new Personaje("Kris", 80);
        Personaje monstruo= new Personaje("Susie",100);
        Personaje principe=new Personaje("Ralsei", 65);
        Enemigo jefe = new Enemigo("Roaring Knight", 250);
        Arma espada= new Espada();
        Arma bufanda= new Bufanda();
        Arma hacha=new Hacha();

        char opcion;
        do{
            if(humano.estaVivo()){
                turnoJugador(sc, humano, jefe, espada, false);
            }
            if(monstruo.estaVivo()){
                turnoJugador(sc, monstruo, jefe, hacha, true);
            }
            if(principe.estaVivo()){
                turnoJugador(sc, principe, jefe, bufanda, true);
            }
            if(jefe.estaVivo()){
                System.out.println("\n>>> Turno del Roaring Knight <<<");
                if(humano.estaVivo()){
                    jefe.atacar(humano, espada);
                }else if(monstruo.estaVivo()){
                    jefe.atacar(monstruo, hacha);
                }else if(principe.estaVivo()){
                    jefe.atacar(principe, bufanda);
                }
            }

            if(!jefe.estaVivo()){
                System.out.println("\n Ganaste 200 de oro 850 de experiencia");
                break;
            }
            if(!humano.estaVivo() && !monstruo.estaVivo() && !principe.estaVivo()){
                System.out.println("\nComo perdiste en eso");
                break;
            }
            System.out.println("\n¿Desea continuar? (S)continuar (N) abandonar: ");
            opcion = sc.next().toUpperCase().charAt(0);
        }while(opcion!='N');
        sc.close();
    }
    public static void turnoJugador(Scanner sc, Personaje pj, Enemigo jefe, Arma arma, boolean tieneMagia){
        System.out.println("\nTurno de "+pj.getNombre());
        System.out.println("1) Atacar");
        System.out.println("2) Actuar");
        System.out.println("3) Defender");
        System.out.println("4) Escapar");
        System.out.print("Elige: ");
        char op = sc.next().charAt(0);
        switch(op){
            case '1':
                pj.atacar(jefe, arma);
                break;
            case '2':
                if(tieneMagia){
                    pj.magia(jefe);
                }else{
                    System.out.println(pj.getNombre()+" Llama a alguien...");
                    System.out.println("pero nadie vino...");
                }
                break;
            case '3':
                System.out.println(pj.getNombre()+" se defiende, recibe menos daño el próximo turno.");
                break;
            case '4':
                Sxystem.out.println(pj.getNombre()+" intenta escapar... pero no puede!");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
}