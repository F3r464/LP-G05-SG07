import java.sql.*;
import java.util.*;

public class Ejer1Galeria{
    private static final String CLAVE="1003";
    private static Connection con;

    public static void main(String[] args){
        Scanner chocolate=new Scanner(System.in);
        conectar();
        crearTabla();
        String op;
        do{
            System.out.println("\n1 ingresar");
            System.out.println("2 borrar");
            System.out.println("3 actualizar");
            System.out.println("4 mostrar");
            System.out.println("5 salir");
            System.out.print("elige: ");
            op=chocolate.nextLine();
            switch(op){
                case "1": ingresar(chocolate);
                    break;
                case "2": borrar(chocolate); 
                    break;
                case "3": actualizar(chocolate);
                    break;
                case "4": mostrar();
                    break;
                case "5": System.out.println("adios"); 
                    break;
                default: System.out.println("no valido");
            }
        }while(!op.equals("5"));
        try{ 
            con.close(); 
            
        }catch(Exception e){}
    }

    private static void conectar(){
        try{
            con=DriverManager.getConnection("jdbc:sqlite:galeria.db");
        }catch(Exception e){
            System.out.println("error conectando bd");
        }
    }
    private static void crearTabla(){
        try(Statement st=con.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS Artista(id_artista INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,apellido TEXT,estilo TEXT,telefono TEXT,pais TEXT)");
        }catch(Exception e){
            System.out.println("error creando tabla");
        }
    }
    private static void ingresar(Scanner chocolate){
        System.out.print("nombre: ");
        String n=chocolate.nextLine();
        System.out.print("apellido: ");
        String a=chocolate.nextLine();
        System.out.print("estilo: ");
        String es=chocolate.nextLine();
        System.out.print("telefono: ");
        String t= chocolate.nextLine();
        System.out.print("pais: ");
        String p=chocolate.nextLine();
        System.out.print("clave: ");
        String clave=chocolate.nextLine();
        if(!clave.equals(CLAVE)){
            System.out.println("clave mala");
            return;
        }
        try(PreparedStatement ps=con.prepareStatement("INSERT INTO Artista(nombre,apellido,estilo,telefono,pais) VALUES(?,?,?,?,?)")){
            ps.setString(1,n);
            ps.setString(2,a);
            ps.setString(3,es);
            ps.setString(4,t);
            ps.setString(5,p);
            ps.executeUpdate();
            System.out.println("artista guardado");
        }catch(Exception e){
            System.out.println("error insertando");
        }
    }
    private static void borrar(Scanner chocolate){
        System.out.print("id_artista: ");
        int id=Integer.parseInt(chocolate.nextLine());
        System.out.print("clave: ");
        String clave=chocolate.nextLine();
        if(!clave.equals(CLAVE)){
            System.out.println("clave mala, revertiendo");
            return;
        }
        try(PreparedStatement ps=con.prepareStatement("DELETE FROM Artista WHERE id_artista=?")){
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("artista borrado");
        }catch(Exception e){
            System.out.println("error borrando");
        }
    }
    private static void actualizar(Scanner chocolate){
        System.out.print("id_artista: ");
        int id=Integer.parseInt(chocolate.nextLine());
        System.out.print("nuevo nombre: ");
        String n=chocolate.nextLine();
        System.out.print("nuevo estilo: ");
        String es=chocolate.nextLine();
        System.out.print("clave: ");
        String clave=chocolate.nextLine();
        if(!clave.equals(CLAVE)){
            System.out.println("clave mala");
            return;
        }
        try(PreparedStatement ps=con.prepareStatement("UPDATE Artista SET nombre=?, estilo=? WHERE id_artista=?")){
            ps.setString(1,n);
            ps.setString(2,es);
            ps.setInt(3,id);
            ps.executeUpdate();
            System.out.println("artista actualizado");
        }catch(Exception e){
            System.out.println("error actualizando");
        }
    }
    private static void mostrar(){
        try(Statement st=con.createStatement()){
            ResultSet rs=st.executeQuery("SELECT * FROM Artista");
            while(rs.next()){
                System.out.println(rs.getInt("id_artista")+" "+rs.getString("nombre")+" "+rs.getString("apellido")+" "+rs.getString("estilo")+" "+rs.getString("telefono")+" "+rs.getString("pais"));
            }
        }catch(Exception e){
            System.out.println("error mostrando");
        }
    }
}
