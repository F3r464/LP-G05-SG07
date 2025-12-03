import java.util.*;
interface EstrategiaDescuento{
    double aplicar(ArrayList<Producto> productos);
}
class SinDescuento implements EstrategiaDescuento{
    public double aplicar(ArrayList<Producto> productos){
        double total=0;
        for(Producto p:productos){
            total+=p.precio;
        }
        return total;
    }
}
class DescuentoFijo implements EstrategiaDescuento{
    public double aplicar(ArrayList<Producto> productos){
        double total=0;
        for(Producto p:productos){
            total+=p.precio;
        }
        return total*0.90;
    }
}
class DescuentoPorcentual implements EstrategiaDescuento{
    public double aplicar(ArrayList<Producto> productos){
        double total=0;
        for(Producto p:productos){
            total+=p.precio;
        }
        if(productos.size()==2&&productos.get(0).nombre.equals(productos.get(1).nombre)){
            total *= 0.70;
        }
        return total;
    }
}
class DescuentoPorcentualAcumulado implements EstrategiaDescuento{
    public double aplicar(ArrayList<Producto> productos){
        double total=0;
        for(Producto p:productos){
            total+=p.precio;
        }
        if(productos.size()>=3){
            double min=productos.get(0).precio;
            for(Producto p:productos){
                if(p.precio<min){
                    min=p.precio;
                }
            }
            total -= min*0.50;
        }
        return total;
    }
}
class Producto{
    String nombre;
    double precio;
    public Producto(String n,double p){
        nombre=n;
        precio=p;
    }
}
class CalculadoraDePrecios{
    EstrategiaDescuento estrategia;
    public void setEstrategia(EstrategiaDescuento e){
        estrategia=e;
    }
    public double calcular(ArrayList<Producto> lista){
        return estrategia.aplicar(lista);
    }
public class TiendaDeDescuentos{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Producto> carrito=new ArrayList<>();
        carrito.add(new Producto("Anillos",120));
        carrito.add(new Producto("Aretes",50));
        carrito.add(new Producto("Pulseras",80));

        CalculadoraDePrecios calc=new CalculadoraDePrecios();
        System.out.println("Descuentos:");
        System.out.println("1 Sin descuento");
        System.out.println("2 Descuento 10%");
        System.out.println("3 30% por 2 productos iguales");
        System.out.println("4 50% por 3 pproductos");
        System.out.print("Opcióo: ");
        int opc=sc.nextInt();
        switch(opc){
            case 1: 
                calc.setEstrategia(new SinDescuento());
                break;
            case 2:
                calc.setEstrategia(new DescuentoFijo());
                break;
            case 3:
                calc.setEstrategia(new DescuentoPorcentual());
                break;
            case 4:
                calc.setEstrategia(new DescuentoPorcentualAcumulado());
                break;
            default:
                System.out.println("otra opcion por favor");
                return;
        }

        double total=calc.calcular(carrito);
        System.out.println("pagar: "+total);
    }
}
