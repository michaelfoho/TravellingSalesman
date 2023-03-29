import javax.swing.*;
import java.awt.*;

public class panel extends JPanel {

    Image desert,castle,trap,wall,market;

    panel(){


        trap = new ImageIcon("img/trap.png").getImage();
        wall = new ImageIcon("img/wall.png").getImage();
        market = new ImageIcon("img/market.png").getImage();
        this.setPreferredSize(new Dimension(750,750));
    }
    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        castle = new ImageIcon("img/castle.png").getImage();
        g2D.drawImage(castle,375,375,null);

        desert = new ImageIcon("img/desert.png").getImage();
        g2D.drawImage(desert,0,0,null);

        //g2D.drawImage(trap,0,0,null);
        //g2D.drawImage(wall,0,0,null);
        //g2D.drawImage(market,0,0,null);

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));//thikness
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
            }
        }

    }
}
