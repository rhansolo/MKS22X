import java.util.LinkedList;

public class Calculator{
    public static double eval(String exp){
        Stack stak = new Stack();

	for (int i = 0; i < exp.length(); i++){
	    String curr= "";

	    int j = i;
	    while (j < exp.length() && exp.charAt(j) != ' '){
		if (".1234567890".indexOf(exp.charAt(j))>= 0){
		    curr += exp.charAt(j);
		}
		else{
		    curr ="" +  exp.charAt(j);

		}
		j++;
		
	    }
	    i = j;
	
	 
	    // System.out.println("curr is " + curr);
	    if (!curr.equals(" ")){
		if (curr.equals("+")){
		    double val1 = stak.pop();
		    double val2 = stak.pop();
		    stak.push(val1+val2);
		}
		else if (curr.equals("-")){
		    double val1 = stak.pop();
		    double val2 = stak.pop();
		    stak.push(val2-val1);
		}
		else if (curr.equals("/")){
		    double val1 = stak.pop();
		    double val2 = stak.pop();
		    stak.push(val2/val1);
		}
		else if (curr.equals("*")){
		    double val1 = stak.pop();
		    double val2 = stak.pop();
		    
		    stak.push(val1*val2);
		}
		else if (curr.equals("%")){
		    double val1 = stak.pop();
		    double val2 = stak.pop();

		    stak.push(val2 % val1);
		}
		else{
		    //System.out.println("stored " + curr);
		    stak.push(Double.parseDouble(curr));
		}
	    }
	}
	return stak.peek();
    }
    public static void main(String[] args) 
    {
	System.out.println(eval("61 7 +"));
	System.out.println(eval("11 3 - 4 + 25 *"));
	System.out.println(eval("5 3 + 8 2 - *"));
    }

}
