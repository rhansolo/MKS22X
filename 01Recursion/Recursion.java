public class Recursion{
    
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }
    public int fib(int n){
	return fibHelp(n,0,1);
    }
    
    private static int fibHelp(int n, int x, int y){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 0;
	}
	if (n == 1){
	    return y;
	}
	return fibHelp(n-1, y, x+y);
    }
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 0.;
	}
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
Recursion x = new Recursion(); //Making a recursion object

	//
	// Error testing
	//
	
	System.out.println("Error testing:");

	System.out.println("fact(n)");
	try{
	    try{
		x.fact(-10);
	    }
	    catch (IllegalArgumentException e){
		System.out.println("Cookies\n");
	    }

	    System.out.println("fib(n)");
	    try{
		x.fib(-10);
	    }
	    catch (IllegalArgumentException e){
		System.out.println("Cakes\n");
	    }
	
	    System.out.println("sqrt(n)");
	    try{
		x.sqrt(-10.0);
	    }
	    catch (IllegalArgumentException e){
		System.out.println("Ice Cream\n");
	    }
	    System.out.println("Well Done! \n");
	}
	catch (StackOverflowError stack){
	    System.out.println("Oh oh, gotta throw those exceptions\n");
	}

	//
	// fact(n)
	//
	    
	System.out.println("fact(n)");
	
	String expression = "1";
	
	for (int h = 0; h < 11; h++){

	    int factSol = x.fact(h);

	    if (h != 0){
		expression += " * " + h;
	    }
	    
	    System.out.println(h + "! " + factSol + " Expanded: " + expression);
 	}
	System.out.println();
	
	//
	// fib(n)
	//

	System.out.println("fib(n)");
	for (int i = 0; i < 11; i++){
	    int fibRecurs = x.fib(i);
	    double fibFormula =  getFibonacci(i);
	    
	    System.out.println("n: " + i + " fib(n): " + fibRecurs+ " Formula: " + fibFormula + " Correct? " + (fibRecurs == (int)fibFormula));
	}



	System.out.println();
	System.out.println("Runtime test for fib(n)");
	long startTimeA = System.currentTimeMillis();
	
	System.out.println(x.fib(10000)); // I got 2132534333
	
	runTime(startTimeA); //Should take 0.01 ms
	System.out.println("<= 1ms\n");

	//
	// sqrt(n)
	//

	System.out.println("sqrt(n)");
	for (int j = 0; j < 17; j++){
	    double sqrtRecurs = x.sqrt(j);
	    double sqrtMath =  Math.sqrt(j);
	    
	    System.out.println("n: " + j);
	    System.out.println("sqrt(n): " + sqrtRecurs);
	    System.out.println("Math.sqrt(n): " + sqrtMath);
	    System.out.println("Correct? " +
			       (sqrtRecurs >= sqrtMath * 0.999 && sqrtRecurs <= sqrtMath * 1.001)
			       );
	    System.out.println();       
	}
    }
     public static void runTime(long startTime){
	System.out.println("Runtime: " +
			   (System.currentTimeMillis() - startTime) + "ms or " +
			   (System.currentTimeMillis() - startTime)/1000.0 + "s"
			   );	
    }
    public static double getFibonacci(int n) {
	//n += 1; //Shifts function over by one THIS SHOULD NOT BE HERE fib(0) --> 0 fib(1) --> 1
	double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
	double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);

	return Math.floor((f1 - f2) / Math.sqrt(5));
    }
    
}
