import java.awt.*;

public class Area {
    int x, y, width, height;
    int number;//area number

    Area(int x, int y, int width, int height, int number) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.number = number;
    }

    public boolean area() {

        if (MouseInfo.getPointerInfo().getLocation().x > x && MouseInfo.getPointerInfo().getLocation().x < x + width)
            if (MouseInfo.getPointerInfo().getLocation().y > y && MouseInfo.getPointerInfo().getLocation().y < y + height)
                return true;

        return false;
    }
}