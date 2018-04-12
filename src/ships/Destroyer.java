package ships;

import game.Ships;
/**
 * 	Battleship Class contains methods for the basic ship functionality
 *  @author Vinesh Mistry Student Number: 1509170
 *
 */
public class Destroyer implements Ships {
	private int player, x, y;
	private boolean moved;
	private int number;
	private ShipType[] destroys;
	/**
	 * 
	 * @param p - player number
	 * @param n - ship number
	 */
	public Destroyer(int p, int n){
		player = p;
		moved = false;
		number = n;
		destroys = new ShipType[3];
	}

	@Override
	public ShipType getType() {
		return ShipType.DESTROYER;
	}

	@Override
	public int getPlayer() {
		return player;
	}

	@Override
	public int getMoves() {
		return 6;
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
	public ShipType[] destroys(){
		destroys[0]= ShipType.DESTROYER;
		destroys[1]= ShipType.MINESWEEPER;
		destroys[2]= ShipType.SUBMARINE;
		return destroys;
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
