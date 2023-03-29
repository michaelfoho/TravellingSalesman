import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JLabel desert = new JLabel();
        ImageIcon desertIcon = new ImageIcon("img/desert.png");
        desert.setIcon(desertIcon);


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 0, 0));
        leftPanel.setBounds(0, 0, 750, 750);
        leftPanel.setLayout(new BorderLayout());

        leftPanel.add(desert);


        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 0));
        rightPanel.setBounds(750, 0, 750, 750);


        Frame frame = new Frame();

        frame.add(leftPanel);
        frame.add(rightPanel);
    }
}