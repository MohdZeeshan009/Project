package othello_Game_Project;

public class OthelloBoard {

	private int board[][];
	private int boardSize=8;
	final static int p1Symbol=1;
	final static int p2Symbol=2;
	private static int[] xDir = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] yDir = {0, 1, 1, 1, 0, -1, -1, -1};
	private final static int SETZERO=0;

	public OthelloBoard() {
		board= new int [boardSize][boardSize];
//		for(int i=0; i<boardSize;i++) {
//			for(int j=0; j<boardSize; j++) {
//				board[i][j]=SETZERO;
//			}
//		}
		board[3][3]=p1Symbol;
		board[3][4]=p2Symbol;
		board[4][3]=p2Symbol;
		board[4][4]=p1Symbol;
	}


	public boolean move(int symbol, int x, int y) {
		if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] != 0) {
			return false;
		}
		boolean movePossible = false;
		for (int i = 0; i < xDir.length; i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];
			int currentX = x + xStep;
			int currentY = y + yStep;
			int count = 0; // count of opponent's pieces encountered
			while (currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8) {
				if (board[currentX][currentY] == 0) {
					break;
				} else if (board[currentX][currentY] != symbol) {
					currentX += xStep;
					currentY += yStep;
					count++;
				} else {
					if (count > 0) {
						movePossible = true;
						int convertX = currentX - xStep;
						int convertY = currentY - yStep;
						while (convertX != x || convertY != y) {
							board[convertX][convertY] = symbol;
							convertX = convertX - xStep;
							convertY = convertY - yStep;
						}
					}
					break;
				}
			}
		}
		if (movePossible) {
			board[x][y] = symbol;
		}
		return movePossible;
	}

	public void print() {
		for(int i=0; i<boardSize;i++) {
			for(int j=0; j<boardSize; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
