interface Promocion{
    double aplicar(double precio);
}
class PromoSinDescuento implements Promocion{
    public double aplicar(double precio){
        return precio;
    }
}
class Promo10 implements Promocion{
    public double aplicar(double precio){
        return precio*0.9;
    }
}
class Promo20 implements Promocion{
    public double aplicar(double precio){
        return precio*0.8;
    }
}
class PromoCyber implements Promocion{
    public double aplicar(double precio){
        return precio*0.4;
    }
}
class Producto{
    private String nombre;
    private double precio;
    private Promocion promo;
    public Producto(String nombre,double precio){
        this.nombre=nombre;
        this.precio=precio;
        this.promo=new PromoSinDescuento();
    }
    public void setPromocion(Promocion p){
        this.promo=p;
    }
    public double calcularPrecioFinal(){
        return promo.aplicar(precio);
    }
    public String getNombre(){
        return nombre;
    }
}
public class Strategia{
    public static void main(String[]args){
        Producto p1=new Producto("Laptop",2000);
        Producto p2=new Producto("Audifonos Promo Yape",100);
        p1.setPromocion(new Promo10());
        p2.setPromocion(new PromoCyber());
        System.out.println("Producto: "+p1.getNombre()+" Precio: "+p1.calcularPrecioFinal()+"que ganga");
        System.out.println("Producto: "+p2.getNombre()+" Precio: "+p2.calcularPrecioFinal()+"ojo por eso es bueno malgastar dinero compra compra");
        p1.setPromocion(new PromoSinDescuento());
        System.out.println("Producto: "+p1.getNombre()+" sin promo: "+p1.calcularPrecioFinal()+"!!!jasjjajas pobre!!!");
    }
}
