import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JProgressBar player_1_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max
        JProgressBar player_2_HP_bar = new JProgressBar(0, 500);//0 is min & 500 is max


        Frame frame = new Frame();

        frame.add(player_1_HP_bar);
        frame.add(player_2_HP_bar);

        //ProgressBarDemo player_1_HP_barDemo = new ProgressBarDemo(player_1_HP_bar);
        //ProgressBarDemo player_2_HP_barDemo = new ProgressBarDemo(player_2_HP_bar);


    }
}