
public class Game extends Textfield {

  public Game() {
    setSize(900, 600); // Initializing the JPanel including size, location, etc.
    setTitle("Hunt The Wumpus");
    setLocationRelativeTo(null);
    new Map();
    new Textfield();
    new MoveShoot();

  }

}
