import javax.swing.*;
import javax.swing.border.Border;
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
    int sw = 2;
    int repaint = 1;//for repaint after firstpage
    int ending_y = -810;
    int treasurescore[] = new int[8];
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

    Button nextButton, stateButton, diceButton, continueButton, newGameButton, quitButton, ExitButton, NewgameButton;

    Image firstPage, desert, backgroundColor;
    Image castle, wall, treasureBox, lootBox;
    Image trapDesert;
    Image marketDesert;
    Image statusBoard, inventory;
    Image playerImage, werewolfImage, angelImage;
    Image player1, player2, werewolf, angel;
    Image[] treasure = new Image[8];
    Image[] lostObject = new Image[13];
    Image[] weapon = new Image[4];
    Image[] diceImage = new Image[6];
    Image dice;
    Image questImage;
    Image ending;

    Panel() {

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

        ExitButton = new Button(700, 80, 100, 50, "Exit", new Color(100, 100, 100));
        ExitButton.addActionListener(this);

        NewgameButton = new Button(800, 130, 100, 50, "Newgame", new Color(180, 150, 0));
        NewgameButton.addActionListener(this);


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

        werewolfImage = new ImageIcon("img/hero/werewolf.png").getImage();
        angelImage = new ImageIcon("img/hero/angel.png").getImage();

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

        ending = new ImageIcon("img/ending.png").getImage();


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

        switch (sw) {

            case 1:

                this.add(continueButton);
                this.add(newGameButton);
                this.add(quitButton);


                g2D.drawImage(firstPage, 0, 0, null);

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
                    if (playerInfo.mapLoot[i].show)
                        g2D.drawImage(lootBox, playerInfo.mapLoot[i].x, playerInfo.mapLoot[i].y, null);
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

                if (playerInfo.treasure[0].show) g2D.drawImage(treasure[0], 1393, 355, null);
                if (playerInfo.treasure[1].show) g2D.drawImage(treasure[1], 1407, 445, null);
                if (playerInfo.treasure[2].show) g2D.drawImage(treasure[2], 1400, 540, null);
                if (playerInfo.treasure[3].show) g2D.drawImage(treasure[3], 1397, 635, null);
                if (playerInfo.treasure[4].show) g2D.drawImage(treasure[4], 1330, 351, null);
                if (playerInfo.treasure[5].show) g2D.drawImage(treasure[5], 1314, 445, null);
                if (playerInfo.treasure[6].show) g2D.drawImage(treasure[6], 1325, 545, null);
                if (playerInfo.treasure[7].show) g2D.drawImage(treasure[7], 1314, 635, null);

                if (playerInfo.mapLoot[0].show) {
                    g2D.drawImage(lostObject[0], 1235, 445, null);
                    lootchecker[0] = true;
                }
                if (playerInfo.mapLoot[1].show) {
                    g2D.drawImage(lostObject[1], 1235, 540, null);
                    lootchecker[1] = true;
                }
                if (playerInfo.mapLoot[2].show) {
                    g2D.drawImage(lostObject[2], 1235, 635, null);
                    lootchecker[2] = true;
                }
                if (playerInfo.mapLoot[3].show) {
                    g2D.drawImage(lostObject[3], 1157, 445, null);
                    lootchecker[3] = true;
                }
                if (playerInfo.mapLoot[4].show) {
                    g2D.drawImage(lostObject[4], 1157, 540, null);
                    lootchecker[4] = true;
                }
                if (playerInfo.mapLoot[5].show) {
                    g2D.drawImage(lostObject[5], 1157, 635, null);
                    lootchecker[5] = true;
                }
                if (playerInfo.mapLoot[6].show) {
                    g2D.drawImage(lostObject[6], 1079, 445, null);
                    lootchecker[6] = true;
                }
                if (playerInfo.mapLoot[7].show) {
                    g2D.drawImage(lostObject[7], 1079, 540, null);
                    lootchecker[7] = true;
                }
                if (playerInfo.mapLoot[8].show) {
                    g2D.drawImage(lostObject[8], 1079, 635, null);
                    lootchecker[8] = true;
                }
                if (playerInfo.mapLoot[9].show) {
                    g2D.drawImage(lostObject[9], 1000, 350, null);
                    lootchecker[9] = true;
                }
                if (playerInfo.mapLoot[10].show) {
                    g2D.drawImage(lostObject[10], 1000, 445, null);
                    lootchecker[10] = true;
                }
                if (playerInfo.mapLoot[11].show) {
                    g2D.drawImage(lostObject[11], 1000, 540, null);
                    lootchecker[11] = true;
                }
                if (playerInfo.mapLoot[12].show) {
                    g2D.drawImage(lostObject[12], 1000, 635, null);
                    lootchecker[12] = true;
                }

                for (int i = 0; i < 6; i++) {
                    if (playerInfo.move[i][0] != 0 && playerInfo.move[i][1] != 0)
                        g2D.fillOval(playerInfo.move[i][0] + 20, playerInfo.move[i][1] + 20, 10, 10);
                }

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

                //treasure score
                for (int i=0;i<8;i++){
                    if (once2[i]) {
                        g2D.setFont(font24);
                        g2D.setPaint(new Color(0, 0, 255));
                        g2D.drawString(String.valueOf(treasurescore[i]), 1155, 155);
                        break;
                    }
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


                g2D.drawRoundRect(750, 700, 50, 50, 10, 10);


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

                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        g2D.drawRoundRect(50 * i, 50 * j, 50, 50, 10, 10);
                    }
                }


                //quest
                g2D.drawImage(questImage, 1093, 60, null);


                //raise money cause of loot
                for (int i = 0; i < 13; i++) {
                    if (once[i] == true) lootchecker[i] = false;
                }
                for (int i = 0; i < 13; i++) {
                    if (lootchecker[i] == true) {
                        playerInfo.money += playerInfo.mapLoot[i].price;
                        once[i] = true;
                        repaint();
                    }
                }

                //events at homes
                //market
                int counter = 0;
                for (int i = 0; i < 5; i++) {
                    if (playerInfo.x == PlayerInfo.market[i].x && playerInfo.y == PlayerInfo.market[i].y) {
                        if (marketBool) {
                            Market market = new Market("img/marketBackground.png", "img/building/marketDesert.png", "Market", playerInfo);
                            marketBool = false;
                            break;
                        }
                        repaint();
                    }
                }
                for (int i = 0; i < 5; i++) {
                    if (playerInfo.x != PlayerInfo.market[i].x && playerInfo.y != PlayerInfo.market[i].y) {
                        counter += 1;
                    }
                }
                if (counter == 5) marketBool = true;

                //trap
                for (int i = 0; i < 10; i++) {
                    if (playerInfo.x == playerInfo.trap[i].x && playerInfo.y == playerInfo.trap[i].y) {
                        if (trapBool) {
                            if (playerInfo.power > 0) playerInfo.power -= 1;
                            if (playerInfo.money > 9) playerInfo.money -= 10;
                            playerInfo.trap[i].show = true;
                            trapBool = false;
                            break;
                        }
                        repaint();
                    }
                }
                counter = 0;
                for (int i = 0; i < 10; i++) {
                    if (playerInfo.x != playerInfo.trap[i].x && playerInfo.y != playerInfo.trap[i].y) {
                        counter += 1;
                    }
                }
                if (counter == 10) trapBool = true;

                for (int i = 0; i < 13; i++) {
                    if (playerInfo.x == playerInfo.mapLoot[i].x && playerInfo.y == playerInfo.mapLoot[i].y) {
                        playerInfo.mapLoot[i].show = true;
                        repaint();
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (playerInfo.x == playerInfo.treasure[i].x && playerInfo.y == playerInfo.treasure[i].y) {
                        playerInfo.treasure[i].show = true;
                        repaint();
                    }
                }

                //castle
                if (castleBool) {
                    if (playerInfo.x == 7 * 50 && playerInfo.y == 7 * 50) {

                        for (int i = 0; i < 8; i++) {
                            if (playerInfo.treasure[i].show == true && quest[i] == true && once2[i] == true) {
                                playerInfo.money += playerInfo.treasure[i].price;
                                playerInfo.treasure_number += 1;
                                once2[i] = false;
                                if (player1Info.treasure_number + player2Info.treasure_number == 8) break;

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
                        if (player1Info.treasure_number + player2Info.treasure_number == 8) {

                            g2D.drawImage(ending, 0, 0, null);

                            if (player1Info.treasure_number > player2Info.treasure_number) {
                                g2D.drawImage(werewolfImage, 280, 350, 250, 250, null);
                                g2D.setFont(font40);
                                g2D.setPaint(new Color(160, 160, 160));
                                g2D.drawString(player1Info.name, 330, 640);
                                g2D.setPaint(Color.white);
                                g2D.drawString("is winner", 490, 490);
                                this.add(NewgameButton);
                                this.add(ExitButton);

                            } else if (player2Info.treasure_number > player1Info.treasure_number) {
                                g2D.drawImage(angelImage, 200, 400, null);
                                g2D.setFont(font40);
                                g2D.setPaint(new Color(160, 160, 160));
                                g2D.drawString(player2Info.name, 200, 470);
                                g2D.setPaint(Color.white);
                                g2D.drawString("is winner", 230, 430);
                                this.add(NewgameButton);
                                this.add(ExitButton);

                            } else if (player1Info.treasure_number == player2Info.treasure_number) {
                                g2D.drawImage(werewolfImage, 200, 400, null);
                                g2D.drawImage(angelImage, 280, 400, null);
                                g2D.setFont(font40);
                                g2D.setPaint(new Color(160, 160, 160));
                                g2D.drawString(player1Info.name, 200, 470);
                                g2D.drawString(player2Info.name, 280, 470);
                                g2D.setPaint(Color.white);
                                g2D.drawString("=", 240, 430);
                                this.add(NewgameButton);
                                this.add(ExitButton);
                            }
                            repaint();
                        }

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


                if (playerInfo.x != 7 * 50 && playerInfo.y != 7 * 50) castleBool = true;


                break;

            case 3://end


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
        if (e.getSource() == stateButton) {

            if (playerInfo == player1Info) {

                playerInfo = player2Info;
                playerImage = angelImage;
            } else {

                playerInfo = player1Info;
                playerImage = werewolfImage;
            }
        }

        if (e.getSource() == ExitButton) System.exit(0);

        if (e.getSource() == NewgameButton) sw = 2;

        repaint();
    }
}