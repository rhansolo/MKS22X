import java.util.*;

public class StackFrontier implements Frontier{
    
    private Stack<Location> pos;
    
    public StackFrontier(){
        pos = new Stack<>();
    }
    public boolean hasNext(){
	return pos.size() != 0;
    }
 
    
    public Location next(){

	return pos.pop();
    }
    public void add(Location next){

	pos.push(next);
    }

}
