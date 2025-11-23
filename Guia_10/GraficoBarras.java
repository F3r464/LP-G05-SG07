import javax.swing.*;
import java.awt.*;
public class GraficoBarras extends JFrame{
    private String[] productos ={"telf", "lapt", "audi", "watch", "tabl"};
    private int[] ventas={40, 90, 120, 60, 150};
    public GraficoBarras(){
        setTitle("alarcon, quispe");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PanelBarras());
        setVisible(true);
    }

    class PanelBarras extends JPanel {
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            int margenIzq=50;
            int margenInf=50;
            int anchoBarra=50;
            int espacio=20;
            int alturaMax=200;

            int maxVenta=0;
            for(int v:ventas){
                if(v>maxVenta) maxVenta=v;
            }
            for(int i=0;i<productos.length;i++){
                int alto=(int)((double)ventas[i]/maxVenta*alturaMax);
                int x=margenIzq+i*(anchoBarra+espacio);
                int y=getHeight()-margenInf-alto;

                g2.setColor(Color.blue);
                g2.fillRect(x,y,anchoBarra,alto);

                g2.setColor(Color.black);
                g2.drawString(String.valueOf(ventas[i]),x+10,y-5);
                g2.drawString(productos[i],x+15,getHeight()-margenInf+15);
            }

            g2.drawLine(margenIzq,getHeight()-margenInf,margenIzq,getHeight()-margenInf-alturaMax);
            g2.drawString("Ventas",margenIzq-40,getHeight()-margenInf-alturaMax);
        }
    }
    public static void main(String[]args){
        new GraficoBarras();
    }
}
