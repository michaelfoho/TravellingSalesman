import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {

        int diceNumber = 1;


        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 4, true);
        Font font32 = new Font("Century", Font.PLAIN, 32);
        Font font64 = new Font("Century", Font.PLAIN, 64);
        Font font24 = new Font("Century", Font.PLAIN, 24);


        /*TreasureLoot ring = new TreasureLoot("img/treasure/ring.png", 646, 350, 50, 70);
        TreasureLoot sword = new TreasureLoot("img/treasure/sword.png", 660, 445, 50, 70);
        TreasureLoot goldenGlass = new TreasureLoot("img/treasure/goldenGlass.png", 655, 540, 50, 70);
        TreasureLoot glassCup = new TreasureLoot("img/treasure/glassCup.png", 652, 635, 50, 70);
        TreasureLoot bow = new TreasureLoot("img/treasure/bow.png", 583, 350, 50, 70);
        TreasureLoot shield = new TreasureLoot("img/treasure/shield.png", 567, 447, 50, 70);
        TreasureLoot key = new TreasureLoot("img/treasure/key.png", 580, 540, 50, 70);
        TreasureLoot scroll = new TreasureLoot("img/treasure/scroll.png", 567, 637, 50, 70);

        TreasureLoot lostObject_1 = new TreasureLoot("img/lostObject/lostObject_1.png", 490, 445, 50, 70);
        TreasureLoot lostObject_2 = new TreasureLoot("img/lostObject/lostObject_2.png", 490, 540, 50, 70);
        TreasureLoot lostObject_3 = new TreasureLoot("img/lostObject/lostObject_3.png", 490, 635, 50, 70);
        TreasureLoot lostObject_4 = new TreasureLoot("img/lostObject/lostObject_4.png", 411, 445, 50, 70);
        TreasureLoot lostObject_5 = new TreasureLoot("img/lostObject/lostObject_5.png", 411, 540, 50, 70);
        TreasureLoot lostObject_6 = new TreasureLoot("img/lostObject/lostObject_6.png", 411, 635, 50, 70);
        TreasureLoot lostObject_7 = new TreasureLoot("img/lostObject/lostObject_7.png", 332, 447, 50, 70);
        TreasureLoot lostObject_8 = new TreasureLoot("img/lostObject/lostObject_8.png", 332, 540, 50, 70);
        TreasureLoot lostObject_9 = new TreasureLoot("img/lostObject/lostObject_9.png", 332, 635, 50, 70);
        TreasureLoot lostObject_10 = new TreasureLoot("img/lostObject/lostObject_10.png", 253, 540, 50, 70);
        TreasureLoot lostObject_11 = new TreasureLoot("img/lostObject/lostObject_11.png", 253, 635, 50, 70);
        TreasureLoot lostObject_12 = new TreasureLoot("img/lostObject/lostObject_12.png", 175, 540, 50, 70);
        TreasureLoot lostObject_13 = new TreasureLoot("img/lostObject/lostObject_13.png", 175, 637, 50, 70);*/

       /* JLabel statusBoard1 = new JLabel();
        statusBoard1.setText("Status Board");
        statusBoard1.setHorizontalTextPosition(JLabel.CENTER);
        statusBoard1.setVerticalTextPosition(JLabel.TOP);
        statusBoard1.setIconTextGap(-35);//distance between image & text
        statusBoard1.setFont(font32);
        ImageIcon statusBoardIcon1 = new ImageIcon("img/statusBoard.png");
        statusBoard1.setIcon(statusBoardIcon1);
        statusBoard1.setBounds(10, 10, 500, 300);
        statusBoard1.setBorder(border);*/

        /*JLabel statusBoard2 = new JLabel();
        statusBoard2.setText("Status Board");
        statusBoard2.setHorizontalTextPosition(JLabel.CENTER);
        statusBoard2.setVerticalTextPosition(JLabel.TOP);
        statusBoard2.setIconTextGap(-35);//distance between image & text
        statusBoard2.setFont(font32);
        ImageIcon statusBoardIcon2 = new ImageIcon("img/statusBoard.png");
        statusBoard2.setIcon(statusBoardIcon2);
        statusBoard2.setBounds(10, 10, 500, 300);
        statusBoard2.setBorder(border);*/

        /*JLabel inventory1 = new JLabel();
        inventory1.setText("In              ry");
        inventory1.setHorizontalTextPosition(JLabel.CENTER);
        inventory1.setVerticalTextPosition(JLabel.TOP);
        inventory1.setIconTextGap(-68);//distance between image & text
        inventory1.setFont(font32);
        inventory1.setForeground(Color.WHITE);
        ImageIcon inventoryIcon1 = new ImageIcon("img/inventory.png");
        inventory1.setIcon(inventoryIcon1);
        inventory1.setBounds(130, 330, 600, 400);
        inventory1.setBorder(border);*/

        /*JLabel inventory2 = new JLabel();
        inventory2.setText("In              ry");
        inventory2.setHorizontalTextPosition(JLabel.CENTER);
        inventory2.setVerticalTextPosition(JLabel.TOP);
        inventory2.setIconTextGap(-68);//distance between image & text
        inventory2.setFont(font32);
        inventory2.setForeground(Color.WHITE);
        ImageIcon inventoryIcon2 = new ImageIcon("img/inventory.png");
        inventory2.setIcon(inventoryIcon2);
        inventory2.setBounds(130, 330, 600, 400);
        inventory2.setBorder(border);*/

       /* Text textVen1 = new Text("ven", font32, Color.WHITE, 409, 340, 100, 50);
        Text textVen2 = new Text("ven", font32, Color.WHITE, 409, 340, 100, 50);
        Text textTo1 = new Text("to", font32, Color.WHITE, 421, 370, 100, 50);
        Text textTo2 = new Text("to", font32, Color.WHITE, 421, 370, 100, 50);
        Text textquest1 = new Text("quest:", font32, Color.BLACK, 245, 30, 300, 100);
        Text textquest2 = new Text("quest:", font32, Color.BLACK, 245, 30, 300, 100);
        Text text_treasure_number_1 = new Text("treasure number:", font24, Color.WHITE, 245, 70, 300, 100);
        Text text_treasure_number_2 = new Text("treasure number:", font24, Color.WHITE, 245, 70, 300, 100);
        Text text_treasure_score_1 = new Text("treasure score:", font24, Color.WHITE, 245, 110, 300, 100);
        Text textT_treasure_score_2 = new Text("treasure score:", font24, Color.WHITE, 245, 110, 300, 100);
        Text textpower1 = new Text("power:", font24, Color.WHITE, 245, 150, 300, 100);
        Text textpower2 = new Text("power:", font24, Color.WHITE, 245, 150, 300, 100);
        Text textmoney1 = new Text("money:", font24, Color.WHITE, 245, 190, 300, 100);
        Text textmoney2 = new Text("money:", font24, Color.WHITE, 245, 190, 300, 100);
        Text texttime1 = new Text("time:", font24, Color.WHITE, 245, 230, 300, 100);
        Text texttime2 = new Text("time:", font24, Color.WHITE, 245, 230, 300, 100);*/

        JLabel dice1 = new JLabel();
        dice1.setText("" + diceNumber);
        dice1.setHorizontalAlignment(JLabel.CENTER);
        dice1.setVerticalAlignment(JLabel.CENTER);
        dice1.setFont(font64);
        dice1.setBackground(new Color(255, 0, 0, 70));//background color
        dice1.setOpaque(true);//display background color
        dice1.setBounds(17, 340, 100, 100);
        dice1.setBorder(border);
        MouseListener diceMouse1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("0");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        dice1.addMouseListener(diceMouse1);

        JLabel dice2 = new JLabel();
        dice2.setText("" + diceNumber);
        dice2.setHorizontalAlignment(JLabel.CENTER);
        dice2.setVerticalAlignment(JLabel.CENTER);
        dice2.setFont(font64);
        dice2.setBackground(new Color(255, 0, 0, 70));//background color
        dice2.setOpaque(true);//display background color
        dice2.setBounds(17, 340, 100, 100);
        dice2.setBorder(border);
        MouseListener diceMouse2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("0");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        dice2.addMouseListener(diceMouse2);


        /*JLabel player_1_Image = new JLabel();
        player_1_Image.setText("Werewolf");
        player_1_Image.setForeground(Color.BLACK);
        player_1_Image.setHorizontalTextPosition(JLabel.CENTER);
        player_1_Image.setVerticalTextPosition(JLabel.BOTTOM);
        player_1_Image.setFont(font32);
        ImageIcon player_1_image_Icon = new ImageIcon("img/hero/player_1_image.png");
        player_1_Image.setIcon(player_1_image_Icon);
        player_1_Image.setBounds(500, 0, 300, 320);

        JLabel player_2_Image = new JLabel();
        player_2_Image.setText("Angel");
        player_2_Image.setForeground(Color.BLACK);
        player_2_Image.setHorizontalTextPosition(JLabel.CENTER);
        player_2_Image.setVerticalTextPosition(JLabel.BOTTOM);
        player_2_Image.setFont(font32);
        ImageIcon player_2_image_Icon = new ImageIcon("img/hero/player_2_image.png");
        player_2_Image.setIcon(player_2_image_Icon);
        player_2_Image.setBounds(500, 0, 300, 320);*/


        /*JLabel player_1 = new JLabel();
        player_1.setHorizontalTextPosition(JLabel.CENTER);
        player_1.setVerticalTextPosition(JLabel.CENTER);
        ImageIcon player_1_Icon = new ImageIcon("img/hero/player_1.png");
        player_1.setIcon(player_1_Icon);
        player_1.setBounds(0, 675, 75, 75);
        player_1.setBorder(border);

        JLabel player_2 = new JLabel();
        player_2.setHorizontalTextPosition(JLabel.CENTER);
        player_2.setVerticalTextPosition(JLabel.CENTER);
        ImageIcon player_2_Icon = new ImageIcon("img/hero/player_2.png");
        player_2.setIcon(player_2_Icon);
        player_2.setBounds(0, 675, 75, 75);
        player_2.setBorder(border);*/


        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max
        JProgressBar player_2_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        JPanel player_1_panel = new JPanel();
        player_1_panel.setBackground(new Color(50, 50, 50));
        player_1_panel.setBounds(0, 0, 750, 750);
        player_1_panel.setLayout(null);
        player_1_panel.setBorder(border);
        // player_1_panel.add(player_1_Image);
        ///player_1_panel.add(player_1);
        //player_1_panel.add(player_1_HP_bar);
        //player_1_panel.add(textquest1);
        //player_1_panel.add(text_treasure_number_1);
        //player_1_panel.add(text_treasure_score_1);
        //player_1_panel.add(textpower1);
        //player_1_panel.add(textmoney1);
        //player_1_panel.add(texttime1);
        ////player_1_panel.add(statusBoard1);
        //player_1_panel.add(textVen1);
        //player_1_panel.add(textTo1);

        //player_1_panel.add(ring);
        //player_1_panel.add(sword);
        //player_1_panel.add(goldenGlass);
        //player_1_panel.add(glassCup);
        //player_1_panel.add(bow);
        //player_1_panel.add(shield);
        //player_1_panel.add(key);
        //player_1_panel.add(scroll);

        //player_1_panel.add(lostObject_1);
        //player_1_panel.add(lostObject_2);
        //player_1_panel.add(lostObject_3);
        //player_1_panel.add(lostObject_4);
        //player_1_panel.add(lostObject_5);
        //player_1_panel.add(lostObject_6);
        //player_1_panel.add(lostObject_7);
        //player_1_panel.add(lostObject_8);
        //player_1_panel.add(lostObject_9);
        //player_1_panel.add(lostObject_10);
        //player_1_panel.add(lostObject_11);
        //player_1_panel.add(lostObject_12);
        //player_1_panel.add(lostObject_13);

        //player_1_panel.add(inventory1);
        player_1_panel.add(dice1);


        JPanel player_2_panel = new JPanel();
        player_2_panel.setBackground(new Color(200, 200, 200));
        player_2_panel.setBounds(0, 0, 750, 750);
        player_2_panel.setLayout(null);
        player_2_panel.setBorder(border);
        // player_2_panel.add(player_2_Image);
        //player_2_panel.add(player_2);
        //player_2_panel.add(player_2_HP_bar);
        //player_2_panel.add(textquest2);
        //player_2_panel.add(text_treasure_number_2);
        //player_2_panel.add(textT_treasure_score_2);
        //player_2_panel.add(textpower2);
        //player_2_panel.add(textmoney2);
        //player_2_panel.add(texttime2);
        //// player_2_panel.add(statusBoard2);
        //player_2_panel.add(textVen2);
        //player_2_panel.add(textTo2);
        //// player_2_panel.add(inventory2);
        //player_2_panel.add(dice2);


        Frame frame = new Frame();

        frame.add(player_1_HP_bar);

        ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);
        //ProgressBarDemo player_2_HP_barDemo = new ProgressBarDemo(player_2_HP_bar);
    }
}