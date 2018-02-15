public class KnightBoard{
    int[] xmove = new int[]{1,2,2,1,-1,-2,-2,-1};
    int[] ymove = new int[]{2,1,-1,-2,-2,-1,1,2};
    int[][] board;
    public KnightBoard(int r, int c){
	board = new int[r][c];
    }
    public boolean solve(int startingRow, int startingCol){
	return solveH(startingRow,startingCol,1);
    }
    public int countSolutions(int startingRow, int startingCol){

    }
    private boolean solveH(int row, int col, int level){
	if (level == board.length*board[0].length){
	    return true;
	}
	for (int i = 0; i < 8; i++){
	    int tmpxCor = row + xmove[i];
	    int tmpyCor = col + ymove[i];
	    if (tmpxCor < board.length && tmpyCor < board[0].length && ymoveboard[row + xmove[i]][col+ymove[i]] == 0){
		solveH(tmpxCor,tmpyCor,level +=1);
	    }
	}
	
    }
}
