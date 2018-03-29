public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
    public MyLinkedList(){
	
    }
    public String toString(){
	return "";
    }
    private class Node{
	int data;
	Node nextNode;
	Node prevNode;
	public Node(int n){
	    data = n;
	    nextNode = null;
	    prevNode = null;
	}
	public Node getNext(){
	    return nextNode;
	}
	public Node getPrev(){
	    return prevNode;
	}
	public int getValue(){
	    return data;
	}
	public String toString(){
	    return "" + data;
	}
    }
}
