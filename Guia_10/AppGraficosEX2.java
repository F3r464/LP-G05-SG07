import javax.swing.*;
import java.awt.*;
public class AppGraficosEX2 extends JFrame{
    public AppGraficosEX2(){
        setTitle("Demostracion de figuras");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);

        g.drawLine(20,60,100,60);

        g.drawRect(20,80,100,50);
        g.fillRect(140,80,100,50);

        g.drawRoundRect(20,150,100,50,20,20);
        g.fillRoundRect(140,150,100,50,20,20);

        g.drawOval(20,220,80,60);
        g.fillOval(140,220,80,60);

        g.drawArc(20,300,80,60,0,180);
        g.fillArc(140,300,80,60,45,270);

        int[] xp={300,350,250};
        int[] yp={100,200,200};
        g.drawPolygon(xp,yp,3);

        int[] xpf={420,470,370};
        int[] ypf={100,200,200};
        g.fillPolygon(xpf,ypf,3);

        int[] x2={270,340,250,360,270};
        int[] y2={280,260,250,230,200};      
        g.drawPolyline(x2,y2,5);

        g.drawString("Hola Mundo",250,350);

        char[] palabra={'a','e','i','o','u','?','!'};
        g.drawChars(palabra,0,4,250,380);

        Image img=Toolkit.getDefaultToolkit().getImage("foto.png");
        g.drawImage(img,250,20,80,80,this);

        g.clearRect(350,300,50,50);

        g.copyArea(20,80,100,50,200,0);
    }
    public static void main(String[]args){
        new AppGraficosEX2();
    }
}
