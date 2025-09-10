public class Coche{
  private String marca;
  private String modelo;
  private int anio;
  private double precio;
  public Coche(){}
  public Coche(String marca,String modelo,int anio,double precio){
    this.marca=marca;
    this.modelo=modelo;
    this.anio=anio;
    this.precio=precio;
  }
  public void setMarca(String marca){
    this.marca=marca;
  }
  public String getMarca(){
    return this.marca;
  }
  public void setModelo(String modelo){
    this.modelo=modelo;
  }
  public String getModelo(){
    return this.modelo;
  }
  public void setAnio(int anio){
    this.anio=anio;
  }
  public int getAnio(){
    return this.anio;
  }
  public void setPrecio(double precio){
    this.precio=precio;
  }
  public double getPrecio(){
    return this.precio;
  }
  public void agregarDescuento(){
    if(this.anio<2010){
      this.precio=this.precio*0.90;
      System.out.println("Coche antiguo: !Descuento¡ ");
    }else{
      System.out.println("Paga todo");
    }
  }
  public void mostrarInfo(){
    System.out.println("marca: "+marca+" modelo: "+modelo+" año: "+anio+" precio: "+precio);
  }
  public void acelerar(){
    System.out.println("coche acelera");
  }
  public void frenar(){
    System.out.println("coche frena");
  }
  public void prender(){
    System.out.println("coche esta encendido");
  }
  public void apagar(){
    System.out.println("coche esta apagado");
  }
}
