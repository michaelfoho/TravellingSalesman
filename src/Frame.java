import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenu soundMenu = new JMenu("Sound");
    JMenu helpMenu = new JMenu("Help");

    JMenuItem newGameItem = new JMenuItem("New Game");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem exitItem = new JMenuItem("Exit");

    JMenuItem soundOnItem = new JMenuItem("On");
    JMenuItem soundOffItem = new JMenuItem("Off");

    panel panel;

    Frame() {

        panel = new panel();

        this.setTitle("Travelling Salesman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();

        this.setSize(1500, 810);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//load frame in the center of screen instead the top corner
        this.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("img/logo.png");//change icon of frame(top left)
        this.setIconImage(imageIcon.getImage());


        newGameItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(newGameItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        soundOnItem.addActionListener(this);
        soundOffItem.addActionListener(this);

        soundMenu.add(soundOnItem);
        soundMenu.add(soundOffItem);

        menuBar.add(fileMenu);
        menuBar.add(soundMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newGameItem) {
            System.out.println(1);
        }
        if (e.getSource() == saveItem) {
            System.out.println(1);
        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }

        if (e.getSource() == soundOnItem) {
            System.exit(0);
        }
        if (e.getSource() == soundOffItem) {
            System.exit(0);
        }

    }
}
