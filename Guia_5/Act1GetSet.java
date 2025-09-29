public class Par<F, S> {
    private F primero;
    private S segundo;
 
    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }
 
    public F getPrimero() {
        return primero;
    }
 
    public S getSegundo() {
        return segundo;
    }
 
    public void setPrimero(F primero) {
        this.primero = primero;
    }
 
    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }
 
    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
 
    public boolean esIgual(Par<F, S> otroPar) {
        return this.primero.equals(otroPar.getPrimero()) &&
               this.segundo.equals(otroPar.getSegundo());
    }
}
public class Act1GetSet{
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 25);
        System.out.println("Par inicial: " + par1);
        System.out.println("Primero: " + par1.getPrimero());
        System.out.println("Segundo: " + par1.getSegundo());
        par1.setPrimero("Años");
        par1.setSegundo(2012);
        System.out.println("Par modificado: " + par1);
    }
}
