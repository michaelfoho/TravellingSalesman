import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);
        JProgressBar player_2_HP_bar = new JProgressBar(0, 500);

        Frame frame = Frame.getInstance();//singleton

        frame.add(player_1_HP_bar);
        frame.add(player_2_HP_bar);

        //ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);
        //ProgressBarDemo player_2_HP_barDemo = new ProgressBarDemo(player_2_HP_bar);
    }
}