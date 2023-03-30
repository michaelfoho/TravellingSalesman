import javax.swing.*;

public class TreasureLoot extends JLabel {
    TreasureLoot(String URL, int x, int y, int width, int height) {

        ImageIcon ringIcon = new ImageIcon(URL);
        this.setIcon(ringIcon);
        this.setBounds(x, y, width, height);
    }

}
