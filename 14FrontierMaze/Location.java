public class Location implements Comparable<Location>{
    private double dist;
    private Location prev;
    private int x,y;

    public Location(int x, int y, Location prev, double dist){
	this.x = x;
	this.y = y;
	this.dist = dist;
	this.prev = prev;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public double getDist(){
	return dist;
       
    }
    public Location getPrev(){
	return prev;
    }
    public int compareTo(Location l){
	if(this.dist - l.getDist() > 0){
	    return 1;
	    
	}
	else if (this.dist-l.getDist()< 0){
	    return -1;
	}
	else {
	    return 0;
	}
    }
}
