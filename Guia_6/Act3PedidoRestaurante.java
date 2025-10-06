import java.util.*;  
class Pedido{  
    private String nombrePlato;  
    private String tipoPlato;  
    public Pedido(String nombrePlato, String tipoPlato){  
        this.nombrePlato=nombrePlato;  
        this.tipoPlato=tipoPlato;  
    }  
    public String getNombrePlato(){  
        return nombrePlato;  
    }  
    public String getTipoPlato(){  
        return tipoPlato;  
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
    public void borrarPedido(String valor){  
        for(int i=0;i<pedidos.size();i++){  
            if(pedidos.get(i).getNombrePlato().equals(valor) || pedidos.get(i).getTipoPlato().equals(valor)){  
                pedidos.remove(i);  
                break;  
            }  
        }  
    }  
    public void actualizarPedido(String viejo,String nuevo,String tipoNuevo){  
        for(int i=0;i<pedidos.size();i++){  
            if(pedidos.get(i).getNombrePlato().equals(viejo) || pedidos.get(i).getTipoPlato().equals(viejo)){  
                pedidos.set(i,new Pedido(nuevo,tipoNuevo));  
                break;  
            }  
        }  
    }  
    public boolean buscarPedido(String valor){  
        for(Pedido p:pedidos){  
            if(p.getNombrePlato().equals(valor)||p.getTipoPlato().equals(valor)){  
                return true;  
            }  
        }  
        return false;  
    }  
    public int contarPedido(){  
        return pedidos.size();  
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
    public String solicitarNombreTipoPlato(){  
        System.out.print("Inserte nombre o tipo de su 'comida': ");  
        return scanner.nextLine();  
    }  
    public void mostrarPedidos(List<Pedido> pedidos){  
        if (pedidos.isEmpty()){  
            System.out.println("estas libre");  
        }else{  
            System.out.println("||||||||||||||||Pedidos|||||||||||||||||||||:");  
            for (Pedido pedido:pedidos){  
                System.out.println("- " + pedido.getNombrePlato() + " ("+pedido.getTipoPlato()+")");  
            }  
        }  
    }  
    public void mostrarMenu(){  
        System.out.println("\nOpciones:");  
        System.out.println("1. Mas Pedido");  
        System.out.println("2. Ver Pedidos");  
        System.out.println("3. Eliminar Pedido");  
        System.out.println("4. Actualizar Pedido");  
        System.out.println("5. Buscar Pedido");  
        System.out.println("6. Salir Pedidos");  
    }  
    public String solicitarOpcion(){  
        System.out.print("OPciones elige: ");  
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
    public void agregarPedido(String nombrePlato,String tipoPlato){  
        if(!nombrePlato.isEmpty()){  
            modelo.agregarPedido(new Pedido(nombrePlato,tipoPlato));  
            vista.mostrarMensaje("Comida entro al pedido: " + nombrePlato);  
        }else{  
            vista.mostrarMensaje("que nombre es ese");  
        }  
    }  
    public void borrarPedido(String valor){  
        modelo.borrarPedido(valor);  
        vista.mostrarMensaje("Comida salio del servidor: " + valor);  
    }  
    public void actualizarPedido(String viejo,String nuevo,String tipo){  
        modelo.actualizarPedido(viejo,nuevo,tipo);  
        vista.mostrarMensaje("Pedido digievoluciona de: " + viejo + " por " + nuevo);  
    }  
    public void buscarPedido(String valor){  
        if(modelo.buscarPedido(valor)){  
            vista.mostrarMensaje("Buscabas esto? ----->: " + valor);  
        }else{  
            vista.mostrarMensaje("no encuentro nada: " + valor);  
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
            opcion=vista.solicitarOpcion();  
            switch(opcion){  
                case "1":  
                    String nombre=vista.solicitarNombreTipoPlato();  
                    String tipo=vista.solicitarNombreTipoPlato();  
                    agregarPedido(nombre,tipo);  
                    break;  
                case "2":  
                    mostrarPedidos();  
                    break;  
                case "3":  
                    String borrar=vista.solicitarNombreTipoPlato();  
                    borrarPedido(borrar);  
                    break;  
                case "4":  
                    String viejo=vista.solicitarNombreTipoPlato();  
                    String nuevo=vista.solicitarNombreTipoPlato();  
                    String tipoNuevo=vista.solicitarNombreTipoPlato();  
                    actualizarPedido(viejo,nuevo,tipoNuevo);  
                    break;  
                case "5":  
                    String buscar=vista.solicitarNombreTipoPlato();  
                    buscarPedido(buscar);  
                    break;  
                case "6":  
                    vista.mostrarMensaje("Expulsando");  
                    break;  
                default:  
                    vista.mostrarMensaje("no que solo era 1 2 3 4 5 6");  
            }  
        }while(!opcion.equals("6"));  
        vista.cerrarScanner();  
    }  
}  

public class Act2PedidoRestaurante{  
    public static void main(String[] args){  
        PedidoModelo modelo=new PedidoModelo();  
        PedidoVista vista=new PedidoVista();  
        PedidoControlador controlador = new PedidoControlador(modelo,vista);  
        controlador.iniciar();  
    }  
}