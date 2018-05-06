import java.util.*;
public class RunningMedian{
    private Double med;
    private MyHeap<Double> max;
    private MyHeap<Double> min;
    
 
    
    public RunningMedian(){
	max = new MyHeap<Double>();
	min = new MyHeap<Double>(false);
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

	if(max.size() == 0 && min.size() == 0){
	    max.add(val);
 
	    med = val;
	 
	}
	else{
	    if(val > med){
		min.add(val);
	    }
	    else{
		max.add(val);
	    }
	    
	    
	    if((max.size() - min.size()) >1){
		min.add(max.remove());
	    }
	    else if((min.size() - max.size()) > 1){
		max.add(min.remove());
	    }
	}
    }
    public int size(){
	return max.size() + min.size();
    }
    
}
