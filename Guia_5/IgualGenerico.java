public class IgualGenerico{
    public static <T> boolean esIgualA(T obj1, T obj2){
        return (obj1==null)?(obj2==null):obj1.equals(obj2);
    }
    public static void main(String[]args){
        Integer num1=10;
        Integer num2=10;
        System.out.println("Comparando Integer: "+esIgualA(num1, num2));
        String str1="Hola";
        String str2="Hola";
        System.out.println("Comparando String: "+esIgualA(str1, str2));
        Object obj1=new Object();
        Object obj2=new Object();
        System.out.println("Comparando Object: "+esIgualA(obj1, obj2));
        System.out.println("Comparando diferentes tipos: "+esIgualA(num1, str1));
        System.out.println("Comparando null: "+esIgualA(null, null));
        System.out.println("Comparando null & Integer: "+esIgualA(null, num1));
    }
}
