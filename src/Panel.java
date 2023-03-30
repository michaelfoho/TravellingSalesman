import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Image desert, castle, market, wall, trap, treasure, loot;

    Panel() {

        desert = new ImageIcon("img/desert.png").getImage();
        castle = new ImageIcon("img/castle.png").getImage();
        wall = new ImageIcon("img/wall.png").getImage();
        trap = new ImageIcon("img/trap.png").getImage();
        treasure = new ImageIcon("img/treasure.png").getImage();
        loot = new ImageIcon("img/loot.png").getImage();
        market = new ImageIcon("img/market.png").getImage();

        this.setPreferredSize(new Dimension(750, 750));
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(desert, 0, 0, null);
        g2D.drawImage(castle, 5 * 75, 5 * 75, null);
        g2D.drawImage(wall, 2 * 75, 2 * 75, null);
        g2D.drawImage(wall, 7 * 75, 6 * 75, null);
        g2D.drawImage(trap, 3 * 75, 8 * 75, null);
        g2D.drawImage(trap, 5 * 75, 1 * 75, null);
        g2D.drawImage(trap, 6 * 75, 3 * 75, null);
        g2D.drawImage(treasure, 4 * 75, 2 * 75, null);
        g2D.drawImage(treasure, 8 * 75, 7 * 75, null);
        g2D.drawImage(loot, 1 * 75, 5 * 75, null);
        g2D.drawImage(loot, 3 * 75, 4 * 75, null);
        g2D.drawImage(market, 5 * 75, 7 * 75, null);
        g2D.drawImage(market, 2 * 75, 0 * 75, null);
        g2D.drawImage(market, 6 * 75, 1 * 75, null);
        g2D.drawImage(market, 9 * 75, 5 * 75, null);
        g2D.drawImage(market, 6 * 75, 9 * 75, null);

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));//thikness
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
            }
        }

    }
}
