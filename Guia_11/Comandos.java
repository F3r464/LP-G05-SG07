interface Comando{
    void ejecutar();
}
class Luz{
    public void encender(){
        System.out.println("hola luz");
    }
    public void apagar(){
        System.out.println("bye luz");
    }
}
class EncenderLuz implements Comando{
    Luz luz;
    public EncenderLuz(Luz l){
        luz=l;
    }
    public void ejecutar(){
        luz.encender();
    }
}
class ApagarLuz implements Comando{
    Luz luz;
    public ApagarLuz(Luz l){
        luz=l;
    }
    public void ejecutar(){
        luz.apagar();
    }
}
class ControlRemoto{
    private Comando comando;
    public void setComando(Comando c){
        comando=c;
    }
    public void presionarBoton(){
        comando.ejecutar();
    }
}
public class Comandos{
    public static void main(String[]args){
        Luz luz=new Luz();
        Comando enc=new EncenderLuz(luz);
        Comando apg=new ApagarLuz(luz);
        ControlRemoto control=new ControlRemoto();
        control.setComando(enc);
        control.presionarBoton();
        control.setComando(apg);
        control.presionarBoton();
    }
}
