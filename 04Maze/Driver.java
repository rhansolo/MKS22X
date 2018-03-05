public class Driver{
    public static void main(String[] args){
	Maze maze = new Maze("input.txt");
	maze.setAnimate(true);
	System.out.println(maze);
	maze.solve();
    }
}
