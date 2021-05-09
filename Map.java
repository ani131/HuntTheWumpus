import java.awt.*;

public class Map extends MoveShoot {
  public void paint(Graphics g) {
    g.drawString("x=" + (moveX - 50 + 100) + ", y=" + (moveY - 60 + 100), 40, 45); // A string that displays
                                                                                   // coordinates at the top left
                                                                                   // ex: (x=1, y=2)
    g.drawString("wumpusX=" + (wumpusX - 50 + 100) + ", wumpusY=" + (wumpusY - 60 + 100), 200, 45);
    g.drawString("pitX=" + (pitX - 50 + 100) + ", pitY=" + (pitY - 60 + 100), 500, 45);
    g.drawString("batX=" + (batX - 50 + 100) + ", batY=" + (batY - 60 + 100), 700, 45);

    g.drawRect(600, 60, 270, 150);

    if (numArrows == 0) {
      g.drawString("You can not shoot. You are out of arrows", 605, 200);
    } else {
      g.drawString("Number of arrows left: " + numArrows, 605, 200);
    }

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

}
