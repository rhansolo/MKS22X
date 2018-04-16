import java.util.Random;
import java.util.Arrays;

public class Sorts{
    public static void radixSort(MyLinkedListImproved<Integer> origList){
	MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
	for(int i = 0; i < 10; i++){
	    digits[i] = new MyLinkedListImproved<Integer>();
	}
	MyLinkedListImproved<Integer> positiveValues = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> negativeValues = new MyLinkedListImproved<>();

	for (Integer i : origList){
	    if (i > 0){
		positiveValues.add(i);
	    }
	    else{
		negativeValues.add(i);
	    }
	}
	
	if (positiveValues.size() > 0){
	    double max = positiveValues.get(positiveValues.max());
	    
	    int largestDigitCount = (int)Math.round(Math.log10(max));
	    
	    for(int i = 1; i <= largestDigitCount; i++){
		for(Integer n : positiveValues){
		    
		    digits[((n / (int)Math.round(Math.pow(10, i - 1)))% 1)].add(n);
		}
		
		positiveValues.clear();
		
		for(int j = 0; j < 10; j++){
		    positiveValues.extend(digits[j]);
		    digits[j].clear();
		}
	    }
	}

	if (negativeValues.size() > 0){
	    double min = origList.get(origList.min());
	    
	    int largestDigitCount = (int)Math.round(Math.log10(-min));
	    for(int i = 1; i <= largestDigitCount; i++){
		for(Integer n : origList){
		    
		    digits[(n / (int)Math.round(Math.pow(10, i - 1)))% 1].add(n);
		}
		origList.clear();
		
		for(int j = 9; j >= 0; j--){
		    
		    negativeValues.extend(digits[j]);
		    digits[j].clear();
		}
	    }
	}
	negativeValues.extend(positiveValues);
    }
    private static int getDig(int j, int dig){
	return (j / (int)Math.round(Math.pow(10, dig - 1)))% 10;
    }
}
