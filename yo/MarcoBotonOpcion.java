import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarcoBotonOpcion extends JFrame implements ActionListener {
    JTextField texto;
    JRadioButton simple, negrita, cursiva, negritaCursiva;
    ButtonGroup grupo;
    JPanel botones;
    public MarcoBotonOpcion(){
        super("Alarcon, Quispe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 120);
        setLayout(new BorderLayout());

        texto=new JTextField("");
        texto.setFont(new Font("Arial", Font.PLAIN, 28));
        add(texto, BorderLayout.CENTER);
      
        botones=new JPanel(new FlowLayout());
        simple = new JRadioButton("Simple", true);
        negrita = new JRadioButton("Negrita");
        cursiva = new JRadioButton("Cursiva");
        negritaCursiva = new JRadioButton("Negrita|Cursiva");

        grupo = new ButtonGroup();
        grupo.add(simple);
        grupo.add(negrita);
        grupo.add(cursiva);
        grupo.add(negritaCursiva);
        simple.addActionListener(this);
        negrita.addActionListener(this);
        cursiva.addActionListener(this);
        negritaCursiva.addActionListener(this);
        botones.add(simple);
        botones.add(negrita);
        botones.add(cursiva);
        botones.add(negritaCursiva);
        add(botones, BorderLayout.SOUTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        int estilo = Font.PLAIN;

        if (negrita.isSelected()) {
            estilo = Font.BOLD;
        } else if (cursiva.isSelected()) {
            estilo = Font.ITALIC;
        } else if (negritaCursiva.isSelected()) {
            estilo = Font.BOLD | Font.ITALIC;
        } else {
            estilo = Font.PLAIN;
        }

        texto.setFont(new Font("Arial", estilo, 28));
    }

    public static void main(String[] args) {
        new MarcoBotonOpcion();
    }
}
