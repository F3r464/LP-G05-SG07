import java.sql.*;
import java.util.*;

public class Act1BD{
    private static Connection con;
    public static void main(String[] args){
        Scanner chocolate=new Scanner(System.in);
        conectar();
        crearTabla();
        String op;
        do{
            System.out.println("\n1 insertar");
            System.out.println("2 mostrar");
            System.out.println("3 actualizar");
            System.out.println("4 borrar");
            System.out.println("5 salir");
            System.out.print("elige: ");
            op=chocolate.nextLine();
            switch(op){
                case "1": insertar(chocolate);
                    break;
                case "2": mostrar();
                    break;
                case "3": actualizar(chocolate);
                    break;
                case "4": borrar(chocolate);
                    break;
                case "5": System.out.println("adios");
                    break;
                default: System.out.println("otra");
            }
        }while(!op.equals("5"));
        try{
            con.close();
        }
        catch(Exception e){}
    }
    private static void conectar(){
        try{
            con=DriverManager.getConnection("jdbc:sqlite:Act1.db");
            System.out.println("conexion");
        }catch(Exception e){
            System.out.println("error conexion");
        }
    }

    private static void crearTabla(){
        try(Statement st=con.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS Producto(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,precio REAL,cantidad INTEGER)");
        }catch(Exception e){
            System.out.println("error creando tabla");
        }
    }

    private static void insertar(Scanner chocolate){
        System.out.print("nombre: ");
        String n=chocolate.nextLine();
        System.out.print("precio: ");
        double p=Double.parseDouble(chocolate.nextLine());
        System.out.print("cantidad: ");
        int c=Integer.parseInt(chocolate.nextLine());
        try{
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("INSERT INTO Producto(nombre,precio,cantidad) VALUES(?,?,?)");
            ps.setString(1,n);
            ps.setDouble(2,p);
            ps.setInt(3,c);
            ps.executeUpdate();
            con.commit();
            System.out.println("coomit");
        }catch(Exception e){
            System.out.println(" rollback");
            try{con.rollback();}catch(Exception ex){}
        }finally{
            try{
                con.setAutoCommit(true);
            }
            catch(Exception e){}
        }
    }

    private static void mostrar(){
        try(Statement st=con.createStatement()){
            ResultSet rs=st.executeQuery("SELECT * FROM Producto");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("nombre")+" "+rs.getDouble("precio")+" "+rs.getInt("cantidad"));
            }
        }
        catch(Exception e){
            System.out.println("error mostrando");
        }
    }

    private static void actualizar(Scanner chocolate){
        System.out.print("id producto: ");
        int id=Integer.parseInt(chocolate.nextLine());
        System.out.print("nuevo precio: ");
        double p=Double.parseDouble(chocolate.nextLine());
        try{
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("UPDATE Producto SET precio=? WHERE id=?");
            ps.setDouble(1,p);
            ps.setInt(2,id);
            ps.executeUpdate();
            con.commit();
            System.out.println("prec commint");
        }catch(Exception e){
            System.out.println(" rollback");
            try{
                con.rollback();
            }
            catch(Exception ex){}
        }finally{
            try{
                con.setAutoCommit(true);
            }
            catch(Exception e){}
        }
    }

    private static void borrar(Scanner chocolate){
        System.out.print("id producto: ");
        int id=Integer.parseInt(chocolate.nextLine());
        try{
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("DELETE FROM Producto WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            con.commit();
            System.out.println("producto borrado");
        }catch(Exception e){
            System.out.println("error borrando, rollback");
            try{
                con.rollback();
            }
            catch(Exception ex){}
        }finally{
            try{
                con.setAutoCommit(true);
            }
            catch(Exception e){}
        }
    }
}