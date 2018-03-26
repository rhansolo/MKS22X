public class Quick{
    static int[] arr = new int[]{0,6,4,2,4,7,8,4,34,67,7,3,5,8,5,3,2};
    int pivot = 0; 
    
    public static void main(String[] args){
	quicksort(arr);
	
	System.out.println(quickselect(arr,6));
	for (int i = 0; i < arr.length; i++){
	    System.out.print(arr[i]);
	}
    }
    public static void quicksort(int[] arr){
	quicksortHelper(arr, 0, arr.length -1);
    }
    public static void quicksortHelper(int[] arr, int low, int high){
	if (low == high){
	    return;

	}
	int[] indexs = partition(arr,low,low,high);
	if (indexs[0]!= low){
	    quicksortHelper(arr,low,indexs[0]-1);
	}
	if (indexs[1] != high){
	    quicksortHelper(arr,indexs[0]+1,high);
	}
    }
    public static void sort(int[] arr, int low, int high){
	partition(arr,low,low+1,high);
    }
    public static int[]  partition(int[] arr, int lt, int i, int gt){
	int index = (int)(Math.random()*(gt-lt+1)+lt);
	int v = arr[index];
	while (i <= gt){
	    if (arr[i] < v){
		swap(arr,i,lt);
		lt++;
		i++;
	    }
	    else if (arr[i] > v){
		swap(arr,i,gt);
		gt--;
	     
	    }
	    else{
		i ++;
	    }
	}
	int[] indexs = {lt,gt};
	return indexs;
    }

    public static int quickselect(int[] arr, int k){
	return selecthelper(arr,k,0,arr.length-1);
    }
    public static int selecthelper(int[] arr, int k, int low, int high){
	int[]indexs = partition(arr, low,low ,high);
	if(indexs[1] >= k-1&& indexs[0]<= k-1 ){
	    return arr[indexs[0]];
	}
	if(indexs[0] < k-1){
	    return selecthelper(arr,k,indexs[1]+1,high);	    
	}
	else{
	    return selecthelper(arr,k,low,indexs[0]-1);
	
	}
    }
    public static void swap(int[] arr, int i1, int i2){
	int tmp = arr[i1];
	arr[i1] = arr[i2];
	arr[i2] = tmp;

    }


}
