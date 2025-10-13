import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
public class TestFile {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre del archivo: ");
        Path ruta=Paths.get(sc.nextLine());
        
        if (Files.exists(ruta)){
            System.out.printf("%s existe%n",ruta.getFileName());
            System.out.printf("%s un directorio%n", Files.isDirectory(ruta)?"Es":"No es");
            System.out.printf("%s una ruta absoluta%n", ruta.isAbsolute()?"Es":"No es");
            BasicFileAttributes attrs=Files.readAttributes(ruta, BasicFileAttributes.class);
            System.out.printf("Fecha de última modificación: %s%n", attrs.lastModifiedTime());
            System.out.printf("Tamaño: %d bytes%n", attrs.size());
            System.out.printf("Ruta: %s%n", ruta);
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());
            
            if (Files.isDirectory(ruta)){
                System.out.printf("%nContenido del directorio:%n");
                try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)){
                    for (Path p:flujoDirectorio){
                        System.out.println(p);
                    }
                }
            }
        } else {
            System.out.printf("%s no existe%n", ruta);
        }
    }
}
