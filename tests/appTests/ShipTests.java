package appTests;
import static org.junit.Assert.*;

import org.junit.Test;

import ships.*;

public class ShipTests {

	@Test
	public void battleshipTypeTest() {
		Battleship battle = new Battleship(1,1);
		assertEquals(ShipType.BATTLESHIP ,battle.getType());
	}
	
	@Test
	public void battleshipPlayerTest() {
		Battleship battle = new Battleship(1,1);
		assertEquals(1 , battle.getPlayer());
	}
	
	@Test
	public void destroyerTypeTest() {
		Destroyer destroy = new Destroyer(2,2);
		assertEquals(ShipType.DESTROYER , destroy.getType());
	}
	
	@Test
	public void destroyerPlayerTest() {
		Destroyer destroy = new Destroyer(2,2);
		assertEquals(2 , destroy.getPlayer());
	}
	
}
