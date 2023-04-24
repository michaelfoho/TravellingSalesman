import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    /*ImageIcon icon = new ImageIcon("img/logo.png");
    Image scaleIcon = icon.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);*/   //scaled image

    boolean marketBool = true, trapBool = true, castleBool = true;
    boolean[] quest = new boolean[8];
    boolean lootchecker[] = new boolean[13];
    boolean once[] = new boolean[13], once2[] = new boolean[8];
    public Pointer sw = new Pointer(1);
    int treasurescore[] = new int[8];
    int repaint = 1, treasureRand = 0;//blocks{} integers
    static Pointer mainTurn = new Pointer(1);
    Pointer diceNumber = new Pointer();
    boolean diceOnce = true;

    Font font40 = new Font("Century", Font.PLAIN, 40);
    Font font16 = new Font("Century", Font.PLAIN, 16);
    Font font36 = new Font("Century", Font.PLAIN, 36);
    Font font24 = new Font("Century", Font.PLAIN, 24);
    Random rand = new Random();

    PlayerInfo playerInfo;
    PlayerInfo player1Info = new PlayerInfo(1, mainTurn, diceNumber, "Werewolf");
    PlayerInfo player2Info = new PlayerInfo(2, mainTurn, diceNumber, "Angel");

    Button continueButton, newGameButton, quitButton;
    Button nextButton, stateButton, diceButton;
    Button endNewGameButton, endOthersButton, endHomeButton;

    Image firstPage, choosePlayer, desert, backgroundColor;
    Image castle, wall, treasureBox, lootBox;
    Image trapDesert;
    Image marketDesert;
    Image statusBoard, inventory;
    static Image playerImage, player1Image, player2Image;
    Image[] pImage = new Image[15];
    Image player1, player2;
    Image[] pSmallImage = new Image[15];
    Image[] treasure = new Image[8];
    Image[] lostObject = new Image[13];
    Image[] weapon = new Image[4];
    Image[] diceImage = new Image[6];
    Image dice, wallet;
    Image questImage;
    Image ending, endMenu;
    Image[] endIcon = new Image[5];

    ChoosePlayerArea[] area = new ChoosePlayerArea[17];
    Keyboard keyboard = new Keyboard(sw);

    Panel() {
        this.addKeyListener(keyboard);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                area[3 * i + j] = new ChoosePlayerArea(60 + i * 235, 55 + j * 220, 200, 200, 3 * i + j, sw);
                this.addMouseListener(area[3 * i + j]);
            }
        }
        area[15] = new ChoosePlayerArea(1283, 30, 200, 200, 15, sw);
        area[16] = new ChoosePlayerArea(1283, 350, 200, 200, 16, sw);
        this.addMouseListener(area[15]);
        this.addMouseListener(area[16]);

        continueButton = new Button(1200, 15, 250, 50, "Continue", new Color(100, 100, 100));
        continueButton.addActionListener(this);
        newGameButton = new Button(1200, 80, 250, 50, "New Game", new Color(100, 100, 100));
        newGameButton.addActionListener(this);
        quitButton = new Button(1200, 145, 250, 50, "Quit", new Color(100, 100, 100));
        quitButton.addActionListener(this);

        diceButton = new Button(767, 341, 98, 98, null, new Color(50, 50, 50));
        diceButton.addActionListener(this);
        nextButton = new Button(767, 450, 98, 70, "Next", new Color(180, 150, 0));
        nextButton.addActionListener(this);
        stateButton = new Button(767, 550, 98, 70, "state", new Color(180, 150, 0));
        stateButton.addActionListener(this);

        endNewGameButton = new Button(70, 630, 200, 50, "New Game", new Color(180, 150, 0));
        endNewGameButton.addActionListener(this);
        endOthersButton = new Button(300, 630, 200, 50, "Others", new Color(100, 100, 100));
        endOthersButton.addActionListener(this);
        endHomeButton = new Button(530, 630, 200, 50, "Home", new Color(100, 100, 100));
        endHomeButton.addActionListener(this);

        firstPage = new ImageIcon("img/firstPage.png").getImage();
        choosePlayer = new ImageIcon("img/choosePlayer.png").getImage();
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
        wallet = new ImageIcon("img/wallet.png").getImage();

        treasure[0] = new ImageIcon("img/treasure/ring.png").getImage();
        treasure[1] = new ImageIcon("img/treasure/sword.png").getImage();
        treasure[2] = new ImageIcon("img/treasure/goldenGlass.png").getImage();
        treasure[3] = new ImageIcon("img/treasure/glassCup.png").getImage();
        treasure[4] = new ImageIcon("img/treasure/bow.png").getImage();
        treasure[5] = new ImageIcon("img/treasure/shield.png").getImage();
        treasure[6] = new ImageIcon("img/treasure/key.png").getImage();
        treasure[7] = new ImageIcon("img/treasure/scroll.png").getImage();

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

        pImage[0] = new ImageIcon("img/hero/player0.png").getImage();
        pImage[1] = new ImageIcon("img/hero/player1.png").getImage();
        pImage[2] = new ImageIcon("img/hero/player2.png").getImage();
        pImage[3] = new ImageIcon("img/hero/player3.png").getImage();
        pImage[4] = new ImageIcon("img/hero/player4.png").getImage();
        pImage[5] = new ImageIcon("img/hero/player5.png").getImage();
        pImage[6] = new ImageIcon("img/hero/player6.png").getImage();
        pImage[7] = new ImageIcon("img/hero/player7.png").getImage();
        pImage[8] = new ImageIcon("img/hero/player8.png").getImage();
        pImage[9] = new ImageIcon("img/hero/player9.png").getImage();
        pImage[10] = new ImageIcon("img/hero/player10.png").getImage();
        pImage[11] = new ImageIcon("img/hero/player11.png").getImage();
        pImage[12] = new ImageIcon("img/hero/player12.png").getImage();
        pImage[13] = new ImageIcon("img/hero/player13.png").getImage();
        pImage[14] = new ImageIcon("img/hero/player14.png").getImage();

        pSmallImage[0] = new ImageIcon("img/hero/small/player0.png").getImage();
        pSmallImage[1] = new ImageIcon("img/hero/small/player1.png").getImage();
        pSmallImage[2] = new ImageIcon("img/hero/small/player2.png").getImage();
        pSmallImage[3] = new ImageIcon("img/hero/small/player3.png").getImage();
        pSmallImage[4] = new ImageIcon("img/hero/small/player4.png").getImage();
        pSmallImage[5] = new ImageIcon("img/hero/small/player5.png").getImage();
        pSmallImage[6] = new ImageIcon("img/hero/small/player6.png").getImage();
        pSmallImage[7] = new ImageIcon("img/hero/small/player7.png").getImage();
        pSmallImage[8] = new ImageIcon("img/hero/small/player8.png").getImage();
        pSmallImage[9] = new ImageIcon("img/hero/small/player9.png").getImage();
        pSmallImage[10] = new ImageIcon("img/hero/small/player10.png").getImage();
        pSmallImage[11] = new ImageIcon("img/hero/small/player11.png").getImage();
        pSmallImage[12] = new ImageIcon("img/hero/small/player12.png").getImage();
        pSmallImage[13] = new ImageIcon("img/hero/small/player13.png").getImage();
        pSmallImage[14] = new ImageIcon("img/hero/small/player14.png").getImage();

        diceImage[0] = new ImageIcon("img/dice/dice1.png").getImage();
        diceImage[1] = new ImageIcon("img/dice/dice2.png").getImage();
        diceImage[2] = new ImageIcon("img/dice/dice3.png").getImage();
        diceImage[3] = new ImageIcon("img/dice/dice4.png").getImage();
        diceImage[4] = new ImageIcon("img/dice/dice5.png").getImage();
        diceImage[5] = new ImageIcon("img/dice/dice6.png").getImage();

        ending = new ImageIcon("img/end/ending.png").getImage();
        endMenu = new ImageIcon("img/end/endMenu.png").getImage();

        endIcon[0] = new ImageIcon("img/end/icon0.png").getImage();
        endIcon[1] = new ImageIcon("img/end/icon1.png").getImage();
        endIcon[2] = new ImageIcon("img/end/icon2.png").getImage();
        endIcon[3] = new ImageIcon("img/end/icon3.png").getImage();
        endIcon[4] = new ImageIcon("img/end/icon4.png").getImage();

        playerInfo = player1Info;

        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(1500, 750));
        this.addKeyListener(player1Info);
        this.addKeyListener(player2Info);
    }

    private void fight(PlayerInfo player1Info, PlayerInfo player2Info) {

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

        switch (sw.prt) {

            case 1:

                this.add(continueButton);
                this.add(newGameButton);
                this.add(quitButton);

                continueButton.setEnabled(true);
                newGameButton.setEnabled(true);
                quitButton.setEnabled(true);

                g2D.drawImage(firstPage, 0, 0, 1514, 750, null);


                break;
            case 2:

                if (diceNumber.prt != 0) repaint();

                for (int i = 0; i < 8; i++) {
                    treasurescore[i] = playerInfo.treasure[i].price;
                }

                if (repaint == 1) {
                    repaint();
                    repaint = 0;

                    //quest
                    int q = rand.nextInt(8);
                    questImage = treasure[q];
                    quest[q] = true;
                    once2[q] = true;
                }

                this.add(diceButton);
                this.add(nextButton);
                this.add(stateButton);

                diceButton.setEnabled(true);
                nextButton.setEnabled(true);
                stateButton.setEnabled(true);

                g2D.drawImage(desert, 0, 0, null);
                g2D.drawImage(castle, 7 * 50, 7 * 50, null);

                for (int i = 0; i < 24; i++)
                    if (PlayerInfo.wall[i].show)
                        g2D.drawImage(wall, PlayerInfo.wall[i].x, PlayerInfo.wall[i].y, null);
                for (int i = 0; i < 8; i++)
                    if (playerInfo.treasure[i].show)
                        g2D.drawImage(treasureBox, playerInfo.treasure[i].x, playerInfo.treasure[i].y, null);
                for (int i = 0; i < 13; i++)
                    if (playerInfo.loot[i].show)
                        g2D.drawImage(lootBox, playerInfo.loot[i].x, playerInfo.loot[i].y, null);
                for (int i = 0; i < 5; i++)
                    if (PlayerInfo.market[i].show)
                        g2D.drawImage(marketDesert, PlayerInfo.market[i].x, PlayerInfo.market[i].y, null);
                for (int i = 0; i < 10; i++)
                    if (playerInfo.trap[i].show)
                        g2D.drawImage(trapDesert, playerInfo.trap[i].x, playerInfo.trap[i].y, null);

                g2D.drawImage(backgroundColor, 750, 0, null);
                g2D.drawImage(statusBoard, 760, 10, null);
                g2D.drawRoundRect(760, 10, 500, 300, 10, 10);
                g2D.drawImage(inventory, 880, 330, null);
                g2D.drawRoundRect(880, 330, 600, 400, 10, 10);

                if (playerInfo.treasure[0].show) g2D.drawImage(treasure[0], 1393, 355, null);
                if (playerInfo.treasure[1].show) g2D.drawImage(treasure[1], 1407, 445, null);
                if (playerInfo.treasure[2].show) g2D.drawImage(treasure[2], 1400, 540, null);
                if (playerInfo.treasure[3].show) g2D.drawImage(treasure[3], 1397, 635, null);
                if (playerInfo.treasure[4].show) g2D.drawImage(treasure[4], 1330, 351, null);
                if (playerInfo.treasure[5].show) g2D.drawImage(treasure[5], 1314, 445, null);
                if (playerInfo.treasure[6].show) g2D.drawImage(treasure[6], 1325, 545, null);
                if (playerInfo.treasure[7].show) g2D.drawImage(treasure[7], 1314, 635, null);

                if (playerInfo.loot[0].show) {
                    g2D.drawImage(lostObject[0], 1235, 445, null);
                    lootchecker[0] = true;
                }
                if (playerInfo.loot[1].show) {
                    g2D.drawImage(lostObject[1], 1235, 540, null);
                    lootchecker[1] = true;
                }
                if (playerInfo.loot[2].show) {
                    g2D.drawImage(lostObject[2], 1235, 635, null);
                    lootchecker[2] = true;
                }
                if (playerInfo.loot[3].show) {
                    g2D.drawImage(lostObject[3], 1157, 445, null);
                    lootchecker[3] = true;
                }
                if (playerInfo.loot[4].show) {
                    g2D.drawImage(lostObject[4], 1157, 540, null);
                    lootchecker[4] = true;
                }
                if (playerInfo.loot[5].show) {
                    g2D.drawImage(lostObject[5], 1157, 635, null);
                    lootchecker[5] = true;
                }
                if (playerInfo.loot[6].show) {
                    g2D.drawImage(lostObject[6], 1079, 445, null);
                    lootchecker[6] = true;
                }
                if (playerInfo.loot[7].show) {
                    g2D.drawImage(lostObject[7], 1079, 540, null);
                    lootchecker[7] = true;
                }
                if (playerInfo.loot[8].show) {
                    g2D.drawImage(lostObject[8], 1079, 635, null);
                    lootchecker[8] = true;
                }
                if (playerInfo.loot[9].show) {
                    g2D.drawImage(lostObject[9], 1000, 350, null);
                    lootchecker[9] = true;
                }
                if (playerInfo.loot[10].show) {
                    g2D.drawImage(lostObject[10], 1000, 445, null);
                    lootchecker[10] = true;
                }
                if (playerInfo.loot[11].show) {
                    g2D.drawImage(lostObject[11], 1000, 540, null);
                    lootchecker[11] = true;
                }
                if (playerInfo.loot[12].show) {
                    g2D.drawImage(lostObject[12], 1000, 635, null);
                    lootchecker[12] = true;
                }

                for (int i = 0; i < 6; i++)
                    if (playerInfo.move[i][0] != 0 && playerInfo.move[i][1] != 0)
                        g2D.fillOval(playerInfo.move[i][0] + 20, playerInfo.move[i][1] + 20, 10, 10);

                g2D.setPaint(Color.white);
                g2D.setStroke(new BasicStroke(3));//thickness
                g2D.setFont(font16);

                if (playerInfo.weapon[0].number > 0) {
                    g2D.drawImage(weapon[0], 935, 350, null);
                    g2D.drawString(String.valueOf(playerInfo.weapon[0].number), 960, 420);
                }
                if (playerInfo.weapon[1].number > 0) {
                    g2D.drawImage(weapon[1], 926, 445, null);
                    g2D.drawString(String.valueOf(playerInfo.weapon[1].number), 960, 514);
                }
                if (playerInfo.weapon[2].number > 0) {
                    g2D.drawImage(weapon[2], 926, 540, null);
                    g2D.drawString(String.valueOf(playerInfo.weapon[2].number), 960, 608);
                }
                if (playerInfo.weapon[3].number > 0) {
                    g2D.drawImage(weapon[3], 932, 635, null);
                    g2D.drawString(String.valueOf(playerInfo.weapon[3].number), 960, 702);
                }

                g2D.drawImage(questImage, 1093, 60, null);//quest
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
                g2D.drawString(String.valueOf(playerInfo.money + "$"), 1060, 245);

                //treasure score
                for (int i = 0; i < 8; i++)
                    if (once2[i]) {
                        g2D.setFont(font24);
                        g2D.setPaint(new Color(0, 0, 255));
                        g2D.drawString(String.valueOf(treasurescore[i]), 1155, 155);
                        break;
                    }

                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(2));//thickness
                g2D.setFont(font40);

                g2D.drawImage(playerImage, 1250, 20, 250, 250, null);
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

                g2D.setPaint(Color.WHITE);
                g2D.drawString("Click", 768, 402);
                g2D.drawImage(dice, 765, 340, null);//dice
                g2D.setFont(font36);
                g2D.drawString("Next", 775, 497);
                g2D.drawString("state", 773, 595);

                g2D.setFont(font40);
                g2D.setPaint(Color.BLACK);

                g2D.drawRoundRect(766, 340, 100, 100, 10, 10);//dice
                g2D.drawRoundRect(766, 450, 100, 70, 10, 10);//next button
                g2D.drawRoundRect(766, 550, 100, 70, 10, 10);//state button

                for (int i = 0; i < 15; i++)
                    for (int j = 0; j < 15; j++)
                        g2D.drawRoundRect(50 * i, 50 * j, 50, 50, 10, 10);
                g2D.drawRoundRect(750, 700, 50, 50, 10, 10);

                //raise money cause of loot
                for (int i = 0; i < 13; i++) if (once[i] == true) lootchecker[i] = false;

                for (int i = 0; i < 13; i++)
                    if (lootchecker[i] == true) {
                        playerInfo.money += playerInfo.loot[i].price;
                        once[i] = true;
                        repaint();
                    }

                //events at homes

                //market
                int counter = 0;
                if (diceNumber.prt == 0)
                    for (int i = 0; i < 5; i++)
                        if (playerInfo.x == PlayerInfo.market[i].x && playerInfo.y == PlayerInfo.market[i].y) {
                            if (marketBool) {
                                Market market = new Market("img/marketBackground.png", "img/building/marketDesert.png", "Market", playerInfo, player1Image, player2Image);
                                marketBool = false;
                            }
                            repaint();
                        }

                for (int i = 0; i < 5; i++)
                    if (playerInfo.x != PlayerInfo.market[i].x && playerInfo.y != PlayerInfo.market[i].y) counter += 1;
                if (counter == 5) marketBool = true;

                //trap
                if (diceNumber.prt == 0)
                    for (int i = 0; i < 10; i++)
                        if (playerInfo.x == playerInfo.trap[i].x && playerInfo.y == playerInfo.trap[i].y) {
                            if (trapBool) {
                                if (playerInfo.power > 0) playerInfo.power -= 1;
                                if (playerInfo.money > 9) playerInfo.money -= 10;
                                playerInfo.trap[i].show = true;
                                trapBool = false;
                            }
                            repaint();
                        }

                counter = 0;
                for (int i = 0; i < 10; i++)
                    if (playerInfo.x != playerInfo.trap[i].x && playerInfo.y != playerInfo.trap[i].y) counter += 1;
                if (counter == 10) trapBool = true;

                if (diceNumber.prt == 0)
                    for (int i = 0; i < 13; i++)
                        if (playerInfo.x == playerInfo.loot[i].x && playerInfo.y == playerInfo.loot[i].y) {
                            playerInfo.loot[i].show = true;
                            repaint();
                        }
                if (diceNumber.prt == 0)
                    for (int i = 0; i < 8; i++)
                        if (playerInfo.x == playerInfo.treasure[i].x && playerInfo.y == playerInfo.treasure[i].y) {
                            playerInfo.treasure[i].show = true;
                            repaint();
                        }

                //castle
                if (diceNumber.prt == 0)
                    if (castleBool) {
                        if (playerInfo.x == 7 * 50 && playerInfo.y == 7 * 50) {

                            for (int i = 0; i < 8; i++) {
                                if (playerInfo.treasure[i].show == true && quest[i] == true && once2[i] == true) {
                                    playerInfo.money += playerInfo.treasure[i].price;
                                    playerInfo.treasureNumber += 1;
                                    once2[i] = false;
                                    if (player1Info.treasureNumber + player2Info.treasureNumber == 8) break;

                                    int r;
                                    do {
                                        r = rand.nextInt(8);
                                    } while (quest[r]);

                                    once2[r] = true;
                                    quest[r] = true;
                                    questImage = treasure[r];

                                    if (playerInfo.treasure[r].show == true) {
                                        repaint();
                                        continue;
                                    }

                                    castleBool = false;
                                    repaint();
                                    break;
                                }
                            }
                            //ending
                            if (player1Info.treasureNumber + player2Info.treasureNumber == 8) {
                                sw.prt = 3;
                                repaint();
                            }
                        }
                    }
                if (playerInfo.x != 7 * 50 && playerInfo.y != 7 * 50) castleBool = true;

                //fight
                if (diceNumber.prt == 0)
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

                //treasure map
                if (playerInfo.hasTreasureMap) {

                    if (playerInfo.hasTreasureMapOnce) do {
                        treasureRand = rand.nextInt(8);
                        repaint();
                    } while (playerInfo.treasure[treasureRand].show);
                    playerInfo.hasTreasureMapOnce = false;

                    g2D.setPaint(new Color(150, 20, 10));
                    g2D.setStroke(new BasicStroke(5));
                    g2D.drawLine(playerInfo.treasure[treasureRand].x + 10, playerInfo.treasure[treasureRand].y + 10, playerInfo.treasure[treasureRand].x + 40, playerInfo.treasure[treasureRand].y + 40);
                    g2D.drawLine(playerInfo.treasure[treasureRand].x + 40, playerInfo.treasure[treasureRand].y + 10, playerInfo.treasure[treasureRand].x + 10, playerInfo.treasure[treasureRand].y + 40);

                    if (playerInfo.x == playerInfo.treasure[treasureRand].x && playerInfo.y == playerInfo.treasure[treasureRand].y) {
                        playerInfo.hasTreasureMap = false;
                        repaint();
                    }
                }

                break;
            case 3://end

                diceButton.setEnabled(false);
                nextButton.setEnabled(false);
                stateButton.setEnabled(false);

                this.add(endNewGameButton);
                this.add(endOthersButton);
                this.add(endHomeButton);

                endNewGameButton.setEnabled(true);
                endOthersButton.setEnabled(true);
                endHomeButton.setEnabled(true);

                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(4));

                g2D.drawImage(ending, 0, 0, null);

                g2D.drawImage(endMenu, 50, 50, null);
                g2D.setPaint(new Color(100, 100, 50, 150));
                g2D.fillRoundRect(50, 50, 700, 650, 10, 10);
                g2D.setPaint(Color.BLACK);
                g2D.drawRoundRect(50, 50, 700, 650, 10, 10);

                if (player1Info.treasureNumber == player2Info.treasureNumber) {

                    g2D.drawImage(player1Image, 1150, 0, 350, 350, null);
                    g2D.drawImage(player2Image, 1150, 400, 350, 350, null);

                    g2D.drawString("'No Winner !'", 290, 100);

                    for (int i = 0; i < 2; i++) {
                        g2D.drawImage(endIcon[0], 70 + i * 330, 170, 70, 70, null);
                        g2D.drawRoundRect(70 + i * 330, 170, 70, 70, 10, 10);
                    }
                    g2D.drawString(player1Info.name, 150, 220);
                    g2D.drawString(player2Info.name, 480, 220);

                    if (player1Info.treasure[0].show) g2D.drawImage(treasure[0], 200 - 130, 345 - 50, null);
                    if (player1Info.treasure[1].show) g2D.drawImage(treasure[1], 278 - 130, 340 - 50, null);
                    if (player1Info.treasure[2].show) g2D.drawImage(treasure[2], 338 - 130, 340 - 50, null);
                    if (player1Info.treasure[3].show) g2D.drawImage(treasure[3], 400 - 130, 340 - 50, null);
                    if (player1Info.treasure[4].show) g2D.drawImage(treasure[4], 475 - 390, 340 + 40, null);
                    if (player1Info.treasure[5].show) g2D.drawImage(treasure[5], 525 - 390, 340 + 40, null);
                    if (player1Info.treasure[6].show) g2D.drawImage(treasure[6], 602 - 390, 345 + 40, null);
                    if (player1Info.treasure[7].show) g2D.drawImage(treasure[7], 655 - 390, 340 + 40, null);

                    if (player2Info.treasure[0].show) g2D.drawImage(treasure[0], 200 - 130 + 330, 345 - 50, null);
                    if (player2Info.treasure[1].show) g2D.drawImage(treasure[1], 278 - 130 + 330, 340 - 50, null);
                    if (player2Info.treasure[2].show) g2D.drawImage(treasure[2], 338 - 130 + 330, 340 - 50, null);
                    if (player2Info.treasure[3].show) g2D.drawImage(treasure[3], 400 - 130 + 330, 340 - 50, null);
                    if (player2Info.treasure[4].show) g2D.drawImage(treasure[4], 475 - 390 + 330, 340 + 40, null);
                    if (player2Info.treasure[5].show) g2D.drawImage(treasure[5], 525 - 390 + 330, 340 + 40, null);
                    if (player2Info.treasure[6].show) g2D.drawImage(treasure[6], 602 - 390 + 330, 345 + 40, null);
                    if (player2Info.treasure[7].show) g2D.drawImage(treasure[7], 655 - 390 + 330, 340 + 40, null);

                    for (int i = 0; i < 4; i++)
                        for (int j = 0; j < 2; j++) g2D.drawRoundRect(70 + i * 65, 290 + j * 90, 50, 70, 10, 10);
                    for (int i = 0; i < 4; i++)
                        for (int j = 0; j < 2; j++) g2D.drawRoundRect(400 + i * 65, 290 + j * 90, 50, 70, 10, 10);

                } else {

                    if (player1Info.treasureNumber > player2Info.treasureNumber) {
                        playerInfo = player1Info;
                        playerImage = player1Image;
                    } else {
                        playerInfo = player2Info;
                        playerImage = player2Image;
                    }

                    for (int j = 0; j < 5; j++) {
                        g2D.drawImage(endIcon[j], 70, 70 + j * 90, 70, 70, null);
                        g2D.drawRoundRect(70, 70 + j * 90, 70, 70, 10, 10);
                    }

                    if (playerInfo.treasure[0].show) g2D.drawImage(treasure[0], 200, 345, null);
                    if (playerInfo.treasure[1].show) g2D.drawImage(treasure[1], 278, 340, null);
                    if (playerInfo.treasure[2].show) g2D.drawImage(treasure[2], 338, 340, null);
                    if (playerInfo.treasure[3].show) g2D.drawImage(treasure[3], 400, 340, null);
                    if (playerInfo.treasure[4].show) g2D.drawImage(treasure[4], 475, 340, null);
                    if (playerInfo.treasure[5].show) g2D.drawImage(treasure[5], 525, 340, null);
                    if (playerInfo.treasure[6].show) g2D.drawImage(treasure[6], 602, 345, null);
                    if (playerInfo.treasure[7].show) g2D.drawImage(treasure[7], 655, 340, null);

                    g2D.drawImage(weapon[0], 215, 250, null);
                    g2D.drawImage(weapon[1], 270, 250, null);
                    g2D.drawImage(weapon[2], 336, 250, null);
                    g2D.drawImage(weapon[3], 407, 250, null);
                    for (int i = 0; i < 4; i++) {
                        g2D.setFont(font16);
                        g2D.drawString(String.valueOf(playerInfo.weapon[i].number), 238 + i * 65, 315);
                        g2D.drawRoundRect(200 + i * 65, 250, 50, 70, 10, 10);
                    }
                    for (int i = 0; i < 8; i++) {
                        g2D.drawRoundRect(200 + i * 65, 340, 50, 70, 10, 10);
                        if (playerInfo.loot[i].show) g2D.drawImage(lostObject[i], 200 + i * 65, 430, null);
                        g2D.drawRoundRect(200 + i * 65, 430, 50, 70, 10, 10);
                    }
                    for (int i = 0; i < 5; i++) {
                        if (playerInfo.loot[i].show) g2D.drawImage(lostObject[i + 8], 200 + i * 65, 520, null);
                        g2D.drawRoundRect(200 + i * 65, 520, 50, 70, 10, 10);
                    }

                    g2D.drawImage(playerImage, 775, 50, 700, 700, null);

                    g2D.setFont(font40);
                    g2D.drawString(playerInfo.name + "  is the winner", 200, 120);
                    g2D.drawString(playerInfo.money + " $", 200, 207);
                }

                g2D.drawRoundRect(70, 630, 200, 50, 10, 10);
                g2D.drawRoundRect(300, 630, 200, 50, 10, 10);
                g2D.drawRoundRect(530, 630, 200, 50, 10, 10);

                g2D.setFont(font36);
                g2D.drawString("New Game", 77, 667);
                g2D.drawString("Others", 340, 667);
                g2D.drawString("Home", 583, 667);

                repaint();


                break;
            case 4://choose player

                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(4));
                g2D.setFont(font40);

                g2D.drawImage(choosePlayer, 0, 0, 1514, 750, null);

                g2D.setPaint(new Color(100, 70, 50, 170));
                g2D.fillRoundRect(30, 30, 1200, 690, 10, 10);
                g2D.fillRoundRect(1283, 30, 200, 200, 10, 10);
                g2D.fillRoundRect(1283, 350, 200, 200, 10, 10);
                //g2D.fillRoundRect(1283, 230, 200, 50, 10, 10);
                //g2D.fillRoundRect(1283, 550, 200, 50, 10, 10);

                g2D.setPaint(Color.BLACK);
                g2D.drawRoundRect(30, 30, 1200, 690, 10, 10);
                g2D.drawRoundRect(1283, 30, 200, 200, 10, 10);
                g2D.drawRoundRect(1283, 350, 200, 200, 10, 10);
                //g2D.drawRoundRect(1283, 230, 200, 50, 10, 10);
                //g2D.drawRoundRect(1283, 550, 200, 50, 10, 10);

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        g2D.drawRoundRect(60 + i * 235, 55 + j * 220, 200, 200, 10, 10);
                        g2D.drawImage(pImage[3 * i + j], 60 + i * 235, 55 + j * 220, 200, 200, null);
                    }
                }

                g2D.drawImage(player1Image, 1283, 30, 200, 200, null);
                g2D.drawImage(player2Image, 1283, 350, 200, 200, null);

                if (ChoosePlayerArea.p1 != -1) {
                    player1Image = pImage[ChoosePlayerArea.p1];
                    player1 = pSmallImage[ChoosePlayerArea.p1];
                }
                if (ChoosePlayerArea.p2 != -1) {
                    player2Image = pImage[ChoosePlayerArea.p2];
                    player2 = pSmallImage[ChoosePlayerArea.p2];
                }
                playerImage = player1Image;

                repaint();

                break;
        }
    }

   /* public void newGame() {

        player1Info = new PlayerInfo(1, mainTurn, diceNumber, "Werewolf");
        player2Info = new PlayerInfo(2, mainTurn, diceNumber, "Angel");
        sw = 2;
        repaint();
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == continueButton) {

        }
        if (e.getSource() == newGameButton) {
            sw.prt = 4;

            continueButton.setEnabled(false);
            newGameButton.setEnabled(false);
            quitButton.setEnabled(false);
        }
        if (e.getSource() == quitButton) {
            System.exit(0);
        }

        if (e.getSource() == diceButton) if (diceNumber.prt == 0 && diceOnce) {

            diceNumber.prt = rand.nextInt(6) + 1;
            dice = diceImage[diceNumber.prt - 1];
            diceOnce = false;
        }
        if (e.getSource() == nextButton) if (diceNumber.prt == 0) {

            if (mainTurn.prt == 1) {
                mainTurn.prt = 2;
                playerInfo = player2Info;
                playerImage = player2Image;
            } else {
                mainTurn.prt = 1;
                playerInfo = player1Info;
                playerImage = player1Image;
            }

            dice = null;
            diceOnce = true;
        }
        if (e.getSource() == stateButton) {

            if (playerInfo == player1Info) {
                playerInfo = player2Info;
                playerImage = player2Image;
            } else {
                playerInfo = player1Info;
                playerImage = player1Image;
            }
        }

        if (e.getSource() == endNewGameButton) {
            //newGame();
            System.out.println(10);
        }
        if (e.getSource() == endOthersButton) {
            System.out.println(20);
            /*if (playerInfo == player1Info) playerInfo = player2Info;
            else playerInfo = player1Info;*/
        }
        if (e.getSource() == endHomeButton) {
            sw.prt = 1;

            endNewGameButton.setEnabled(false);
            endOthersButton.setEnabled(false);
            endHomeButton.setEnabled(false);
        }

        repaint();
    }
}