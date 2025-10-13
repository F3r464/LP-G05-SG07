class Modelo{
    private List<Empleado> lista;
    private File archivo;
    public Modelo(String ruta){
        archivo=new File(ruta);
        lista=new ArrayList<>();
        leerEmpleados();
    }
    public void leerEmpleados(){
        if(!archivo.exists()){
            return;
        }
        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea=br.readLine())!=null){
                String[] p=linea.split(",");
                if(p.length==3){
                    int num=Integer.parseInt(p[0]);
                    String nom=p[1];
                    double sue=Double.parseDouble(p[2]);
                    lista.add(new Empleado(num,nom,sue));
                }
            }
        }
        catch(Exception e){
            System.out.println("error leyendo archivo");
        }
    }
    private void guardar(){
        try(PrintWriter pw=new PrintWriter(new FileWriter(archivo))){
            for(Empleado e:lista){
                pw.println(e.toString());
            }
        }catch(Exception e){
            System.out.println("error guardando archivo");
        }
    }
    public List<Empleado> getLista(){
        return lista;
    }
    public void agregarEmpleado(Empleado e){
        for(Empleado x:lista){
            if(x.getNumero()==e.getNumero()){
                System.out.println("numero ya usado");
                return;
            }
        }
        lista.add(e);
        guardar();
        System.out.println("empleado agregado");
    }

    public Empleado buscarEmpleado(int num){
        for(Empleado e:lista){
            if(e.getNumero()==num){
                return e;
            }
        }
        return null;
    }

    public void eliminarEmpleado(int num){
        Iterator<Empleado> it=lista.iterator();
        while(it.hasNext()){
            Empleado e=it.next();
            if(e.getNumero()==num){
                it.remove();
                guardar();
                System.out.println("empleado eliminado");
                return;
            }
        }
        System.out.println("empleado no encontrado");
    }
}
