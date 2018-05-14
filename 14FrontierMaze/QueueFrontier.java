
import java.util.*;


public class QueueFrontier implements Frontier{
    
    private MyDeque<Location> pos;
    public QueueFrontier(){
	pos = new MyDeque<>();
    }
    
    public boolean hasNext(){
	try{
	    return pos.getFirst() != null;
	}catch(NoSuchElementException e){
	    return false;
	}
    }

    public Location next(){
	
	return pos.removeFirst();
    }
    public void add(Location next){
	pos.addLast(next);
    }
 
}
