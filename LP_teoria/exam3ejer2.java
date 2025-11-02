class GestorArchivosTexto{
    public static String leerDatos(String archivo) throws FileNotFoundException{
        Scanner sc=new Scanner(new FileReader(archivo));
        if(sc.hasNextLine()){
            String linea=sc.nextLine();
        }
        return linea;
    }
}