class GestorArchivosTexto{
    public static void escribirDatos(String archivo,String datos) throws FileNotFoundException{
        PrintWriter pw=new PrintWriter(archivo);
        pw.println(datos);
    }
}
