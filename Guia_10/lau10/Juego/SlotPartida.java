import javax.swing.*;

public class SlotPartida extends JButton {

    public SlotPartida(Partida p) {

        setLayout(null);
        setBorderPainted(false);
        setContentAreaFilled(false);

        setIcon(new ImageIcon("assets/slot_base.png"));
        setRolloverIcon(new ImageIcon("assets/slot_base_hover.png"));
        setSize(600, 140);

        if (p != null) {

            JLabel nombre = new JLabel(new ImageIcon("assets/slot_nombre.png"));
            nombre.setBounds(40, 20, 400, 40);
            add(nombre);

            JLabel tiempo = new JLabel(new ImageIcon("assets/slot_tiempo.png"));
            tiempo.setBounds(40, 65, 300, 40);
            add(tiempo);

            JLabel escenario = new JLabel(new ImageIcon("assets/slot_escenario.png"));
            escenario.setBounds(260, 65, 300, 40);
            add(escenario);

        } else {
            JLabel vacio = new JLabel(new ImageIcon("assets/slot_vacio.png"));
            vacio.setBounds(230, 45, 200, 40);
            add(vacio);
        }
    }
}
