public class Location implements Comparable<Location>{
    private double dist;
    private Location prev;
    private double distAlready;
    private int x,y;

    public Location(int x, int y, Location prev, double dist){
	this.x = x;
	this.y = y;
	this.dist = dist;
	this.prev = prev;
    }
    public Location( int x, int y, Location prev, double dist, double distAlready){
	this.x = x;
	this.y = y;
	this.dist = dist;
	this.prev = prev;
	
	this.distAlready = distAlready;
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
    public double getDistTraveled(){
	return distAlready;
    }
    public Location getPrev(){
	return prev;
    }
    public int compareTo(Location l){
	double curr = getDist() + getDistTraveled();
	double other = l.getDist() + getDistTraveled();
	
	if(curr - other > 0){
	    return 1;
	    
	}
	else if (curr-other< 0){
	    return -1;
	}
	else {
	    return 0;
	}
    }
}
