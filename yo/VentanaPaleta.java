import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VentanaPaleta extendsx JFrame implements ActionListener{
    JPanel panelColores;
    JLabel etiqueta;
    Color[] colores={Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA,Color.PINK,Color.GRAY,Color.LIGHT_GRAY,Color.BLACK,Color.WHITE};
    String[] nombres={"Rojo","Naranja","Amarillo","Verde","Cyan","Azul","Magenta","Rosa","Gris","Gris claro","Negro","Blanco"};
    public VentanaPaleta(){
        super("GridLayout");
        setSize(400, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        etiqueta = new JLabel("Selecciona color", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 16));
        add(etiqueta, BorderLayout.NORTH);

        panelColores=new JPanel();
        panelColores.setLayout(new GridLayout(3, 4, 5, 5));
        for(int i=0; i < colores.length; i++){
            JButton boton=new JButton();
            boton.setBackground(colores[i]);
            boton.setActionCommand(nombres[i]);
            boton.addActionListener(this);
            boton.setToolTipText(nombres[i]);
            panelColores.add(boton);
        }
        add(panelColores, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String color=e.getActionCommand();
        etiqueta.setText("Color: " + color);
        for(int i=0; i < nombres.length; i++){
            if (color.equals(nombres[i])) {
                getContentPane().setBackground(colores[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new VentanaPaleta();
    }
}
