import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContadorClicks extends JFrame {
    private int izq = 0, der = 0, cen = 0;
    private JLabel info;
    private Timer temporizador;
    private String ultimoMensaje = "Haz clic para comenzar";

    public ContadorClicks() {
        super("Contador de Clics del Mouse");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        info = new JLabel(ultimoMensaje, SwingConstants.CENTER);
        info.setFont(new Font("Arial", Font.BOLD, 14));
        add(info);

        temporizador = new Timer(1000, e -> reiniciarContadores());
        temporizador.setRepeats(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    izq++;
                    ultimoMensaje = String.format("Clics IZQ: %d", izq);
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    der++;
                    ultimoMensaje = String.format("Clics DER: %d", der);
                } else if (SwingUtilities.isMiddleMouseButton(e)) {
                    cen++;
                    ultimoMensaje = String.format("Clics CENTRAL: %d", cen);
                }

                info.setText(String.format(
                        "<html>%s<br>Izquierdo: %d<br>Derecho: %d<br>Central: %d</html>",
                        ultimoMensaje, izq, der, cen));

                temporizador.restart();
            }
        });

        setVisible(true);
    }

    private void reiniciarContadores() {
        izq = der = cen = 0;
        info.setText("<html>" + ultimoMensaje + "<br><i>(Contadores reiniciados tras 1s sin clics)</i></html>");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContadorClicks::new);
    }
}
