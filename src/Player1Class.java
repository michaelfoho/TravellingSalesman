import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1Class implements KeyListener {

    int x = 750;
    int y = 675;

    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {

            case 'w':
                y -= 75;
                break;
            case 's':
                y += 75;
                break;
            case 'a':
                x -= 75;
                break;
            case 'd':
                x += 75;
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
