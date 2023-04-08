import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame f = new JFrame();
    JLabel l = new JLabel();

    NewWindow() {

        l.setBounds(0, 0, 100, 50);
        l.setFont(new Font("MV Boli", Font.PLAIN, 25));

        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(750, 750);
        f.setLocationRelativeTo(null);//load frame in the center of screen instead the top corner
        f.setLayout(null);
        f.setVisible(true);

    }
}
