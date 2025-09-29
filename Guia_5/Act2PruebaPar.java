public class Act2PruebaPar {
    public static void main(String[] args) {
 
        Par<Integer, String> par1 = new Par<>(1, "Uno");
        Par<Integer, String> par2 = new Par<>(1, "Uno");
        Par<Integer, String> par3 = new Par<>(2, "Dos");
 
        System.out.println("Par 1: " + par1);
        System.out.println("Par 2: " + par2);
        System.out.println("Par 3: " + par3);
 
        System.out.println("\n¿Par1 es igual a Par2? " + par1.esIgual(par2));
        System.out.println("¿Par1 es igual a Par3? " + par1.esIgual(par3));
    }
}
