package gameTests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import ships.ShipType;

public class TestBoard {
	/**
	 * Test method for {@link presentation.Board#getColumns()}.
	 */
	@Test
	public void testGetColumns() {
		System.out.println("testGetColumns");
		Board b = new Board();
		b.setColumns();
		assertEquals(b.getColumns(), 10);	
	}

	/**
	 * Test method for {@link presentation.Board#setColumns()}.
	 */
	@Test
	public void testSetColumns() {
		System.out.println("testSetColumns");
		Board b = new Board();
		b.setColumns();
		assertEquals(b.getColumns(), 10);	
	}

	/**
	 * Test method for {@link presentation.Board#getRows()}.
	 */
	@Test
	public void testGetRows() {
		System.out.println("testGetRows");
		Board b = new Board();
		b.setRows();
		assertEquals(b.getRows(), 5);
	}

	/**
	 * Test method for {@link presentation.Board#setRows()}.
	 */
	@Test
	public void testSetRows() {
		System.out.println("testSetRows");
		Board b = new Board();
		b.setRows();
		assertEquals(b.getRows(), 5);
	}
	
	
	@Test
	 // Pass if ships collide
	public void testCollisions() {
		System.out.println("testCollisions");
		Board b = new Board();
		b.initGame();
		b.configPlayers("p1");
		b.updateBoard(1);
		b.changeTurn(1);
		b.setMovement();
		b.updateBoard(1);
		assertTrue(b.getCollision());
	}

	@Test
	//Pass if player 2 ships destroyed using battleship
	//Enter 1 BattleShip ONLY
	//One turn Conflit
	//Co-ordinates to enter Battleship P1: (4,1)
	//Co-ordinates to enter Destroyer/EnemyShip P2: (5,1)
	public void testBattleshipConflict() {
		System.out.println("testBattleshipConflict");
		Board b = new Board();
		b.initGame();
		b.configPlayers("p1");
		b.updateBoard(1);
		b.configPlayers("p2");
		b.updateBoard(2);
		b.setMovement();
		b.updateBoard(1);
		b.updateBoard(2);
		b.checkFinish();
		assertEquals(0, b.getP2Count());
		
	}

	@Test
	//Pass if both players ships destroyed
	//Enter 1 of each Ship ONLY - QUICK TEST
	//One turn Conflit
	//Co-ordinates to enter Start At P1: (4,1) End At: (4,5)
	//Co-ordinates to enter Start At P2: (5,1) End At: (5,5)
	public void testTotalAnnihilation() {
		System.out.println("testTotalAnnihilation");
		Board b = new Board();
		b.initGame();
		b.configPlayers("p1");
		b.updateBoard(1);
		b.configPlayers("p2");
		b.updateBoard(2);
		b.setMovement();
		b.updateBoard(1);
		b.updateBoard(2);
		b.checkFinish();
		assertEquals(0, b.getP2Count()+b.getP1Count());

	}


	@Test
	//One turn Conflit
	//Pass if player 2 ships destroyed
	//Enter 1 Destroyer ONLY 
	//Enter 0 BattleShips - BattleShip will destroy Destroyer
	//Co-ordinates to enter Destroyer P1: (4,1)
	////Co-ordinates to enter Destroyer/EnemyShip P2: (5,1)
	public void testDestroyerConflict() {
		System.out.println("testDestroyerConflict");
		Board b = new Board();
		b.initGame();
		b.configPlayers("p1");
		b.updateBoard(1);
		b.configPlayers("p2");
		b.updateBoard(2);
		b.setMovement();
		b.updateBoard(1);
		b.updateBoard(2);
		b.checkFinish();
		assertEquals(0, b.getP2Count());
	}
	
	@Test
	//Pass if ships added to shipMap
	public void testPutShip() {
		System.out.println("testPutShip");
		Board b = new Board();
		b.putShips();
		System.out.println(b.getShipMap());
		assertNotNull(b.getShipMap());
		
	}

	@Test
	//Pass if ships added to shipMap
	public void testSetMineCounters() {
		System.out.println("testSetMineCounters");
		Board b = new Board();
		b.setmCounter(10);
		assertEquals(10, b.getmCounter());
	}
	
	@Test
	//Pass if ships added to shipMap
	public void testSetBattleshipCounters() {
		System.out.println("testSetBattleshipCounters");
		Board b = new Board();
		b.setbCounter(0);
		assertEquals(0, b.getmCounter());
	}
	
	@Test
	//Pass if ships added to shipMap
	public void testRemoveShip() {
		System.out.println("testSetBattleshipCounters");
		Board b = new Board();
		b.initGame();
		b.configPlayers("p1");
		b.removeShip(b.getShip(ShipType.BATTLESHIP, 1, 0));
		b.checkFinish();
		assertEquals(0, b.getP1Count());
	}
}
