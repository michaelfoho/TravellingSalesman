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