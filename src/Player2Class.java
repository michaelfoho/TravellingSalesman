import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player2Class implements KeyListener {

    int x = 750;
    int y = 675;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 38 && y - 75 >= 0) y -= 75;
        if (e.getKeyCode() == 40 && y + 75 <= 675) y += 75;
        if (e.getKeyCode() == 37 && x - 75 >= 0) x -= 75;
        if (e.getKeyCode() == 39 && x + 75 < 750) x += 75;

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
