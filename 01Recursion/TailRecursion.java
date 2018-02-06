public class TailRecursion{
    public static boolean foo(int end, int target){
	//	System.out.println(target + " target");
	//	System.out.println(end +  " end");
	if (target - end  == 0){
	    // System.out.println("exit 3");
	    //  System.out.println();
	    return true;
	}
	if (end == 0){
	    //  System.out.println("exit 1");
	    //  System.out.println();
	    return false;
	}

	return (foo(end-1,target) || foo(end-1,target - end));
    }
    public static void main(String[] args){
	System.out.println(foo(3,1));
    }
}
