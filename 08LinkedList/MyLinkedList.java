public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
    public MyLinkedList(){
	length = 0;
	first = null;
	last = null;
    }
    private Node getNode(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Node curr = first;
	for (int i = 1; i < index; i++){
	    curr = curr.getNext();
	}
	return curr;
    }
    public String toString(){
	String tmp = "{ ";
	for (int i = 0; i < length; i++){
	    tmp += getNode(i).toString() + " ";
	}
	return tmp + "}";
    }
    public int size(){
	return length;
    }
    public Integer get(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Integer ans = getNode(index).getValue();
	return ans;
    }
    public Integer set(int index, Integer value){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Integer ans = getNode(index).getValue();
	getNode(index).setValue(value);
	return ans;
    }
    public int indexOf(Integer value){
	for (int i = 0; i < length; i++){
	    if(getNode(i).getValue().equals(value)){
		return i;
	    }
	}
	return -1;
    }
    public boolean add(Integer newData){	
	if (length == 0){
	    first  = new Node(newData);
	    
	    last = first;
	    length++;
	    return true;
	}
        
	getNode(length-1).setNext(new Node(newData));
	length ++;
	return true;
    }
    public void add(int index, Integer value){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0){
	    Node tmp = first;
	    first  = new Node(value);
	    first .setNext(tmp);
	    length++;
	}
	else if (index == length){
	    add(value);
	}
	else{
	    Node tmp = getNode(index);
	    getNode(index-1).setNext(new Node(value));
	    getNode(index).setNext(tmp);
	    length++;
	}
    }
    public boolean remove(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	else if (index == 0){
	    first = null;
	    last = null;
	    length = 0;
	}
	else if (index == length - 1){
	    last = getNode(length - 2);
	    last.setNext(null);
	}
	else{
	    getNode(index - 1).setNext(getNode(index+1));
	}
	length --;
	return true;
    }
    public boolean remove(Integer value){
	int removeInd = indexOf(value);
	remove(removeInd);
	return true;
    }
    
    public void clear(){
	length = 0;
	first = null;
	last = null;
    }
    private class Node{
	Integer data;
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
	public Integer  getValue(){
	    return data;
	}
	public boolean setValue(Integer i){
	    data = i;
	    return true;
	}
	 
	public String toString(){
	    return "" + data;
	}
	public boolean setNext(Node n){
	    nextNode = n;
	    return true;
	}

	
    }
}
