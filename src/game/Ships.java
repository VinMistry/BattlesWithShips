package game;

import ships.ShipType;
/**
 * Interface for Ships
 * @author Vinesh Mistry Student No: 1509170
 *
 */
public interface Ships {
	/**
	 * 
	 * @return ShipType
	 */
	public ShipType getType();
	/**
	 * 
	 * @return player number
	 */
	public int getPlayer();
	/**
	 * 
	 * @return number of moves a ship can move
	 */
	public int getMoves();
	/**
	 * 
	 * @return boolean if a ship has moved
	 */
	public boolean getMoved();
	/**
	 * 
	 * @param moved if the ship has moved
	 */
	public void setMoved(boolean moved);
	/**
	 * 
	 * @return ship number
	 */
	public int getNumber();
	/**
	 * 
	 * @return Array of types of ships each ship can destroy
	 */
	public ShipType[] destroys();
	/**
	 * 
	 * @return Ships X co-ordinate
	 */
	public int getX();
	/**
	 * 
	 * @param x - new x co-ordinate to set
	 */
	public void setX(int x);
	/**
	 * 
	 * @return Ships Y co-ordinate
	 */
	public int getY();
	/**
	 * 
	 * @param y - new y co-ordinate to set
	 */
	public void setY(int y);
	
}
