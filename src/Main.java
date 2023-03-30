import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {

        int diceNumber = 0;


        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 4, true);
        Font font32 = new Font("Century", Font.PLAIN, 32);
        Font font64 = new Font("Century", Font.PLAIN, 64);
        Font font24 = new Font("Century", Font.PLAIN, 24);


        JLabel statusBoard = new JLabel();
        statusBoard.setText("Status Board");
        statusBoard.setHorizontalTextPosition(JLabel.CENTER);
        statusBoard.setVerticalTextPosition(JLabel.TOP);
        statusBoard.setIconTextGap(-35);//distance between image & text
        statusBoard.setFont(font32);
        //statusBoard.setForeground(Color.WHITE);
        ImageIcon statusBoardIcon = new ImageIcon("img/statusBoard.png");
        statusBoard.setIcon(statusBoardIcon);
        statusBoard.setBounds(10, 10, 500, 300);
        statusBoard.setBorder(border);

        JLabel inventory = new JLabel();
        inventory.setText("In              ry");
        inventory.setHorizontalTextPosition(JLabel.CENTER);
        inventory.setVerticalTextPosition(JLabel.TOP);
        inventory.setIconTextGap(-68);//distance between image & text
        inventory.setFont(font32);
        inventory.setForeground(Color.WHITE);
        ImageIcon inventoryIcon = new ImageIcon("img/inventory.png");
        inventory.setIcon(inventoryIcon);
        inventory.setBounds(130, 330, 600, 400);
        inventory.setBorder(border);

        Text textVen = new Text("ven", font32, Color.WHITE, 409, 340, 100, 50);
        Text textTo = new Text("to", font32, Color.WHITE, 421, 370, 100, 50);
        Text texttime = new Text("time:",font24,Color.WHITE,230,217,100,100);
        Text text_treasure_score = new Text("treasure score:",font24,Color.WHITE,230,113,300,100);
        Text textmoney = new Text("money:",font24,Color.WHITE,230,147,300,100);
        Text textpower = new Text("power:",font24,Color.WHITE,230,180,300,100);
        Text textquest = new Text("quest:",font32,Color.WHITE,230,25,300,100);
        Text text_treasure_number = new Text("treasure number:",font24,Color.WHITE,230,75,300,100);

        JLabel player_1_Image = new JLabel();
        player_1_Image.setText("Werewolf");
        player_1_Image.setHorizontalTextPosition(JLabel.CENTER);
        player_1_Image.setVerticalTextPosition(JLabel.BOTTOM);
        player_1_Image.setFont(font32);
        ImageIcon player_1_image_Icon = new ImageIcon("img/player_1_image.png");
        player_1_Image.setIcon(player_1_image_Icon);
        player_1_Image.setBounds(500, 0, 300, 320);

        JLabel player_1 = new JLabel();
        player_1.setHorizontalTextPosition(JLabel.CENTER);
        player_1.setVerticalTextPosition(JLabel.CENTER);
        ImageIcon player_1_Icon = new ImageIcon("img/player_1.png");
        player_1.setIcon(player_1_Icon);
        player_1.setBounds(0, 675, 75, 75);
        player_1.setBorder(border);

        JLabel dice = new JLabel();
        dice.setText("" + diceNumber);
        dice.setHorizontalAlignment(JLabel.CENTER);
        dice.setVerticalAlignment(JLabel.CENTER);
        dice.setFont(font64);
        dice.setBackground(new Color(255, 0, 0, 70));//background color
        dice.setOpaque(true);//display background color
        dice.setBounds(17, 340, 100, 100);
        dice.setBorder(border);
        MouseListener diceMouse = new MouseListener() {
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
        dice.addMouseListener(diceMouse);


        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        JPanel player_1_panel = new JPanel();
        player_1_panel.setBackground(new Color(255, 255, 0));
        player_1_panel.setBounds(750, 0, 750, 750);
        player_1_panel.setLayout(null);
        player_1_panel.setBorder(border);

        player_1_panel.add(player_1_Image);
        player_1_panel.add(player_1);
        player_1_panel.add(player_1_HP_bar);
        player_1_panel.add(texttime);
        player_1_panel.add(text_treasure_number);
        player_1_panel.add(text_treasure_score);
        player_1_panel.add(textmoney);
        player_1_panel.add(textpower);
        player_1_panel.add(textquest);
        player_1_panel.add(statusBoard);
        player_1_panel.add(textVen);
        player_1_panel.add(textTo);
        player_1_panel.add(inventory);


        player_1_panel.add(dice);


        Frame frame = new Frame();

        frame.add(player_1_panel);
        //frame.panel.add(player_1);

        ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);


    }
}