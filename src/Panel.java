import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Image desert,castle,trap,wall,market,treasure,loot;

    Panel(){

        desert = new ImageIcon("img/desert.png").getImage();
        castle = new ImageIcon("img/castle.png").getImage();
        trap = new ImageIcon("img/trap.png").getImage();
        wall = new ImageIcon("img/wall.png").getImage();
        market = new ImageIcon("img/market.png").getImage();
        treasure = new ImageIcon("img/treasure.png").getImage();
        loot = new ImageIcon("img/loot.png").getImage();

        this.setPreferredSize(new Dimension(750,750));
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(desert,0,0,null);
        g2D.drawImage(castle,5*75,372,null);
        g2D.drawImage(wall,3*75,7*75,null);
        g2D.drawImage(wall,4*75,2*75,null);
        g2D.drawImage(trap,6*75,7*75,null);
        g2D.drawImage(trap,2*75,2*75,null);
        g2D.drawImage(trap,8*75,4*75,null);
        g2D.drawImage(market,8*75,2*75,null);
        g2D.drawImage(market,7*75,6*75,null);
        g2D.drawImage(market,1*75,9*75,null);
        g2D.drawImage(market,8*75,8*75,null);
        g2D.drawImage(market,3*75,4*75,null);
        g2D.drawImage(treasure,9*75,7*75,null);
        g2D.drawImage(treasure,1*75,0*75,null);
        g2D.drawImage(loot,1*75,6*75,null);
        g2D.drawImage(loot,6*75,1*75,null);


        g2D.setStroke(new BasicStroke(5));//thikness
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
            }
        }
    }
}
