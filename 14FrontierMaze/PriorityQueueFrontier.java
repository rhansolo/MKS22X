public class PriorityQueueFrontier implements Frontier{

    private MyHeap<Location> priorQueue;

    public PriorityQueueFrontier(){
	priorQueue = new MyHeap<>(false);
    }

    public void add(Location l){
	priorQueue.add(l);
    }

    public Location next(){
	return priorQueue.remove();
    }

    public boolean hasNext(){
	return priorQueue.size() > 0;
    }
}
