import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GifMarcoSeleccion extends JFrame implements ActionListener{
    JComboBox<String> listaOpciones;
    JLabel gifLabel;
    ImageIcon gif1, gif2, gif3;
    public GifMarcoSeleccion(){
        super("Alarcon, Quispe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new FlowLayout());

        String[] opciones={"gif 1", "gif 2", "gif 3"};
        listaOpciones=new JComboBox<>(opciones);
        listaOpciones.addActionListener(this);
        gif1 = escalarGif(new ImageIcon("gif1.gif"), 100, 100);
        gif2 = escalarGif(new ImageIcon("gif2.gif"), 100, 100);
        gif3 = escalarGif(new ImageIcon("gif3.gif"), 100, 100);
        gifLabel = new JLabel(gif1);
        add(listaOpciones);
        add(gifLabel);
        setVisible(true);
    }
    private ImageIcon escalarGif(ImageIcon icon, int ancho, int alto){
        Image imagen=icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        return new ImageIcon(imagen);
    }
    public void actionPerformed(ActionEvent e){
        int indice = listaOpciones.getSelectedIndex();
        switch (indice){
            case 0:
                gifLabel.setIcon(gif1);
                break;
            case 1:
                gifLabel.setIcon(gif2);
                break;
            case 2:
                gifLabel.setIcon(gif3);
                break;
        }
    }
    public static void main(String[] args) {
        new GifMarcoSeleccion();
    }
}
