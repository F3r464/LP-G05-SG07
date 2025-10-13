public class Ejer3MVC{
    public static void main(String[] args){
        Modelo m=new Modelo("empleados.txt");
        Vista v=new Vista();
        Controlador c=new Controlador(m,v);
        c.iniciar();
    }
}
