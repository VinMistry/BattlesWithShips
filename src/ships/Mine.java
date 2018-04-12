/**
 * 
 */
package ships;

import game.Ships;

/**
 * 	Battleship Class contains methods for the basic ship functionality
 *  @author Vinesh Mistry Student Number: 1509170
 *
 */
public class Mine implements Ships  {
	
private boolean moved;	
private int player, x, y;
private int number;
/**
 * 
 * @param p - player number
 * @param n - ship number
 */
	public Mine(int p, int n){
		player = p;
		moved= false;
		number = n;
	}

	@Override
	public ShipType getType() {
		return ShipType.MINE;
	}
	@Override
	public int getPlayer(){
		return player;
	}

	@Override
	public int getMoves() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getMoved() {
		return moved;
	}


	@Override
	public void setMoved(boolean moved) {
		this.moved = moved;
		
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public ShipType[] destroys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}
	
}
