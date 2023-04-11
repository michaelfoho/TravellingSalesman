import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PlayerInfo implements KeyListener {

    Random rand = new Random();
    boolean[][] map = new boolean[10][10];


    private final int turn;
    int x = 750;
    int y = 675;
    int money = 100;
    int power = 10;
    String name;
    Pointer mainTurn;
    Pointer dice;


    boolean[] inventoryTreasureBool = new boolean[8];
    boolean[] inventoryLootBool = new boolean[13];
    int[] inventoryWeaponNumber = new int[4];


    mapObject mapRing, mapSword, mapBow, mapGoldenGlass, mapKey, mapScroll, mapShield, mapGlassCup;
    mapObject[] loot = new mapObject[13];
    mapObject[] wall = new mapObject[8];
    mapObject[] market = new mapObject[4];
    mapObject[] trap = new mapObject[4];


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


        map[5][5] = true;//castle

        mapRing = new mapObject(map, area[0], 5000, true);
        mapSword = new mapObject(map, area[0], 5000, true);
        mapBow = new mapObject(map, area[1], 5000, true);
        mapGoldenGlass = new mapObject(map, area[1], 5000, true);
        mapKey = new mapObject(map, area[2], 5000, true);
        mapScroll = new mapObject(map, area[2], 5000, true);
        mapShield = new mapObject(map, area[3], 5000, true);
        mapGlassCup = new mapObject(map, area[3], 5000, true);

        for (int i = 0; i < 3; i++) loot[i] = new mapObject(map, area[0], 500, true);
        for (int i = 3; i < 6; i++) loot[i] = new mapObject(map, area[1], 500, true);
        for (int i = 6; i < 9; i++) loot[i] = new mapObject(map, area[2], 500, true);
        for (int i = 9; i < 13; i++) loot[i] = new mapObject(map, area[3], 500, true);

        for (int i = 0; i < 4; i++) {
            wall[i] = new mapObject(map, area[i], 0, true);
            wall[i + 4] = new mapObject(map, area[i], 0, true);
            market[i] = new mapObject(map, area[i], 0, true);
            trap[i] = new mapObject(map, area[i], 0, true);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

        int wallWarning = 0;

        if (mainTurn.prt == turn) if (dice.prt > 0) {

            if (e.getKeyChar() == 'w' && y - 75 >= 0 && x != 750) {
                for (int i = 0; i < 8; i++) {
                    if (this.x == wall[i].x && this.y - 75 == wall[i].y) {
                        wallWarning = 1;
                        break;
                    }
                }
                if (wallWarning == 0) {
                    y -= 75;
                    dice.prt -= 1;
                }
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

            wallWarning = 0;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
