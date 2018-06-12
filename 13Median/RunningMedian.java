import java.util.*;
public class RunningMedian{
    private MyHeap<Double> max;
    private MyHeap<Double> min;
    private double med;
    private int size;
 
    
    public RunningMedian(){
	max = new MyHeap<Double>(true);
	min = new MyHeap<Double>(false);
    }
    public RunningMedian(double[] arr){
	min = new MyHeap<Double>(false);
	max = new MyHeap<Double>(true);
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

    public void add(Double value){
	if ( value.compareTo(getMedian()) > 0 || size == 0){
	    min.add(value);
	}
	else {
	    max.add(value);
	}
	if (Math.abs(max.size()-min.size()) > 1){
	    if (max.size() > min.size()){
		min.add(max.remove());
	    }
	    else if (min.size() > max.size()) {
		max.add(min.remove());
	    }
	}
	size++;
    }
    public int size(){
	return size;
    }
    public static void main(String[] args){
    double[] data = {1.0,5.0,3.0,4.0,2.0};
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
