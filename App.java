import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class App extends Frame implements KeyListener {

    Random rand = new Random();

    int wumpusXRand = rand.nextInt(4);
    int wumpusYRand = rand.nextInt(4);
    int pitXRand = rand.nextInt(4);
    int pitYRand = rand.nextInt(4);

    int moveX = 50, moveY = 60;
    int shootX = moveX, shootY = moveY;
    int wumpusX = (((wumpusXRand + 1) * 100) - 50), wumpusY = (((wumpusYRand + 1) * 100) - 40);
    int pitX = (((pitXRand + 1) * 100) - 50), pitY = (((pitYRand + 1) * 100) - 40);

    int numArrows = 4;

    public App() {

        setSize(900, 600); // Initializing the JPanel including size, location, etc.
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
        g.drawString("x=" + (moveX - 50 + 100) + ", y=" + (moveY - 60 + 100), 40, 45); // A string that displays
                                                                                       // coordinates at the top left
                                                                                       // ex: (x=1, y=2)
        g.drawString("wumpusX=" + (wumpusX - 50 + 100) + ", wumpusY=" + (wumpusY - 60 + 100), 200, 45);
        g.drawString("pitX=" + (pitX - 50 + 100) + ", pitY=" + (pitY - 60 + 100), 500, 45);

        g.drawLine(150, 60, 150, 560); // horzontal and vertical grid lines
        g.drawLine(250, 60, 250, 560);
        g.drawLine(350, 60, 350, 560);
        g.drawLine(450, 60, 450, 560);

        g.drawLine(50, 160, 550, 160);
        g.drawLine(50, 260, 550, 260);
        g.drawLine(50, 360, 550, 360);
        g.drawLine(50, 460, 550, 460);

        g.drawRect(50, 60, 500, 500);
        g.setColor(Color.CYAN); // Cyan colored character
        g.fillRect(moveX, moveY, 100, 100);

    }

    void moveUp() {
        if (moveY > 80) {
            moveY = moveY - 100;
            shootY = moveY;
        }
    }

    void moveDown() {
        if (moveY < 419) {
            moveY = moveY + 100;
            shootY = moveY;
        }

    }

    void moveLeft() {
        if (moveX > 100) {
            moveX = moveX - 100;
            shootX = moveX;
        }
    }

    void moveRight() {
        if (moveX < 389) {
            moveX = moveX + 100;
            shootX = moveX;
        }
    }

    public void keyPressed(KeyEvent ke) { // movement
        int keyCode = ke.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W:
                moveUp();
                if ((moveY) == pitY && (moveX == pitX)) {
                    System.out.println("You fell in da pit");
                    // Popup and reset
                } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
                    System.out.println("You ran into da Wumpus");
                    // Popup and reset
                }
                break;
            case KeyEvent.VK_S:
                moveDown();
                if ((moveY) == pitY && (moveX == pitX)) {
                    System.out.println("You fell in da pit");
                    // Popup and reset
                } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
                    System.out.println("You ran into da Wumpus");
                    // Popup and reset
                }
                break;
            case KeyEvent.VK_A:
                moveLeft();
                if ((moveY) == pitY && (moveX == pitX)) {
                    System.out.println("You fell in da pit");
                    // Popup and reset
                } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
                    System.out.println("You ran into da Wumpus");
                    // Popup and reset
                }
                break;
            case KeyEvent.VK_D:
                moveRight();
                if ((moveY) == pitY && (moveX == pitX)) {
                    System.out.println("You fell in da pit");
                    // Popup and reset
                } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
                    System.out.println("You ran into da Wumpus");
                    // Popup and reset
                }
                break;
            case KeyEvent.VK_UP:
                if (numArrows == 0) {
                    System.out.println("You cannot shoot, you are out of arrows");
                } else {
                    if ((shootY - 100) == wumpusY && shootX == wumpusX) {
                        System.out.println("You hit da Wumpus");
                        // Popup and reset
                    } else {
                        System.out.println("You did not hit da wumpus");
                        // decrease num arrows
                        numArrows -= 1;
                        if (numArrows == 0) {
                            System.out.println("You ran out of arrows");
                        }
                    }
                }
                shootY = moveY;
                break;

            case KeyEvent.VK_DOWN:
                if (numArrows == 0) {
                    System.out.println("You cannot shoot, you are out of arrows");
                } else {
                    if ((shootY + 100) == wumpusY && shootX == wumpusX) {
                        System.out.println("You hit da Wumpus");
                        // Popup and reset
                    } else {
                        System.out.println("You did not hit da wumpus");
                        // decrease num arrows
                        numArrows -= 1;
                        if (numArrows == 0) {
                            System.out.println("You ran out of arrows");
                        }
                    }
                }
                shootY = moveY;
                break;
            case KeyEvent.VK_LEFT:
                if (numArrows == 0) {
                    System.out.println("You cannot shoot, you are out of arrows");
                } else {
                    if (shootY == wumpusY && (shootX - 100) == wumpusX) {
                        System.out.println("You hit da Wumpus");
                        // Popup and reset
                    } else {
                        System.out.println("You did not hit da wumpus");
                        // decrease num arrows
                        numArrows -= 1;
                        if (numArrows == 0) {
                            System.out.println("You ran out of arrows");
                        }
                    }
                }
                shootY = moveY;
                break;

            case KeyEvent.VK_RIGHT:
                if (numArrows == 0) {
                    System.out.println("You cannot shoot, you are out of arrows");
                } else {
                    if (shootY == wumpusY && (shootX + 100) == wumpusX) {
                        System.out.println("You hit da Wumpus");
                        // Popup and reset
                    } else {
                        System.out.println("You did not hit da wumpus");
                        // decrease num arrows
                        numArrows -= 1;
                        if (numArrows == 0) {
                            System.out.println("You ran out of arrows");
                        }
                    }
                }
                shootY = moveY;
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
