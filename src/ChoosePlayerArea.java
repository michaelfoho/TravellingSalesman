import javax.swing.*;
import java.awt.event.*;

public class ChoosePlayerArea extends Area implements MouseListener {
    int sw;
    static int p1 = -1;
    static int p2 = -1;
    static int turn;

    ChoosePlayerArea(int x, int y, int width, int height, int number, int sw) {
        super(x, y, width, height, number);
        this.sw = sw;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (area() && sw == 4) {

            if (number == 15) turn = 1;
            if (number == 16) turn = 2;

            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 3; j++)
                    if (number == 3 * i + j) {
                        if (turn == 1 && p2 != 3 * i + j) p1 = 3 * i + j;
                        if (turn == 2 && p1 != 3 * i + j) p2 = 3 * i + j;
                    }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
