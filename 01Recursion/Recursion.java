public class Recursion{
    
    public static int fact(int n){
	if (n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }
    public static int fib(int n){
	return fibHelp(n,0,1);
    }
    
    private static int fibHelp(int n, int x, int y){
	if (n == 0){
	    return 0;
	}
	if (n == 1){
	    return y;
	}
	return fibHelp(n-1, y, x+y);
    }
    public static double sqrt(double n){
	return sqrtHelp(1.0,n);
    }
    private static double sqrtHelp(double guess, double n){
	guess = (n/guess + guess)/2;
	double squared = guess * guess;
	if (Math.abs(guess*guess - n)< 0.00001){
	    return guess; 
      	}
	return sqrtHelp(guess,n);
    }
    public static void main(String[] args){
	//	System.out.println(fact(3));
	//	System.out.println(fact(4));
	//	System.out.println(fact(6));
	//	System.out.println(fib(10));
	System.out.println(sqrt(2));
    }
}
