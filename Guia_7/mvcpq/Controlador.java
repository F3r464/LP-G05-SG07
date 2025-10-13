class Controlador{
    private Modelo modelo;
    private Vista vista;
    public Controlador(Modelo m,Vista v){
        modelo=m;
        vista=v;
    }
    public void iniciar(){
        int op;
        do{
            op=vista.menu();
            switch(op){
                case 1:
                    vista.mostrarEmpleados(modelo.getLista());
                    break;
                case 2:
                    Empleado e=vista.nuevoEmpleado();
                    modelo.agregarEmpleado(e);
                    break;
                case 3:
                    int n=vista.pedirNumero();
                    vista.mostrarEmpleado(modelo.buscarEmpleado(n));
                    break;
                case 4:
                    int d=vista.pedirNumero();
                    modelo.eliminarEmpleado(d);
                    break;
                case 5:
                    vista.mensaje("saliendo ... .. .");
                    break;
                default:
                    vista.mensaje("opcion invalida");
            }
        }while(op!=5);
    }
}
