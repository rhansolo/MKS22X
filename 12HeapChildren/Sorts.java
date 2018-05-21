import java.util.Arrays;

public class Sorts{
    
    public static void heapsort(int[] arr){
	
	heapify(arr,arr.length - 1);
    }
    
    private static void change(int[] arr, int ind1, int ind2){
	int tmp = arr[ind1];
	
	arr[ind1] = arr[ind2];
	arr[ind2] = tmp;
    }
    
    public static void heapify(int[] arr, int ind){
	if(ind != 0){
	   int tmpInd = ind;
	    while(( 2 * ind + 1 < arr.length && arr[ind] < arr[2 * ind + 1]) || (2 * ind + 2 < arr.length && arr[ind] < arr[2 * ind + 2])) {
		if(2 * ind + 2 >= arr.length || arr[2 * ind + 1] > arr[2 * ind + 2]){
		    
		    change(arr, 2 * ind + 1, ind);
		    
		    ind = 2 * ind + 1;
		}
		else{
		    
		    change(arr, 2 * ind + 2, ind);
		    ind = 2 * ind + 2;
		}
	    }
	    heapify(arr, tmpInd - 1);
	}
	
	else{
	    while(( 2 * ind + 1 < arr.length && arr[ind] < arr[2 * ind + 1]) || (2 * ind + 2 < arr.length && arr[ind] < arr[2 * ind + 2])) {
		if(2 * ind + 2 >= arr.length || arr[2 * ind + 1] > arr[2 * ind + 2]){
		    
		    change(arr, 2 * ind + 1, ind);
		    ind = 2 * ind + 1;
		}
		
		else{
		    change(arr, 2 * ind + 2, ind);
		    ind = 2 * ind + 2;
		}
	    }
	    for(int i = arr.length - 1; i > 0; i--){
		int tmpInd = 0;
		change(arr, 0, i);
		
		while(2 * tmpInd + 2 < i && (arr[tmpInd] < arr[2 * tmpInd + 1] || arr[tmpInd] < arr[2 * tmpInd + 2])) {
		    if(2 * tmpInd + 2 == arr.length || arr[2 * tmpInd + 1] > arr[2 * tmpInd + 2]){
			change(arr, 2 * tmpInd + 1, tmpInd);
			tmpInd = 2 * tmpInd + 1;
		    }
		    else{
			change(arr, 2 * tmpInd + 2, tmpInd);
			tmpInd = 2 * tmpInd + 2;
		    }
		}
	    }
	    if(arr[0] > arr[1]){
		change(arr, 0, 1);
	    }	    
	}
    }
  
}
