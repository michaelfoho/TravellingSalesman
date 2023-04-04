import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Button extends JButton {

    Border border = BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true);
    Font font24 = new Font("Century", Font.PLAIN, 24);


    Button(int x, int y, int width, int height, String text, Color color) {
        this.setBounds(x, y, width, height);
        //this.addActionListener(this);//bayad beravad tooye panel
        this.setFocusable(true);
        this.setVisible(true);
        this.setText(text);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setFont(font24);
        this.setForeground(Color.BLACK);
        this.setBackground(color);//if you add an image for background of button comment this line
        this.setEnabled(true);//if you want to disable the button change (true) to (false)
    }

}
