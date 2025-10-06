import java.util.*;
class Pedido{
    private String nombrePlato;
    public Pedido(String nombrePlato){
        this.nombrePlato=nombrePlato;
    }
    public String getNombrePlato(){
        return nombrePlato;
    }
}
class PedidoModelo{
    private List<Pedido> pedidos;
    public PedidoModelo(){
        pedidos=new ArrayList<>();
    }
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public List<Pedido> getPedidos(){
        return pedidos;
    }
}
class PedidoVista{
    private Scanner scanner;
    public PedidoVista(){
        scanner=new Scanner(System.in);
    }
    public String solicitarNombrePlato(){
        System.out.print("Inserte nombre de su 'comida': ");
        return scanner.nextLine();
    }
    public void mostrarPedidos(List<Pedido> pedidos){
        if (pedidos.isEmpty()){
            System.out.println("estas libre");
        }else{
            System.out.println("||||||||||||||||Pedidos|||||||||||||||||||||:");
            for (Pedido pedido:pedidos){
                System.out.println("- " + pedido.getNombrePlato());
            }
        }
    }
    public void mostrarMenu(){
        System.out.println("\nOpciones:");
        System.out.println("1. Mas Pedido");
        System.out.println("2. Ver Pedidos");
        System.out.println("3. Salir Pedidos");
    }
    public String solicitarOpcion(){
        System.out.print("OPciones 12 3 elige: ");
        return scanner.nextLine();
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void cerrarScanner(){
        scanner.close();
    }
}
class PedidoControlador{
    private PedidoModelo modelo;
    private PedidoVista vista;
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    public void agregarPedido(String nombrePlato){
        if(!nombrePlato.isEmpty()){
            modelo.agregarPedido(new Pedido(nombrePlato));
            vista.mostrarMensaje("Comida entro al pedido: " + nombrePlato);
        }else{
            vista.mostrarMensaje("que nombre es ese");
        }
    }
    public void mostrarPedidos(){
        List<Pedido> pedidos=modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }
    public void iniciar(){
        String opcion;
        do{
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch(opcion){
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    agregarPedido(nombrePlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    vista.mostrarMensaje("Expulsando");
                    break;
                default:
                    vista.mostrarMensaje("no que solo era 1 2  y 3");
            }
        }while(!opcion.equals("3"));
        vista.cerrarScanner();
    }
}

public class Act1PedidoRestaurante{
    public static void main(String[] args){
        PedidoModelo modelo=new PedidoModelo();
        PedidoVista vista=new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo,vista);
        controlador.iniciar();
    }
}