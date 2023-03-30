import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 4, true);
        Font font32 = new Font("Century", Font.PLAIN, 32);


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


        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 0));
        rightPanel.setBounds(750, 0, 750, 750);
        rightPanel.setLayout(null);
        rightPanel.setBorder(border);
        rightPanel.add(player_1_Image);
        rightPanel.add(player_1);
        rightPanel.add(player_1_HP_bar);
        rightPanel.add(statusBoard);
        rightPanel.add(textVen);
        rightPanel.add(textTo);
        rightPanel.add(inventory);


        Frame frame = new Frame();

        frame.add(rightPanel);
        //frame.panel.add(player_1);

        ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);


    }
}