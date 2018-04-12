package game;


import java.util.EnumMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import game.Position;
import game.Ships;
import ships.ShipType;



/**
 * Board Class contains methods that allow for the game to be displayed and function
 * @author Vinesh Mistry Student Number: 1509170
 *
 */
public class Board {
	
	private boolean firstTurn, finish, collision;
	private int columns;
	private int rows;
	private Controller player1, player2;
	private Position[][] positions; 
	private int bCounter, dCounter, mCounter, sCounter, msCounter, p1Count, p2Count;
	private EnumMap<ShipType, Integer> shipMap = new EnumMap<ShipType, Integer>(ShipType.class);
	
	
	/**
	 * Default constructor 
	 */
	public Board(){
		player1 = new Controller();
		player1.setPlayerNumb(1);
		player2 = new Controller();
		player2.setPlayerNumb(2);
		finish = false;
		collision = false;
	}

	/**
	 * @return the shipMap
	 */
	public EnumMap<ShipType, Integer> getShipMap() {
		return shipMap;
	}

	/**
	 * @param shipMap the shipMap to set
	 */
	public void setShipMap(EnumMap<ShipType, Integer> shipMap) {
		this.shipMap = shipMap;
	}
	
	/**
	 * Adds ship types and battle strengths into the EnumMap shipMap
	 */
	public void putShips(){
		shipMap.put(ShipType.BATTLESHIP, 4);
		shipMap.put(ShipType.DESTROYER,3); 
		shipMap.put(ShipType.MINESWEEPER, 2);
		shipMap.put(ShipType.SUBMARINE, 1);
		shipMap.put(ShipType.MINE, 5);
	}
	/**
	 * @return the p1Count
	 */
	public int getP1Count() {
		return p1Count;
	}

	/**
	 * @param p1Count the p1Count to set
	 */
	public void setP1Count(int p1Count) {
		this.p1Count = p1Count;
	}

	/**
	 * @return the p2Count
	 */
	public int getP2Count() {
		return p2Count;
	}

	/**
	 * @param p2Count the p2Count to set
	 */
	public void setP2Count(int p2Count) {
		this.p2Count = p2Count;
	}

	/**
	 * @return the positions
	 */
	public Position[][] getPositions() {
		return positions;
	}

	/**
	 * @param positions the positions to set
	 */
	public void setPositions(Position[][] positions) {
		this.positions = positions;
	}

