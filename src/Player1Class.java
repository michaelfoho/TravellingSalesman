import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1Class implements KeyListener {

    int x = 750;
    int y = 675;

    int treasureNumber = 0;
    int treasureScore = 0;
    int money = 0;
    int power = 0;
    Dice d;

    Player1Class(Dice d) {

        this.d = d;
    }


    @Override
    public void keyTyped(KeyEvent e) {

        if (d.diceNumber > 0) {

            if (e.getKeyChar() == 'w' && y - 75 >= 0 && x != 750) {
                y -= 75;
                d.diceNumber -= 1;
            }
            if (e.getKeyChar() == 's' && y + 75 <= 675) {
                y += 75;
                d.diceNumber -= 1;
            }
            if (e.getKeyChar() == 'a' && x - 75 >= 0) {
                x -= 75;
                d.diceNumber -= 1;
            }
            if (e.getKeyChar() == 'd' && x + 75 < 750) {
                x += 75;
                d.diceNumber -= 1;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
