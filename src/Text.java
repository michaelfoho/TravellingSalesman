import javax.swing.*;
import java.awt.*;

public class Text extends JLabel {

    Text(String text, Font font, Color color, int x, int y, int width, int height) {
        this.setText(text);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setFont(font);
        this.setForeground(color);
        this.setBounds(x, y, width, height);
    }

}
