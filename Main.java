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


        JLabel statusBoard = new JLabel();
        statusBoard.setText("Status Board");
        statusBoard.setHorizontalTextPosition(JLabel.CENTER);
        statusBoard.setVerticalTextPosition(JLabel.TOP);
        statusBoard.setIconTextGap(-35);//distance between image & text
        statusBoard.setFont(font32);
        ImageIcon statusBoardIcon1 = new ImageIcon("img/statusBoard.png");
        statusBoard.setIcon(statusBoardIcon1);
        statusBoard.setBounds(10, 10, 500, 300);
        statusBoard.setBorder(border);

        JLabel inventory = new JLabel();
        inventory.setText("In              ry");
        inventory.setHorizontalTextPosition(JLabel.CENTER);
        inventory.setVerticalTextPosition(JLabel.TOP);
        inventory.setIconTextGap(-68);//distance between image & text
        inventory.setFont(font32);
        inventory.setForeground(Color.WHITE);
        ImageIcon inventoryIcon1 = new ImageIcon("img/inventory.png");
        inventory.setIcon(inventoryIcon1);
        inventory.setBounds(130, 330, 600, 400);
        inventory.setBorder(border);

        Text textVen = new Text("ven", font32, Color.WHITE, 409, 340, 100, 50);
        Text textTo = new Text("to", font32, Color.WHITE, 421, 370, 100, 50);

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


        JLabel player_2_Image = new JLabel();
        player_2_Image.setText("Illidan");
        player_2_Image.setHorizontalTextPosition(JLabel.CENTER);
        player_2_Image.setVerticalTextPosition(JLabel.BOTTOM);
        player_2_Image.setFont(font32);
        ImageIcon player_2_image_Icon = new ImageIcon("img/player_2_image.png");
        player_2_Image.setIcon(player_2_image_Icon);
        player_2_Image.setBounds(500, 0, 300, 320);


        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max
        JProgressBar player_2_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        JPanel player_1_panel = new JPanel();
        player_1_panel.setBackground(new Color(255, 255, 0));
        player_1_panel.setBounds(0, 0, 750, 750);
        player_1_panel.setLayout(null);
        player_1_panel.setBorder(border);
        player_1_panel.add(player_1_Image);
        player_1_panel.add(player_1_HP_bar);
        player_1_panel.add(statusBoard);
        player_1_panel.add(textVen);
        player_1_panel.add(textTo);
        player_1_panel.add(inventory);
        player_1_panel.add(dice);

        JPanel player_2_panel = new JPanel();
        player_2_panel.setBackground(new Color(0, 0, 255));
        player_2_panel.setBounds(0, 0, 750, 750);
        player_2_panel.setLayout(null);
        player_2_panel.setBorder(border);
        player_2_panel.add(player_2_Image);
        player_2_panel.add(player_2_HP_bar);
        player_2_panel.add(statusBoard);
        player_2_panel.add(textVen);
        player_2_panel.add(textTo);
        player_2_panel.add(inventory);
        player_2_panel.add(dice);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(750, 0, 750, 750);

        layeredPane.add(player_1_panel, Integer.valueOf(0));
        layeredPane.add(player_2_panel, Integer.valueOf(1));


        Frame frame = new Frame();

        frame.add(layeredPane);
        //frame.panel.add(player_1);

        ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);
        ProgressBarDemo player_2_HP_barDemo = new ProgressBarDemo(player_2_HP_bar);


    }
}