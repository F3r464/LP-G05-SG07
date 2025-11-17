import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EFLowLayout extends JFrame implements ActionListener{
    JButton boton1, boton2, boton3;
    JPanel contenedor;
    public EFLowLayout(){
        super("Alarcon, Quispe");
        setLayout(new BorderLayout());
        setSize(1000, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contenedor=new JPanel(new FlowLayout());
        boton1=new JButton("Boton 1");
        boton2=new JButton("Boton 2");
        boton3=new JButton("Boton 3");
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        contenedor.add(boton1);
        contenedor.add(boton2);
        contenedor.add(boton3);
        add(contenedor, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==boton1){
            JOptionPane.showMessageDialog(this,"Izquierda.","Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
            add(contenedor, BorderLayout.WEST);
        }else if(e.getSource()==boton2){
            JOptionPane.showMessageDialog(this,"Centro.","Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
            add(contenedor, BorderLayout.CENTER);
        }else if(e.getSource()==boton3){
            JOptionPane.showMessageDialog(this,"Dereecha","Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
            add(contenedor, BorderLayout.EAST);
        }
        revalidate();
        repaint();
    }
    public static void main(String[] args){
        new EFLowLayout();
    }
}