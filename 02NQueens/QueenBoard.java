public class QueenBoard{
    private int[][] board;
    private int sol;
    public QueenBoard(int size){
	board = new int[size][size];
    }
    public String toString(){
	String tmp = "";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if (board[i][j] < 0){
		    tmp += "Q ";
		}
		else{
		    //tmp += "" + board[i][j] + " ";
		    tmp += "_ ";
		}
	    }
	    tmp += "\n";

	}
	return tmp;
    }
    public boolean solve(){
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
		if(board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelper(0);
    }
    public boolean solveHelper(int col){
	if (col >= board.length){
	    return true;
	}
	for (int row = 0; row < board.length; row++){
	    if ( addQueen(row,col)){
		if (solveHelper(col + 1)){
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }
    public int countSolutions(){
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
		if(board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	countSolutionsHelper(0);
	return sol;
    }
    public boolean countSolutionsHelper(int col){
	if (col >= board.length){
	    sol ++;
	    return true;
	}
	for (int row = 0; row < board.length; row++){
	    if (addQueen(row,col)){
		countSolutionsHelper(col + 1);
		removeQueen(row,col);
	    }
	} 
	return false;
    }
    public boolean addQueen(int r, int c){
	if (board[r][c] == 0){
	    changeBoard(r,c,1);
	    return true;
	}
	return false;
    }
    public  boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    changeBoard(r,c,-1);
	    return true;
	}
	return false;
    }
    private boolean changeBoard(int r, int c, int increment){
	for (int i = 0; i < board.length; i++){	    
	    board[i][c] += increment;
	    board[r][i] += increment;
	}
	int tmpr1,tmpr2,tmpr3,tmpr4;
	int tmpc1,tmpc2,tmpc3,tmpc4;
	tmpr1 = tmpr2 = tmpr3 = tmpr4 = r;
	tmpc1 = tmpc2 = tmpc3 = tmpc4 = c;
	for (int i = 0; i < board.length; i++){
	     if (tmpr1 + 1 < board.length  && tmpc1 + 1 < board.length){
		tmpr1 ++;
		tmpc1 ++;
		board[tmpr1][tmpc1] += increment;
	    }
	     if (tmpr2 + 1 < board.length  && tmpc2 - 1 > -1){
		tmpr2 ++;
		tmpc2 --;
		board[tmpr2][tmpc2] += increment;
	    }
	    if (tmpr3 - 1 > -1  && tmpc3 + 1 < board.length){
		tmpr3 --;
		tmpc3 ++;
		board[tmpr3][tmpc3] += increment;
	    }
	    if (tmpr4 -1 > -1 && tmpc4 -1 > -1){
		tmpr4 --;
		tmpc4 --;
		board[tmpr4][tmpc4] += increment;
	    }
	    
	}
	if (increment < 0){
	    board[r][c] = 0;
	}
	else{
	    board [r][c] = -1;
	}
	return true;
    }
}
