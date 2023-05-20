import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {
    private static Frame instance = new Frame();

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu soundMenu = new JMenu("Sound");
    JMenuItem newGameItem = new JMenuItem("New Game");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem exitItem = new JMenuItem("Exit");
    JMenuItem soundOnItem = new JMenuItem("On");
    JMenuItem soundOffItem = new JMenuItem("Off");

    Panel panel;
    private Clip clip;

    public static Frame getInstance() {
        return instance;
    }

    private Frame() {

        panel = new Panel();

        this.setTitle("Travelling Salesman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setSize(1514, 810);
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

        //soundOnItem.addActionListener(this);
        soundOffItem.addActionListener(this);

        soundMenu.add(soundOnItem);
        soundMenu.add(soundOffItem);

        menuBar.add(fileMenu);
        menuBar.add(soundMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);

        soundOnItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                } else {
                    playSound();
                }
            }
        });
    }


    private void playSound() {
        try {

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Frame.class.getResource("music/menumusic.wav"));

            clip = AudioSystem.getClip();
            clip.open(audioIn);


            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newGameItem) {
            //panel.newGame();
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