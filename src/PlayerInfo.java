import java.awt.event.*;
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
    int lastX;
    int lastY;
    boolean[] moveLock = new boolean[4];

    static MapObject castle;
    static MapObject[] market = new MapObject[5];


    int treasure_number = 0;
    int treasurescore[]=new int[8];

    int[][] treasureMap = new int[100][100];


    MapObject[] treasure = new MapObject[8];
    MapObject[] mapLoot = new MapObject[13];
    static MapObject[] wall = new MapObject[24];
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

        map[7][7] = true;    //castle
        map[6][2] = true;    //market
        map[13][3] = true;   //market
        map[3][13] = true;   //market
        map[1][6] = true;    //market
        map[11][11] = true;  //market

        castle = new MapObject(350, 350);
        market[0] = new MapObject(6 * 50, 2 * 50);
        market[1] = new MapObject(13 * 50, 3 * 50);
        market[2] = new MapObject(3 * 50, 13 * 50);
        market[3] = new MapObject(1 * 50, 6 * 50);
        market[4] = new MapObject(11 * 50, 11 * 50);

        for (int i = 0; i < 24; i++) wall[i] = new MapObject(map, area[i], 0, true);
        for (int i = 0; i < 8; i++) treasure[i] = new MapObject(map, area[i], 5000 - i * 500, false);
        for (int i = 0; i < 13; i++) mapLoot[i] = new MapObject(map, area[i + 8], 500 - i * 25, false);
        for (int i = 0; i < 10; i++) trap[i] = new MapObject(map, area[2 * i], 0, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

        lastX = x;
        lastY = y;

        if (mainTurn.prt == turn) if (dice.prt > 0 && dice.prt < 7) {

            move[dice.prt - 1][0] = x;
            move[dice.prt - 1][1] = y;
            int lastDice = dice.prt;


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
            if (e.getKeyChar() == 'd' && x + 50 <= 700) {
                x += 50;
                dice.prt -= 1;
            }

            if (dice.prt != lastDice) {

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
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 10)
            for (int i = 0; i < 5; i++) {
                if (x == market[i].x && y == market[i].y) {

                    Market market = new Market("img/marketBackground.png", "img/building/marketDesert.png", "Market", this);
                    break;
                }
            }//market
    }

    @Override
    public void keyReleased(KeyEvent e) {

        for (int i = 0; i < 24; i++)
            if (x == wall[i].x && y - 50 == wall[i].y) {
                moveLock[0] = true;
                break;
            }
        for (int i = 0; i < 24; i++)
            if (x == wall[i].x && y + 50 == wall[i].y) {
                moveLock[1] = true;
                break;
            }
        for (int i = 0; i < 24; i++)
            if (x - 50 == wall[i].x && y == wall[i].y) {
                moveLock[2] = true;
                break;
            }
        for (int i = 0; i < 24; i++)
            if (x + 50 == wall[i].x && y == wall[i].y) {
                moveLock[3] = true;
                break;
            }
        for (int i = 0; i < 6; i++)
            if (x == move[i][0] && y - 50 == move[i][1]) {
                moveLock[0] = true;
                break;
            }
        for (int i = 0; i < 6; i++)
            if (x == move[i][0] && y + 50 == move[i][1]) {
                moveLock[1] = true;
                break;
            }
        for (int i = 0; i < 6; i++)
            if (x - 50 == move[i][0] && y == move[i][1]) {
                moveLock[2] = true;
                break;
            }
        for (int i = 0; i < 6; i++)
            if (x + 50 == move[i][0] && y == move[i][1]) {
                moveLock[3] = true;
                break;
            }
        if (y == 0) moveLock[0] = true;
        if (y == 700) moveLock[1] = true;
        if (x == 0) moveLock[2] = true;
        if (x == 700) moveLock[3] = true;


        for (int i = 0, lockCount = 0; i < 4; i++) {

            if (moveLock[i]) lockCount++;

            if (lockCount == 4) {
                dice.prt = 0;
            }
        }

        if (dice.prt == 0) {
            for (int i = 0; i < 6; i++) {
                move[i][0] = -100;
                move[i][1] = -100;
            }

            for (int i = 0; i < 4; i++) {
                moveLock[i] = false;
            }

        }
    }
}