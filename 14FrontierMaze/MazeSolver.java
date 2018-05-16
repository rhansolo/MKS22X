public class MazeSolver{

    private Frontier frontier;
    private Maze maze;
 
    private boolean animate;
    public static void main(String[] args){
	
	MazeSolver i = new MazeSolver("data3.txt");

	i.switchAnimate(true);
	
	i.solve(0);
    }
    public MazeSolver(String input){
	maze = new Maze(input);
	animate = false;
    }
    public MazeSolver(String input, boolean animate){
	maze = new Maze(input);
        this.animate= animate;
    }

    public boolean solve(){
	return solve(3);
    }
    public void switchAnimate(boolean ani){
	animate = ani;
    }
    public boolean solve(int o){
	
	if(o == 0){
	    frontier = new QueueFrontier();

	}
	else if(o == 1){
	    
	    frontier = new StackFrontier();

	}
	else if (o == 2){
	    frontier = new PriorityQueueFrontier();
	}
	else{
	    maze.applyAStar();
	    
	}
	
	frontier.add(maze.getStart());

	
	Location end = maze.getEnd();

	while(frontier.hasNext()){

  
	    Location previous = frontier.next();
	    Location[] nextLocations = maze.getNeighbors(previous);
	    for(Location l: nextLocations){
		if(l != null){

		    char sym = maze.get(l.getX(), l.getY());
		    if(sym == 'E'){
			maze.set(previous.getX(), previous.getY(), '.');
			
			maze.end = new Location(l.getX(), l.getY(), previous,0);
			end = maze.getEnd();
			while(end.getPrev() != null &&( !end.getPrev().equals(maze.getStart()))){
			    end = end.getPrev();
			    
			    maze.set(end.getX(), end.getY(), '@');
	    			    
			}
			System.out.println(maze.toStringColor());

			return true;
		    }
		    if(sym == '?'){
			frontier.add(l);
		    }
		}
	    }
	    
	    System.out.println(maze.toStringColor());
	    if(maze.get(previous.getX(), previous.getY()) != 'S'){
		
		maze.set(previous.getX(), previous.getY(), '.');
	    }
	}
      
	return false;
    }
	
    
}
