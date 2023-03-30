import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Image desert, castle, wall, treasure, loot;
    Image trap_1, trap_2;
    Image split_1, split_2, split_3;
    Image market_1, market_2, market_3, market_4;

    Panel() {

        desert = new ImageIcon("img/desert.png").getImage();
        //split_1 = new ImageIcon("img/split_1.png").getImage();
        //split_2 = new ImageIcon("img/split_2.png").getImage();
        //split_3 = new ImageIcon("img/split_3.png").getImage();
        castle = new ImageIcon("img/building/castle.png").getImage();
        wall = new ImageIcon("img/building/wall.png").getImage();
        trap_1 = new ImageIcon("img/trap_1.png").getImage();
        trap_2 = new ImageIcon("img/trap_2.png").getImage();
        treasure = new ImageIcon("img/treasure.png").getImage();
        loot = new ImageIcon("img/loot.png").getImage();
        market_1 = new ImageIcon("img/building/market_1.png").getImage();
        market_2 = new ImageIcon("img/building/market_2.png").getImage();
        market_3 = new ImageIcon("img/building/market_3.png").getImage();
        market_4 = new ImageIcon("img/building/market_4.png").getImage();

        this.setPreferredSize(new Dimension(750, 750));
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(desert, 0, 0, null);
        //g2D.drawImage(split_1, 0, 0, null);
        //g2D.drawImage(split_2, 400, 0, null);
        //g2D.drawImage(split_3, 320, 330, null);
        g2D.drawImage(castle, 5 * 75, 5 * 75, null);
        g2D.drawImage(wall, 2 * 75, 2 * 75, null);
        g2D.drawImage(wall, 7 * 75, 6 * 75, null);
        g2D.drawImage(trap_1, 3 * 75, 8 * 75, null);
        g2D.drawImage(trap_1, 5 * 75, 1 * 75, null);
        g2D.drawImage(trap_2, 6 * 75, 3 * 75, null);
        g2D.drawImage(trap_2, 0 * 75, 0 * 75, null);
        g2D.drawImage(treasure, 4 * 75, 2 * 75, null);
        g2D.drawImage(treasure, 8 * 75, 7 * 75, null);
        g2D.drawImage(loot, 1 * 75, 5 * 75, null);
        g2D.drawImage(loot, 3 * 75, 4 * 75, null);
        g2D.drawImage(market_1, 0 * 75, 7 * 75, null);
        g2D.drawImage(market_2, 2 * 75, 0 * 75, null);
        g2D.drawImage(market_3, 6 * 75, 1 * 75, null);
        g2D.drawImage(market_4, 9 * 75, 5 * 75, null);
        g2D.drawImage(market_1, 6 * 75, 9 * 75, null);

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(4));//thikness


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
            }
        }

    }
}
