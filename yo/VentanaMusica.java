import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaMusica extends JFrame implements ActionListener{
    JLabel estado, portada, abajo;
    JButton play, pause, stop, volumen;
    public VentanaMusica() {
        super("BorderLayout");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo=new JLabel("Canción: Aishitetanoni-Materu", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        portada=new JLabel(new ImageIcon("musica.png"));
        portada.setHorizontalAlignment(SwingConstants.CENTER);
        add(portada, BorderLayout.CENTER);

        JPanel abajo=new JPanel(new BorderLayout());
        JPanel controles = new JPanel();
        play=new JButton("▶️ Play");
        pause=new JButton("⏸️ Pause");
        stop=new JButton("⏹️ Stop");
        controles.add(play);
        controles.add(pause);
        controles.add(stop);

        estado=new JLabel("Estado: Esperando accion...", SwingConstants.CENTER);
        estado.setOpaque(true);
        estado.setBackground(Color.LIGHT_GRAY);

        abajo.add(controles, BorderLayout.NORTH);
        abajo.add(estado, BorderLayout.SOUTH);

        add(abajo,BorderLayout.SOUTH);

        JPanel volum=new JPanel();
        volumen=new JButton("🔊 Volumen");
        volum.add(volumen, BorderLayout.CENTER);
        volum.setBorder(BorderFactory.createEmptyBorder(80, 0, 80, 0));
        add(volum, BorderLayout.EAST);

        add(new JLabel("Spotifi", SwingConstants.CENTER), BorderLayout.WEST);



        play.addActionListener(this);
        pause.addActionListener(this);
        stop.addActionListener(this);
        volumen.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==play){
            estado.setText("Reproduciendo musica");
            estado.setBackground(Color.GREEN);
        }else if(e.getSource()==pause){
            estado.setText("Música en pausa");
            estado.setBackground(Color.YELLOW);
        }else if(e.getSource()==stop){
            estado.setText("Reproducción detenida");
            estado.setBackground(Color.RED);
        }else if(e.getSource()==volumen){
            estado.setBackground(Color.ORANGE);
        }
    }
    public static void main(String[] args) {
        new VentanaMusica();
    }
}
