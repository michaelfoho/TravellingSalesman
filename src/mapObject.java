import java.util.Random;

public class mapObject {
    Random rand = new Random();

    int x;
    int y;
    boolean show = true;//if show==ture -->draw image
    int price;

    mapObject(boolean[][] map, int area, int price) {
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

        do {

            x = (rand.nextInt(5) + i) * 75;
            y = (rand.nextInt(5) + j) * 75;

        } while (map[x / 75][y / 75]);//true means the home isn't empty

        map[x / 75][y / 75] = true;


        this.price = price;
    }

}
