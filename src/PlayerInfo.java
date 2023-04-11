import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PlayerInfo implements KeyListener {
    Random rand = new Random();
    static boolean[][] map = new boolean[15][15];

    private final int turn;
    int x = 750;
    int y = 700;
    int money = 100;
    int power = 10;
    String name;
    Pointer mainTurn;
    Pointer dice;
    int[] weaponNumber = new int[4];
    int[][] move = new int[6][6];


    mapObject[] treasure = new mapObject[8];
    mapObject[] loot = new mapObject[13];
    static mapObject[] wall = new mapObject[24];
    mapObject[] market = new mapObject[5];
    mapObject[] trap = new mapObject[10];


    PlayerInfo(int turn, Pointer mainTurn, Pointer dice, String name) {

        this.turn = turn;
        this.mainTurn = mainTurn;
        this.dice = dice;
        this.name = name;

        int[] area = new int[24];
        for (int i = 0; i < 24; i++) {
            area[i] = rand.nextInt(24);
            for (int j = i; j > 0; j--) {
                if (area[i] == area[i - j]) {
                    i--;
                    break;
                }
            }
        }

        map[7][7] = true;//castle
        for (int i = 0; i < 24; i++) wall[i] = new mapObject(map, area[i], 0, true);
        for (int i = 0; i < 8; i++) treasure[i] = new mapObject(map, area[i], 5000 - i * 500, false);
        for (int i = 0; i < 13; i++) loot[i] = new mapObject(map, area[i + 8], 500 - i * 25, false);
        for (int i = 0; i < 5; i++) market[i] = new mapObject(map, area[i], 0, true);
        for (int i = 0; i < 10; i++) trap[i] = new mapObject(map, area[i], 0, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

        int lastX = x;
        int lastY = y;

        if (mainTurn.prt == turn) if (dice.prt > 0) {

            if (e.getKeyChar() == 'w' && y - 50 >= 0 && x != 750) {
                move[dice.prt - 1][0] = x;
                move[dice.prt - 1][1] = y;
                y -= 50;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 's' && y + 50 <= 700) {
                move[dice.prt - 1][1] = y;
                y += 50;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 'a' && x - 50 >= 0) {
                x -= 50;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 'd' && x + 50 < 750) {
                x += 50;
                dice.prt -= 1;
            }

            for (int i = 0; i < 24; i++) {
                if (x == wall[i].x && y == wall[i].y) {
                    x = lastX;
                    y = lastY;
                    dice.prt += 1;
                    break;
                }
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