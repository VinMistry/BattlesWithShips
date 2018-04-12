package game;

/**
 * Position class will help to store ships
 @author Vinesh Mistry Student No: 1509170
 *
 */
public class Position {
	private Ships ship;
	
	/**
	 * Parameterised constructor
	 * @param ship ship to add into a position
	 */
	public Position(Ships ship){
		this.ship = ship;
	}
	/**
	 * @return the ship
	 */
	public Ships getShip() {
		return ship;
	}

	/**
	 * @param ship the ship to set
	 */
	public void setShip(Ships ship) {
		this.ship = ship;
	}
	
}
