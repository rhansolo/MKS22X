import java.util.*;
import java.util.Arrays;

public class Merge{
    public static void msort(int[] data, int[] tmp, int low, int high){
      if (low < high){
        for (int i = low; i <= high; i++){
          tmp[i] = data[i];
        }
	
        int middle = (low + high) / 2;
        msort(tmp, data, low, middle);
        msort(tmp, data, middle + 1, high);
        merge(data, tmp, low, middle, middle + 1, high);
      }
  }
  public static void merge(int[] data, int[] tmp, int low1, int high1, int low2, int high2){
    for (int i = low1; i <= high2; i++){
      if (low1 <= high1){
	  if (low2 > high2 || tmp[low1] < tmp[low2]){
	      data[i] = tmp[low1];
	      
	      low1++;
	  }
	  
	  else {
	      data[i] = tmp[low2];
	      low2++;
	  }
      }
    }
  }
    


  public static void mergesort(int[] data){
    int[] tmp = new int[data.length];
    msort(data,tmp,0,data.length - 1);
  }

}
