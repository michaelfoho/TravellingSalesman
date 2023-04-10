import java.util.Random;

public class TreasureLoot {
    Random rand = new Random();

    int x;
    int y;
    boolean show = true;//if show==ture -->draw image
    int price;

    TreasureLoot(int area, int price, int[][] storedXY) {
        int i = 0, j = 0;

        if (area == 1) {
            i = 0;
            j = 0;
        }
        if (area == 2) {
            i = 5;
            j = 0;
        }
        if (area == 3) {
            i = 0;
            j = 5;
        }
        if (area == 4) {
            i = 5;
            j = 5;
        }


        this.price = price;
    }

}
