import java.awt.*;
import java.awt.event.*;

public class App extends Frame implements KeyListener {

    int x = 50, y = 60;

    public App() {

        setSize(600, 600);
        setTitle("Hunt The Wumpus");
        setLocationRelativeTo(null);

        addKeyListener(this);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    public void paint(Graphics g) {
        g.drawString("x=" + (x - 50 + 100) / 100 + ", y=" + (y - 60 + 100) / 100, 40, 45);

        g.drawLine(150, 60, 150, 560);
        g.drawLine(250, 60, 250, 560);
        g.drawLine(350, 60, 350, 560);
        g.drawLine(450, 60, 450, 560);

        g.drawLine(50, 160, 550, 160);
        g.drawLine(50, 260, 550, 260);
        g.drawLine(50, 360, 550, 360);
        g.drawLine(50, 460, 550, 460);

        g.drawRect(50, 60, 500, 500);
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 100, 100);

    }

    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W:
                if (y > 80)
                    y = y - 100;
                break;
            case KeyEvent.VK_S:
                if (y < 419)
                    y = y + 100;
                break;
            case KeyEvent.VK_A:
                if (x > 100)
                    x = x - 100;
                break;
            case KeyEvent.VK_D:
                if (x < 389)
                    x = x + 100;
                break;
            case KeyEvent.VK_UP:
                if (y > 80)
                    y = y - 100;
                break;
            case KeyEvent.VK_DOWN:
                if (y < 419)
                    y = y + 100;
                break;
            case KeyEvent.VK_LEFT:
                if (x > 100)
                    x = x - 100;
                break;
            case KeyEvent.VK_RIGHT:
                if (x < 389)
                    x = x + 100;
                break;
        }

        repaint();

    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
    }

    public static void main(String[] args) throws Exception {
        new App().setVisible(true);
    }
}
