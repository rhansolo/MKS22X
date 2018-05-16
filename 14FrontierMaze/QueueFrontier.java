
import java.util.*;


public class QueueFrontier implements Frontier{
    
    private LinkedList<Location> pos;
    
    public QueueFrontier(){
	pos = new LinkedList<>();
    }
    
    public boolean hasNext(){
	try{
	    return pos.getFirst() != null;
	}
	catch(NoSuchElementException e){
	    return false;
	}
    }

    public Location next(){
	
	return pos.remove();
    }
    public void add(Location next){
	pos.add(next);
    }
 
}
