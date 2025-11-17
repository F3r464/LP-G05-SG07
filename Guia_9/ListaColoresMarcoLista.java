import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ListaColoresMarcoLista extends JFrame implements ActionListener {
    JComboBox<String> listaColores;
    JPanel panel;
    public ListaColoresMarcoLista(){
        super("Alarcon, Quispe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        String[] colores={"Blanco", "Rojo", "Verde", "Azul", "Amarillo", "Cyan", "Magenta", "Gris", "Negro"};
        listaColores=new JComboBox<>(colores);
        listaColores.addActionListener(this);
        panel.add(listaColores);
        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String opc=(String) listaColores.getSelectedItem();
        switch (opc) {
            case "Blanco":
                panel.setBackground(Color.WHITE);
                break;
            case "Rojo":
                panel.setBackground(Color.RED);
                break;
            case "Verde":
                panel.setBackground(Color.GREEN);
                break;
            case "Azul":
                panel.setBackground(Color.BLUE);
                break;
            case "Amarillo":
                panel.setBackground(Color.YELLOW);
                break;
            case "Cyan":
                panel.setBackground(Color.CYAN);
                break;
            case "Magenta":
                panel.setBackground(Color.MAGENTA);
                break;
            case "Gris":
                panel.setBackground(Color.GRAY);
                break;
            case "Negro":
                panel.setBackground(Color.BLACK);
                break;
        }
    }
    public static void main(String[] args) {
        new ListaColoresMarcoLista();
    }
}
