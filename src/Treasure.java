import javax.swing.*;

public class Treasure extends JLabel {
    Treasure(String URL, int x, int y, int width, int height) {

        ImageIcon ringIcon = new ImageIcon(URL);
        this.setIcon(ringIcon);
        this.setBounds(x, y, width, height);
    }

}
