import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
public class Sonidos extends JFrame implements ActionListener{
    JButton btnAplausos, btnCampana, btnExplosion;
    Clip clip;
    public Sonidos(){
        super("Alarcon, Quispe");
        setSize(350, 200);
        setLayout(new GridLayout(3, 1, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAplausos=new JButton("Aplausos");
        btnCampana=new JButton("Campana");
        btnExplosion=new JButton("Explosión");

        btnAplausos.addActionListener(this);
        btnCampana.addActionListener(this);
        btnExplosion.addActionListener(this);

        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);
        setVisible(true);
    }
    private void reproducirSonido(String archivo){
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            File soundFile = new File(archivo);
            AudioInputStream audio=AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,"Error"+archivo,"Alarcon, Quispe",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource()==btnAplausos) {
          	
            reproducirSonido("aplausos.wav");
        }
        else if(e.getSource()==btnCampana){
   
            reproducirSonido("campana.wav");
        }
        else if (e.getSource()==btnExplosion){
     
            reproducirSonido("explosion.wav");
        }
    }
    public static void main(String[] args){
        new Sonidos();
    }
}
