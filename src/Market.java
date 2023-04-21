import javax.swing.*;
import java.awt.*;

public class Market extends JFrame {
    PlayerInfo playerInfo;
    MarketArea[] area = new MarketArea[5];
    MarketArea backArea;

    Image background, wallet, playerImage;
    Image treasureMap = new ImageIcon("img/treasureMap.png").getImage();
    Image weapon1 = new ImageIcon("img/weapon/market/weapon1.png").getImage();
    Image weapon2 = new ImageIcon("img/weapon/market/weapon2.png").getImage();
    Image weapon3 = new ImageIcon("img/weapon/market/weapon3.png").getImage();
    Image weapon4 = new ImageIcon("img/weapon/market/weapon4.png").getImage();

    Market(String backgroundURL, String frameIconURL, String title, PlayerInfo playerInfo, Image player1Image, Image player2Image) {

        this.playerInfo = playerInfo;
        if (Panel.mainTurn.prt == 1) this.playerImage = player1Image;
        if (Panel.mainTurn.prt == 2) this.playerImage = player2Image;

        background = new ImageIcon(backgroundURL).getImage();
        wallet = new ImageIcon("img/wallet.png").getImage();

        area[0] = new MarketArea(770, 80, 150, 150, 0, "img/weapon/inventory/weapon1.png", playerInfo, this);
        area[1] = new MarketArea(940, 80, 150, 150, 1, "img/weapon/inventory/weapon2.png", playerInfo, this);
        area[2] = new MarketArea(1110, 80, 150, 150, 2, "img/weapon/inventory/weapon3.png", playerInfo, this);
        area[3] = new MarketArea(1280, 80, 150, 150, 3, "img/weapon/inventory/weapon4.png", playerInfo, this);
        area[4] = new MarketArea(770, 300, 150, 150, 4, "img/smallTreasureMap.png", playerInfo, this);
        backArea = new MarketArea(0, 0, 600, 750, 5, null, playerInfo, this);

        for (int i = 0; i < 5; i++) this.addMouseListener(area[i]);
        this.addMouseListener(backArea);

        this.setBounds(12, 35, 1514, 780);
        this.setTitle(title);
        this.setResizable(false);
        this.setFocusable(true);
        this.setLayout(null);
        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon(frameIconURL);//change icon of frame(top left)
        this.setIconImage(imageIcon.getImage());
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(4));//thickness
        g2D.setFont(new Font("Century", Font.PLAIN, 40));

        g2D.drawImage(background, 0, 0, 1514, 775, null);

        g2D.setPaint(new Color(50, 50, 50, 150));
        g2D.fillRoundRect(750, 60, 700, 460, 10, 10);
        g2D.fillRoundRect(850, 550, 500, 200, 10, 10);

        g2D.setPaint(Color.BLACK);
        g2D.drawRoundRect(750, 60, 700, 460, 10, 10);
        g2D.drawRoundRect(850, 550, 500, 200, 10, 10);

        for (int i = 0; i < 4; i++) {
            g2D.drawRoundRect(770 + i * 170, 80, 150, 150, 10, 10);
            g2D.drawRoundRect(770 + i * 170, 230, 150, 50, 10, 10);
        }
        g2D.drawRoundRect(770, 300, 150, 150, 10, 10);
        g2D.drawRoundRect(770, 450, 150, 50, 10, 10);

        for (int i = 0; i < 4; i++) g2D.drawRoundRect(1070 + i * 70, 560, 50, 85, 10, 10);
        g2D.drawRoundRect(1070, 680, 50, 60, 10, 10);

        g2D.drawImage(wallet, 860, 685, 50, 50, null);
        g2D.drawImage(playerImage, 860, 550, 150, 150, null);

        g2D.drawImage(weapon1, 830, 95, 30, 120, null);
        g2D.drawImage(weapon2, 983, 95, 70, 120, null);
        g2D.drawImage(weapon3, 1165, 95, 55, 120, null);
        g2D.drawImage(weapon4, 1338, 95, 35, 120, null);
        g2D.drawImage(treasureMap, 775, 305, 140, 140, null);

        g2D.drawImage(weapon1, 1086, 568, 17, 70, null);
        g2D.drawImage(weapon2, 1146, 568, 41, 70, null);
        g2D.drawImage(weapon3, 1221, 568, 32, 70, null);
        g2D.drawImage(weapon4, 1294, 568, 21, 70, null);
        if (playerInfo.hasTreasureMap) g2D.drawImage(treasureMap, 1073, 685, 44, 44, null);

        g2D.setPaint(new Color(255, 180, 0));

        g2D.drawString("400 $", 795, 268);
        g2D.drawString("300 $", 966, 268);
        g2D.drawString("200 $", 1137, 268);
        g2D.drawString("100 $", 1308, 268);
        g2D.drawString("2500 $", 785, 488);

        g2D.drawString(String.valueOf(playerInfo.money) + "$", 920, 725);

        g2D.setPaint(Color.white);
        g2D.setFont(new Font("Century", Font.PLAIN, 16));
        for (int i = 0; i < 4; i++) g2D.drawString(String.valueOf(playerInfo.weapon[i].number), 1107 + i * 70, 640);
    }
}