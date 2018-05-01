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
	T ans = arr[0];
	arr[0] = arr[size - 1];
	arr[size] = null;
	int currIndex = 0;
	while(
	    ((2 * currIndex + 1 < size) && ((arr[currIndex].compareTo(arr[2 * currIndex + 1]) > 0 && !maxHeap)||
	    ((2 * currIndex + 2 < size) && arr[currIndex].compareTo(arr[2 * currIndex + 2]) > 0) && !maxHeap))||
	    ((2 * currIndex + 1 < size) && ((arr[currIndex].compareTo(arr[2 * currIndex + 1]) < 0 && maxHeap) ||
	    ((2 * currIndex + 2 < size) && arr[currIndex].compareTo(arr[2 * currIndex + 2]) < 0) && maxHeap)) ) {
	    
            if(
	       2 * currIndex + 2 == size &&
	      (maxHeap && (arr[currIndex].compareTo(arr[2 * currIndex + 1]) < 0)||
	      (!maxHeap && (arr[currIndex].compareTo(arr[2 * currIndex + 1]) > 0 )))){
		
		T temp = arr[2 * currIndex + 1];
		arr[2 * currIndex + 1] = arr[currIndex];
		arr[currIndex] = temp;
		currIndex = 2 * currIndex + 1;
            }
	    else if( (arr[currIndex].compareTo(arr[2 * currIndex + 2]) > 0  && !maxHeap) || (maxHeap  && arr[currIndex].compareTo(arr[2 * currIndex + 2]) < 0 )) { 
		T temp = arr[2 * currIndex + 2];
		arr[2 * currIndex + 2] = arr[currIndex];
		arr[currIndex] = temp;
		currIndex = 2 * currIndex + 2;
            }
            else if((2 * currIndex + 2 < size) &&
		    (arr[2 * currIndex + 1].compareTo(arr[2 * currIndex + 2]) >= 0 && maxHeap && (arr[currIndex].compareTo(arr[2 * currIndex + 1]) < 0)) ||
		    (arr[2 * currIndex + 1].compareTo(arr[2 * currIndex + 2]) <= 0 && !maxHeap && (arr[currIndex].compareTo(arr[2 * currIndex + 1]) > 0 )) )  {
		T temp = arr[2 * currIndex + 1];
		
		arr[2 * currIndex + 1] = arr[currIndex];

		arr[currIndex] = temp;
		currIndex = 2 * currIndex + 1;
            }
    
  
	}
	
	size--;
	return ans;
    }
    
    public T peek(){
	
	return arr[0];
    }
    
    public int size(){
	return size;
    }
    
    public String toString(){
	String ans = "{";
	for(int i = 0; i < size; i++){
	    ans += arr[i] + ", ";
	}
	ans += "}";
	return ans;
    }
}
