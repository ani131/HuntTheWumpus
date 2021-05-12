import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MoveShoot extends Frame implements KeyListener {

  Random rand = new Random();

  // Initializing random variables to set random locations for the pit, Wumpus,
  // and bats.

  int wumpusXRand = rand.nextInt(5);
  int wumpusYRand = rand.nextInt(5);
  int pitXRand = rand.nextInt(5);
  int pitYRand = rand.nextInt(5);
  int batXRand = rand.nextInt(5);
  int batYRand = rand.nextInt(5);

  // Initilizing varibales for the initial locations for the player, Wumpus, pit,
  // bat, and the shoot variable

  int moveX = 50, moveY = 60;
  int shootX = moveX, shootY = moveY;
  int wumpusX = (((wumpusXRand + 1) * 100) - 50), wumpusY = (((wumpusYRand + 1) * 100) - 40);
  int pitX = (((pitXRand + 1) * 100) - 50), pitY = (((pitYRand + 1) * 100) - 40);
  int batX = (((batXRand + 1) * 100) - 50), batY = (((batYRand + 1) * 100) - 40);

  // Initilizing variables for gamemode related items including number of arrows,
  // number of moves, and the gamemode

  int numArrows = 0;
  private int gameMode = 0;
  int numMoves = 0;
  String text = "";

  public MoveShoot() {

    // Sets key listener and window listener

    addKeyListener(this);
    addWindowListener(new WindowAdapter() {

      public void windowClosing(WindowEvent we) {
        setVisible(false);
      }
    });

    // Creates formula that ensures that the pit, the player, the Wumpus, and the
    // bats never spawn on the same square

    while ((pitX == wumpusX) && (pitY == wumpusY)) {
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

    while ((moveX == wumpusX) && (moveY == wumpusY)) {
      wumpusX = ((rand.nextInt(5) + 1) * 100 - 50);
      wumpusY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((moveX == batX) && (moveY == batY)) {
      batX = ((rand.nextInt(5) + 1) * 100 - 50);
      batY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((moveX == pitX) && (moveY == pitY)) {
      pitX = ((rand.nextInt(5) + 1) * 100 - 50);
      pitY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

  }

  // Sets the different number of arrows and moves for the gamemodes based on the
  // parameters passed from App.Java and Game.Java

  void setNum(int gameNum) {
    gameMode = gameNum;

    if (gameMode == 1) {
      numArrows = 5;
      numMoves = 20;
      setBackground(new java.awt.Color(152, 251, 152));
    } else if (gameMode == 2) {
      numArrows = 3;
      numMoves = 15;
      setBackground(new java.awt.Color(255, 252, 187));
    } else if (gameMode == 3) {
      numArrows = 1;
      numMoves = 10;
      setBackground(new java.awt.Color(235, 165, 160));
    }
  }

  // Creates methods to move the player up, down, left, and rigth as well as
  // adjust where the player would shoot if they chose to fire at that certain
  // time

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

  // Creates a method to move the Wumpus to a random location on the map. Used
  // when an arrow is fired and misses

  void moveWumpus() {
    wumpusX = ((rand.nextInt(5) + 1) * 100 - 50);
    wumpusY = ((rand.nextInt(5) + 1) * 100 - 40);

    while ((wumpusX == moveX) && (wumpusY == moveY)) {
      wumpusX = ((rand.nextInt(5) + 1) * 100 - 50);
      wumpusY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((wumpusX == pitX) && (wumpusY == pitY)) {
      wumpusX = ((rand.nextInt(5) + 1) * 100 - 50);
      wumpusY = ((rand.nextInt(5) + 1) * 100 - 40);
    }

    while ((wumpusX == batX) && (wumpusY == batY)) {
      wumpusX = ((rand.nextInt(5) + 1) * 100 - 50);
      wumpusY = ((rand.nextInt(5) + 1) * 100 - 40);
    }
  }

  // Creates methods for all of the scenarios in which the game could end and
  // creates alert messages for them. Game loss outcomes include running out of
  // arrows, running out of moves, falling into the pit, hitting the wumpus. Game
  // win outcomes include shooting the Wumpus

  void noArrows() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You are out of arrows. You lose.", "Game over", JOptionPane.ERROR_MESSAGE);
    setVisible(false);
  }

  void noMoves() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You are out of moves. You lose.", "Game over", JOptionPane.ERROR_MESSAGE);
    setVisible(false);
  }

  void pit() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You fell in the pit. You lose.", "Game over", JOptionPane.ERROR_MESSAGE);
    setVisible(false);
  }

  void wumpus() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You were eaten by the Wumpus. You lose.", "Game over",
        JOptionPane.ERROR_MESSAGE);
    setVisible(false);
  }

  void win() {
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");

    JOptionPane.showMessageDialog(frame, "You shot the Wumpus! You win!", "Game over", JOptionPane.PLAIN_MESSAGE);
    setVisible(false);
  }

  // Creates method to relocate the player to a random spot on the map while also
  // ensuring it does not go to a spot with the Wumpus, the bats, or the pit. This
  // method will be used when the player runs into the bats

  void relocate() {
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

  // These cases are used for movement and indicators for the textbox. Each time
  // you press W, A, S, or D, it calls the corresponding up, down, left, or right
  // method which changes the players X and Y values moving it around. It also
  // checks to see if the newly moved player is on the same spot as the pit,
  // Wumpus, or bats in which case it calls the corresponding method to relocate
  // or end the game. Then it trasmits a value to Map.java which prints out any
  // necessary events.

  public void keyPressed(KeyEvent ke) {
    int keyCode = ke.getKeyCode();

    switch (keyCode) {
      case KeyEvent.VK_W:
        moveUp();
        numMoves -= 1;
        if ((moveY) == pitY && (moveX == pitX)) {
          text = "You fell in the pit";
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          text = "You ran into the Wumpus";
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          text = "You hit a bat";
          relocate();
        }
        break;

      case KeyEvent.VK_S:
        moveDown();
        numMoves -= 1;
        if ((moveY) == pitY && (moveX == pitX)) {
          text = "You fell in the pit";
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          text = "You ran into the Wumpus";
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          text = "You hit a bat";
          relocate();

        }
        break;
      case KeyEvent.VK_A:
        moveLeft();
        numMoves -= 1;
        if ((moveY) == pitY && (moveX == pitX)) {
          text = "You fell in the pit";
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          text = "You ran into the Wumpus";
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          text = "You hit a bat";
          relocate();
        }
        break;
      case KeyEvent.VK_D:
        moveRight();
        numMoves -= 1;
        if ((moveY) == pitY && (moveX == pitX)) {
          text = "You fell in the pit";
          pit();
        } else if ((moveY) == wumpusY && (moveX == wumpusX)) {
          text = "You ran into the Wumpus";
          wumpus();
        } else if ((moveY) == batY && (moveX == batX)) { // bat
          text = "You hit a bat";
          relocate();
        }
        break;

      // These cases are used for shooting and indicators for the textbox. Each time
      // you press the up, down, left, or right keys it changes the shoot coordinates
      // for the player and then checks to see if that new shoot value is on the same
      // spot as the Wumpus. If it is, it runs the win() method which ends the game.
      // If the player misses, it decreases 1 arrow for the number of arrows, moves
      // the Wumpus with moveWumpus() and checks if the player is out of arrows in
      // which case it ends the game.

      case KeyEvent.VK_UP:

        if ((shootY - 100) == wumpusY && shootX == wumpusX) {
          text = "You hit the Wumpus";
          win();
        } else {
          text = "You did not hit the Wumpus";
          moveWumpus();
          numArrows -= 1;
          if (numArrows == 0) {
            text = "You ran out of arrows";
          }
        }

        shootY = moveY;
        break;

      case KeyEvent.VK_DOWN:

        if ((shootY + 100) == wumpusY && shootX == wumpusX) {
          text = "You hit the Wumpus";
          win();
        } else {
          moveWumpus();
          text = "You did not hit the Wumpus";
          numArrows -= 1;
          if (numArrows == 0) {
            text = "You ran out of arrows";
          }
        }

        shootY = moveY;
        break;
      case KeyEvent.VK_LEFT:

        if (shootY == wumpusY && (shootX - 100) == wumpusX) {
          text = "You hit the Wumpus";
          win();
        } else {
          text = "You did not hit the Wumpus";
          moveWumpus();
          numArrows -= 1;
          if (numArrows == 0) {
            text = "You ran out of arrows";
          }
        }

        shootY = moveY;
        break;

      case KeyEvent.VK_RIGHT:

        if (shootY == wumpusY && (shootX + 100) == wumpusX) {
          text = "You hit the Wumpus";
          win();
        } else {
          text = "You did not hit the Wumpus";
          moveWumpus();
          numArrows -= 1;
          if (numArrows == 0) {
            text = "You ran out of arrows";
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
