import java.util.*;
import java.util.Iterator;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node first, last;
    private int size;
    
    
    public MyLinkedListImproved(){
    }
    //end and start
    private Node getEnd(){
	return last;
    }
    private Node getStart(){
	return first;
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
    public T get(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getData();
    }

    //changes Integer value for an already created object
    public T set(int index, T v){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	T tmp = getNode(index).getData();
	getNode(index).setData(v);
	return tmp;
  }
    //gets the index of the Oject with the same Integer value, returns -1 if not found
    public int indexOf(T v){
	for (int i = 0; i < size; i++){
	    if(getNode(i).getData().equals(v)){
		return i;
	    }
	}
	return -1;
    }
    //adds Integer object to the end of the linked list;
    public boolean add(T newData){
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
    public void add(int index, T v){
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
    
    public boolean remove(T v){
	int index = indexOf(v);
	
	if(index != -1){
	
	    remove(index);
      return true;
	}
	return false;
    }
    //Removes object from linked list given its index
    public T remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	T tmp = get(index);
	
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

    
    //Get Max Index
    public int max(){
	if(size == 0){
	    return -1;
	}
	int ind = 0;
	T max = first.getData();
	Node currNode = first;
	for(int i = 0; i < size; i++){
	    if(max.compareTo(currNode.getData()) < 0){
		max = currNode.getData();
		ind = i;
	    }
	    currNode = currNode.getNext();
	}
	return ind;
    }

    
    //Get Min Index
    public int min(){
	if(size == 0){
	    return -1;
	}
	int ind = 0;
	T max = first.getData();
	Node currNode = first;
	for(int i = 0; i < size; i++){
	    if(max.compareTo(currNode.getData()) > 0){
		max = currNode.getData();
		ind = i;
	    }
	    currNode = currNode.getNext();
	}
	return ind;
    }
    
    public void extend(MyLinkedListImproved<T> otherList){
	if(otherList.getStart() != null){
	    if(first != null){
		last.setNext(otherList.getStart());
		otherList.getStart().setPrev(last);
		last = otherList.getEnd();
		size += otherList.size();
		
	    }
	    
	    else{
		first = otherList.getStart();
		last = otherList.getEnd();
		
		size = otherList.size();

	    }
	    otherList.clear();
	}
    }

    public Iterator<T> iterator(){
	return new LinkedListIterator(this.first);
    }
    
    private class LinkedListIterator implements Iterator<T>{
	
	private Node curr;
	
	public LinkedListIterator(Node curr){
	    this.curr = curr;
	}

	public boolean hasNext(){
	    return curr != null;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

	public T next(){
	    T ans;
	    if (!hasNext()){
		System.exit(0);
	    }
	    ans = curr.getData();
	    curr = curr.getNext();
	    return ans;
	}
    }



    // PRIVATE NODE CLASS!!!
    private class Node{
	private T data;
	private Node next;
	private Node prev;
	
	public Node(T n){
	    data = n;
	}
	
	public T getData(){
	    return data;
	}
	public boolean setData(T n){
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
