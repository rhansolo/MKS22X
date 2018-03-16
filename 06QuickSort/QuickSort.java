public class QuickSort{
    static int[] arr = new int[]{0,1,2,0,0,2,1,1,2,2,0,0,2,0,1,2,0,2,2,0,1,2,0};
    int pivot = 0; 
    
    public static void main(String[] args){
	sort(arr,0,arr.length-1);
	for (int i = 0; i < arr.length; i++){
	    System.out.print(arr[i]);
	}
    }
    public static void sort(int[] arr, int low, int high){
	helpSort(arr,low,low+1,high);
    }
    public static void helpSort(int[] arr, int lt, int i, int gt){
	int v = arr[lt];
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
    }
    public static void swap(int[] arr, int i1, int i2){
	int tmp = arr[i1];
	arr[i1] = arr[i2];
	arr[i2] = tmp;

    }


}
