import javax.swing.*;
import java.awt.*;

public class panel extends JPanel {

    Image image;

    panel(){

        image = new ImageIcon("img/desert.png").getImage();
        this.setPreferredSize(new Dimension(750,750));
    }
    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(image,0,0,null);

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));//thikness
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.drawRoundRect(75 * i, 75 * j, 75, 75, 10, 10);
            }
        }

    }
}
