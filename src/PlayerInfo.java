import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInfo implements KeyListener {

    private int turn;
    Pointer mainTurn;
    Pointer dice;


    String name;

    int x = 750;
    int y = 675;
    int money = 0;
    int power = 10;

    boolean[] treasureBool = new boolean[8];//if true shown
    boolean[] lostObjectBool = new boolean[13];//if true shown
    int[] weaponNumber = new int[4];//if weaponBool[i]>0 shown


    PlayerInfo(int turn, Pointer mainTurn, Pointer dice, String name) {

        this.turn = turn;
        this.mainTurn = mainTurn;
        this.dice = dice;


        this.name = name;


        for (int i = 0; i < 8; i++) treasureBool[i] = false;
        for (int i = 0; i < 13; i++) lostObjectBool[i] = false;
        for (int i = 0; i < 4; i++) weaponNumber[i] = 1;
    }

    @Override
    public void keyTyped(KeyEvent e) {


        if (mainTurn.prt == turn) if (dice.prt > 0) {

            if (e.getKeyChar() == 'w' && y - 75 >= 0 && x != 750) {
                y -= 75;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 's' && y + 75 <= 675) {
                y += 75;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 'a' && x - 75 >= 0) {
                x -= 75;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 'd' && x + 75 < 750) {
                x += 75;
                dice.prt -= 1;
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
