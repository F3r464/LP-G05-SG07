import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaBotones extends JFrame implements ActionListener {
    JButton botonSimple, botonElegante;
    public PruebaBotones() {
        super("Alarcon, Quispe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 140);
        setLayout(new FlowLayout());
 
        botonSimple = new JButton("Boton Simple");
        botonSimple.addActionListener(this);
        ImageIcon icono = new ImageIcon("imagen.png");
        Image correjido=icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon nuevo= new ImageIcon(correjido);
        botonElegante = new JButton("Boton Elegante", nuevo);
        botonElegante.addActionListener(this);
        add(botonSimple);
        add(botonElegante);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==botonSimple) {
            JOptionPane.showMessageDialog(this, "Se presiono el Boton Simple");
        } else if (e.getSource()==botonElegante) {
            JOptionPane.showMessageDialog(this, "Se presiono el Boton Elegante");
        }
    }

    public static void main(String[] args) {
        new PruebaBotones();
    }
}
