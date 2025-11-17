import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
public class E2GridLayout extends JFrame implements ActionListener{
    JButton b1, b2, b3, b4, b5, b6;
    JPanel panel;
    boolean estado=true;

    public E2GridLayout(){
        super("Alarcon, Quispe"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        //setLocationRelativeTo(null);

        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6"); 
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        panel=new JPanel(new GridLayout(2, 3, 5, 5));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);

        add(panel);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        //JButton boton=(JButton) e.getSource();
        //e.getSource==boton;
        if(estado){
            panel.setLayout(new GridLayout(2, 3, 5, 5));
            panel.add(b1);
            panel.add(b2);
            panel.add(b4);
            panel.add(b3);
            panel.add(b5);
            panel.add(b6);
            estado = false;
        }else{
            panel.setLayout(new GridLayout(3, 2, 5, 5));
            panel.add(b1);
            panel.add(b2);
            panel.add(b3);
            panel.add(b4);
            panel.add(b5);
            panel.add(b6);
            estado = true;
        }
        panel.revalidate();
        panel.repaint();
    }
    
    public static void main(String[] args) {
        new E2GridLayout();
    }
}