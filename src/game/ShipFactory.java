package game;
import ships.*;
/**
 * ShipFactory produces Ships interface objects
 * @author Vinesh Mistry Student No: 1509170
 *
 */
public class ShipFactory {
	/**
	 * ShipFactory produces Ships interface objects
	 * @param ship - String ship name
	 * @param player - player number
	 * @param num - ship number
	 * @return Ships interface object
	 */
	public Ships shipFactory(String ship, int player, int num){
		if(ship.equalsIgnoreCase("BattleShip")){
			return new Battleship(player, num);
		}
		else if(ship.equalsIgnoreCase("Destroyer")){
			return new Destroyer(player, num);
		}
		else if(ship.equalsIgnoreCase("Minesweeper")){
			return new Minesweeper(player, num);
		}
		else if(ship.equalsIgnoreCase("Submarine")){
			return new Submarine(player, num);
		}
		else if(ship.equalsIgnoreCase("Mine")){
			return new Mine(player, num);
		}
		return null;
	}
}
