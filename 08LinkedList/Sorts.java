import java.util.Random;
import java.util.Arrays;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> origList){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
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
		    
		    digits[((n / (int)Math.round(Math.pow(10, i - 1)))% 10)].add(n);
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
		for(Integer n : negativeValues){
		    
		    digits[-(n / (int)Math.round(Math.pow(10, i - 1)))% 10].add(n);
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
    
  public static void main(String[] args) {
    //-----------SORTING POSITIVES-----------
    System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
    MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
    int[] correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    long end,start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    boolean hasError = false;
    int index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with all positive integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING NEGATIVES-----------
    System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
    data.clear();
    correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      temp *= -1;
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with all negative numbers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING POSITIVES AND NEGATIVES-----------
    System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
    data.clear();
    correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      if((int)(Math.random() * 1000) % 2 == 0){
        temp *= -1;
      }
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING EMPTY LISTS-----------
    System.out.println("SORTING ON EMPTY LISTS");
    data.clear();
    correctData = new int[0];

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your empty LinkedList is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    int temp = (int)(Math.random() * 1000);
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one positive element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    temp = (int)(Math.random() * 1000) * -1;
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one negative element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
  }
}
