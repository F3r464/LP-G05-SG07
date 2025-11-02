class ProductoControlador{
    private ProductoModelo modelo;
    public ProductoControlador(ProductoModelo modelo){
        this.modelo=modelo;
    }
    public void coordinarVistaDePrecio(){
        Producto p=modelo.buscarPrecio();
        System.out.print("precio: "+p.getPrecio());
    }
}