	/**
	 * @return the player1
	 */
	public Controller getPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(Controller player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public Controller getPlayer2() {
		return player2;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayer2(Controller player2) {
		this.player2 = player2;
	}

	/**
	 * @return the bCounter
	 */
	public int getbCounter() {
		return bCounter;
	}

	/**
	 * @param bCounter the bCounter to set
	 */
	public void setbCounter(int bCounter) {
		this.bCounter = bCounter;
	}

	/**
	 * @return the dCounter
	 */
	public int getdCounter() {
		return dCounter;
	}

	/**
	 * @param dCounter the dCounter to set
	 */
	public void setdCounter(int dCounter) {
		this.dCounter = dCounter;
	}

	/**
	 * @return the mCounter
	 */
	public int getmCounter() {
		return mCounter;
	}

	/**
	 * @param mCounter the mCounter to set
	 */
	public void setmCounter(int mCounter) {
		this.mCounter = mCounter;
	}

	/**
	 * @return the sCounter
	 */
	public int getsCounter() {
		return sCounter;
	}

	/**
	 * @param sCounter the sCounter to set
	 */
	public void setsCounter(int sCounter) {
		this.sCounter = sCounter;
	}

	/**
	 * @return the msCounter
	 */
	public int getMsCounter() {
		return msCounter;
	}

	/**
	 * @param msCounter the msCounter to set
	 */
	public void setMsCounter(int msCounter) {
		this.msCounter = msCounter;
	}

	/**
	 * @return the coords
	 */
	public void getCoords() {
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null){
					System.out.println("Coords[" + y + "][" + x + "]" + ":" + positions[x][y].getShip().getType() + positions[x][y].getShip().getNumber() + " Player: "+ positions[x][y].getShip().getPlayer());
				}
				else{
					System.out.println("No Ship");
				}
				y++;
			}
			x++;
			y=0;
		}
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns() {
		try{
		System.out.println("\nPlease Enter Number of Columns :");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int columns = sc.nextInt();
		if(columns < 2){
			System.err.println("Error Please Enter A Number Greater Than 1!");
			setColumns();
		}
		else{
			this.columns = columns;
		}
		}
		catch(InputMismatchException e){
			System.err.println("Error Please Enter A Number!");
			setColumns();
		}
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows() {
		try{
		System.out.println("\nPlease Enter Number of Rows :");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		if(rows < 2){
			System.err.println("Error Please Enter A Number Greater Than 3!");
			setRows();
		}
		this.rows = rows;
		}
		catch(InputMismatchException e){
			System.err.println("Error Please Enter A Number!");
			setRows();
		}
	}
	
	/**
	 * @param rows the rows to set
	 */
	public void setPlayers() {
		System.out.println("\nEnter Player 1 Name :");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String play1 = sc.next();
		player1.setName(play1);
		System.out.println("\nEnter Player 2 Name :");
		@SuppressWarnings("resource")
		Scanner sa = new Scanner(System.in);
		String play2 = sa.next();
		player2.setName(play2);
		System.out.println("\nPlayer 1: " + player1.getName() + "\nPlayer 2: " + player2.getName());
	}
	
	/**
	 * Starts the game
	 */
	public void startGame(){
		firstTurn = true;
		System.out.println("######### WELCOME TO ... ########");
		System.out.println("###### BATTLES WITH SHIPS #######\n");
		initGame();
		displayBlankBoard();
		configurePlayers();
		firstTurn = false;
		mainGame();
	}
	/** 
	 * Initialises the game elements
	 */
	public void initGame(){
		setPlayers();
		setColumns();
		setRows();
		System.out.println("\n####--CONFIGURE NUMBER OF EACH SHIP--###\n");
		setBattleshipCounters();
		setDestroyersCounters();
		setMinesweeperCounters();
		setSubmarineCounters();
		setMineCounters();
		positions = new Position[columns][rows];
		p1Count = 0;
		System.out.println("Battle: " + getbCounter() + "\nDestroy: "+ getdCounter()+ "\nMines: "+
		getmCounter() + "\nSub: "+ getsCounter() + "\nMinesweepers: "+ getMsCounter());
	}
	
	/**
	 * configures players
	 */
	private void configurePlayers(){
		configPlayers("p1");
		System.out.println("###### PLAYER 1's BOARD #######\n");
		updateBoard(1);
		sleepMethod(2000);
		displayBlankBoard();
		configPlayers("p2");
		System.out.println("###### PLAYER 2's BOARD #######\n");
		updateBoard(2);
		sleepMethod(2000);
	}
	/**
	 * Main game to run e.g. change turn and check to see if game has ended
	 * 
	 */
	private void mainGame(){
		int counter = 0;
		while(!finish){
			setMovement();
			changeTurn(1);
			changeTurn(2);
			setMovement();
			resetMoved();
			counter++;
			checkFinish();
		}
		if(finish){
			System.out.println("Number of Turns: "+ counter);
		}
	}
	/**
	 * checks to see if game has ended
	 */
	public void checkFinish(){
		System.out.println("###--CHECKING --###");
		int x = 0;
		int y = 0;
		int numOfMines1 = 0;
		int numOfMines2 = 0;
		p1Count = 0;
		p2Count = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null && positions[x][y].getShip().getPlayer() == 1 ){
					if(positions[x][y] != null && positions[x][y].getShip().getType() == ShipType.MINE){
						numOfMines1++;
					}
					p1Count++;
				}
				else if(positions[x][y] != null && positions[x][y].getShip().getPlayer() == 2){
					if(positions[x][y] != null && positions[x][y].getShip().getType() == ShipType.MINE){
						numOfMines2++;
					}
					p2Count++;
				}
				y++;
			}
			x++;
			y=0;
		}
		System.out.println("PLAYER 1 COUNT: "+ p1Count + "\nPLAYER 2 COUNT: " + p2Count);
		sleep(5000);
		if((p1Count - numOfMines1 <= 0 && p2Count - numOfMines2 <= 0 ) ||(p1Count == 0 && p2Count == 0 ) ){
			System.out.println("###--GAME OVER--###");
			System.out.println("PLAYER 1 COUNT: "+ p1Count + "\nPLAYER 2 COUNT: " + p2Count);
			System.out.println("RESULT : DRAW!");
			finish = true;
		}
		else if(p1Count == 0 || p1Count - numOfMines1 <= 0 ){
			System.out.println("###--GAME OVER--###");
			System.out.println("PLAYER 1 COUNT: "+ p1Count + "\nPLAYER 2 COUNT: " + p2Count);
			System.out.println("RESULT : PLAYER 2 WINS!");
			finish = true;
		}
		else if( p2Count == 0 || p2Count - numOfMines2 <= 0 ){
			System.out.println("###--GAME OVER--###");
			System.out.println("PLAYER 1 COUNT: "+ p1Count + "\nPLAYER 2 COUNT: " + p2Count);
			System.out.println("RESULT : PLAYER 1 WINS!");
			finish = true;
		}
		else{
			
		}
	}
	/**
	 * Sleeps thread for specified time
	 * @param time - time to sleep
	 */
	private void sleepMethod(long time){
		try{
			Thread.sleep(time);
			for(int i = 0; i< 50; i++){
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			}
		}
			catch(InterruptedException e){
				
			}
	}
	
	/**
	 * Sleeps thread for specified time
	 * @param time - time to sleep
	 */
	private void sleep(long time){
		try{
			Thread.sleep(time);
		}
			catch(InterruptedException e){
				
			}
	}
	/**
	 * Changes turn depending on player
	 * @param player - player number
	 */
	public void changeTurn(int player){
		if(player == 1){
			updateBoard(1);
			moveShip(1);
			updateBoard(1);
			sleepMethod(2000);
		}
		else{
			updateBoard(2);
			moveShip(2);
			updateBoard(2);
			sleepMethod(2000);
		}
	}
	/**
	 * Sets counters for battleship
	 */
	private void setBattleshipCounters(){
		System.out.println("\nSpaces Remaining: " +  ((columns*rows/2)-4));
		System.out.println("\nPlease Enter The Number of Battleships You Want: ");
		try{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int bsCounter = sc.nextInt();
			if(bsCounter >  ((columns*rows/2)-4)){
				System.err.println("Error!\n Please Enter A Number Less Than: " + ((columns*rows/2)-4));
				 setBattleshipCounters();
			}
			else{
				bCounter = bsCounter;
			}
		}
		catch(NumberFormatException n){
			System.err.println("Error!\n Please Enter A Number!");
		}
	}
	/**
	 * Sets counters for destroyer
	 */
	private void setDestroyersCounters(){
		System.out.println("\nSpaces Remaining: " + (((columns*rows)/2)-(3+bCounter)));
		System.out.println("\nPlease Enter The Number of Destroyers You Want: ");
		try{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int dsCounter = sc.nextInt();
			if(dsCounter > (((columns*rows)/2)-(3+bCounter))){
				System.err.println("Error!\n Please Enter A Number Less Than: " + (((columns*rows)/2)-(3+bCounter)));
				 setBattleshipCounters();
			}
			else{
				dCounter = dsCounter;
			}
		}
		catch(NumberFormatException n){
			System.err.println("Error!\n Please Enter A Number!");
		}
	}
	/**
	 * Sets counters for minesweeper
	 */
	private void setMinesweeperCounters(){
		System.out.println("\nSpaces Remaining: " + ((columns*rows/2)-(2+bCounter+dCounter)));
		System.out.println("\nPlease Enter The Number of Minesweepers You Want: ");
		try{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int minesweepCounter = sc.nextInt();
			if(minesweepCounter > (((columns*rows)/2)-(2+bCounter+dCounter))){
				System.err.println("Error!\n Please Enter A Number Less Than: " + (((columns*rows)/2)-(2+bCounter+dCounter)));
				 setBattleshipCounters();
			}
			else{
				msCounter = minesweepCounter;
			}
		}
		catch(NumberFormatException n){
			System.err.println("Error!\n Please Enter A Number!");
		}
	}
	/**
	 * Sets counters for submarine
	 */
	private void setSubmarineCounters(){
		System.out.println("\nSpaces Remaining: " +  (((columns*rows)/2)-(1+bCounter+dCounter+msCounter)));
		System.out.println("\nPlease Enter The Number of Submarines You Want: ");
		try{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int subCounter = sc.nextInt();
			if(subCounter > (((columns*rows)/2)-(1+bCounter+dCounter+msCounter))){
				System.err.println("Error!\n Please Enter A Number Less Than: " + (((columns*rows)/2)-(1+bCounter+dCounter+msCounter)));
				 setBattleshipCounters();
			}
			else{
				sCounter = subCounter;
			}
		}
		catch(NumberFormatException n){
			System.err.println("Error!\n Please Enter A Number!");
		}
	}
	/**
	 * Sets counters for Mines
	 */
	private void setMineCounters(){
		System.out.println("\nSpaces Remaining: " + (((columns*rows)/2)-(bCounter+dCounter+msCounter+sCounter)));
		System.out.println("\nPlease Enter The Number of Mines You Want: ");
		try{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int mineCounter = sc.nextInt();
			if(mineCounter > (((columns*rows)/2)-(bCounter+dCounter+msCounter+sCounter))){
				System.err.println("Error!\n Please Enter A Number Less Than: " + (((columns*rows)/2)-(bCounter+dCounter+msCounter+sCounter)));
				 setBattleshipCounters();
			}
			else{
				mCounter = mineCounter;
			}
		}
		catch(NumberFormatException n){
			System.err.println("Error!\n Please Enter A Number!");
		}
	}
	
	/**
	 * prints the number of columns
	 */
	private void printColumns(){
		System.out.print("\n");
		for(int i= 0; i < columns; i++ ){
			if(i == 0 ){
				System.out.print("    " + i + "  ");
			}
			else if(i >=  10){
				System.out.print("  " + i + " ");
			}
			else{
				System.out.print("  " + i + "  ");
			}
		}
		
	}

	/**
	 * prints the number of rows
	 */
	private void printRows(){
		for(int j= 0; j < rows; j++ ){
			if(j == 0){
				System.out.print("\n\n" + j );
				for(int s= 0; s < columns; s++ ){
					System.out.print("   - ");
				}	
			}
			else if(j >= 10){
				System.out.print("\n"+ j + " ");
				for(int s= 0; s < columns; s++ ){
					System.out.print(" -   ");
				}
			}
			else{
				System.out.print("\n"+ j + " ");
				for(int s= 0; s < columns; s++ ){
					System.out.print("  -  ");
				}
			}
			System.out.print("\n");
		}
	}

	/** 
	 * 
	 * @param x - x co-ordinate
	 * @param y - y co-ordinate
	 * @return String value of a ship
	 */
	private String getShipInitial(int x, int y){
		if(positions[x][y] != null){
			if(positions[x][y].getShip().getType() == ShipType.BATTLESHIP){
				return "B";
			}
			if(positions[x][y].getShip().getType() == ShipType.DESTROYER){
				return "D";
			}
			if(positions[x][y].getShip().getType() == ShipType.SUBMARINE){
				return "S";
			}
			if(positions[x][y].getShip().getType() == ShipType.MINESWEEPER){
				return "M";
			}
			if(positions[x][y].getShip().getType() == ShipType.MINE){
				return "*";
			}
		}
		return null;
	}

	/**
	 * prints the number of rows
	 */
	private void updateRows(int player){
		int x = 0;
		int y = 0;
		for(int j= 0; j < rows; j++ ){
			if(j == 0){
				System.out.print("\n\n" + j + " " );
				for(int s= 0; s < columns; s++ ){
					if(positions[x][y] != null && positions[x][y].getShip().getPlayer() == player){
						System.out.print("  "+getShipInitial(x, y)+ "  ");
	
					} else {
						System.out.print("  -  ");
					}	
					if(y < columns){
						y++;
					}
				}
				if(x < rows){
					x++;
				}
				y = 0;
			}
			else{
				System.out.print("\n"+ j + " ");
				for(int s= 0; s < columns; s++ ){
					if(positions[x][y] != null && positions[x][y].getShip().getPlayer() == player){
						System.out.print("  "+getShipInitial(x, y)+ "  ");
	
					} else {
						System.out.print("  -  ");
					}	
					if(y < columns){
						y++;
					}
				}
				if(x < rows){
					x++;
				}
				y = 0;
			}
			System.out.print("\n");
		}
	}
	/**
	 * Prints an updated board
	 * @param player
	 */
	public void updateBoard(int player){
		printColumns();
		updateRows(player);
	}
	/**
	 * Prints a black board
	 */
	private void displayBlankBoard(){
		printColumns();
		printRows();
	}

	/**
	 * Configures ships depending on player
	 * @param play player to configure
	 */
	public void configPlayers(String play){
		if(play == "p1"){
		System.out.println("\nPlayer 1: " + player1.getName() + " Configuring Ships:  \n");
		configShips(ShipType.BATTLESHIP , 1);
		configShips(ShipType.DESTROYER, 1);
		configShips(ShipType.MINESWEEPER, 1);
		configShips(ShipType.SUBMARINE ,1 );
		configShips(ShipType.MINE, 1);
		}
		else{
			System.out.println("\nPlayer 2: " + player2.getName() + " Configuring Ships:  \n");
			configShips(ShipType.BATTLESHIP, 2);
			configShips(ShipType.DESTROYER, 2);
			configShips(ShipType.MINESWEEPER, 2);
			configShips(ShipType.SUBMARINE, 2);
			configShips(ShipType.MINE, 2);
		}
		
	}
	/**
	 * Configures each ship
	 * @param type - type of ship to configure
	 * @param play - player number
	 */
	public void configShips(ShipType type, int play){
		switch(type){
		case BATTLESHIP:
			for(int i =0; i < bCounter; i++){
				System.out.println("Configure Battleship " + i + ": ");
				Ships battle = new ShipFactory().shipFactory("Battleship", play, i);
				setCoords(battle, i);
			}
			break;
		case DESTROYER:
			for(int i =0; i < dCounter; i++){
				System.out.println("Configure Destroyer "+i+": ");
				Ships dest = new ShipFactory().shipFactory("Destroyer", play, i);
				setCoords(dest, i);
			}
			break;
		case MINESWEEPER:
			for(int i =0; i < msCounter; i++){
				System.out.println("Configure Minesweeper "+ i+ ": ");
				Ships minesweep = new ShipFactory().shipFactory("Minesweeper", play, i);
				setCoords(minesweep, i);
			}
			break;
		case SUBMARINE:
			for(int i =0; i < sCounter; i++){
				System.out.println("Configure Submarine "+i+": ");
				Ships sub = new ShipFactory().shipFactory("Submarine", play, i);
				setCoords(sub, i);
			}
			break;
		case MINE:
			for(int i =0; i < mCounter; i++){
				System.out.println("Configure Mine "+i+": ");
				Ships mine = new ShipFactory().shipFactory("Mine", play, i);
				setCoords(mine, i);
			}
			break;
		}
	}
	/**
	 * @param coords the coords to set
	 */
	public void setCoords(Ships ship, int num) {
		try{
		System.out.println("\nPlease Enter The X and Y Coordinates of "+ ship.getType() + " " + num +":");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String co = sc.next();
		int x =0;
		int y=0;
		int count = 1;
		String cor = co.replaceAll("\\s","");
		for( String c: cor.split(",")){
			 if(count ==1){
				x = Integer.parseInt(c);
				count++;
			}
			else{
				y = Integer.parseInt(c);
			}
		}		
		if(x >= columns || y >= rows){
			System.out.println("##--Incorrect Co-ordinates, Please Enter Positions On The Board--##\n");
			setCoords(ship, num);
		}
		else if(firstTurn && x > (columns/2)-1 && ship.getPlayer() == 1){
			System.out.println("##--Incorrect Co-ordinates, Please Enter Positions In Your Half--##\n");
			setCoords(ship, num);
		}
		else if(firstTurn && ship.getPlayer() == 2){
			if(x < columns/2 || x > columns - 1 || y > rows-1){
				System.out.println("##--Incorrect Co-ordinates, Please Enter Positions In Your Half--##\n");
				setCoords(ship,num);
			}
			else{
				if(positions[y][x] != null){
					System.out.println("##--Incorrect Co-ordinates, Positions Taken--##\n");
					setCoords(ship, num);
				}
				else{
					ship.setX(x);
					ship.setY(y);
					System.out.println(ship.getX()+ " " + ship.getY());
					positions[y][x] = new Position(ship);
					
				}
			}
		}
		else{
			if(positions[y][x] != null){
				System.out.println("##--Incorrect Co-ordinates, Positions Taken--##\n");
				setCoords(ship, num);
			}
			else{	
				ship.setX(x);
				ship.setY(y);
				System.out.println(ship.getX()+ " " + ship.getY());
				positions[y][x] = new Position(ship);
			}
		}
		}
		catch(NumberFormatException e){
			System.err.println("Please Enter Valid Numbers !");
			setCoords(ship, num);
		}
		catch(ArrayIndexOutOfBoundsException a){
			System.err.println("Please Enter Valid Numbers !");
			setCoords(ship, num);
		}
	}
	/**
	 * Removes ship from positions 2D array
	 * @param s - ship to remove
	 */
	public void removeShip(Ships s){
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null && positions[x][y].getShip() == s ){
					positions[x][y] = null;
				}
				y++;
			}
			x++;
			y=0;
		}
	}
	/**
	 * Removes ship from positions 2D array
	 * @param s - ship to remove
	 */
	public Ships getShip(ShipType s , int player, int number){
		Ships retShip = null;
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null && positions[x][y].getShip().getType() == s  && positions[x][y].getShip().getPlayer() == player && positions[x][y].getShip().getNumber() == number){
					System.out.println("Ship Found");
					retShip = positions[x][y].getShip();
				}
				y++;
			}
			x++;
			y=0;
		}
		return retShip;
	}
	/**
	 * @param coords the coords to set
	 */
	public void setMovement() {
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null){
						collision = false;
						checkCollision(positions[x][y].getShip());
						if(getCollision() == true){
							System.out.println("COLLISION OCCURRED");
							//positions[x][y] = null;
						}
						else{
							int newXPos = positions[x][y].getShip().getX();
							int newYPos = positions[x][y].getShip().getY();
							Ships ship = positions[x][y].getShip();
							positions[x][y] = null;
							positions[newYPos][newXPos] = new Position(ship);
							battle(ship, newYPos,  newXPos);
							
					}
				}
				else{
					//System.out.println("ERROR AT: "  + positions[x][y].getShip().getType() +"\nX: "+ x +" Y: "+y);
				}
				y++;
			}
			x++;
			y=0;
		}
	}
	/**
	 * Checks to see if a collision will occur
	 * @param s - ship to check collision with
	 */
	private void checkCollision(Ships s){
		try{
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null && positions[x][y].getShip().getX() == s.getX() && positions[x][y].getShip().getY() == s.getY() && positions[x][y].getShip() != s){
					if(s.getPlayer() == positions[x][y].getShip().getPlayer()){
						System.out.println("Player "+ s.getPlayer() +"'s Ships Collide!");
					}
					else{
						System.out.println("Both Player's Ships Collide!");
					}
					if((positions[x][y].getShip().getType() == ShipType.MINE && s.getType() == ShipType.MINESWEEPER)){
						System.out.println("Mine Neautralised");
						positions[x][y] = null;
					}
					else{
						System.out.println("COLLISION BETWEEN : "+positions[x][y].getShip().getType() + " "+ positions[x][y].getShip().getNumber() );
						System.out.println("AND : " + s.getType() + " "+ s.getNumber());
						positions[x][y] = null;
						removeShip(s);
						collision = true;
					}
				}
				else{
				}
				y++;
			}
			x++;
			y=0;
		
		}
		}
		catch(NullPointerException n){
			System.out.println("Null");
		}
	}
	/**
	 * 
	 * @return boolean collision
	 */
	public boolean getCollision(){
		return collision;
	}
	/**
	 * Asks to move ship
	 * @param players player number
	 */
	private void moveShip(int players){
		if(players == 1){
			System.out.println("\nPlayer 1: "+player1.getName()+"'s turn");
			System.out.println("Please choose where you want to move your ships");
		}
		else{
			System.out.println("\nPlayer 2: "+player2.getName()+"'s turn");
			System.out.println("Please choose where you want to move your ships");
		}
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null && positions[x][y].getShip().getPlayer() == players && !positions[x][y].getShip().getMoved()){
					boolean move = false;
					boolean correctAns = false;
					Ships s = positions[x][y].getShip();
					while(!correctAns){
						if(s.getType() == ShipType.MINE){
							return;
						}
						System.out.println("Do you want to move " + s.getType() +" "+ s.getNumber()+ " ?");
						if(players == 1){
							System.out.println("Current Position: " + "X: "+y+" Y: "+ x);
						}
						else{
							System.out.println("Current Position: " + "X: "+y+" Y: "+ x);
						}
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						String ans = sc.next();
						if(ans.equalsIgnoreCase("YES") || ans.equalsIgnoreCase("Y")){
							move = true;
							correctAns = true;
						}
						else if(ans.equalsIgnoreCase("NO") || ans.equalsIgnoreCase("N")){
							move = false;
							correctAns = true;
						}
						else {
							System.out.println("### Error ###");
							correctAns = false;
						}
					}
					if(move && !s.getMoved() && players == 1){
						s.setMoved(true);
						setNewCoords(s, x, y);
						
					}
					if(move && !s.getMoved() && players == 2){
						s.setMoved(true);
						setNewCoords(s, y, x);
					}
				}
				y++;
			}
			x++;
			y=0;
		}
	}
	
	/**
	 * @param coords the coords to set
	 */
	public void setNewCoords(Ships ship, int oldX, int oldY) {
		try{
		System.out.println("\nPlease Enter The X and Y Coordinates of "+ ship.getType() +" " +ship.getNumber() +":");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String co = sc.next();
		int x =0;
		int y=0;
		int count = 1;
		String cor = co.replaceAll("\\s","");
		for( String c: cor.split(",")){
			 if(count ==1){
				x = Integer.parseInt(c);
				count++;
			}
			else{
				y = Integer.parseInt(c);
			}
		}		
		if(x >= columns || y >= rows){
			System.out.println("##--Incorrect Co-ordinates, Please Enter Positions On The Board--##\n");
			setNewCoords(ship,oldX,oldY);
		}
		else{
			if(((x-oldX)+(y-oldY)) > ship.getMoves()){
				System.out.println("##--Incorrect Co-ordinates, Ship Can Not Move This Distance--##\n");
				setNewCoords(ship,oldX,oldY);
			}
			else if(((oldX-x)+(oldY-y)) > ship.getMoves()){
				System.out.println("##--Incorrect Co-ordinates, Ship Can Not Move This Distance--##\n");
				setNewCoords(ship,oldX,oldY);
			}
			else if(((x-oldX)+(oldY-y)) > ship.getMoves()){
				System.out.println("##--Incorrect Co-ordinates, Ship Can Not Move This Distance--##\n");
				setNewCoords(ship,oldX,oldY);
			}
			else{	
				ship.setMoved(true);
				ship.setX(x);
				ship.setY(y);
			}
		}	
	}
		catch(NumberFormatException e){
			System.err.println("Please Enter Valid Numbers !");
			setNewCoords(ship,oldX,oldY);
		}
	}
	/**
	 * Resets moved boolean on all ships
	 */
	private void resetMoved(){
		int x = 0;
		int y = 0;
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				if(positions[x][y] != null){
					positions[x][y].getShip().setMoved(false);
				}
				else{
				
				}
				y++;
			}
			x++;
			y=0;
		}
	}
	/**
	 * 
	 * @param ship- ship to attack
	 * @param x - x position of the ship
	 * @param y - y position of the ship
	 */
	private void battle(Ships ship,  int x, int y){
		if( x > 0 && positions[x-1][y] != null && positions[x-1][y].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x-1][y].getShip());
		}
		if(x < columns-1 && positions[x+1][y] != null && positions[x+1][y].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x+1][y].getShip());
		}
		if(y > 0 && positions[x][y-1] != null && positions[x][y-1].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x][y-1].getShip());
		}
		if(y < rows-1 && positions[x][y+1] != null && positions[x][y+1].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x][y+1].getShip());
		}
		if(x < columns-1 && y < rows-1 && positions[x+1][y+1] != null && positions[x+1][y+1].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x+1][y+1].getShip());
		}
		if(x < columns-1 && y > 0 && positions[x+1][y-1] != null && positions[x+1][y-1].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x+1][y-1].getShip());
		}
		if(x > 0 && y < rows-1 && positions[x-1][y+1] != null && positions[x-1][y+1].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x-1][y+1].getShip());
		}
		if(x > 0 && y > 0 && positions[x-1][y-1] != null && positions[x-1][y-1].getShip().getPlayer() != ship.getPlayer()){
			battleCalc2(ship, positions[x-1][y-1].getShip());
		}
	}
	
	/*public void battleCalc(Ships attack,Ships defend, Position position){
		try{
			for(ShipType s : attack.destroys()){
				if(s == defend.getType()){
					System.out.println("Attacking Ship "+ attack.getType()+ " Destroyed: "+ s);
					int x = 0;
					int y = 0;
					for(int i = 0; i < rows; i++){
						for (int j = 0; j < columns; j++) {
							if(positions[x][y]!= null && positions[x][y].getShip() == defend){
								System.out.println("Position: "+ y+" " + x+ "\n");
								positions[x][y] = null;
							}
							else{
								
							}
							y++;
						}
						x++;
						y=0;
					}
				}
			}
			for(ShipType d : defend.destroys()){
				if(d == attack.getType()){
					int x = 0;
					int y = 0;
					System.out.println("Defending Ship "+ defend.getType()+ " Destroyed: "+ d);
					for(int i = 0; i < rows; i++){
						for (int j = 0; j < columns; j++) {
							if(positions[x][y]!= null && positions[x][y].getShip().getType() == d){
								System.out.println("Position: "+ y+" " + x +"\n");
								positions[x][y] = null;
							}
							else{
								
							}
							y++;
						}
						x++;
						y=0;
					}
				}
			}
			battle(defend, defend.getY(), defend.getX());
		}
		catch(NullPointerException n){
			
		}
	}
	*/
	/**
	 * Calculates battle 
	 * @param attack - attacking ship
	 * @param defend - defending ship
	 */
	private void battleCalc2(Ships attack,Ships defend){
		int aPower = 0;
		int dPower = 0 ;
		for(ShipType a :shipMap.keySet()){
			if(a == attack.getType()){
				 aPower = shipMap.get(a);
			}
			if(a == defend.getType()){
				 dPower = shipMap.get(a);
			}
		}
		if(aPower == dPower){
			System.out.println("Attacking Ship "+ attack.getType()+ " Destroyed: "+ defend.getType());
			removeShip(attack);
			battle(defend, defend.getY(), defend.getX());
			removeShip(defend);
		}
		else if(aPower > dPower){
			System.out.println("Attacking Ship "+ attack.getType()+ " Destroyed: "+ defend.getType());
			battle(defend, defend.getY(), defend.getX());
			removeShip(defend);
		}
		else{
			System.out.println("Defending Ship "+ defend.getType()+ " Destroyed: "+ attack.getType());
			removeShip(attack);
		}
	}
}	
