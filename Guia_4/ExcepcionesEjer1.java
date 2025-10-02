import java.io.*;
class VocalException extends Exception{
    VocalException(String msg){
        super(msg);
    }
}

class NumeroException extends Exception{
    NumeroException(String msg){
        super(msg);
    }
}

class BlancoException extends Exception{
    BlancoException(String msg){
        super(msg);
    }
}

class SalidaException extends Exception{
    SalidaException(String msg){
        super(msg);
    }
}
class LeerEntrada{
    private char c;
    char getChar() throws IOException{
        c=(char)System.in.read();
        return c;
    }
}
public class ExcepcionesEjer1{
    LeerEntrada lector=new LeerEntrada();
    void procesar() throws Exception{
        char ch=lector.getChar();
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            throw new VocalException("es una vocal");
        }else if(Character.isDigit(ch)){
            throw new NumeroException("es un numero");
        }else if(ch==' '||ch=='\n'){
            throw new BlancoException("es un espacio en blanco");
        }else if(ch=='x'||ch=='X'){
            throw new SalidaException("salida detectada");
        }
    }
    public static void main(String[] args){
        ManejoCaracteres app=new ManejoCaracteres();
        System.out.println("ingrese caracteres, use x para salir:");
        while(true){
            try{
                app.procesar();
            }catch(VocalException e){
                System.out.println("vocal detectada");
            }catch(NumeroException e){
                System.out.println("numero detectado");
            }catch(BlancoException e){
                System.out.println("espacio en blanco detectado");
            }catch(SalidaException e){
                System.out.println("salida del programa");
                break;
            }catch(Exception e){
                System.out.println("error: "+e.getMessage());
            }
        }
    }
}