public class MyLinkedList{
  private Node first, last;
  private int size;


  public MyLinkedList(){
  }
    
    // gets Node from by index
    private Node getNode(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	
	Node ans = first;
	for (int i = 0; i < index; i++){
	    ans = ans.getNext();
	}
	return ans;
    }

    
    // gets Integer value by index
    public Integer get(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
    }
    return getNode(index).getData();
    }

    //changes Integer value for an already created object
    public Integer set(int index, Integer v){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Integer tmp = getNode(index).getData();
	getNode(index).setData(v);
	return tmp;
  }
    //gets the index of the Oject with the same Integer value, returns -1 if not found
    public int indexOf(Integer v){
	for (int i = 0; i < size; i++){
	    if(getNode(i).getData().equals(v)){
		return i;
	    }
	}
	return -1;
    }
    //adds Integer object to the end of the linked list;
    public boolean add(Integer newData){
	Node a = new Node(newData);
	if (size == 0){
	    first = a;
	    last = a;
	    size++;
	    return true;
	}
	last.setNext(a);
	size++;
	Node tmp = last;
	last = a;
	last.setPrev(tmp);
	return true;
    }
    // adds Integer Object in a given position
    public void add(int index, Integer v){
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node n = new Node(v);
	if(index == size){
	    add(v);
	}
	
	else if(index == 0){
	    Node tmp = first;
	    first = n;
	    first.setNext(tmp);
	    size++;
	}
	
	else{
	    
	    Node tmp = getNode(index);
	    getNode(index - 1).setNext(n);
	    
	    Node vCurr = getNode(index);
	    vCurr.setNext(tmp);
	    tmp.setPrev(vCurr);
	    vCurr.setPrev(getNode(index - 1));
	    
	    size++;
	}
    }
    
    public boolean remove(Integer v){
	int index = indexOf(v);
	
	if(index != -1){
	
	    remove(index);
      return true;
	}
	return false;
    }
    //Removes object from linked list given its index
    public Integer remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Integer tmp = get(index);
	
	if(size == 1){
	    first = null;
	    
	    last = null;
	}
	
	else if(index == size - 1){
	    last = getNode(size - 2);
	    
	    last.setNext(null);
	    
	}
	else if(index == 0){
	    first = getNode(1);
	    first.setPrev(null);
	}
	
	else{
	    Node tmpPrev = getNode(index - 1);
	
	    Node tmpNext = getNode(index + 1);
	    
	    tmpPrev.setNext(tmpNext);
	    tmpNext.setPrev(tmpPrev);
	}
	size--;
    
	return tmp;
    }
    
    // clears entire list
    public void clear(){
	first = null;
	last = null;
	size = 0;
    }
    //returns list size
    public int size(){
	return size;
    }
    //format printing for the list
    public String toString(){
	String ans = "{ ";
	Node currNode  = first;
    for (int i = 0; i < size; i++){
	ans += currNode.toString() + " ";
	currNode  = currNode.getNext();
    }
    return ans + "}";
    }


    
    // PRIVATE NODE CLASS!!!
    private class Node{
	private Integer data;
	private Node next;
	private Node prev;
	
	public Node(Integer n){
	    data = n;
	}
	
	public Integer getData(){
	    return data;
	}
	public boolean setData(Integer n){
	    data = n;
	    return true;
	}

	public boolean setNext(Node n){
	    next = n;
	    return true;
	}
	
	public boolean setPrev(Node n){
	    prev = n;
	    return true;
	}
	
	public Node getNext(){
	    return next;
	}
	
	public Node getPrev(){
	    return prev;
	    
	}
	
	public String toString(){
	    return "[" + data + "]";
	}
	
   }
}
