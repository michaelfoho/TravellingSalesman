import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PlayerInfo implements KeyListener {
    Random rand = new Random();
    static boolean[][] map = new boolean[15][15];

    private final int turn;
    int x = 750;
    int y = 700;
    int money = 5500;
    int power = 10;
    String name;
    Pointer mainTurn;
    Pointer dice;
    Weapon[] weapon = new Weapon[4];
    int[][] move = new int[6][6];


    MapObject[] treasure = new MapObject[8];
    MapObject[] mapLoot = new MapObject[13];
    static MapObject[] wall = new MapObject[24];
    static MapObject[] market = new MapObject[5];
    MapObject[] trap = new MapObject[10];


    PlayerInfo(int turn, Pointer mainTurn, Pointer dice, String name) {

        this.turn = turn;
        this.mainTurn = mainTurn;
        this.dice = dice;
        this.name = name;


        for (int i = 0; i < 4; i++) {
            weapon[i] = new Weapon(400 - i * 100);
        }


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
        for (int i = 0; i < 24; i++) wall[i] = new MapObject(map, area[i], 0, true);
        for (int i = 0; i < 8; i++) treasure[i] = new MapObject(map, area[i], 5000 - i * 500, false);
        for (int i = 0; i < 13; i++) mapLoot[i] = new MapObject(map, area[i + 8], 500 - i * 25, false);
        for (int i = 0; i < 5; i++) market[i] = new MapObject(map, area[23 - i], 0, true);
        for (int i = 0; i < 10; i++) trap[i] = new MapObject(map, area[2 * i], 0, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

        int lastX = x;
        int lastY = y;


        if (mainTurn.prt == turn) if (dice.prt > 0) {

            move[dice.prt - 1][0] = x;
            move[dice.prt - 1][1] = y;


            if (e.getKeyChar() == 'w' && y - 50 >= 0 && x != 750) {
                y -= 50;
                dice.prt -= 1;
            }
            if (e.getKeyChar() == 's' && y + 50 <= 700) {
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


            for (int i = 0; i < 6; i++) {
                if (x == move[i][0] && y == move[i][1]) {
                    x = lastX;
                    y = lastY;
                    dice.prt += 1;
                    break;
                }
            }
            for (int i = 0; i < 24; i++) {
                if (x == wall[i].x && y == wall[i].y) {
                    x = lastX;
                    y = lastY;
                    dice.prt += 1;
                    break;
                }
            }
            if (dice.prt == 0) for (int i = 0; i < 6; i++) {
                move[i][0] = 0;
                move[i][1] = 0;
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