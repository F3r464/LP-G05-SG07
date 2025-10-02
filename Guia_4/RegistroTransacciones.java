import java.util.*;  
import java.time.*;
class DatosInvalidosException extends Exception{  
    DatosInvalidosException(String msg){  
        super(msg);  
    }
}
class PrecioInferiorException extends Exception{  
    PrecioInferiorException(String msg){  
        super(msg);  
    }
}
class ContratoInvalidoException extends Exception{
    ContratoInvalidoException(String msg){
        super(msg);
    }
}
class PagoInvalidoException extends Exception{
    PagoInvalidoException(String msg){
        super(msg);
    }
}
class Propiedad{  
    String direccion;
    double precio;
    double tamaño;
    Propiedad(String direccion,double precio,double tamaño)throws DatosInvalidosException{
        if(precio <= 0 || tamaño <= 0){
            throw new DatosInvalidosException("numero positivos");
        }
        this.direccion=direccion;  
        this.precio=precio;  
        this.tamaño=tamaño;
    }
    public String toString(){  
        return direccion+" - s/"+precio+" - "+tamaño+" m2";  
    }  
}
class TransaccionInmobiliaria{  
    int id;  
    Propiedad propiedad;  
    double precioTransaccion;
    TransaccionInmobiliaria(int id,Propiedad propiedad,double precioTransaccion)throws PrecioInferiorException{  
        if(precioTransaccion < propiedad.precio){  
            throw new PrecioInferiorException("precio transaccion inferior");
        } 
        this.id=id;  
        this.propiedad=propiedad;  
        this.precioTransaccion=precioTransaccion;  
    }
    public String toString(){  
        return "transaccion "+id+" -> "+propiedad+" vendido en s/"+precioTransaccion;  
    }  
}  
class ContratoAlquiler{  
    int duracionMeses;  
    double monto;
    void setContrato(int duracionMeses,double monto)throws ContratoInvalidoException{  
        if(duracionMeses <=0|| monto<=0){  
            throw new ContratoInvalidoException("valores validos, corrupcion corrupcion");  
        }  
        this.duracionMeses=duracionMeses;  
        this.monto=monto;  
    }
    public String toString(){  
        return "contrato: "+duracionMeses+" meses por s/"+monto;  
    }  
}
class HistorialDePagos{  
    ArrayList<String> pagos=new ArrayList<>();
    void registrarPago(LocalDate fecha,double monto)throws PagoInvalidoException{  
        if(fecha.isAfter(LocalDate.now())){
            throw new PagoInvalidoException("no se acepta ir al futuro (en fechas)");  
        }
        if(monto <= 0){
            throw new PagoInvalidoException("monto invalido");  
        }  
        pagos.add("fecha: "+fecha+" monto: s/"+monto);  
    }  

    void mostrarPagos(){  
        if(pagos.isEmpty()){  
            System.out.println("no hay pago registrados");  
        }else{  
            for(String p:pagos){  
                System.out.println(p);  
            }  
        }  
    }  
}
public class RegistroTransacciones{  
    public static void main(String[]args){  
        try{  
            Propiedad p1=new Propiedad("av calle nueva",100000,120);  
            System.out.println("la propiedad salio del suelo de la nada :/ : "+p1);  
            TransaccionInmobiliaria t1=new TransaccionInmobiliaria(1,p1,110000);  
            System.out.println("transaccion exitosa: "+t1);  
            ContratoAlquiler c1=new ContratoAlquiler();  
            c1.setContrato(12,500);  
            System.out.println(c1);  
            HistorialDePagos h1=new HistorialDePagos();  
            h1.registrarPago(LocalDate.now(),500);  
            h1.mostrarPagos();  
        }catch(DatosInvalidosException | PrecioInferiorException | ContratoInvalidoException | PagoInvalidoException e){  
            System.out.println("error: "+e.getMessage());  
        }  
    }  
}  
