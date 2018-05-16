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
	return solve(0);
    }
    public void switchAnimate(boolean ani){
	animate = ani;
    }
    public boolean solve(int o){
	
	if(o == 0){
	    frontier = new QueueFrontier();

	}else if(o == 1){
	    
	    frontier = new StackFrontier();

	}else{
	    
	    frontier = new PriorityQueueFrontier();
	}
	
	Location[] neighborArr = maze.getNeighbors(maze.getStart());
	for(int i = 0; i < neighborArr.length; i ++){
	    if (neighborArr[i] != null){
		frontier.add(neighborArr[i]);
	    }
	}
	while(frontier.hasNext()){
	    
	    if(animate){
		System.out.println(maze.toStringColor(50));
	    }
	    
	    Location next = frontier.next();

	    maze.set(next.getX(), next.getY(), '.');
	    
	    Location[] neighborsList = maze.getNeighbors(next);
	    
	    for(int i = 0; i < neighborsList.length && neighborsList[i] != null; i ++){
		
		if( neighborsList[i].getY() == maze.getEnd().getY() && neighborsList[i].getX() == maze.getEnd().getX()){
		    Location currPos = neighborsList[i].getPrev();
		    
		    while( currPos.getY() != maze.getStart().getY()|| currPos.getX() != maze.getStart().getX() ){
			maze.set(currPos.getX(), currPos.getY(), '@');
			if(animate){
			    
			    System.out.println(maze.toStringColor(10));
			}

			
			currPos = currPos.getPrev();
		    }
		    return true;

		}
		
		frontier.add(neighborsList[i]);

		
		maze.set(neighborsList[i].getX(), neighborsList[i].getY(), '?');
	    }	    
	}
	return false;
    }
    
}
