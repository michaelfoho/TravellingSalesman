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


    TreasureLoot ringmap, swordmap,bowmap,goldenGlassmap,scrollmap,glassCupmap,keymap,shieldmap;
    TreasureLoot loot1map,loot2map,loot3map,loot4map,loot5map,loot6map,loot7map,loot8map,loot9map,loot10map,loot11map,loot12map,loot13map;


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
        bowmap = new TreasureLoot(area[1],3000,storedXY);
        goldenGlassmap= new TreasureLoot(area[1],2000,storedXY);
        scrollmap = new TreasureLoot(area[2],1000,storedXY);
        glassCupmap = new TreasureLoot(area[2],6000,storedXY);
        keymap= new TreasureLoot(area[3],7000,storedXY);
        shieldmap = new TreasureLoot(area[3],8000,storedXY);
        loot1map = new TreasureLoot(area[0],0,storedXY);
        loot2map = new TreasureLoot(area[0],0,storedXY);
        loot3map = new TreasureLoot(area[0],0,storedXY);
        loot4map = new TreasureLoot(area[1],0,storedXY);
        loot5map = new TreasureLoot(area[1],0,storedXY);
        loot6map = new TreasureLoot(area[1],0,storedXY);
        loot7map = new TreasureLoot(area[2],0,storedXY);
        loot8map = new TreasureLoot(area[2],0,storedXY);
        loot9map = new TreasureLoot(area[2],0,storedXY);
        loot10map = new TreasureLoot(area[3],0,storedXY);
        loot11map = new TreasureLoot(area[3],0,storedXY);
        loot12map = new TreasureLoot(area[3],0,storedXY);
        loot13map = new TreasureLoot(area[3],0,storedXY);


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
