class Registro<T> implements Serializable{
    private String nombre;
    private T identificador;
    public Registro(String nombre,T identificador){
        this.nombre=nombre;
        this.identificador=identificador;
    }
    public String getNombre(){
        return nombre;
    }
    public T getIdentificador(){
        return identificador;
    }
    public String toString(){
        return nombre+"- "+identificador;
    }
}