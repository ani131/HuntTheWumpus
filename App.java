import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class App extends Game {

    public static void main(String[] args) throws Exception {

        JFrame f = new JFrame("Hunt Da Wumpus");
        JLabel l = new JLabel("Hunt Da Wumpus");

        JButton a = new JButton("Start the Game!");
        JButton b = new JButton("Instructions");

        l.setFont(new Font("Arial", Font.PLAIN, 25));

        l.setBounds(90, 90, 250, 30);

        a.setBounds(120, 200, 150, 30);
        b.setBounds(120, 250, 150, 30);

        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game().setVisible(true);
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Instructions().setVisible(true);
            }
        });

        f.add(l);

        f.add(a);
        f.add(b);

        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        // new Game().setVisible(false);
    }
}

class Instructions extends JFrame {
    public Instructions() {

        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // need to add instructions

    }

}
