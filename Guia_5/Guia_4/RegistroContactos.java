import java.util.*;
class Direccion{  
    String calle;
    String ciudad;
    String pais;
    Direccion(String calle,String ciudad,String pais){  
        this.calle=calle;
        this.ciudad=ciudad;  
        this.pais=pais;  
    }
    public String toString(){
        return calle+", "+ciudad+", "+pais;
    }
}
class Empresa{
    String nombre;  
    String rubro;
    Empresa(String nombre,String rubro){
        this.nombre=nombre;  
        this.rubro=rubro;  
    }  
    public String toString(){
        return nombre+" ("+rubro+")";  
    }  
}  
class Contacto{  
    String nombre;  
    String telefono;  
    String email;  
    Direccion direccion;
    Empresa empresa;
    Contacto(String nombre,String telefono,String email,Direccion direccion,Empresa empresa){  
        if(nombre==null || nombre.trim().isEmpty()){  
            throw new IllegalArgumentException("nombre invalido");  
        }  
        this.nombre=nombre;  
        this.telefono=telefono;  
        this.email=email;  
        this.direccion=direccion;  
        this.empresa=empresa;  
    }  
    public String toString(){  
        return nombre+" - "+telefono+" - "+email+" - "+direccion+" - "+empresa;  
    }  
}  
class GestorContactos{  
    ArrayList<Contacto> lista;  
    GestorContactos(){  
        lista=new ArrayList<>();  
    }
    void agregarContacto(Contacto c){  
        lista.add(c);  
    }
    void modificarContacto(String nombre,String nuevoTelefono,String nuevoEmail){  
        for(Contacto c:lista){  
            if(c.nombre.equalsIgnoreCase(nombre)){  
                c.telefono=nuevoTelefono;  
                c.email=nuevoEmail;  
                System.out.println("contacto modificado");  
                return;  
            }  
        }  
        throw new NoSuchElementException("contacto no encontrado");  
    }
    void eliminarContacto(String nombre){  
        Iterator<Contacto> it=lista.iterator();  
        while(it.hasNext()){  
            Contacto c=it.next();  
            if(c.nombre.equalsIgnoreCase(nombre)){  
                it.remove();  
                System.out.println("contacto eliminado");  
                return;  
            }  
        }  
        throw new NoSuchElementException("contacto no encontrado");  
    }
    void mostrarContactos(){  
        if(lista.isEmpty()){  
            System.out.println("no hay contactos");  
        }else{  
            for(Contacto c:lista){  
                System.out.println(c);  
            }  
        }  
    }  
}
public class GestionContactos{  
    public static void main(String[] args){  
        Scanner sc=new Scanner(System.in);  
        GestorContactos gestor=new GestorContactos();
        try{  
            Direccion d1=new Direccion("av. imaginaria","CUidada  cuidad","pais nuevo arequipa");  
            Empresa e1=new Empresa("tiendas paracaida co","arboles de navidad");  
            Contacto c1=new Contacto("trabajador 22222","403903","trabajador@gmail.com",d1,e1);  
            gestor.agregarContacto(c1);  
            System.out.println("contacto agregado");  
        }catch(IllegalArgumentException e){  
            System.out.println("error: "+e.getMessage());  
        }
        try{  
            gestor.modificarContacto("htrabajador acendido","9334223","nuevoente@gmail.com");  
        }catch(NoSuchElementException e){  
            System.out.println("error: "+e.getMessage());  
        }
        try{
            gestor.eliminarContacto("personanadaquever");  
        }catch(NoSuchElementException e){  
            System.out.println("error: "+e.getMessage());  
        }
        gestor.mostrarContactos();  
        sc.close();  
    }  
}  
