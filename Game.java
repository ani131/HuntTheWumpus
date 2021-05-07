
public class Game extends Map {

  public Game() {
    setSize(900, 600); // Initializing the JPanel including size, location, etc.
    setTitle("Hunt The Wumpus");
    setLocationRelativeTo(null);
    new Map();
    new MoveShoot();

  }

}
