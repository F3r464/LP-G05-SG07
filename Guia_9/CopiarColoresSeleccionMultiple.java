import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CopiarColoresSeleccionMultiple extends JFrame implements ActionListener {
    JList<String> listaColores;
    JButton botonCopiar;
    JTextArea cuadroResultado;
    public CopiarColoresSeleccionMultiple() {
        super("Alarcon, Quispe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        String[] colores = {"Blanco", "Rojo", "Verde", "Azul", "Amarillo", "Cyan", "Magenta", "Gris", "Negro"};
        listaColores = new JList<>(colores);
        listaColores.setVisibleRowCount(5);
        listaColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scroll = new JScrollPane(listaColores);
        botonCopiar = new JButton("Copiar");
        botonCopiar.addActionListener(this);
        cuadroResultado=new JTextArea(5, 20);
        cuadroResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(cuadroResultado);

        add(new JLabel("Seleccione colores:"));
        add(scroll);
        add(botonCopiar);
        add(new JLabel("Colores copiados:"));
        add(scrollResultado);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        java.util.List<String> seleccionados=listaColores.getSelectedValuesList();
        StringBuilder texto = new StringBuilder();
        for (String color : seleccionados) {
            texto.append(color).append("\n");
        }
        cuadroResultado.setText(texto.toString());
    }
    public static void main(String[] args) {
        new CopiarColoresSeleccionMultiple();
    }
}
