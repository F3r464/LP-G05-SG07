class ArchivoModelo{
    private String nombreArchivo;
    public ArchivoModelo(String nombreArchivo){
        this.nombreArchivo=nombreArchivo;
    }
    public String cargarContenido(){
        return GestorArchivosTexto.leerDatos(nombreArchivo);
    }
}