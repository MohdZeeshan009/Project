package project;
import java.util.*;

import project2.Board;

public class TicTacToe {

	private Player player1, player2;
	private Board board;
	private int numPlayers;

	public static void main(String[] args) {

		TicTacToe t= new TicTacToe();
		t.startGame();
	}

	public void startGame() {
		// taking input from players
		Scanner sc=new Scanner(System.in);
		player1=takeInput(++numPlayers);
		player2=takeInput(++numPlayers);

		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol is already taken ! please Enter the another symbol ");
			player2.setSymbol(sc.next().charAt(0));
		}
		// creating board
		board =new Board(player1.getSymbol(), player2.getSymbol());

		// starting game
		boolean player1turn=true;
		int status=Board.INCOMPLETE;
		while(status == Board.INCOMPLETE || status ==Board.INVALIDMOVE) {
			if(player1turn) {
				System.out.println("Player 1 - "+player1.getName()+"'s turn: ");
				System.out.println("Enter x:  ");
				int x=sc.nextInt();
				System.out.println("Enter y: ");
				int y=sc.nextInt();

				status=board.move(player1.getSymbol(), x, y);

				if(status==Board.INVALIDMOVE) {
					System.out.println("Invalid move !! Please try again !!");
					continue;
				}
			}
			else {
				System.out.println("Player 2 - "+player2.getName()+"'s turn: ");
				System.out.println("Enter x:  ");
				int x=sc.nextInt();
				System.out.println("Enter y: ");
				int y=sc.nextInt();

				status=board.move(player2.getSymbol(), x, y);

				if(status == Board.INVALIDMOVE) {
					System.out.println("Invalid move !! Please try again !! ");
					continue;
				}
			}
			player1turn=!player1turn;
			board.print();
		}
		if(status == Board.PLAYER1WINS){
			System.out.println("Player 1 - " + player1.getName() +"wins !!");
		}
		else if(status == Board.PLAYER2WINS){
			System.out.println("Player 2 - " + player2.getName() +"wins !!");
		}
		else {
			System.out.println("Draw !!");
		}
	}


	private Player takeInput(int num) {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the name of the"+ num + "Name: ");
		String name=sc.next();
		System.out.println("Enter your symbol: ");
		char symbol=sc.next().charAt(0);
		Player p=new Player(name, symbol);
		return p;

	}

}
