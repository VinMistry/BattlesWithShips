import game.*;
/**
 * Class Launches the game
 * @author Vinesh Mistry Student No: 1509170
 *
 */
public class Launch {
	/**
	 * Main method starts game
	 * @param args - string arguments
	 */
	public static void main(String[] args) {
		Board b = new Board();
		b.startGame();
		/*b.putShips();
		System.out.println(b.getShipMap());*/
	}
}
