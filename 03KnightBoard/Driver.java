public class Driver{
    public static void main(String[] args){
	KnightBoard b = new KnightBoard(5,5);
	//System.out.println(b.solve(0,0));
	//System.out.println(b.toString());
	System.out.println("it is " + b.countSolutions(0,0));
    }
}
