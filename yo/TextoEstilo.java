import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextoEstilo extends JFrame implements ItemListener {
    JTextField texto;
    JCheckBox negrita, cursiva;

    public TextoEstilo(){
        super("Alarcon, Quispe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 125);
        setLayout(new BorderLayout(10, 10));

        texto=new JTextField("");
        texto.setFont(new Font("Arial", Font.PLAIN, 28));
        add(texto, BorderLayout.CENTER);

        JPanel panelOpciones=new JPanel(new FlowLayout());
        negrita=new JCheckBox("Negrita");
        cursiva=new JCheckBox("Cursiva");
        negrita.addItemListener(this);
        cursiva.addItemListener(this);
        panelOpciones.add(negrita);
        panelOpciones.add(cursiva);
        add(panelOpciones, BorderLayout.SOUTH);
        setVisible(true);
    }


    public void itemStateChanged(ItemEvent e){
        int estilo=Font.PLAIN;
        if(negrita.isSelected()){
            estilo|=Font.BOLD;
        }
        if(cursiva.isSelected()){
            estilo|=Font.ITALIC;
        }
        texto.setFont(new Font("Arial", estilo, 28));
    }

    public static void main(String[] args){
        new TextoEstilo();
    }
}
