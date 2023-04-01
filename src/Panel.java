import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

    Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 4, true);
    Font font64 = new Font("Century", Font.PLAIN, 64);
    Font font40 = new Font("Century", Font.PLAIN, 40);
    Font font32 = new Font("Century", Font.PLAIN, 32);
    Font font24 = new Font("Century", Font.PLAIN, 24);


    JButton button;


    Image desert, castle, wall, treasure, loot;
    Image trap1, trap2;
    Image market1, market2, market3, market4;
    Image statusBoard, inventory;
    Image playerImage, werewolfImage, angelImage;
    Image player, werewolf, angel;
    Image ring, sword, goldenGlass, glassCup, bow, shield, key, scroll;
    Image lostObject_1, lostObject_2, lostObject_3, lostObject_4, lostObject_5, lostObject_6;
    Image lostObject_7, lostObject_8, lostObject_9, lostObject_10, lostObject_11, lostObject_12, lostObject_13;
    Image weapon1, weapon2, weapon3, weapon4;

    Panel() {

        button = new JButton();
        button.setBounds(766, 450, 100, 70);
        button.addActionListener(this);
        button.setFocusable(true);
        //button.setVisible(true);
        button.setText("Next");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFont(font24);
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(180, 150, 0));//if you add an image for background of button comment this line
        button.setEnabled(true);//if you want to disable the button change (true) to (false)


        desert = new ImageIcon("img/desert.png").getImage();
        castle = new ImageIcon("img/building/castle.png").getImage();
        wall = new ImageIcon("img/building/wall.png").getImage();
        trap1 = new ImageIcon("img/trap1.png").getImage();
        trap2 = new ImageIcon("img/trap2.png").getImage();
        treasure = new ImageIcon("img/treasure.png").getImage();
        loot = new ImageIcon("img/loot.png").getImage();
        market1 = new ImageIcon("img/building/market1.png").getImage();
        market2 = new ImageIcon("img/building/market2.png").getImage();
        market3 = new ImageIcon("img/building/market3.png").getImage();
        market4 = new ImageIcon("img/building/market4.png").getImage();

        statusBoard = new ImageIcon("img/statusBoard.png").getImage();
        inventory = new ImageIcon("img/inventory.png").getImage();

        ring = new ImageIcon("img/treasure/ring.png").getImage();
        sword = new ImageIcon("img/treasure/sword.png").getImage();
        goldenGlass = new ImageIcon("img/treasure/goldenGlass.png").getImage();
        glassCup = new ImageIcon("img/treasure/glassCup.png").getImage();
        bow = new ImageIcon("img/treasure/bow.png").getImage();
        shield = new ImageIcon("img/treasure/shield.png").getImage();
        key = new ImageIcon("img/treasure/key.png").getImage();
        scroll = new ImageIcon("img/treasure/scroll.png").getImage();

        lostObject_1 = new ImageIcon("img/lostObject/lostObject_1.png").getImage();
        lostObject_2 = new ImageIcon("img/lostObject/lostObject_2.png").getImage();
        lostObject_3 = new ImageIcon("img/lostObject/lostObject_3.png").getImage();
        lostObject_4 = new ImageIcon("img/lostObject/lostObject_4.png").getImage();
        lostObject_5 = new ImageIcon("img/lostObject/lostObject_5.png").getImage();
        lostObject_6 = new ImageIcon("img/lostObject/lostObject_6.png").getImage();
        lostObject_7 = new ImageIcon("img/lostObject/lostObject_7.png").getImage();
        lostObject_8 = new ImageIcon("img/lostObject/lostObject_8.png").getImage();
        lostObject_9 = new ImageIcon("img/lostObject/lostObject_9.png").getImage();
        lostObject_10 = new ImageIcon("img/lostObject/lostObject_10.png").getImage();
        lostObject_11 = new ImageIcon("img/lostObject/lostObject_11.png").getImage();
        lostObject_12 = new ImageIcon("img/lostObject/lostObject_12.png").getImage();
        lostObject_13 = new ImageIcon("img/lostObject/lostObject_13.png").getImage();

        weapon1 = new ImageIcon("img/weapon/weapon1.png").getImage();
        weapon2 = new ImageIcon("img/weapon/weapon2.png").getImage();
        weapon3 = new ImageIcon("img/weapon/weapon3.png").getImage();
        weapon4 = new ImageIcon("img/weapon/weapon4.png").getImage();


        werewolfImage = new ImageIcon("img/hero/big/werewolf.png").getImage();
        angelImage = new ImageIcon("img/hero/big/angel.png").getImage();

        werewolf = new ImageIcon("img/hero/small/werewolf.png").getImage();
        angel = new ImageIcon("img/hero/small/angel.png").getImage();


        playerImage = werewolfImage;
        player = werewolf;

        this.setLayout(null);

        this.add(button);

        this.setPreferredSize(new Dimension(1500, 750));
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(4));//thickness
        g2D.setFont(font40);//font


        g2D.drawImage(desert, 0, 0, null);
        g2D.drawImage(castle, 5 * 75, 5 * 75, null);
        g2D.drawImage(wall, 2 * 75, 2 * 75, null);
        g2D.drawImage(wall, 7 * 75, 6 * 75, null);
        g2D.drawImage(trap1, 3 * 75, 8 * 75, null);
        g2D.drawImage(trap1, 5 * 75, 1 * 75, null);
        g2D.drawImage(trap2, 6 * 75, 3 * 75, null);
        g2D.drawImage(trap2, 0 * 75, 0 * 75, null);
        g2D.drawImage(treasure, 4 * 75, 2 * 75, null);
        g2D.drawImage(treasure, 8 * 75, 7 * 75, null);
        g2D.drawImage(loot, 1 * 75, 5 * 75, null);
        g2D.drawImage(loot, 3 * 75, 4 * 75, null);
        g2D.drawImage(market1, 0 * 75, 7 * 75, null);
        g2D.drawImage(market2, 2 * 75, 0 * 75, null);
        g2D.drawImage(market3, 6 * 75, 1 * 75, null);
        g2D.drawImage(market4, 9 * 75, 5 * 75, null);
        g2D.drawImage(market1, 6 * 75, 9 * 75, null);

        g2D.drawImage(statusBoard, 760, 10, null);
        g2D.drawRoundRect(760, 10, 500, 300, 10, 10);
        g2D.drawImage(inventory, 880, 330, null);
        g2D.drawRoundRect(880, 330, 600, 400, 10, 10);

        g2D.drawImage(ring, 1393, 355, null);
        g2D.drawImage(sword, 1407, 445, null);
        g2D.drawImage(goldenGlass, 1400, 540, null);
        g2D.drawImage(glassCup, 1397, 635, null);
        g2D.drawImage(bow, 1330, 351, null);
        g2D.drawImage(shield, 1314, 445, null);
        g2D.drawImage(key, 1325, 545, null);
        g2D.drawImage(scroll, 1314, 635, null);

        g2D.drawImage(lostObject_1, 1235, 445, null);
        g2D.drawImage(lostObject_2, 1235, 540, null);
        g2D.drawImage(lostObject_3, 1235, 635, null);
        g2D.drawImage(lostObject_4, 1157, 445, null);
        g2D.drawImage(lostObject_5, 1157, 540, null);
        g2D.drawImage(lostObject_6, 1157, 635, null);
        g2D.drawImage(lostObject_7, 1079, 445, null);
        g2D.drawImage(lostObject_8, 1079, 540, null);
        g2D.drawImage(lostObject_9, 1079, 635, null);
        g2D.drawImage(lostObject_10, 1000, 350, null);
        g2D.drawImage(lostObject_11, 1000, 445, null);
        g2D.drawImage(lostObject_12, 1000, 540, null);
        g2D.drawImage(lostObject_13, 1000, 635, null);

        g2D.drawImage(weapon1, 926, 350, null);
        g2D.drawImage(weapon2, 935, 445, null);
        g2D.drawImage(weapon3, 932, 540, null);
        g2D.drawImage(weapon4, 926, 635, null);

        g2D.drawImage(playerImage, 1250, 20, null);
        g2D.setPaint(new Color(160, 160, 160));
        g2D.drawString("Werewolf", 1290, 300);

        g2D.setPaint(Color.BLACK);

        g2D.drawImage(player, 750, 675, null);
        g2D.drawRoundRect(750, 675, 75, 75, 10, 10);

        g2D.drawRoundRect(766, 450, 100, 70, 10, 10);//button


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
            }
        }


        g2D.setPaint(new Color(5, 100, 125));
        g2D.fillRoundRect(766, 340, 100, 100, 10, 10);//dice
        g2D.setPaint(new Color(0, 0, 0));
        g2D.drawRoundRect(766, 340, 100, 100, 10, 10);//dice
        g2D.setFont(font64);//font
        g2D.drawString("1", 798, 410);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {

            if (playerImage == werewolfImage) {
                playerImage = angelImage;
                player = angel;
            } else {
                playerImage = werewolfImage;
                player = werewolf;
            }


        }
        repaint();

    }
}
