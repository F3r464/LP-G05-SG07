import javax.swing.*;
import java.awt.event.*;
public class AppEX1 extends JFrame implements ActionListener{
    JButton boton;
    Persona p;
    JTextField nombre,edad,sexo;
    public AppEX1(){
        super("fernando, quispe");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p=new Persona("fernando",20,"masculino");
        nombre=new JTextField(p.getNombre(),12);
        edad=new JTextField(String.valueOf(p.getEdad()),12);
        sexo=new JTextField(p.getSexo(),12);
        boton=new JButton("actualizar");
        boton.addActionListener(this);
        setLayout(new java.awt.FlowLayout());
        add(nombre);
        add(edad);
        add(sexo);
        add(boton);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boton){
            JOptionPane.showMessageDialog(this,"n:"+nombre.getText()+" e:"+edad.getText()+" s:"+sexo.getText(),"Alarcon, Quispe", JOptionPane.INFORMATION_MESSAGE);
        }
        p.setNombre(nombre.getText());
        try{
            p.setEdad(Integer.parseInt(edad.getText()));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"edad invalida","alarcon, Quispe", JOptionPane.ERROR_MESSAGE);
        }
        p.setSexo(sexo.getText());
        System.out.println(p.getNombre()+" "+p.getEdad()+" "+p.getSexo());
    }

    public static void main(String[]args){
        new AppEX1();
    }
}

class Persona{
    private String nombre;
    private int edad;
    private String sexo;
    public Persona(String n,int e,String s){
        nombre=n;
        edad=e;
        sexo=s;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String n){
        nombre=n;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int e){
        edad=e;
    }
    public String getSexo(){
        return sexo;
    }
    public void setSexo(String s){
        sexo=s;
    }
}
