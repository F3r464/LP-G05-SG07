import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class AppGraficoBarras extends JFrame {
    public AppGraficoBarras() {
        super("Alarcón, Quispe");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new PanelDibujo());
        setVisible(true);
    }
    public static void main(String[] args){
        new AppGraficoBarras();
    }
}
class PanelDibujo extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(Color.blue);
        Shape rect = new Rectangle2D.Float(50, 50, 80, 40);
        g2.draw(rect);

        AffineTransform mover =new AffineTransform();
        mover.translate(150, 0);
        g2.setColor(Color.red);
        g2.draw(mover.createTransformedShape(rect));

        AffineTransform escalar = new AffineTransform();
        escalar.scale(1.5, 1.5);
        g2.setColor(Color.green);
        g2.draw(escalar.createTransformedShape(rect));

        AffineTransform rotar = new AffineTransform();
        rotar.rotate(Math.toRadians(45), 300, 100);
        g2.setColor(Color.orange);
        g2.draw(rotar.createTransformedShape(rect));
    }
}
