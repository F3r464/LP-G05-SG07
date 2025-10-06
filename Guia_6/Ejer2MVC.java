import java.util.*;  
class Item{  
    private String nombre;  
    private int cantidad;  
    private String tipo;  
    private String descripcion;  
    public Item(String nombre,int cantidad,String tipo,String descripcion){  
        this.nombre=nombre;  
        this.cantidad=cantidad;  
        this.tipo=tipo;  
        this.descripcion=descripcion;  
    }  
    public String getNombre(){  
        return nombre;  
    }  
    public int getCantidad(){  
        return cantidad;  
    }  
    public String getTipo(){  
        return tipo;  
    }  
    public String getDescripcion(){  
        return descripcion;  
    }  
    public void usarItem(){  
        if(cantidad>0){  
            cantidad--;  
            System.out.println("usaste el item: "+nombre+" queda: "+cantidad);  
        }else{  
            System.out.println("pobre no tiene "+nombre);  
        }  
    }  
}  
class ItemModelo{  
    private List<Item> items;  
    public ItemModelo(){  
        items=new ArrayList<>();  
    }  
    public void agregarItem(Item item){  
        items.add(item);  
    }  
    public void eliminarItem(String nombre){  
        for(int i=0;i<items.size();i++){  
            if(items.get(i).getNombre().equals(nombre)){  
                items.remove(i);  
                break;  
            }  
        }  
    }  
    public List<Item> obtenerItems(){  
        return items;  
    }  
    public Item buscarItem(String nombre){  
        for(Item i:items){  
            if(i.getNombre().equals(nombre)){  
                return i;  
            }  
        }  
        return null;  
    }  
}  
class ItemVista{  
    private Scanner sc;  
    public ItemVista(){  
        sc=new Scanner(System.in);  
    }  
    public String pedirDato(String texto){  
        System.out.print(texto);  
        return sc.nextLine();  
    }  
    public void mostrarInventario(List<Item> items){  
        if(items.isEmpty()){  
            System.out.println("no items");  
        }else{  
            System.out.println("inventario:");  
            for(Item i:items){  
                System.out.println("- "+i.getNombre()+" ("+i.getTipo()+") x"+i.getCantidad());  
            }  
        }  
    }  
    public void mostrarDetallesItem(Item i){  
        if(i!=null){  
            System.out.println("nombre: "+i.getNombre());  
            System.out.println("tipo: "+i.getTipo());  
            System.out.println("cantidad: "+i.getCantidad());  
            System.out.println("descripcion: "+i.getDescripcion());  
        }else{  
            System.out.println("obfuscate item");  
        }  
    }  
    public void mostrarMensaje(String mensaje){  
        System.out.println(mensaje);  
    }  
    public void mostrarMenu(){  
        System.out.println("\n1.agregar");  
        System.out.println("2.eliminar");  
        System.out.println("3.inventario");  
        System.out.println("4.stats");  
        System.out.println("5.buscar");  
        System.out.println("6.usar");  
        System.out.println("7.salir");  
    }  
    public void cerrar(){  
        sc.close();  
    }  
}  
class ItemControlador{  
    private ItemModelo modelo;  
    private ItemVista vista;  
    public ItemControlador(ItemModelo modelo,ItemVista vista){  
        this.modelo=modelo;  
        this.vista=vista;  
    }  
    public void agregarItem(String nombre,int cantidad,String tipo,String descripcion){  
        modelo.agregarItem(new Item(nombre,cantidad,tipo,descripcion));  
        vista.mostrarMensaje("item agregado: "+nombre);  
    }  
    public void eliminarItem(String nombre){  
        modelo.eliminarItem(nombre);  
        vista.mostrarMensaje("eliminado: "+nombre);  
    }  
    public void verInventario(){  
        vista.mostrarInventario(modelo.obtenerItems());  
    }  
    public void mostrarDetalles(String nombre){  
        Item i=modelo.buscarItem(nombre);  
        vista.mostrarDetallesItem(i);  
    }  
    public void buscarItem(String nombre){  
        Item i=modelo.buscarItem(nombre);  
        if(i!=null){  
            vista.mostrarMensaje("encontrado: "+i.getNombre());  
        }else{  
            vista.mostrarMensaje("no hay");  
        }  
    }  
    public void usarItem(String nombre){  
        Item i=modelo.buscarItem(nombre);  
        if(i!=null){  
            i.usarItem();  
        }else{  
            vista.mostrarMensaje("esta mal");  
        }  
    }  
    public void iniciar(){  
        String op;  
        do{  
            vista.mostrarMenu();  
            op=vista.pedirDato("elige opcion: ");  
            switch(op){  
                case "1":  
                    String n=vista.pedirDato("nombre: ");  
                    int c=Integer.parseInt(vista.pedirDato("cantidad: "));  
                    String t=vista.pedirDato("tipo: ");  
                    String d=vista.pedirDato("descripcion: ");  
                    agregarItem(n,c,t,d);  
                    break;  
                case "2":  
                    String e=vista.pedirDato("nombre: ");  
                    eliminarItem(e);  
                    break;  
                case "3":  
                    verInventario();  
                    break;  
                case "4":  
                    String det=vista.pedirDato("nombre: ");  
                    mostrarDetalles(det);  
                    break;  
                case "5":  
                    String b=vista.pedirDato("nombre: ");  
                    buscarItem(b);  
                    break;  
                case "6":  
                    String u=vista.pedirDato("nombre: ");  
                    usarItem(u);  
                    break;  
                case "7":  
                    vista.mostrarMensaje("adios");  
                    break;  
                default:  
                    vista.mostrarMensaje("??????");  
            }  
        }while(!op.equals("7"));  
        vista.cerrar();  
    }  
}  
public class Ejer2MVC{  
    public static void main(String[] args){  
        ItemModelo m=new ItemModelo();  
        ItemVista v=new ItemVista();  
        ItemControlador c=new ItemControlador(m,v);  
        c.iniciar();  
    }  
}  
