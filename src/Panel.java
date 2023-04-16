import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    /*ImageIcon icon = new ImageIcon("img/logo.png");
    Image scaleIcon = icon.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);*/   //scaled image

    boolean market_bool, trap_bool, castle_bool, treasure_checker[] = new boolean[8], quest[] = new boolean[8];
    int sw = 2, adad = 0;
    int repaint = 1;//for repaint after firstpage
    Pointer mainTurn = new Pointer(1);
    Pointer diceNumber = new Pointer();


    Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true);
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
    Image castle, wall, treasureBox, lootBox;
    Image trapDesert;
    Image marketDesert;
    Image statusBoard, inventory;
    Image playerImage, werewolfImage, angelImage;
    Image player1, player2, werewolf, angel;
    Image ring, sword, goldenGlass, glassCup, bow, shield, key, scroll;
    Image[] lostObject = new Image[13];
    Image[] weapon = new Image[4];
    Image[] diceImage = new Image[6];
    Image dice;
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
        trapDesert = new ImageIcon("img/trap/trapDesert.png").getImage();
        treasureBox = new ImageIcon("img/treasureBox.png").getImage();
        lootBox = new ImageIcon("img/lootBox.png").getImage();
        marketDesert = new ImageIcon("img/building/marketDesert.png").getImage();

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

        weapon[0] = new ImageIcon("img/weapon/inventory/weapon1.png").getImage();
        weapon[1] = new ImageIcon("img/weapon/inventory/weapon2.png").getImage();
        weapon[2] = new ImageIcon("img/weapon/inventory/weapon3.png").getImage();
        weapon[3] = new ImageIcon("img/weapon/inventory/weapon4.png").getImage();

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
        player2Info.y = 700;
        repaint();
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

                for (int i = 0; i < 8; i++) {
                    treasure_checker[i] = false;
                }

                if (diceNumber.prt != 0) repaint();

                if (repaint == 1) {
                    repaint();
                    repaint = 0;
                }

                this.add(diceButton);
                this.add(nextButton);


                g2D.drawImage(desert, 0, 0, null);
                g2D.drawImage(castle, 7 * 50, 7 * 50, null);

                for (int i = 0; i < 24; i++) {
                    if (PlayerInfo.wall[i].show)
                        g2D.drawImage(wall, PlayerInfo.wall[i].x, PlayerInfo.wall[i].y, null);
                }
                for (int i = 0; i < 8; i++) {
                    if (playerInfo.treasure[i].show)
                        g2D.drawImage(treasureBox, playerInfo.treasure[i].x, playerInfo.treasure[i].y, null);
                }
                for (int i = 0; i < 13; i++) {
                    if (playerInfo.loot[i].show)
                        g2D.drawImage(lootBox, playerInfo.loot[i].x, playerInfo.loot[i].y, null);
                }
                for (int i = 0; i < 5; i++) {
                    if (playerInfo.market[i].show)
                        g2D.drawImage(marketDesert, playerInfo.market[i].x, playerInfo.market[i].y, null);
                }
                for (int i = 0; i < 10; i++) {
                    if (playerInfo.trap[i].show)
                        g2D.drawImage(trapDesert, playerInfo.trap[i].x, playerInfo.trap[i].y, null);
                }


                g2D.drawImage(backgroundColor, 750, 0, null);
                g2D.drawImage(statusBoard, 760, 10, null);
                g2D.drawRoundRect(760, 10, 500, 300, 10, 10);
                g2D.drawImage(inventory, 880, 330, null);
                g2D.drawRoundRect(880, 330, 600, 400, 10, 10);

                if (playerInfo.treasure[0].show) g2D.drawImage(ring, 1393, 355, null);
                if (playerInfo.treasure[1].show) g2D.drawImage(sword, 1407, 445, null);
                if (playerInfo.treasure[2].show) g2D.drawImage(goldenGlass, 1400, 540, null);
                if (playerInfo.treasure[3].show) g2D.drawImage(glassCup, 1397, 635, null);
                if (playerInfo.treasure[4].show) g2D.drawImage(bow, 1330, 351, null);
                if (playerInfo.treasure[5].show) g2D.drawImage(shield, 1314, 445, null);
                if (playerInfo.treasure[6].show) g2D.drawImage(key, 1325, 545, null);
                if (playerInfo.treasure[7].show) g2D.drawImage(scroll, 1314, 635, null);

                if (playerInfo.loot[0].show) g2D.drawImage(lostObject[0], 1235, 445, null);
                if (playerInfo.loot[1].show) g2D.drawImage(lostObject[1], 1235, 540, null);
                if (playerInfo.loot[2].show) g2D.drawImage(lostObject[2], 1235, 635, null);
                if (playerInfo.loot[3].show) g2D.drawImage(lostObject[3], 1157, 445, null);
                if (playerInfo.loot[4].show) g2D.drawImage(lostObject[4], 1157, 540, null);
                if (playerInfo.loot[5].show) g2D.drawImage(lostObject[5], 1157, 635, null);
                if (playerInfo.loot[6].show) g2D.drawImage(lostObject[6], 1079, 445, null);
                if (playerInfo.loot[7].show) g2D.drawImage(lostObject[7], 1079, 540, null);
                if (playerInfo.loot[8].show) g2D.drawImage(lostObject[8], 1079, 635, null);
                if (playerInfo.loot[9].show) g2D.drawImage(lostObject[9], 1000, 350, null);
                if (playerInfo.loot[10].show) g2D.drawImage(lostObject[10], 1000, 445, null);
                if (playerInfo.loot[11].show) g2D.drawImage(lostObject[11], 1000, 540, null);
                if (playerInfo.loot[12].show) g2D.drawImage(lostObject[12], 1000, 635, null);


                for (int i = 0; i < 6; i++) {
                    if (playerInfo.move[i][0] != 0 && playerInfo.move[i][1] != 0)
                        g2D.fillOval(playerInfo.move[i][0] + 20, playerInfo.move[i][1] + 20, 10, 10);
                }

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
                g2D.setStroke(new BasicStroke(2));//thickness
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


                g2D.drawRoundRect(750, 700, 50, 50, 10, 10);

                g2D.drawString("Click", 768, 402);
                g2D.drawImage(dice, 765, 340, null);//dice

                g2D.drawRoundRect(766, 340, 100, 100, 10, 10);//dice
                g2D.drawRoundRect(766, 450, 100, 70, 10, 10);//button

                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        g2D.drawRoundRect(50 * i, 50 * j, 50, 50, 10, 10);
                    }
                }

                //quest
                do {
                    adad = rand.nextInt(8);
                    quest[adad]=true;
                    if (!treasure_checker[adad]) break;
                } while (true);

                if (quest[0]) g2D.drawImage(ring, 1093, 60, null);
                if (quest[1]) g2D.drawImage(sword, 1093, 60, null);
                if (quest[2]) g2D.drawImage(goldenGlass, 1093, 60, null);
                if (quest[3]) g2D.drawImage(glassCup, 1093, 60, null);
                if (quest[4]) g2D.drawImage(bow, 1093, 60, null);
                if (quest[5]) g2D.drawImage(shield, 1093, 60, null);
                if (quest[6]) g2D.drawImage(key, 1093, 60, null);
                if (quest[7]) g2D.drawImage(scroll, 1093, 60, null);


                //events at homes
                int counter = 0;
                for (int i = 0; i < 5; i++) {
                    if (playerInfo.x == playerInfo.market[i].x && playerInfo.y == playerInfo.market[i].y) {
                        if (market_bool) {
                            NewWindow marketWindow = new NewWindow("img/marketBackground.png", playerInfo);
                            market_bool = false;
                            break;
                        }
                    }
                }

                for (int i = 0; i < 5; i++) {
                    if (playerInfo.x != playerInfo.market[i].x && playerInfo.y != playerInfo.market[i].y) {
                        counter += 1;
                    }
                }
                if (counter == 5) market_bool = true;
                repaint();

                for (int i = 0; i < 10; i++) {
                    if (playerInfo.x == playerInfo.trap[i].x && playerInfo.y == playerInfo.trap[i].y) {
                        if (trap_bool) {
                            playerInfo.power -= 1;
                            playerInfo.money -= 10;
                            playerInfo.trap[i].show = true;
                            trap_bool = false;
                            break;
                        }
                    }
                }

                counter = 0;
                for (int i = 0; i < 10; i++) {
                    if (playerInfo.x != playerInfo.trap[i].x && playerInfo.y != playerInfo.trap[i].y) {
                        counter += 1;
                    }
                }
                if (counter == 10) trap_bool = true;
                repaint();

                for (int i = 0; i < 13; i++) {
                    if (playerInfo.x == playerInfo.loot[i].x && playerInfo.y == playerInfo.loot[i].y) {
                        playerInfo.loot[i].show = true;
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (playerInfo.x == playerInfo.treasure[i].x && playerInfo.y == playerInfo.treasure[i].y) {
                        playerInfo.treasure[i].show = true;
                    }
                }
                if (castle_bool) {
                    if (playerInfo.x == 7 * 50 && playerInfo.y == 7 * 50) {
                        //NewWindow castleWindow = new NewWindow();
                        /*for (int i=0;i<8;i++){
                            if (quest[i]){
                                treasure_checker[i]=true;
                                //rise money
                            }
                        }*/
                        castle_bool = false;
                        repaint();
                    }
                }

                //fight
                if (player1Info.x == player2Info.x && player1Info.y == player2Info.y && player1Info.x != 750) {
                    if (player1Info.power > player2Info.power) fight(player1Info, player2Info);
                    else if (player2Info.power > player1Info.power) fight(player2Info, player1Info);
                    else if (player1Info.power == player2Info.power && playerInfo.power == 0) {
                        if (mainTurn.prt == 1) {
                            player2Info.x = 750;
                            player2Info.y = 700;
                        } else {
                            player1Info.x = 750;
                            player1Info.y = 700;
                        }
                    } else if (player1Info.power == player2Info.power && playerInfo.power != 0) {
                        if (mainTurn.prt == 1) fight(player1Info, player2Info);
                        else fight(player2Info, player1Info);
                    }

                    repaint();
                }


                if (playerInfo.x != 7 * 50 && playerInfo.y != 7 * 50) castle_bool = true;


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