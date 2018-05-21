import java.util.*;
public class RunningMedian{
    private MyHeap<Double> max;
    private MyHeap<Double> min;
    private double med;
 
    
    public RunningMedian(){
	max = new MyHeap<Double>(false);
	min = new MyHeap<Double>();
    }
    public RunningMedian(double[] arr){
	min = new MyHeap<Double>();
	max = new MyHeap<Double>(false);
	for (int i = 0; i < arr.length; i++){
	    add(arr[i]);
	}
    }
    public Double getMedian(){
	
	if(max.size() == 0 && min.size() == 0){
	    
	    throw new NoSuchElementException();
	}
	if((min.size() - max.size()) == 1){

	    med = min.peek();
	}
	else if((max.size() - min.size()) == 1){
	    med = max.peek();
	}

	else{
	    med = (max.peek() + min.peek()) / 2;
	}

	return med;
    }

    public void add(Double val){
	if(min.size() == 0 && max.size() == 0){
	    min.add(val);
	}
	else{
	    if(val < min.peek()){
		min.add(val);
		if(min.size() - max.size() == 2){
		    max.add(min.remove());
		}
	    }
	    else{
		max.add(val);
		if(max.size() - min.size() == 2){
		    min.add(max.remove());
		}
	    }
	}
    }
    public int size(){
	return max.size() + min.size();
    }
    public static void main(String[] args){
    double[] data = {1.0,3.0,5.0,4.0,2.0};
    RunningMedian a = new RunningMedian(data);
    System.out.println(a.getMedian()); //3
 System.out.println(a.min);
    System.out.println(a.max);
    a.add(6.0);
    System.out.println(a.getMedian()); //3.5
    a.add(1.0);
    a.add(1.0);
    System.out.println(a.getMedian());//2.5
  }
}
