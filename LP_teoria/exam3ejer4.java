class ArchivoControlador{
    private ArchivoModelo modelo;
    private ArchivoVista vista
    public ArchivoControlador(ArchivoModelo modelo, ArchivoVista vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    public void presentarDatosDeArchivos(){
        System.out.println(modelo.cargarContenido());
    }
}