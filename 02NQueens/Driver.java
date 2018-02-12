public class Driver{
    public static void main(String[] args){
	QueenBoard b = new QueenBoard(6);
	b.addQueen(2,4);
	b.addQueen(1,1);
	b.removeQueen(2,4);
	System.out.println(b);
    }
}
