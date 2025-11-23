import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.font.*;
public class AppGraficos2D extends JFrame{
    Image img;
    public AppGraficos2D(){
        super("Ejemplos Graphics2D");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        img=Toolkit.getDefaultToolkit().getImage("foto.png");
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Shape rect=new Rectangle2D.Float(50,100,100,60);
        g2.setStroke(new BasicStroke(3));
        g2.draw(rect);

        Shape oval=new Ellipse2D.Float(200,100,100,60);
        g2.setPaint(Color.orange);
        g2.fill(oval);

        g2.setPaint(Color.red);
        g2.rotate(Math.toRadians(20),150,300);
        Shape r2=new RoundRectangle2D.Float(100,250,150,80,20,20);
        g2.draw(r2);

        g2.setPaint(new Color(0,0,255,120));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        Shape circ=new Ellipse2D.Float(140,260,150,150);
        g2.fill(circ);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1));

        g2.setTransform(new AffineTransform());
        g2.setPaint(Color.black);
        g2.drawString("hola",50.0f,50.0f);

        g2.translate(350,50);
        g2.shear(0.3,0);
        g2.scale(1.2,1.2);
        Shape poly=new Polygon(new int[]{0,40,20},new int[]{0,0,40},3);
        g2.setPaint(Color.green);
        g2.fill(poly);

        g2.setTransform(new AffineTransform());
        AffineTransform t=new AffineTransform();
        t.translate(300,350);
        t.rotate(Math.toRadians(45));
        t.scale(0.5,0.5);
        g2.drawImage(img,t,this);

        g2.setTransform(new AffineTransform());
        g2.setBackground(Color.yellow);
        g2.clearRect(400,400,80,50);
    }
    public static void main(String[]a){
        new AppGraficos2D();
    }
}
