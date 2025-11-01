class RegistroModelo{
    private Registro<Integer> registroActual;
    public RegistroModelo(String nombre,int id){
        registroActual=new Registro<Integer>(nombre,id);
    }
    public Registro<Integer> obtenerRegistro(){
        return registroActual;
    }
}