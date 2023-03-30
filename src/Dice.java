import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Dice implements MouseListener {

    Random rand = new Random();
    int r;
    int previous_r = -1;
    int two_r_before = -2;

    @Override
    public void mouseClicked(MouseEvent e) {

        r = rand.nextInt(6) + 1;

        while (r == previous_r && r == two_r_before) {

            r = rand.nextInt(6) + 1;
        }

        two_r_before = previous_r;
        previous_r = r;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
