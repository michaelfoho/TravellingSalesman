import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /*JLabel desert = new JLabel();
        ImageIcon desertIcon = new ImageIcon("img/desert.png");
        desert.setIcon(desertIcon);
        desert.setBounds(0, 0, 750, 750);*/

        JLabel information = new JLabel();
        ImageIcon informationIcon = new ImageIcon("img/information.png");
        information.setIcon(informationIcon);
        information.setBounds(17, 320, 700, 400);


        JLabel player_1_Image = new JLabel();
        player_1_Image.setText("Werewolf");
        player_1_Image.setHorizontalTextPosition(JLabel.CENTER);
        player_1_Image.setVerticalTextPosition(JLabel.BOTTOM);
        player_1_Image.setFont(new Font("Century", Font.PLAIN, 32));
        ImageIcon player_1_image_Icon = new ImageIcon("img/player_1_image.png");
        player_1_Image.setIcon(player_1_image_Icon);
        player_1_Image.setBounds(500, -230, 750, 750);


        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 0, 0));
        leftPanel.setBounds(0, 0, 750, 750);
        leftPanel.setLayout(null);

        //leftPanel.add(desert);


        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 0));
        rightPanel.setBounds(750, 0, 750, 750);
        rightPanel.setLayout(null);

        rightPanel.add(player_1_Image);
        rightPanel.add(player_1_HP_bar);
        rightPanel.add(information);


        Frame frame = new Frame();

        frame.add(leftPanel);
        frame.add(rightPanel);

        ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);


    }
}