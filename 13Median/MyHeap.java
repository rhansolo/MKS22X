import java.util.*;

public class MyHeap<T extends Comparable<T>>{

    private int size;
    
    private T[] arr;
    private boolean maxHeap;

    
    @SuppressWarnings("unchecked")
    public MyHeap(){
	maxHeap = true;
	arr = (T[]) new Comparable[16];
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean o){
	if(o){
	    maxHeap = true;
	}
	else{
	    maxHeap = false;
	}
	arr = (T[]) new Comparable[16];
    }
    
    public void add(T s){
	if(size == arr.length){
	    resize();
	}
	arr[size] = s;
	int currIndex = size;
	while( ((currIndex - 1) / 2 >= 0) && ((arr[currIndex].compareTo(arr[(currIndex - 1) / 2]) > 0 && maxHeap)||(arr[currIndex].compareTo(arr[(currIndex - 1) / 2]) < 0 && !maxHeap)) ){
	    T temp = arr[(currIndex - 1) / 2];
	    arr[currIndex] = temp;
	    arr[(currIndex - 1) / 2] = s;
	    currIndex = (currIndex - 1) / 2;
	}
	size++;
    }
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp = (T[]) new Comparable[arr.length * 2];
	for(int i = 0; i < size; i++){
	    temp[i] = arr[i];
	}
	arr = temp;
    }
    
    public T remove(){
	
	if (size == 0){
	    return null;
	}
	size --;
	T removed = peek();
	arr[0] = arr[size-1];
	push(0);
	return removed;
    }
    public void push(int index){
	int leftChild = 2*index + 1;
	int rightChild = 2*index + 2;
	
	if (leftChild >= size){
	    return;
	}
	if (rightChild >= size){
	    if (maxHeap && arr[index].compareTo(arr[leftChild]) < 0 || !maxHeap && arr[index].compareTo(arr[leftChild]) > 0){
		swap(index,leftChild);
		push(leftChild);
	    }
	}
	else if (!maxHeap && arr[index].compareTo(arr[leftChild]) > 0 || maxHeap && arr[index].compareTo(arr[leftChild]) < 0 ){

	    if (maxHeap && arr[leftChild].compareTo(arr[rightChild]) >= 0 || !maxHeap && arr[leftChild].compareTo(arr[rightChild]) <= 0){
		swap(index,leftChild);
		push(leftChild);
	    }
	    else {
		swap(index,rightChild);
		push(rightChild);
	    }
	}
	
	else if (!maxHeap && arr[index].compareTo(arr[rightChild]) > 0 || maxHeap && arr[index].compareTo(arr[rightChild]) < 0 ){
	    swap(index,rightChild);
	    push(rightChild);
	}
    }
    public T peek(){
	
	return arr[0];
    }
    
    public int size(){
	return size;
    }
    public void swap(int index1, int index2){
	T temp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = temp;
    }
    public String toString(){
	String ans = "[";
	ans += arr[0];
	for(int i = 1; i < size; i++){
	    ans += "," + arr[i] ;
	}
	ans += "]";
	return ans;
    }
}
