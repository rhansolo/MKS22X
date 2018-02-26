public class KnightBoard{
    int[] xmove = new int[]{1,2,2,1,-1,-2,-2,-1};
    int[] ymove = new int[]{2,1,-1,-2,-2,-1,1,2};
    int[][] board;
    int [][] board2;
    public KnightBoard(int r, int c){
	if (r < 0 || c < 0){
	    throw new IllegalArgumentException("Invalid board size");
	}
	board = new int[r][c];
	board2 = new int[r][c];
	setBoard();
    }

    public String toString(){
	String tmp = "";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if (board[i][j] == 0){
		    tmp +=" _ ";
		}
		else{
		    if (board[i][j]/10 == 0){
			tmp +=" "+board[i][j]+" ";
		    }
		    else{
			tmp +=""+board[i][j]+" ";
		    }
		}
	    }
	    tmp+="\n";
	}
	return tmp;
    }
    public int countSolutions(int startingRow, int startingCol){
	if (startingRow>=board.length || startingCol>=board[0].length ||startingRow<0 || startingCol<0){
	   throw new IllegalArgumentException("negative parameters");
	}
	return countSolutionsH(startingRow,startingCol,0,1);
    }
    private int countSolutionsH(int row, int col, int total, int level){
	if (row>=board.length || col>=board[0].length ||row<0 || col<0){
	    return 0;
	}
	if (board[row][col]>0){
	    return 0;
	}

 	board[row][col] = level;
	if (level == board[0].length * board.length){
	    board[row][col] = 0;
	    return 1;
	}
	for (int i = 0; i < 8; i++){
	    int tmpxCor = row + xmove[i];
	    int tmpyCor = col + ymove[i];
	    
	    total += (countSolutionsH(tmpxCor,tmpyCor,0,level+1));
	
	}
	board[row][col] = 0;
	return total;
    }
    public boolean solveFast(int startingRow, int startingCol){
	if (startingRow>=board.length || startingCol>=board[0].length ||startingRow<0 || startingCol<0){
	   throw new IllegalArgumentException("negative parameters");
	}
	return solvefastH(startingRow,startingCol,1);
    }
    private boolean solvefastH(int row, int col, int level){
	if (level == board.length*board[0].length){
	    board[row][col] = level;
	    return true;
	}
	int min = 100000;
	for (int i = 0; i < 8; i++){
	    int tmpxCor = row + xmove[i];
	    int tmpyCor = col + ymove[i];
	    if (tmpxCor >= 0 && tmpyCor >= 0 && tmpxCor < board.length && tmpyCor < board[0].length && board[tmpxCor][tmpyCor] == 0){
		board2[tmpxCor][tmpyCor]--;
		//solveH(tmpxCor,tmpyCor,level + 1);  
		if (board[tmpxCor][tmpyCor]==0 &&board2[tmpxCor][tmpyCor]< min ){
		    min = board2[tmpxCor][tmpyCor];
		}
	    }
	}
	for (int i = 0; i < 8; i++){
	    int tmpxCor = row + xmove[i];
	    int tmpyCor = col + ymove[i];
	   if (tmpxCor >= 0 && tmpyCor >= 0 && tmpxCor < board.length && tmpyCor < board[0].length && board[tmpxCor][tmpyCor] == 0){
	       if (board2[tmpxCor][tmpyCor] == min){
		    board[row][col] = level;
		    if (solvefastH(tmpxCor,tmpyCor, level + 1)){
			return true;
		    }
		    
		    board2[tmpxCor][tmpyCor] = min;
		    board[row][col] = 0;
		}
	   }
	   
	}
	return false;
    }
    public boolean solve(int startingRow, int startingCol){
	if (startingRow>=board.length || startingCol>=board[0].length ||startingRow<0 || startingCol<0){
	   throw new IllegalArgumentException("negative parameters");
	}
	return solveH(startingRow,startingCol,1);
    }
    private boolean solveH(int row, int col, int level){
	if (level == board.length*board[0].length){
	    board[row][col] = level;
	    return true;
	}
	for (int i = 0; i < 8; i++){
	    int tmpxCor = row + xmove[i];
	    int tmpyCor = col + ymove[i];
	    if (tmpxCor >= 0 && tmpyCor >= 0 && tmpxCor < board.length && tmpyCor < board[0].length && board[tmpxCor][tmpyCor] == 0){
		board[row][col] = level;
		//solveH(tmpxCor,tmpyCor,level + 1);  
		if (solveH(tmpxCor,tmpyCor,level+1)){
		    return true;
		}
		board[row][col] = 0;
	    }
	}
	return false;
    }
    private void setBoard(){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		int placesToMove = 0;
		for (int k = 0; k < 8; k++){
		    int tmpxCor = i + xmove[k];
		    int tmpyCor = j + ymove[k];
		    if (tmpxCor >= 0 && tmpyCor >= 0 && tmpxCor < board.length && tmpyCor < board[0].length && board[tmpxCor][tmpyCor] == 0){
			placesToMove ++;
		    }
		}
		board2[i][j] = placesToMove;
	    }
	    
	}
	
    }
}
