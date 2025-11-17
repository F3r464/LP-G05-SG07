import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VentanaPlantas extends JFrame implements ActionListener{
    JButton cactus, tulipan, girasol;
    public VentanaPlantas(){
        super("Alarcon, Quispe");
        setLayout(new FlowLayout());
        setSize(1000, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo=new JLabel("Selecciona plantas:");
        add(titulo);
        cactus=new JButton("🌵 Cactus");
        tulipan=new JButton("🌷 Tulipan");
        girasol=new JButton("🌻 Girasol");
        cactus.addActionListener(this);
        tulipan.addActionListener(this);
        girasol.addActionListener(this);
        add(cactus);
        add(tulipan);
        add(girasol);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==cactus){
            JOptionPane.showMessageDialog(this,"adaptadas a climas secos mediante la acumulación de agua en sus gruesos tallos carnosos y la protección de sus espinas.","Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==tulipan){
            JOptionPane.showMessageDialog(this,"Estas flores fueron cultivadas en jardines imperiales y en áreas de gran belleza natural desde tiempos antiguos.","Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==girasol){
            JOptionPane.showMessageDialog(this,"El girasol gira siguiendo la luz del sol, fenómeno llamado heliotropismo.","Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String[] args){
        new VentanaPlantas();
    }
}