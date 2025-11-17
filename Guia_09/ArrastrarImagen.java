import javax.swing.*;
import java.awt.event.*;

public class ArrastrarImagen extends JFrame {
    JLabel imagen;
    int x, y;

    public ArrastrarImagen() {
        super("Arrastrar imagen");
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icono = new ImageIcon("insecto1.png");
        imagen = new JLabel(icono);
        imagen.setBounds(100, 100, 128, 128);

        imagen.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        imagen.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int nuevoX = imagen.getX() + e.getX() - x;
                int nuevoY = imagen.getY() + e.getY() - y;
                imagen.setLocation(nuevoX, nuevoY);
            }
        });

        add(imagen);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArrastrarImagen());
    }
}
