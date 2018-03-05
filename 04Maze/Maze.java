import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    private int count = 0;
    private int startx, starty;
    /*Constructor loads a maze text file, and sets animate to false by default.
      
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      
      'S' - the location of the start(exactly 1 per file)
      
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.
      
    */
    
    public Maze(String filename){
	animate = false;
	try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    Scanner inf2 = new Scanner(text);
	    int row = 0;
	    int col = 0;
	    while (inf.hasNextLine()){
		String line = inf.nextLine();
		row ++;
		col = line.length();
		maze = new char[row][col];
	    }
	    for(int k = 0; k < row; k++){
		String line = inf2.nextLine();
		for (int i = 0; i < col; i++){
		    maze[k][i] = line.charAt(i);
		}
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("wyd... ur so uglyyyyyyyyyyy");
	}

    }

    public String toString(){
	String tmpString = "";
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length; j++){
		tmpString += (maze[i][j]);
	    }
	    tmpString += "\n";
	}
	return tmpString;
    }
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
    }
    
    
    public void setAnimate(boolean b){
	
        animate = b;
	
    }
    
    
    public void clearTerminal(){
	
        //erase terminal, go to top left of screen.
	
        System.out.println("\033[2J\033[1;1H");
	
    }
    
    

    /*Wrapper Solve Function returns the helper function
      
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
      
    */
    public int solve(){
	
	//find the location of the S. 
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length;j++){
		if (maze[i][j] == 'S'){
		    startx = i;
		    starty = j;
		    return solve(i,j);
		}
	    }
	}
	
	//erase the S
	
	
	//and start solving at the location of the s.
	
	//return solve(???,???);
	return 0;
    }
    
    /*
      Recursive Solve function:
      
      A solved maze has a path marked with '@' from S to E.
      
      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.
      
      
      Postcondition:
      
      The S is replaced with '@' but the 'E' is not.
      
      All visited spots that were not part of the solution are changed to '.'
      
      Note: This is not required based on the algorithm, it is just nice visually to see.
      All visited spots that are part of the solution are changed to '@'
    */
	
    private int solve(int row, int col){
	//you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){
	    
            clearTerminal();
            System.out.println(this);
	    
            wait(20);
        }
	
        //COMPLETE SOLVE

	if (maze[row][col] == 'E'){
	    maze[row][col] = '@';
	    System.out.println(count);
	    return 1;
	}
	else if (maze[row+1][col] != '#'&& maze[row+1][col] != '@'&& maze[row+1][col] != '.'){
	    
	    maze[row][col] = '@';
	    if (count == 0 ){
		maze[row][col] = 'S';
	    }
	    count++;
	    
	    solve(row+1,col);
	}
        else if (maze[row][col+1] != '#' && maze[row][col+1] != '@'&& maze[row][col+1] != '.'){
	    
	    maze[row][col] = '@';
	    if (count == 0){
		maze[row][col] = 'S';
	    }
	    count++;
	    solve(row,col+1);
	}
        else if (maze[row-1][col] != '#'&& maze[row-1][col] != '@'&& maze[row-1][col] != '.'){
	    
	    maze[row][col] = '@';
	    if (count == 0){
		maze[row][col] = 'S';
	    }
	    count++;
	    solve(row-1,col);
	}
        else if (maze[row][col-1] != '#'&& maze[row][col-1] != '@'&& maze[row][col-1] != '.'){
	    
	    maze[row][col] = '@';
	    if (count == 0){
		maze[row][col] = 'S';
	    }
	    count++;
	    solve(row,col-1);
	}
	
	//maze[row][col] = '.';

	else if (maze[row+1][col] == '@'){
	    maze[row][col] = '.';
	    count--;
	    solve(row+1,col);
	}
        else if (maze[row][col+1] == '@'){
	    maze[row][col] = '.';
	    count--;
	    solve(row,col+1);
	}
        else if (maze[row-1][col] == '@'){
	    maze[row][col] = '.';
	    count--;
	    solve(row-1,col);
	}
	else if (maze[row][col-1] == '@'){
	    maze[row][col] = '.';
	    count--;
	    solve(row,col-1);
	}

        return -1; //so it compiles
    }
    
    
}


