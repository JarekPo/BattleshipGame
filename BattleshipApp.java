import javax.swing.JOptionPane;
import java.util.Arrays;
public class BattleshipApp{
	public static void main(String[] args){
		//vars
		int[][] compBoard;
		int[][] userBoard=new int[3][3]; //board size can be changed
		int[] compShip;
		int[] userShip=new int[2];
		int[] compGuess;
		int[] userGuess=new int[2];
		String compGuessResult, userGuessResult, gameResult;
		//objects
		Battleship b;
		b=new Battleship();
		JOptionPane.showMessageDialog(null, "Boards size "+userBoard.length+" x "+userBoard[0].length);
		//input
		userShip[0]=(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your ship's first coordinate")))-1;
		userShip[1]=(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your ship's second coordinate")))-1;
		userBoard[userShip[0]][userShip[1]]=1;
		b.setUserShip(userShip);
		System.out.println("User's board: ");
		for(int i=0;i<userBoard.length;i++){
			System.out.println(Arrays.toString(userBoard[i]));
		}
		do{
			userGuess[0]=(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your shot's first coordinate")))-1;
			userGuess[1]=(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your shot's second coordinate")))-1;
			//set
			b.setUserGuess(userGuess);
			//compute
			b.computeCompGuess();
			b.checkCompGuess();
			b.checkUserGuess();
			b.computeGameResult();
			//get
			userGuessResult=b.getUserGuessResult();
			compGuessResult=b.getCompGuessResult();
			gameResult=b.getGameResult();
			compBoard=b.getCompBoard();
			compGuess=b.getCompGuess();
			//output
			JOptionPane.showMessageDialog(null, userGuessResult);
			System.out.println("Your shot coordinates: ["+(userGuess[0]+1)+", "+(userGuess[1]+1)+"], "+userGuessResult);
			JOptionPane.showMessageDialog(null, "Computers shot: ["+(compGuess[0]+1)+", "+(compGuess[1]+1)+"]");
			System.out.println("Computer's shot coordinates: ["+(compGuess[0]+1)+", "+(compGuess[1]+1)+"], "+compGuessResult);
			JOptionPane.showMessageDialog(null, compGuessResult);
			System.out.println(gameResult);
	}
		while((gameResult.equals("You win") || gameResult.equals("Computer wins") || gameResult.equals("Draw"))!=true);
		JOptionPane.showMessageDialog(null, gameResult);
		System.out.println("Computer's board: ");
		for(int i=0;i<compBoard.length;i++){
			System.out.println(Arrays.toString(compBoard[i]));
		}
	}
}