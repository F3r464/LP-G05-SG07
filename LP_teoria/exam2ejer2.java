class ContenedorPrecio<T extends Producto>{
    private T producto;
    public ContenedorPrecio(T producto){
        this.producto=producto;
    }
    public T getProducto(){
        return producto;
    }
}