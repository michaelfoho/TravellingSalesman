import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame f = new JFrame();
    JLabel l = new JLabel();

    NewWindow() {

        l.setBounds(0, 0, 1514, 775);
        l.setFont(new Font("MV Boli", Font.PLAIN, 25));
        ImageIcon backgroundIcon = new ImageIcon("img/fightBackground.png");//change icon of frame(top left)
        l.setIcon(backgroundIcon);

        f.add(l);
        f.setBounds(12,35,1514,775);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("img/logo.png");//change icon of frame(top left)
        f.setIconImage(imageIcon.getImage());

    }
}
