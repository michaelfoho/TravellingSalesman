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

        switch (e.getKeyCode()) {
            case 38:
                y -= 75;
                break;
            case 40:
                y += 75;
                break;
            case 37:
                x -= 75;
                break;
            case 39:
                x += 75;
                break;
        }//move with the arrows
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
