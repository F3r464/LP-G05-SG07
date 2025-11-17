import java.awt.BorderLayout;
import javax.swing.*;

public class BorderLayoutDemo extends JFrame {
    
    public BorderLayoutDemo() {
        super("Alarcon, Quispe");
        setLayout(new BorderLayout());
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JButton("NORTE"), BorderLayout.NORTH);
        add(new JButton("SUR"), BorderLayout.SOUTH);
        add(new JButton("ESTE"), BorderLayout.EAST);
        add(new JButton("OESTE"), BorderLayout.WEST);
        add(new JButton("CENTRO"), BorderLayout.CENTER);


    }
    public static void main(String[] args) {
        BorderLayoutDemo ventana = new BorderLayoutDemo();
        ventana.setVisible(true);
    }
}
