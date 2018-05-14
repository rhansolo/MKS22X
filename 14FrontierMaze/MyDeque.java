import java.util.*;

public class MyDeque<E>{
    private E[] arr;
    private int start,end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	arr = (E[])new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initCapacity){
	if (initCapacity < 0){
	    throw new IllegalArgumentException();
	}
	arr = (E[]) new Object[initCapacity];
    }
    public int size(){
	return size;
    }

    public void addFirst(E e){
	if (e == null){
	    throw new NullPointerException();
	}
	if (size == arr.length){
	    resize();
	}
	if (size == 0){
	    arr[start] = e;
	}

	else if (start == 0){
	    arr[arr.length-1] = e;
	    start = arr.length - 1;
	}
	else{
	    arr[start - 1] = e;
	    start -= 1;
	}
	size++;
	
    }

    public void addLast(E e){
	if(e == null){
	    throw new NullPointerException();
	}
        if (size == arr.length){
	    resize();
	}
	if(size == 0){
	    arr[end] = e;
	}

	
	else if (end == arr.length - 1){
	    arr[0] = e;
	    end = 0;
	}
	else{
	    arr[end + 1] = e;

	    end++;
	}
	size++;
    }
    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}

	E removed = arr[start];
	arr[start] = null;
	if(start == arr.length - 1){
	    start = 0;
	    size--;

	}
	else{
	    size--;
	    start++;
	}
	return removed;
    }
    
    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E removed = arr[end];
	arr[end] = null;
	if(end == 0){
	    end = arr.length - 1;
	    
	    size--;
	    
	}
	else{
	    end--;
	    size--;
	}
	return removed;
    }
    
    public E getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return arr[start];
    }
    public E getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return arr[end];
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
	E[] tmp = (E[]) new Object[arr.length * 2];
	if (end < start){
	    int ind = 0;
	    for (int i = start; i < arr.length; i++){
		tmp[ind] = arr[i];
		ind++;
	    }
	    for (int i = 0; i <= end; i++){
		tmp[ind] = arr[i];
		ind++;
		
	    }
	}
	else {
	    for (int i = start; i <= end; i++){
		tmp[i] = arr[i];
	    }
	}
	arr = tmp;
	start = 0;
	end = size() - 1;
    }
    
    
    public String toString(){
	String ans = "";
	if (start <= end){
	    for (int i = start; i <= end; i++){
		ans += arr[i] + " ";
	    }
	}
	else{
	    for (int i = start; i <= end + size; i++){
		ans += arr[i%size] + " ";
	    }
	}
	return ans;
    }















    
}
