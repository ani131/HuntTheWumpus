import java.awt.*;

public class Map extends MoveShoot {
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
}
