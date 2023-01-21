package othello_Game_Project;

import java.util.Scanner;

public class Othello {

	private final static int p1Symbol=1;
	private final static int p2Symbol=2;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		OthelloBoard o=new OthelloBoard();
		int n=sc.nextInt();
		boolean player1turn=true;
		while(n>0) {
			System.out.println("Enter x: ");
			int x=sc.nextInt();
			System.out.println("Enter y: ");
			int y=sc.nextInt();
			boolean ans=false;
			if(player1turn) {
				ans=o.move(p1Symbol, x, y);
			}
			else {
				ans=o.move(p2Symbol, x, y);
			}
			if(ans) {
				o.print();
				player1turn=!player1turn;
				n--;
			}
			else {
				System.out.println(ans);
			}

		}
	}

}
