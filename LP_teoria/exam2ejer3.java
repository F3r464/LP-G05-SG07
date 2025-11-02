class ProductoModelo{
    private ContenedorPrecio<Producto> datos;
    public ProductoModelo(Producto producto){
        datos=new ContenedorPrecio<Producto>(producto);
    }
    public Producto buscarPrecio(){
        return datos.getProducto();
    }
}
