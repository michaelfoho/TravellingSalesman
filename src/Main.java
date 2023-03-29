import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 3);


        JLabel desert = new JLabel();
        ImageIcon desertIcon = new ImageIcon("img/desert.png");
        desert.setIcon(desertIcon);
        desert.setBounds(0, 0, 750, 750);
        //desert.setBorder(border);

        JLabel statusBoard = new JLabel();
        statusBoard.setText("Status Board");
        statusBoard.setHorizontalTextPosition(JLabel.CENTER);
        statusBoard.setVerticalTextPosition(JLabel.TOP);
        statusBoard.setIconTextGap(-35);//distance between image & text
        statusBoard.setFont(new Font("Century", Font.PLAIN, 32));
        ImageIcon informationIcon = new ImageIcon("img/statusBoard.png");
        statusBoard.setIcon(informationIcon);
        statusBoard.setBounds(10, 10, 500, 300);
        statusBoard.setBorder(border);


        JLabel player_1_Image = new JLabel();
        player_1_Image.setText("Werewolf");
        player_1_Image.setHorizontalTextPosition(JLabel.CENTER);
        player_1_Image.setVerticalTextPosition(JLabel.BOTTOM);
        player_1_Image.setFont(new Font("Century", Font.PLAIN, 32));
        ImageIcon player_1_image_Icon = new ImageIcon("img/player_1_image.png");
        player_1_Image.setIcon(player_1_image_Icon);
        player_1_Image.setBounds(500, 0, 300, 320);


        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 0, 0));
        leftPanel.setBounds(0, 0, 750, 750);
        leftPanel.setLayout(null);

        leftPanel.add(desert);


        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 0));
        rightPanel.setBounds(750, 0, 750, 750);
        rightPanel.setLayout(null);

        rightPanel.add(player_1_Image);
        rightPanel.add(player_1_HP_bar);
        rightPanel.add(statusBoard);


        Frame frame = new Frame();

        frame.add(leftPanel);
        frame.add(rightPanel);

        ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);


    }
}