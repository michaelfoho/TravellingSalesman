import java.util.Random;

public class MapObject {
    Random rand = new Random();

    int x;
    int y;
    boolean show;
    int price;

    MapObject(boolean[][] map, int area, int price, boolean show) {
        int i = 0, j = 0;

        if (area >= 0 && area < 5) {
            i = area * 3;
            j = 0;
        }
        if (area >= 5 && area < 10) {
            i = area * 3 - 15;
            j = 3;
        }
        if (area >= 10 && area < 15) {
            i = area * 3 - 30;
            j = 6;
        }
        if (area >= 15 && area < 20) {
            i = area * 3 - 45;
            j = 9;
        }
        if (area >= 20 && area < 24) {
            i = area * 3 - 60;
            j = 12;
        }

        do {
            x = (rand.nextInt(3) + i) * 50;
            y = (rand.nextInt(3) + j) * 50;

        } while (map[x / 50][y / 50]);//true means the home isn't empty

        map[x / 50][y / 50] = true;

        this.price = price;
        this.show = show;
    }

    MapObject(int x, int y) {
        this.x = x;
        this.y = y;
        show = true;
    }
}