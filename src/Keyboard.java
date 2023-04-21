import java.awt.event.*;

public class Keyboard implements KeyListener {
    Pointer sw;

    Keyboard(Pointer sw) {
        this.sw = sw;
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (sw.prt == 4) if (e.getKeyChar() == 'b') if (ChoosePlayerArea.p1 != -1 && ChoosePlayerArea.p2 != -1) {
            sw.prt = 2;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}