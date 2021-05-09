import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Home extends Game {
  public Home() {

    setSize(900, 600); // Initializing the JPanel including size, location, etc.
    setBackground(new java.awt.Color(204, 166, 166));
    setTitle("Hunt The Wumpus");
    setLocationRelativeTo(null);

    JButton b = new JButton("Click Here");

    b.setVisible(true);

  }
}
