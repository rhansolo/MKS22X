import java.util.Arrays;
import java.util.Random;

public class Merge {

	public static void mergesort(int[] data) {
		int[] tmp = new int[data.length];
		for (int i=0; i < data.length; i++) {
			tmp[i]=data[i];
		}
		msort(data,tmp,0,data.length-1);
	}

	public static void msort(int[] data,int[] tmp, int lo, int high) {
		if (high - lo < 2 ) {
			insertionSort(tmp,lo,high);
			return;
		}
		int mid = (lo+high)/2;
		msort(tmp,data,lo,(lo+high)/2);
		msort(tmp,data,(lo+high)/2+1,high);

		merge(data,tmp,lo,mid,high);
	}

	public static void merge(int[] data, int[] tmp, int lo, int mid, int high){
		int index1= lo;
		
		int index2 = mid+1;
		for (int i = lo; i <= high; i++) {
			if (index1 > mid) {
				tmp[i] = data[index2];
				index2+=1;
			}
			
			else if (index2 <= high) {

			    if (data[index1] < data[index2]) {
					tmp[i] = data[index1];
					index1+=1;
			    }
			    else {
				tmp[i] = data[index2];
				index2+=1;
			    }
			}
			
			else {
			    tmp[i] = data[index1];
			    index1 +=1;
			}

		}

		for (int i = lo; i <= high; i++) {
			data[i] = tmp[i];
		}

	}

	public static void insertionSort(int[] arr, int lo, int high) {
	    int j;
	    for (int i = lo; i < high+1; i++) {
		int tmp = arr[i];
		for( j = i; j > lo && tmp < arr[j - 1]; j--) {
		    arr[j] = arr[j-1];
		}
		arr[j] = tmp;
	    }

	}


}
