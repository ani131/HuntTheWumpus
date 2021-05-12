import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class App extends Game {

    public App(int game) {
        super(game);
    }

    public static void main(String[] args) throws Exception {

        JFrame f = new JFrame("Hunt Da Wumpus");
        JLabel l = new JLabel("Hunt Da Wumpus");

        JButton a = new JButton("Instructions");

        JButton b = new JButton("Easy");
        JButton c = new JButton("Medium");
        JButton d = new JButton("Hard");

        l.setFont(new Font("Arial", Font.PLAIN, 25));

        l.setBounds(90, 60, 250, 30);

        a.setBounds(120, 150, 150, 30);
        b.setBounds(120, 200, 150, 30);
        c.setBounds(120, 250, 150, 30);
        d.setBounds(120, 300, 150, 30);

        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Instructions().setVisible(true);
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game(1).setVisible(true);
            }
        });

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game(2).setVisible(true);
            }
        });

        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game(3).setVisible(true);
            }
        });

        f.add(l);

        f.add(a);
        f.add(b);
        f.add(c);
        f.add(d);

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
        new JFrame("Hunt Da Wumpus");
        setSize(400, 525);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        int xx = 22;
        int yy = 60;
        int ww = 350;
        int hh = 30;

        // need to add instructions
        JLabel i = new JLabel("Instructions: ");
        i.setFont(new Font("Arial", Font.PLAIN, 25));
        i.setBounds(xx, 25, ww, hh); // x, y, w, h
        add(i);

        JLabel j = new JLabel("Hunt this angry little monster while avoiding obstacles ahead!");
        j.setFont(new Font("Arial", Font.PLAIN, 12));
        j.setBounds(xx, yy, ww, hh); // x, y, w, h
        add(j);

        JLabel k = new JLabel("ahead! Use your expert senses to hear bats above, pits");
        k.setFont(new Font("Arial", Font.PLAIN, 12));
        k.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(k);

        JLabel m = new JLabel("below, or wumpus’ ahead. Use the W, A, S, D keys of your");
        m.setFont(new Font("Arial", Font.PLAIN, 12));
        m.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(m);

        JLabel n = new JLabel("laptop to navigate the grid.");
        n.setFont(new Font("Arial", Font.PLAIN, 12));
        n.setBounds(xx, yy += 30, ww, hh); // x, y, w, h
        add(n);

        JLabel o = new JLabel("Look to the textbox on the right of the screen to keep track of");
        o.setFont(new Font("Arial", Font.PLAIN, 12));
        o.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(o);

        JLabel p = new JLabel("your surroundings; ");
        p.setFont(new Font("Arial", Font.PLAIN, 12));
        p.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(p);

        JLabel q = new JLabel("Should you come across a bottomless pit, you’ll feel a breeze.");
        q.setFont(new Font("Arial", Font.PLAIN, 12));
        q.setBounds(xx, yy += 30, ww, hh); // x, y, w, h
        add(q);

        JLabel r = new JLabel("Fall in the pit, end the game.");
        r.setFont(new Font("Arial", Font.PLAIN, 12));
        r.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(r);

        JLabel s = new JLabel("Bats nearby? You’ll hear their ominous flapping. Run into this");
        s.setFont(new Font("Arial", Font.PLAIN, 12));
        s.setBounds(xx, yy += 30, ww, hh); // x, y, w, h
        add(s);

        JLabel t = new JLabel("group, you’ll be picked up and dropped to a randomized");
        t.setFont(new Font("Arial", Font.PLAIN, 12));
        t.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(t);

        JLabel u = new JLabel("location on the grid.");
        u.setFont(new Font("Arial", Font.PLAIN, 12));
        u.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(u);

        JLabel v = new JLabel("And as you come across the big, bad wumpus… you’ll smell his");
        v.setFont(new Font("Arial", Font.PLAIN, 12));
        v.setBounds(xx, yy += 30, ww, hh); // x, y, w, h
        add(v);

        JLabel w = new JLabel("signature scent (honestly, we don’t think you could miss it).");
        w.setFont(new Font("Arial", Font.PLAIN, 12));
        w.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(w);

        JLabel x = new JLabel("Knock into him and your time’s up!");
        x.setFont(new Font("Arial", Font.PLAIN, 12));
        x.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(x);

        JLabel y = new JLabel("When you think you’re beside the wumpus, fire an arrow using");
        y.setFont(new Font("Arial", Font.PLAIN, 12));
        y.setBounds(xx, yy += 30, ww, hh); // x, y, w, h
        add(y);

        JLabel z = new JLabel("the arrow keys. Firing an arrow that misses the wumpus may");
        z.setFont(new Font("Arial", Font.PLAIN, 12));
        z.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(z);

        JLabel aa = new JLabel("cause the wumpus to move, so use them wisely! You only get");
        aa.setFont(new Font("Arial", Font.PLAIN, 12));
        aa.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(aa);

        JLabel bb = new JLabel("5. The wumpus is smart - if you fire an arrow and miss, he’ll");
        bb.setFont(new Font("Arial", Font.PLAIN, 12));
        bb.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(bb);

        JLabel cc = new JLabel("move to a new location.");
        cc.setFont(new Font("Arial", Font.PLAIN, 12));
        cc.setBounds(xx, yy += 15, ww, hh); // x, y, w, h
        add(cc);

        JLabel dd = new JLabel("Good luck hunter, our well wishes are with you!");
        dd.setFont(new Font("Arial", Font.PLAIN, 12));
        dd.setBounds(xx, yy += 30, ww, hh); // x, y, w, h
        add(dd);

    }

}
