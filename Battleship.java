/*
Create a simple game of Battleship using 2D arrays. The user should be able to position their ship in a 3x3 array, as should the computer.
Each ‘player’ should take turns choosing spots in the grid until someone hits the other ship.
Note: For simplicity, each player will only have 1 ship, that takes up 1 gid slot
Note: For simplicity, do not worry about repeated guesses
*/
public class Battleship{
	//vars
	private int[][] compBoard=new int[3][3]; //board size can be changed
	private int[][] userBoard;
	private int[] compShip=new int[2];
	private int[] userShip;
	private int[] compGuess=new int[2];
	private int[] userGuess;
	private String compGuessResult, userGuessResult, gameResult;
	//constructor
	public Battleship(){
		compShip[0]=((int)(Math.random()*compBoard.length)); //placing a ship on the computer board in random position
		compShip[1]=((int)(Math.random()*compBoard[0].length));
		compBoard[compShip[0]][compShip[1]]=1;
		compGuessResult="";
		userGuessResult="";
		gameResult="";
	}
	//set
	public void setUserShip(int[] userShip){
		this.userShip=userShip;
	}
	public void setUserGuess(int[] userGuess){
		this.userGuess=userGuess;
	}
	//compute
	public void computeCompGuess(){
		compGuess[0]=((int)(Math.random()*compBoard.length)); //random computer guess
		compGuess[1]=((int)(Math.random()*compBoard[0].length));
	}
	public void checkCompGuess(){
		if(compGuess[0]==userShip[0] && compGuess[1]==userShip[1]){
			compGuessResult="Ship hit";
		}
		else{
			compGuessResult="Computer misses";
		}
	}
	public void checkUserGuess(){
		if(userGuess[0]==compShip[0] && userGuess[1]==compShip[1]){
			userGuessResult="Ship hit";
		}
		else{
			userGuessResult="You miss";
		}
	}
	public void computeGameResult(){
		if(compGuessResult==userGuessResult){
			gameResult="Draw";
		}
		else if(compGuessResult=="Ship hit"){
			gameResult="Computer wins";
		}
		else if(compGuessResult=="Computer misses" && userGuessResult=="You miss"){
			gameResult="You both miss";
		}
		else if(userGuessResult=="Ship hit"){
			gameResult="You win";
		}
	}
	//get
	public int[] getCompGuess(){
		return compGuess;
	}
	public String getCompGuessResult(){
		return compGuessResult;
	}
	public String getUserGuessResult(){
		return userGuessResult;
	}
	public String getGameResult(){
		return gameResult;
	}
	public int[][] getCompBoard(){
		return compBoard;
	}
}