import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MoveShoot extends Frame implements KeyListener {
  Random rand = new Random();

  int wumpusXRand = rand.nextInt(5);
  int wumpusYRand = rand.nextInt(5);
  int pitXRand = rand.nextInt(5);
  int pitYRand = rand.nextInt(5);
  int batXRand = rand.nextInt(5);
  int batYRand = rand.nextInt(5);

  int moveX = 50, moveY = 60;
  int shootX = moveX, shootY = moveY;
  int wumpusX = (((wumpusXRand + 1) * 100) - 50), wumpusY = (((wumpusYRand + 1) * 100) - 40);
  int pitX = (((pitXRand + 1) * 100) - 50), pitY = (((pitYRand + 1) * 100) - 40);
  int batX = (((batXRand + 1) * 100) - 50), batY = (((batYRand + 1) * 100) - 40);

  int numArrows = 4;

  public MoveShoot() {

    addKeyListener(this);

    addWindowListener(new WindowAdapter() {

      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });

    while ((pitX == wumpusX) && (pitY == wumpusY)) // these make sure we dont double up locations keep
    {
      pitX = ((rand.nextInt(5) + 1) * 100 - 50);
      pitY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((batX == wumpusX) && (batY == wumpusY)) {
      batX = ((rand.nextInt(5) + 1) * 100 - 50);
      batY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((batX == pitX) && (batY == pitY)) {
      batX = ((rand.nextInt(5) + 1) * 100 - 50);
      batY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

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

  void pit() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You fell in da pit. You lose.", "Game over", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
  }

  void wumpus() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You were eaten by da Wumpus. You lose.", "Game over",
        JOptionPane.ERROR_MESSAGE);
    System.exit(0);
  }

  void win() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You shot da Wumpus! You win!", "Game over", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
  }

  void bats() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You were picked up by bats! You have been moved.", "Bats",
        JOptionPane.ERROR_MESSAGE);
    System.exit(0);
  }

  void relocate() // method to move player to open spot upon bat hit
  {
    moveX = ((rand.nextInt(5) + 1) * 100 - 50);
    moveY = ((rand.nextInt(5) + 1) * 100 - 40);

    while ((moveX == wumpusX) && (moveY == wumpusY)) {
      moveX = ((rand.nextInt(5) + 1) * 100 - 50);
      moveY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((moveX == pitX) && (moveY == pitY)) {
      moveX = ((rand.nextInt(5) + 1) * 100 - 50);
      moveY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((moveX == batX) && (moveY == batY)) {
      moveX = ((rand.nextInt(5) + 1) * 100 - 50);
      moveY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

  }

  public void keyPressed(KeyEvent ke) { // movement
    int keyCode = ke.getKeyCode();

    switch (keyCode) {
      case KeyEvent.VK_W:
        moveUp();
        if ((moveY) == pitY && (moveX == pitX)) {
          System.out.println("You fell in da pit");
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          System.out.println("You ran into da Wumpus");
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          System.out.println("You hit a bat.");
          relocate();
        }
        break;
      case KeyEvent.VK_S:
        moveDown();
        if ((moveY) == pitY && (moveX == pitX)) {
          System.out.println("You fell in da pit");
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          System.out.println("You ran into da Wumpus");
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          System.out.println("You hit a bat.");
          relocate();
        }
        break;
      case KeyEvent.VK_A:
        moveLeft();
        if ((moveY) == pitY && (moveX == pitX)) {
          System.out.println("You fell in da pit");
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          System.out.println("You ran into da Wumpus");
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          System.out.println("You hit a bat.");
          relocate();
        }
        break;
      case KeyEvent.VK_D:
        moveRight();
        if ((moveY) == pitY && (moveX == pitX)) {
          System.out.println("You fell in da pit");
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          System.out.println("You ran into da Wumpus");
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          System.out.println("You hit a bat.");
          relocate();
        }
        break;
      case KeyEvent.VK_UP:
        if (numArrows == 0) {
          System.out.println("You cannot shoot, you are out of arrows");
        } else {
          if ((shootY - 100) == wumpusY && shootX == wumpusX) {
            System.out.println("You hit da Wumpus");
            win();
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
            win();
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
            win();
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
            win();
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

}
