import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Producto{
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public int getStock(){
        return stock;
    }
    public String getCategoria(){ 
        return categoria;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
    public void setCategoria(String categoria){
        this.categoria =categoria;
    }
}

public class AppProducto extends JFrame implements ActionListener {
    JTextField nombreF, precioF, stockF, categoriaF;
    JLabel infoProducto;
    JButton actualizarBtn;
    Producto producto;
    public AppProducto() {
        super("Alarcon, Quispe");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        producto=new Producto(" ", 0, 0, " ");
        JPanel form =new JPanel(new GridLayout(5, 2, 5, 5));

        form.add(new JLabel("Nombre:"));
        nombreF = new JTextField();
        form.add(nombreF);

        form.add(new JLabel("Precio:"));
        precioF =new JTextField();
        form.add(precioF);

        form.add(new JLabel(" Stock:"));
        stockF = new JTextField();
        form.add(stockF);

        form.add(new JLabel("Categoria:"));
        categoriaF = new JTextField();
        form.add(categoriaF);

        actualizarBtn = new JButton("Actualizar Producto");
        form.add(actualizarBtn);

        add(form, BorderLayout.NORTH);
        infoProducto = new JLabel("Producto sin registrar", SwingConstants.CENTER);
        infoProducto.setOpaque(true);
        infoProducto.setBackground(Color.LIGHT_GRAY);
        add(infoProducto, BorderLayout.CENTER);

        actualizarBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try {
            String nombre=nombreF.getText();
            double precio=Double.parseDouble(precioF.getText());
            int stock =Integer.parseInt(stockF.getText());
            String categoria =categoriaF.getText();

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setCategoria(categoria);


            String texto = "<html><center>"
                    +"Producto actualizado:<br>"
                    +"Nombre: "+producto.getNombre()+"<br>"
                    +"Precio: "+producto.getPrecio()+"<br>"
                    +"Stock: "+producto.getStock()+"<br>"
                    +"Categoria: "+producto.getCategoria()
                    +"</center></html>";
            infoProducto.setText(texto);
            JOptionPane.showMessageDialog(this,"bien","Alarcon, Quispe",JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Error","Alarcon, Quispe",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args){
        new AppProducto();
    }
}