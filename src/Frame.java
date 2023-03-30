import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    JButton button;

    JLayeredPane layeredPane = new JLayeredPane();


    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenu soundMenu = new JMenu("Sound");
    JMenu helpMenu = new JMenu("Help");

    JMenuItem newGameItem = new JMenuItem("New Game");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem exitItem = new JMenuItem("Exit");

    JMenuItem soundOnItem = new JMenuItem("On");
    JMenuItem soundOffItem = new JMenuItem("Off");

    Panel panel;

    Frame(JPanel panel_1, JPanel panel_2) {

        layeredPane.setBounds(750, 0, 750, 750);
        layeredPane.add(panel_1, Integer.valueOf(0));
        layeredPane.add(panel_2, Integer.valueOf(1));

        this.add(layeredPane);


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


        button = new JButton();
        button.setBounds(766, 450, 100, 70);
        button.addActionListener(this);
        button.setFocusable(true);
        //button.setVisible(true);

        button.setText("Button");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        button.setForeground(new Color(0, 0, 0));
        button.setBackground(new Color(0, 255, 255));//if you add an image for background of button comment this line

        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));//this argument can change

        button.setEnabled(true);//if you want to disable the button change (true) to (false)
        this.add(button);


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


        if (e.getSource() == button) {


        }

    }
}
