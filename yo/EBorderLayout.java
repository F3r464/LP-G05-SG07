import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class EBorderLayout extends JFrame implements ActionListener {
    JButton norte, sur, este, oeste, centro;
    public EBorderLayout() {
        super("Alarcon, Quispe");
        setLayout(new BorderLayout());
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        norte=new JButton("NORTE");
        sur=new JButton("SUR");
        este=new JButton("ESTE");
        oeste=new JButton("OESTE");
        centro=new JButton("CENTRO");
        norte.addActionListener(this);
        sur.addActionListener(this);
        este.addActionListener(this);
        oeste.addActionListener(this);
        centro.addActionListener(this);
        add(norte, BorderLayout.NORTH);
        add(sur, BorderLayout.SOUTH);
        add(este, BorderLayout.EAST);
        add(oeste, BorderLayout.WEST);
        add(centro, BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        //JButton boton=(JButton) e.getSource();
        if(e.getSource()==norte){
            sur.setVisible(true);
            este.setVisible(true);
            oeste.setVisible(true);
            centro.setVisible(true);
            norte.setVisible(false);
        }else if(e.getSource()==sur){
            sur.setVisible(false);
            este.setVisible(true);
            oeste.setVisible(true);
            centro.setVisible(true);
            norte.setVisible(true);
        }else if(e.getSource()==este){
            sur.setVisible(true);
            este.setVisible(false);
            oeste.setVisible(true);
            centro.setVisible(true);
            norte.setVisible(true);
        }else if(e.getSource()==oeste){
            sur.setVisible(true);
            este.setVisible(true);
            oeste.setVisible(false);
            centro.setVisible(true);
            norte.setVisible(true);
        }else if(e.getSource()==centro){
            sur.setVisible(true);
            este.setVisible(true);
            oeste.setVisible(true);
            centro.setVisible(false);
            norte.setVisible(true);
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new EBorderLayout();
    }
}
