import javax.swing.*;
import java.awt.event.*;

public class MarketArea extends Area implements MouseListener {
    ImageIcon image;
    JFrame frame;
    PlayerInfo playerInfo;

    MarketArea(int x, int y, int width, int height, int number, String URL, PlayerInfo playerInfo, JFrame frame) {
        super(x, y, width, height, number);
        image = new ImageIcon(URL);
        this.frame = frame;
        this.playerInfo = playerInfo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int answer = -1;

        if (area()) {

            for (int i = 0; i < 4; i++) {
                if (number == i)
                    if (playerInfo.money - playerInfo.weapon[i].price < 0)
                        JOptionPane.showMessageDialog(null, "you don't have enough money!", null, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/smallWallet.png"));
                    else
                        answer = JOptionPane.showOptionDialog(null, "do you want to buy this item?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);

            }
            if (number == 4)
                if (playerInfo.money - 2500 < 0)
                    JOptionPane.showMessageDialog(null, "you don't have enough money!", null, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/smallWallet.png"));
                else
                    answer = JOptionPane.showOptionDialog(null, "do you want to buy this item?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image, null, 0);

            if (number == 5) frame.setVisible(false);
        }

        if (answer == 0) {//0 -->means Yes

            for (int i = 0; i < 4; i++) {
                if (number == i) if (playerInfo.money - playerInfo.weapon[i].price >= 0) {
                    playerInfo.money -= playerInfo.weapon[i].price;
                    playerInfo.weapon[i].number += 1;
                    playerInfo.power += playerInfo.weapon[i].strength;
                }
            }
            if (number == 4) if (playerInfo.money - 2500 >= 0) {
                playerInfo.money -= 2500;
                playerInfo.hasTreasureMap = true;
                playerInfo.hasTreasureMapOnce = true;
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