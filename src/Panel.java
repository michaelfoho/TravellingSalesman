import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    /*ImageIcon icon = new ImageIcon("img/logo.png");
    Image scaleIcon = icon.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);*/   //scaled image


    int sw = 2;
    int repaint = 1;//for repaint after firstpage
    Pointer dicePrt = new Pointer();


    Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true);
    Font font40 = new Font("Century", Font.PLAIN, 40);
    Font font16 = new Font("Century", Font.PLAIN, 16);
    Font font36 = new Font("Century", Font.PLAIN, 36);
    Font font24 = new Font("Century", Font.PLAIN, 24);
    Random rand = new Random();


    Player1Class player1Coordinates = new Player1Class(dicePrt);
    Player2Class player2Coordinates = new Player2Class();

    Button nextButton, diceButton, continueButton, newGameButton, quitButton;


    String playerName;

    Image firstPage, desert, backgroundColor;
    Image castle, wall, treasure, loot;
    Image trap1, trap2;
    Image market1, market2, market3, market4;
    Image statusBoard, inventory;
    Image playerImage, werewolfImage, angelImage;
    Image player1, player2, werewolf, angel;
    Image ring, sword, goldenGlass, glassCup, bow, shield, key, scroll;
    Image lostObject_1, lostObject_2, lostObject_3, lostObject_4, lostObject_5, lostObject_6;
    Image lostObject_7, lostObject_8, lostObject_9, lostObject_10, lostObject_11, lostObject_12, lostObject_13;
    Image weapon1, weapon2, weapon3, weapon4;
    Image dice;

    Image dice1, dice2, dice3, dice4, dice5, dice6;

    Weapon weap1, weap2, weap3, weap4;

    Panel() {


        continueButton = new Button(1200, 15, 250, 50, "Continue", new Color(100, 100, 100));
        continueButton.addActionListener(this);

        newGameButton = new Button(1200, 80, 250, 50, "New Game", new Color(100, 100, 100));
        newGameButton.addActionListener(this);

        quitButton = new Button(1200, 145, 250, 50, "Quit", new Color(100, 100, 100));
        quitButton.addActionListener(this);

        diceButton = new Button(767, 341, 98, 98, "", new Color(50, 50, 50));
        diceButton.addActionListener(this);

        nextButton = new Button(767, 450, 98, 70, "Next", new Color(180, 150, 0));
        nextButton.addActionListener(this);


        firstPage = new ImageIcon("img/firstPage.png").getImage();
        desert = new ImageIcon("img/desert.png").getImage();
        backgroundColor = new ImageIcon("img/backgroundColor.png").getImage();
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
        player1 = werewolf;
        player2 = angel;
        playerName = "Werewolf";


        dice1 = new ImageIcon("img/dice/dice1.png").getImage();
        dice2 = new ImageIcon("img/dice/dice2.png").getImage();
        dice3 = new ImageIcon("img/dice/dice3.png").getImage();
        dice4 = new ImageIcon("img/dice/dice4.png").getImage();
        dice5 = new ImageIcon("img/dice/dice5.png").getImage();
        dice6 = new ImageIcon("img/dice/dice6.png").getImage();

        weap1 = new Weapon("1", 400);
        weap2 = new Weapon("1", 300);
        weap3 = new Weapon("1", 200);
        weap4 = new Weapon("1", 100);


        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(1500, 750));
        this.addKeyListener(player1Coordinates);
        this.addKeyListener(player2Coordinates);
    }


    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(4));//thickness
        g2D.setFont(font40);

        switch (sw) {

            case 1:

                this.add(continueButton);
                this.add(newGameButton);
                this.add(quitButton);


                g2D.drawImage(firstPage, 0, 0, null);

                break;
            case 2:

                if (dicePrt.diceNumber != 0) repaint();


                if (repaint == 1) {
                    repaint();
                    repaint = 0;
                }

                this.add(diceButton);
                this.add(nextButton);


                g2D.drawImage(desert, 0, 0, null);
                g2D.drawImage(backgroundColor, 750, 0, null);
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


                g2D.drawImage(weapon1, 935, 350, null);
                g2D.drawImage(weapon2, 926, 445, null);
                g2D.drawImage(weapon3, 926, 540, null);
                g2D.drawImage(weapon4, 932, 635, null);


                g2D.setPaint(Color.white);
                g2D.setStroke(new BasicStroke(3));//thickness
                g2D.setFont(font16);


                g2D.drawString(weap1.number, 960, 420);
                g2D.drawString(weap2.number, 960, 514);
                g2D.drawString(weap3.number, 960, 608);
                g2D.drawString(weap4.number, 960, 702);

                g2D.drawString("4", 920, 420);
                g2D.drawString("3", 920, 514);
                g2D.drawString("2", 920, 608);
                g2D.drawString("1", 920, 702);

                g2D.setFont(font40);
                g2D.setPaint(Color.BLACK);
                g2D.drawString("'StatusBoard'", 900, 45);
                g2D.setFont(font36);
                g2D.setPaint(Color.RED);
                g2D.drawString("Quest:", 975, 100);
                g2D.setFont(font24);
                g2D.setPaint(Color.white);
                g2D.drawString("Treasure Score:", 975, 155);
                g2D.drawString("Power:", 975, 200);
                g2D.drawString("Money:", 975, 245);
                g2D.drawString("Time:", 975, 290);


                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(4));//thickness
                g2D.setFont(font40);

                g2D.drawImage(playerImage, 1250, 20, null);
                g2D.setPaint(new Color(160, 160, 160));
                switch (playerName) {

                    case "Werewolf":
                        g2D.drawString(playerName, 1290, 300);
                        break;
                    case "Angel":
                        g2D.drawString(playerName, 1325, 300);
                        break;

                }

                g2D.setPaint(Color.BLACK);

                g2D.drawImage(player1, player1Coordinates.x, player1Coordinates.y, null);
                g2D.drawImage(player2, player2Coordinates.x, player2Coordinates.y, null);
                g2D.drawRoundRect(750, 675, 75, 75, 10, 10);

                g2D.drawString("Click", 768, 402);
                g2D.drawImage(dice, 765, 340, null);//dice

                g2D.drawRoundRect(766, 340, 100, 100, 10, 10);//dice
                g2D.drawRoundRect(766, 450, 100, 70, 10, 10);//button

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
                    }
                }


               /* if (player1Coordinates.x == player2Coordinates.x && player1Coordinates.y == player2Coordinates.y && player1Coordinates.x != 750) {

                    NewWindow fightWindow = new NewWindow();

                    repaint();
                }*/


                break;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == continueButton) {

        }
        if (e.getSource() == newGameButton) {

            sw = 2;

            continueButton.setEnabled(false);
            newGameButton.setEnabled(false);
            quitButton.setEnabled(false);

        }
        if (e.getSource() == quitButton) {
            System.exit(0);
        }

        if (e.getSource() == diceButton) {

            dicePrt.diceNumber = rand.nextInt(6) + 1;

            switch (dicePrt.diceNumber) {
                case 1:
                    dice = dice1;
                    break;
                case 2:
                    dice = dice2;
                    break;
                case 3:
                    dice = dice3;
                    break;
                case 4:
                    dice = dice4;
                    break;
                case 5:
                    dice = dice5;
                    break;
                case 6:
                    dice = dice6;
                    break;
            }
        }
        if (e.getSource() == nextButton) {

            if (playerImage == werewolfImage) {

                playerImage = angelImage;
                playerName = "Angel";

            } else {

                playerImage = werewolfImage;
                playerName = "Werewolf";

            }

            dice = null;
        }


        repaint();
    }
}