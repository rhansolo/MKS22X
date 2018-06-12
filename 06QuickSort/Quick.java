import java.util.*;

public class Quick{
    
    public static void quicksort(int[] data){
	sortHelper(data, 0 , data.length -1);
    }
    
    public static void sortHelper(int[] data, int start, int end){
	if(end>start){
	    
	    int[] arr = selectHelper (data,start,end);
	    
	    if(arr[1]>=arr[0]){
		
		if(start!=arr[0]){

		    sortHelper(data,start,arr[0]);
		   }
		if(end!=arr[1]){

		    sortHelper(data,arr[1],end);
		}
	    }

	}
    }
    public static int quickselect(int []data, int k){
	int start=0;
	int end=data.length-1;
        for(int i=0;i<data.length;i++){
	    
	    int arr = partition(data,start,end);

	    if(arr==k){
		return data[arr];
	    }
	    if(k > arr){
	        start=arr+1;
	    }
	    if(k < arr){
		end=arr-1;
	    }
	}
	return -1;
    }
    public static int[] selectHelper ( int [] data, int start, int end){
	int[] arrs=new int[2];
	
	Random rand = new Random();
	
	int  pivot = rand.nextInt(end-start+1)+start;
	swap(data,start,pivot);

	
	int ind = start+1;
	while(ind<=end){
	     if(data[ind]==data[start]){
		 ind++;
        
	     }
	     else if(data[ind]<data[start]){
		swap(data,ind,start);
		start++;
		ind++;
	    }
	    else{
		swap(data,ind,end);
		end--;
	    }
	}
	arrs[0]=start;
	arrs[1]=ind;
	
	return arrs;
    }


    public static int partition ( int [] data, int start, int end){
	Random rand = new Random();
	int  pivot = rand.nextInt(end-start+1)+start;
	swap(data,start,pivot);
	int lo=start;
	start++;
	int i=start;
	while(i<end){
	    if(data[i]==data[lo]){
		i++;
	    }
	    if(data[i]<data[lo]){
		swap(data,i,start);
		start++;
		i++;
	    }
	    if(data[i]>data[lo]){
		swap(data,i,end);
		end--;
	    }
	}
	if(data[end]>data[lo]){
	    swap(data,end-1,lo);
	    end--;
	}
        else{
	    swap(data,end,lo);
	}

	return end;
    }

    public static void swap(int[] data,int x1, int x2){
	int tmp =data[x1];
	data[x1]=data[x2];
	data[x2]=tmp;
    }

    public static void toString(int[] data){
	String ans ="";
	for(int i=0;i<data.length;i++){
	    ans +=data[i]+" ";
	}
	System.out.println(ans);
    }
}
