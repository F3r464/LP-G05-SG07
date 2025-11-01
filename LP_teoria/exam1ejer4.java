public class Main{
    public static void main(String[] args){
        RegistroModelo modelo=new RegistroModelo("yo"),1003);
        try(FileOutputStream f=new FileOutputStream("datos.ser");
            ObjectOutputStream o=new ObjectOutputStream(f)){
            o.writeObject(modelo.obtenerRegistro());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}