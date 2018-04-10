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
	Node tmp = last;
	last = getNode(length - 1);
	last.setPrev(tmp);
	return true;
    }
    public void add(int index, Integer value){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0){
	    Node tmp = first;
	    first  = new Node(value);
	    first.setNext(tmp);
	    length++;
	}
	else if (index == length){
	    add(value);
	}
	else{
	    Node tmp = getNode(index);
	    getNode(index-1).setNext(new Node(value));
	    getNode(index).setNext(tmp);
	    Node curr = getNode(index);
	    tmp.setPrev(curr);
	    curr.setPrev(getNode(index - 1));
	    length++;
	}
    }
    public Integer remove(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
       
	else if (length == 1){
	    first = null;
	    last = null;
	    length = 0;
	}
	else if (index == 0){
	    first = getNode(1);
	    first.setPrev(null);
	}
	else if (index == length - 1){
	    last = getNode(length - 2);
	    last.setNext(null);
	}
	else{
	    getNode(index - 1).setNext(getNode(index+1));
	    getNode(index + 1).setPrev(getNode(index-1));
	}
	length --;
	return get(index);
    }
    public boolean remove(Integer value){
       
	int removeInd = indexOf(value);
	if (removeInd == -1){
	    return false;
	}
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
	public boolean setPrev(Node n){
	    prevNode = n;
	    return true;
	}

	
    }










    
    public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();
     
     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
	 a.add(new Integer(i));
	 System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList
     
     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
	 System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive
     
     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
	 System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     
     for (int i = 0; i < 10; i++){
	 a.add(new Integer(i));
     }
     
     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
	 System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive
     
     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
	 a.remove(new Integer(i));
	 System.out.println(a);
     } //removes first half of the LinkedList
     
     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
	 a.set(i, new Integer(i * 10));
	 System.out.println(a);
     } //sets the data of each node to 10 * index
     
     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
	 System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
	 System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     
     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
	 a.add(i, new Integer(i * 3));
	 System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());
     
     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
	 a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     
     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());
     
     System.out.println("\nTesting exceptions for remove(int index)");
     try{
	 System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
	 System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
	 System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     
     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
    }
}
