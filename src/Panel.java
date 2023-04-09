import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    /*ImageIcon icon = new ImageIcon("img/logo.png");
    Image scaleIcon = icon.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);*/   //scaled image


    int sw = 2;
    int repaint = 1;//for repaint after firstpage
    Pointer mainTurn = new Pointer(1);
    Pointer diceNumber = new Pointer();


    Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true);
    // DecimalFormat df = new DecimalFormat("#.##");
    Font font40 = new Font("Century", Font.PLAIN, 40);
    Font font16 = new Font("Century", Font.PLAIN, 16);
    Font font36 = new Font("Century", Font.PLAIN, 36);
    Font font24 = new Font("Century", Font.PLAIN, 24);
    Random rand = new Random();


    PlayerInfo playerInfo;
    PlayerInfo player1Info = new PlayerInfo(1, mainTurn, diceNumber, "Werewolf");
    PlayerInfo player2Info = new PlayerInfo(2, mainTurn, diceNumber, "Angel");

    Button nextButton, diceButton, continueButton, newGameButton, quitButton;

    Image firstPage, desert, backgroundColor;
    Image castle, wall, treasure, loot;
    Image trap1, trap2;
    Image market1desert;
    Image statusBoard, inventory;
    Image playerImage, werewolfImage, angelImage;
    Image player1, player2, werewolf, angel;
    Image ring, sword, goldenGlass, glassCup, bow, shield, key, scroll;
    Image[] lostObject = new Image[13];
    Image[] weapon = new Image[4];
    Image dice;

    Image[] diceImage = new Image[6];
    Weapon[] weap = new Weapon[4];

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
        market1desert = new ImageIcon("img/building/market1desert.png").getImage();

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

        lostObject[0] = new ImageIcon("img/lostObject/lostObject_1.png").getImage();
        lostObject[1] = new ImageIcon("img/lostObject/lostObject_2.png").getImage();
        lostObject[2] = new ImageIcon("img/lostObject/lostObject_3.png").getImage();
        lostObject[3] = new ImageIcon("img/lostObject/lostObject_4.png").getImage();
        lostObject[4] = new ImageIcon("img/lostObject/lostObject_5.png").getImage();
        lostObject[5] = new ImageIcon("img/lostObject/lostObject_6.png").getImage();
        lostObject[6] = new ImageIcon("img/lostObject/lostObject_7.png").getImage();
        lostObject[7] = new ImageIcon("img/lostObject/lostObject_8.png").getImage();
        lostObject[8] = new ImageIcon("img/lostObject/lostObject_9.png").getImage();
        lostObject[9] = new ImageIcon("img/lostObject/lostObject_10.png").getImage();
        lostObject[10] = new ImageIcon("img/lostObject/lostObject_11.png").getImage();
        lostObject[11] = new ImageIcon("img/lostObject/lostObject_12.png").getImage();
        lostObject[12] = new ImageIcon("img/lostObject/lostObject_13.png").getImage();

        weapon[0] = new ImageIcon("img/weapon/weapon1.png").getImage();
        weapon[1] = new ImageIcon("img/weapon/weapon2.png").getImage();
        weapon[2] = new ImageIcon("img/weapon/weapon3.png").getImage();
        weapon[3] = new ImageIcon("img/weapon/weapon4.png").getImage();

        werewolfImage = new ImageIcon("img/hero/big/werewolf.png").getImage();
        angelImage = new ImageIcon("img/hero/big/angel.png").getImage();

        werewolf = new ImageIcon("img/hero/small/werewolf.png").getImage();
        angel = new ImageIcon("img/hero/small/angel.png").getImage();

        playerImage = werewolfImage;
        player1 = werewolf;
        player2 = angel;

        playerInfo = player1Info;

        diceImage[0] = new ImageIcon("img/dice/dice1.png").getImage();
        diceImage[1] = new ImageIcon("img/dice/dice2.png").getImage();
        diceImage[2] = new ImageIcon("img/dice/dice3.png").getImage();
        diceImage[3] = new ImageIcon("img/dice/dice4.png").getImage();
        diceImage[4] = new ImageIcon("img/dice/dice5.png").getImage();
        diceImage[5] = new ImageIcon("img/dice/dice6.png").getImage();

        weap[0] = new Weapon(400);
        weap[1] = new Weapon(300);
        weap[2] = new Weapon(200);
        weap[3] = new Weapon(100);


        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(1500, 750));
        this.addKeyListener(player1Info);
        this.addKeyListener(player2Info);
    }


    public void fight(PlayerInfo player1Info, PlayerInfo player2Info) {

        player1Info.money += (int) ((player1Info.power - player2Info.power) * player2Info.money) / (player1Info.power + player2Info.power);
        player2Info.money -= (int) ((player1Info.power - player2Info.power) * player2Info.money) / (player1Info.power + player2Info.power);
        player1Info.power -= player2Info.power;
        player2Info.power = 0;
        player2Info.x = 750;
        player2Info.y = 675;

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

                if (diceNumber.prt != 0) repaint();


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
                g2D.drawImage(market1desert, 0 * 75, 7 * 75, null);


                g2D.drawImage(statusBoard, 760, 10, null);
                g2D.drawRoundRect(760, 10, 500, 300, 10, 10);
                g2D.drawImage(inventory, 880, 330, null);
                g2D.drawRoundRect(880, 330, 600, 400, 10, 10);

                if (playerInfo.treasureBool[0]) g2D.drawImage(ring, 1393, 355, null);
                if (playerInfo.treasureBool[1]) g2D.drawImage(sword, 1407, 445, null);
                if (playerInfo.treasureBool[2]) g2D.drawImage(goldenGlass, 1400, 540, null);
                if (playerInfo.treasureBool[3]) g2D.drawImage(glassCup, 1397, 635, null);
                if (playerInfo.treasureBool[4]) g2D.drawImage(bow, 1330, 351, null);
                if (playerInfo.treasureBool[5]) g2D.drawImage(shield, 1314, 445, null);
                if (playerInfo.treasureBool[6]) g2D.drawImage(key, 1325, 545, null);
                if (playerInfo.treasureBool[7]) g2D.drawImage(scroll, 1314, 635, null);

                if (playerInfo.lostObjectBool[0]) g2D.drawImage(lostObject[0], 1235, 445, null);
                if (playerInfo.lostObjectBool[1]) g2D.drawImage(lostObject[1], 1235, 540, null);
                if (playerInfo.lostObjectBool[2]) g2D.drawImage(lostObject[2], 1235, 635, null);
                if (playerInfo.lostObjectBool[3]) g2D.drawImage(lostObject[3], 1157, 445, null);
                if (playerInfo.lostObjectBool[4]) g2D.drawImage(lostObject[4], 1157, 540, null);
                if (playerInfo.lostObjectBool[5]) g2D.drawImage(lostObject[5], 1157, 635, null);
                if (playerInfo.lostObjectBool[6]) g2D.drawImage(lostObject[6], 1079, 445, null);
                if (playerInfo.lostObjectBool[7]) g2D.drawImage(lostObject[7], 1079, 540, null);
                if (playerInfo.lostObjectBool[8]) g2D.drawImage(lostObject[8], 1079, 635, null);
                if (playerInfo.lostObjectBool[9]) g2D.drawImage(lostObject[9], 1000, 350, null);
                if (playerInfo.lostObjectBool[10]) g2D.drawImage(lostObject[10], 1000, 445, null);
                if (playerInfo.lostObjectBool[11]) g2D.drawImage(lostObject[11], 1000, 540, null);
                if (playerInfo.lostObjectBool[12]) g2D.drawImage(lostObject[12], 1000, 635, null);


                g2D.setPaint(Color.white);
                g2D.setStroke(new BasicStroke(3));//thickness
                g2D.setFont(font16);

                if (playerInfo.weaponNumber[0] > 0) {
                    g2D.drawImage(weapon[0], 935, 350, null);
                    g2D.drawString(String.valueOf(playerInfo.weaponNumber[0]), 960, 420);
                }
                if (playerInfo.weaponNumber[1] > 0) {
                    g2D.drawImage(weapon[1], 926, 445, null);
                    g2D.drawString(String.valueOf(playerInfo.weaponNumber[1]), 960, 514);
                }
                if (playerInfo.weaponNumber[2] > 0) {
                    g2D.drawImage(weapon[2], 926, 540, null);
                    g2D.drawString(String.valueOf(playerInfo.weaponNumber[2]), 960, 608);
                }
                if (playerInfo.weaponNumber[3] > 0) {
                    g2D.drawImage(weapon[3], 932, 635, null);
                    g2D.drawString(String.valueOf(playerInfo.weaponNumber[3]), 960, 702);
                }


                g2D.drawString("4", 920, 420);
                g2D.drawString("3", 920, 514);
                g2D.drawString("2", 920, 608);
                g2D.drawString("1", 920, 702);

                g2D.setFont(font40);
                g2D.setPaint(Color.BLACK);
                g2D.drawString("'Status Board'", 900, 45);
                g2D.setFont(font36);
                g2D.setPaint(new Color(100, 0, 0));
                g2D.drawString("Quest:", 975, 100);
                g2D.setFont(font24);
                g2D.setPaint(new Color(100, 100, 100));
                g2D.drawString("Treasure Score:", 975, 155);
                g2D.setPaint(new Color(80, 80, 80));
                g2D.drawString("Power:", 975, 200);
                g2D.setPaint(new Color(50, 50, 50));
                g2D.drawString("Money:", 975, 245);
                g2D.setPaint(new Color(0, 0, 0));
                g2D.drawString("Time:", 975, 290);

                g2D.setPaint(new Color(0, 0, 255));
                g2D.drawString(String.valueOf(playerInfo.power), 1060, 200);
                g2D.setPaint(new Color(20, 130, 0));
                g2D.drawString(String.valueOf(playerInfo.money), 1060, 245);


                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(4));//thickness
                g2D.setFont(font40);

                g2D.drawImage(playerImage, 1250, 20, null);
                g2D.setPaint(new Color(160, 160, 160));
                switch (playerInfo.name) {

                    case "Werewolf":
                        g2D.drawString(playerInfo.name, 1290, 300);
                        break;
                    case "Angel":
                        g2D.drawString(playerInfo.name, 1325, 300);
                        break;

                }

                g2D.setPaint(Color.BLACK);

                if (player1Info.x == 750 && player2Info.x == 750) {
                    g2D.drawImage(player1, player1Info.x, player1Info.y, null);
                } else {
                    g2D.drawImage(player1, player1Info.x, player1Info.y, null);
                    g2D.drawImage(player2, player2Info.x, player2Info.y, null);
                }


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


                if (player1Info.x == player2Info.x && player1Info.y == player2Info.y && player1Info.x != 750) {
                    if (player1Info.power > player2Info.power) fight(player1Info, player2Info);
                    else if (player2Info.power > player1Info.power) fight(player2Info, player1Info);
                    else if (player1Info.power == player2Info.power)
                        if (mainTurn.prt == 1) fight(player1Info, player2Info);
                        else fight(player2Info, player1Info);

                    repaint();
                }


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

            diceNumber.prt = rand.nextInt(6) + 1;
            dice = diceImage[diceNumber.prt - 1];

        }
        if (e.getSource() == nextButton) {

            if (mainTurn.prt == 1) {

                mainTurn.prt = 2;
                playerInfo = player2Info;
                playerImage = angelImage;

            } else {

                mainTurn.prt = 1;
                playerInfo = player1Info;
                playerImage = werewolfImage;

            }

            dice = null;
        }


        repaint();
    }
}