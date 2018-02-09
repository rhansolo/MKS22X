public class QueenBoard{
    private int[][] board;
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
		    tmp += "_ ";
		}
	    }
	    tmp += "\n";

	}
	return tmp;
    }
    public boolean solve(){
	return true;
    }
    public int countSolutions(){
	return 0;
    }
    private boolean addQueen(int r, int c){
	return true;
    }
    private boolean removeQueen(int r, int c){
	return true;
    }
}
