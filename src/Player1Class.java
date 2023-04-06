import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1Class implements KeyListener {

    int x = 750;
    int y = 675;

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyChar() == 'w' && y - 75 >= 0) y -= 75;
        if (e.getKeyChar() == 's' && y + 75 <= 675) y += 75;
        if (e.getKeyChar() == 'a' && x - 75 >= 0) x -= 75;
        if (e.getKeyChar() == 'd' && x + 75 < 750) x += 75;

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
