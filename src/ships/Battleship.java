package ships;


import game.Ships;
/**
 * 	Battleship Class contains methods for the basic ship functionality
 *  @author Vinesh Mistry Student Number: 1509170
 *
 */
public class Battleship implements Ships{
	
	private int player;
	private boolean moved;
	private int number;
	private ShipType[] destroys;
	private int x, y;
	/**
	 * 
	 * @param p - player number
	 * @param n - ship Number
	 */
	public Battleship(int p, int n){
		player = p; 
		moved = false;
		number = n;
		destroys = new ShipType[3];
	}

	@Override
	public ShipType getType() {
		return ShipType.BATTLESHIP;
	}
	@Override
	public int getPlayer(){
		return player;
	}

	@Override
	public int getMoves() {
		return 4;
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
		return number;
	}
	
	@Override
	public ShipType[] destroys(){
		destroys[0]= ShipType.BATTLESHIP;
		destroys[1]= ShipType.DESTROYER;
		destroys[2]= ShipType.MINESWEEPER;
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
