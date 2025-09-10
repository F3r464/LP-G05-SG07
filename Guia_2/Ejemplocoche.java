public class Ejemplocoche{
  public static void main(String[] args){
    Coche cocheDeportivo=new Coche("Ferrari","F8",2020,3000000);
    Coche cocheTodoterreno=new Coche("Toyota","Lr",2005,200000);
    cocheDeportivo.mostrarInfo();
    cocheTodoterreno.mostrarInfo();
    cocheTodoterreno.agregarDescuento();
    cocheDeportivo.agregarDescuento();
    cocheTodoterreno.mostrarInfo();
    cocheDeportivo.mostrarInfo();
    cocheDeportivo.setPrecio(280000);
    cocheTodoterreno.getPrecio();
    System.out.println("nuevo precio deportivo: "+cocheDeportivo.getPrecio());
    cocheDeportivo.prender();
    cocheDeportivo.acelerar();
    cocheDeportivo.frenar();
    cocheDeportivo.apagar();
    cocheTodoterreno.prender();
  }
}
