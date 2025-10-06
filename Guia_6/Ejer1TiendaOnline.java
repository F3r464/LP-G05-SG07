import java.util.*;
class Producto{
    private String nombre;
    private double precio;
    public Producto(String nombre,double precio){
        this.nombre=nombre;
        this.precio=precio;
    }
    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
}
class TiendaModelo{
    private List<Producto> productos;
    private List<Producto> carrito;
    private List<List<Producto>> historial;
    public TiendaModelo(){
        productos=new ArrayList<>();
        carrito=new ArrayList<>();
        historial=new ArrayList<>();
    }
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    public List<Producto> getProductos(){
        return productos;
    }
    public void agregarCarrito(String nombre){
        for(Producto p:productos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                carrito.add(p);
                break;
            }
        }
    }
    public void eliminarDelCarrito(String nombre){
        for(int i=0;i<carrito.size();i++){
            if(carrito.get(i).getNombre().equalsIgnoreCase(nombre)){
                carrito.remove(i);
                break;
            }
        }
    }
    public List<Producto> getCarrito(){
        return carrito;
    }
    public double calcularTotal(double descuento,double envio){
        double total=0;
        for(Producto p:carrito){
            total+=p.getPrecio();
        }
        total=total-(total*descuento/100)+envio;
        return total;
    }
    public void realizarCompra(){
        if(!carrito.isEmpty()){
            historial.add(new ArrayList<>(carrito));
            carrito.clear();
        }
    }
    public List<List<Producto>> getHistorial(){
        return historial;
    }
}
class TiendaVista{
    private Scanner sc;
    public TiendaVista(){
        sc=new Scanner(System.in);
    }
    public void mostrarMenu(){
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Listar Productos");
        System.out.println("3. Agregar Carrito");
        System.out.println("4. Ver Carrito");
        System.out.println("5. Eliminar Carrito");
        System.out.println("6. Calcular");
        System.out.println("7. Compra");
        System.out.println("8. Historial");
        System.out.println("9. Salir");
    }
    public String solicitarDato(String mensaje){
        System.out.print(mensaje);
        return sc.nextLine();
    }
    public void mostrarProductos(List<Producto> lista,String titulo){
        System.out.println("-|-|-|-|-|-|-|-"+titulo+"-|-|-|-|-|-");
        if(lista.isEmpty())System.out.println("Nada aqui");
        else{
            for(Producto p:lista){
                System.out.println("- "+p.getNombre()+" s/"+p.getPrecio());
            }
        }
    }
    public void mostrarHistorial(List<List<Producto>> historial){
        if(historial.isEmpty()){
            System.out.println("nada aca");
        }else{
            for(int i=0;i<historial.size();i++){
                System.out.println("Compra "+(i+1)+":");
                for(Producto p:historial.get(i)){
                    System.out.println(" - "+p.getNombre()+" $"+p.getPrecio());
                }
            }
        }
    }
    public void mostrarMensaje(String m){
        System.out.println(m);
    }
    public void cerrar(){
        sc.close();
    }
}
class TiendaControlador{
    private TiendaModelo modelo;
    private TiendaVista vista;
    public TiendaControlador(TiendaModelo modelo,TiendaVista vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    public void iniciar(){
        String op;
        do{
            vista.mostrarMenu();
            op=vista.solicitarDato("Opcion: ");
            switch(op){
                case "1":
                    String n=vista.solicitarDato("producto: ");
                    double p=Double.parseDouble(vista.solicitarDato("Precio: "));
                    modelo.agregarProducto(new Producto(n,p));
                    vista.mostrarMensaje("productos nuevos disponibles");
                    break;
                case "2":
                    vista.mostrarProductos(modelo.getProductos(),"Productos Disponibles");
                    break;
                case "3":
                    String prod=vista.solicitarDato("Producto -> carrito: ");
                    modelo.agregarCarrito(prod);
                    vista.mostrarMensaje("carrito +1");
                    break;
                case "4":
                    vista.mostrarProductos(modelo.getCarrito(),"Carrito");
                    break;
                case "5":
                    String elim=vista.solicitarDato("Producto <- carrito: ");
                    modelo.eliminarDelCarrito(elim);
                    vista.mostrarMensaje("Incinerando producto");
                    break;
                case "6":
                    double desc=Double.parseDouble(vista.solicitarDato("Descuento %: "));
                    double envio=Double.parseDouble(vista.solicitarDato("Costo rappi: "));
                    double total=modelo.calcularTotal(desc,envio);
                    vista.mostrarMensaje("Paga: s/"+total);
                    break;
                case "7":
                    modelo.realizarCompra();
                    vista.mostrarMensaje("Sin devoluciones");
                    break;
                case "8":
                    vista.mostrarHistorial(modelo.getHistorial());
                    break;
                case "9":
                    vista.mostrarMensaje("Largo de aqui");
                    break;
                default:
                    vista.mostrarMensaje("vuelve a leer las opciones");
            }
        }while(!op.equals("9"));
        vista.cerrar();
    }
}
public class Ejer1TiendaOnline{
    public static void main(String[] args){
        TiendaModelo modelo=new TiendaModelo();
        TiendaVista vista=new TiendaVista();
        TiendaControlador c=new TiendaControlador(modelo,vista);
        c.iniciar();
    }
}
