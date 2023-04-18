import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Area implements MouseListener {
    int x, y, width, height;
    int number;//shomare area
    ImageIcon image;
    PlayerInfo playerInfo;
    JFrame frame;


    Area(int x, int y, int width, int height, int number, String URL, PlayerInfo playerInfo, JFrame frame) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.number = number;
        this.playerInfo = playerInfo;
        this.frame = frame;
        image = new ImageIcon(URL);
    }

    public boolean area() {

        if (MouseInfo.getPointerInfo().getLocation().x > x && MouseInfo.getPointerInfo().getLocation().x < x + width)
            if (MouseInfo.getPointerInfo().getLocation().y > y && MouseInfo.getPointerInfo().getLocation().y < y + height)
                return true;

        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int answer = -1;
        if (area()) {

            for (int i = 0; i < 4; i++) {

                if (number == i)
                    if (playerInfo.money - playerInfo.weapon[i].price < 0) {
                        JOptionPane.showMessageDialog(null,
                                "you don't have enough money!",
                                null,
                                JOptionPane.INFORMATION_MESSAGE,
                                new ImageIcon("img/smallWallet.png")
                        );
                    } else {
                        answer = JOptionPane.showOptionDialog(
                                null,
                                "do you want to buy this item?",
                                null,
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                image,
                                null,
                                0
                        );
                    }
            }

        }

        if (answer == 0) {//0 -->means Yes

            for (int i = 0; i < 4; i++) {

                if (number == i) if (playerInfo.money - playerInfo.weapon[i].price >= 0) {
                    playerInfo.money -= playerInfo.weapon[i].price;
                    playerInfo.weapon[i].number += 1;
                }
            }
            frame.repaint();
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