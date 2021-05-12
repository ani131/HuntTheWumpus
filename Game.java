import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Game extends Textfield {

  public Game() {
    setSize(900, 600); // Initializing the JPanel including size, location, etc.
    setTitle("Hunt The Wumpus");
    setBackground(new java.awt.Color(204, 166, 166));
    setLocationRelativeTo(null);
    // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    new Map().setVisible(false);
    new Textfield().setVisible(false);
    new MoveShoot().setVisible(false);

  }
}
