import javax.swing.*;
import java.awt.*;

public class ProgressBarDemo {
    ProgressBarDemo(JProgressBar bar) {

        bar.setValue(0);
        bar.setBounds(1310, 10, 150, 10);
        bar.setStringPainted(true);
        bar.setFont(new Font("Century", Font.PLAIN, 10));
        bar.setForeground(new Color(255, 0, 0));
        bar.setBackground(new Color(0, 0, 0));


        fill(bar);
    }

    public void fill(JProgressBar bar) {

        int counter = 0;

        while (counter <= 500) {

            bar.setValue(counter);

            try {
                Thread.sleep(50/*mili second*/);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//each second increase

            counter += 1;
        }

        bar.setString("Max");//when the bar is 100% shows the text
    }
}