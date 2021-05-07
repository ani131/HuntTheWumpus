import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MoveShoot extends Frame implements KeyListener {
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

  public MoveShoot() {

    addKeyListener(this);

    addWindowListener(new WindowAdapter() {

      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });

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

}
