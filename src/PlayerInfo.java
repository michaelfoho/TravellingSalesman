import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PlayerInfo implements KeyListener {

    Random rand = new Random();
    int[][] storedXY = new int[2][100];


    private final int turn;
    int x = 750;
    int y = 675;
    int money = 100;
    int power = 10;
    String name;
    Pointer mainTurn;
    Pointer dice;


    boolean[] inventoryTreasureBool = new boolean[8];
    boolean[] inventoryLostObjectBool = new boolean[13];
    int[] inventoryWeaponNumber = new int[4];


    TreasureLoot ringmap, swordmap;


    PlayerInfo(int turn, Pointer mainTurn, Pointer dice, String name) {


        this.turn = turn;
        this.mainTurn = mainTurn;
        this.dice = dice;
        this.name = name;


        int[] area = new int[4];

        area[0] = rand.nextInt(4) + 1;
        do {
            area[1] = rand.nextInt(4) + 1;

        } while (area[1] == area[0]);
        do {
            area[2] = rand.nextInt(4) + 1;

        } while (area[2] == area[1] || area[2] == area[0]);
        area[3] = 10 - area[0] - area[1] - area[2];


        ringmap = new TreasureLoot(area[0], 5000, storedXY);
        swordmap = new TreasureLoot(area[0], 4000, storedXY);


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
