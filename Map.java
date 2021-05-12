import java.awt.*;

public class Map extends MoveShoot {

  // Graphics for the GUI using the built in paint() function

  public void paint(Graphics g) {

    // Displays string of player coordinates using drawString() at the top left ex:
    // (x=1, y=2)

    g.drawString("x=" + (moveX - 50 + 100) + ", y=" + (moveY - 60 + 100), 40, 45); // 50 to offset x and 60 to offset y

    // Draw rectangle outline of the grid map

    g.drawRect(600, 60, 270, 150);

    // Logic to sense the wumpus/pit/bats for surrounding blocks

    if ((Math.abs(moveX - wumpusX)) == 100 && (Math.abs(moveY - wumpusY) == 100)) {
      g.drawString("You smell a Wumpus nearby.", 605, 75);
    } else if ((Math.abs(moveX - wumpusX)) == 100 && (Math.abs(moveY - wumpusY) == 0)) {
      g.drawString("You smell a Wumpus nearby.", 605, 75);
    } else if ((Math.abs(moveX - wumpusX)) == 0 && (Math.abs(moveY - wumpusY) == 100)) {
      g.drawString("You smell a Wumpus nearby.", 605, 75);
    }

    if ((Math.abs(moveX - pitX)) == 100 && (Math.abs(moveY - pitY) == 100)) {
      g.drawString("You feel a breeze.", 605, 100);
    } else if ((Math.abs(moveX - pitX)) == 100 && (Math.abs(moveY - pitY) == 0)) {
      g.drawString("You feel a breeze.", 605, 100);
    } else if ((Math.abs(moveX - pitX)) == 0 && (Math.abs(moveY - pitY) == 100)) {
      g.drawString("You feel a breeze.", 605, 100);
    }

    if ((Math.abs(moveX - batX)) == 100 && (Math.abs(moveY - batY) == 100)) {
      g.drawString("You hear flapping.", 605, 125);
    } else if ((Math.abs(moveX - batX)) == 100 && (Math.abs(moveY - batY) == 0)) {
      g.drawString("You hear flapping.", 605, 125);
    } else if ((Math.abs(moveX - batX)) == 0 && (Math.abs(moveY - batY) == 100)) {
      g.drawString("You hear flapping.", 605, 125);
    }

    // Horizontal and vertical grid lines that form a 5 x 5 grid

    g.drawLine(150, 60, 150, 560);
    g.drawLine(250, 60, 250, 560);
    g.drawLine(350, 60, 350, 560);
    g.drawLine(450, 60, 450, 560);

    g.drawLine(50, 160, 550, 160);
    g.drawLine(50, 260, 550, 260);
    g.drawLine(50, 360, 550, 360);
    g.drawLine(50, 460, 550, 460);

    // Draw the main character and color it cyan

    g.drawRect(50, 60, 500, 500);
    g.setColor(Color.CYAN);
    g.fillRect(moveX, moveY, 100, 100);

    // Black text for the strings on the screen

    g.setColor(Color.BLACK);

    // Displays number of arrows & moves left
    // Triggers the following methods if they there are 0 moves or 0 arrows left

    if (numArrows == 0) {
      noArrows();
    } else {
      g.drawString("Number of arrows left: " + numArrows, 605, 200);
    }

    if (numMoves == 0) {
      noMoves();
    } else {
      g.drawString("Number of moves left: " + numMoves, 605, 175);
    }

    // Basic on screen instructions while playing

    g.drawString("Use WASD to move and the arrow keys to shoot!", 605, 250);
    g.drawString("Goal: Kill the wumpus while avoiding the pit and bats!", 590, 300);

    g.drawString(text, 605, 400);

  }

}
