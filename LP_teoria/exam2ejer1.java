class Producto implements Comparable<Producto>{
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
    public int compareTo(Producto otro){
        if(this.precio>otro.precio){
            return 1;
        }else if(this.precio<otro.precio){
            return -1;
        }else{
            return 0;
        }
    }
    public String toString(){
        return nombre+" "+precio;
    }
}