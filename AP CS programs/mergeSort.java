import java.util.*;

/**
 *  Sorts list of integers using three quadratic sorting algorithms
 *
 * @author     Venkata Poreddy, Period 3, S.N.(4,5)
 * @created    November 23, 2009
 */
public class mergeSort{
  private long steps;

  /**
   *  Constructs Sorts with number of steps equal to 0
   *
   */
  public mergeSort(){
    steps = 0;
  }

  /**
   * Bubble sorts an array
   *
   * @param  list  Passes array from tester program
   */
	public void bubbleSort(ArrayList <Integer> list){
	  steps = 0;
	  for (int outer = 0; outer < list.size() - 1; outer++){
	    for (int inner = 0; inner < list.size()-outer-1; inner++){
	        steps += 3;//count one compare and 2 gets
	        if (list.get(inner).compareTo(list.get(inner + 1)) > 0){
	           steps += 4;//count 2 gets and 2 sets
	           Integer temp = list.get(inner);
	           list.set(inner,list.get(inner + 1));
	           list.set(inner + 1,temp);
	        }
	    }
	  }
	}

  /**
   *  Selection sorts an array
   *
   * @param  list  Passes array from tester program
   */
  public void selectionSort(ArrayList <Integer> list){
  steps = 0;
  int min, temp;
  for (int outer = 0; outer < list.size() - 1; outer++){
    min = outer;
    for (int inner = outer + 1; inner < list.size(); inner++){
      steps += 3;//count 1 compare and 2 gets
      if (list.get(inner) < list.get(min)) {
        min = inner; // a new smallest item is found
      }
    }
    //swap list[outer] & list[min]
    steps+=4;
    temp = list.get(outer);
    list.set(outer, list.get(min));
    list.set(min, temp);
  }
}

  public void selectionSort2(ArrayList <Integer> list, int first, int last){
  steps = 0;
  int min, temp;
  for (int outer = first; outer < last - 1; outer++){
    min = outer;
    for (int inner = outer + 1; inner < last; inner++){
      steps += 3;//count 1 compare and 2 gets
      if (list.get(inner) < list.get(min)) {
        min = inner; // a new smallest item is found
      }
    }
    //swap list[outer] & list[min]
    steps+=4;
    temp = list.get(outer);
    list.set(outer, list.get(min));
    list.set(min, temp);
  }
}

  /**
   *  Insertion sorts an array
   *
   * @param  list  Passes array from tester program
   */
  public void insertionSort(ArrayList <Integer> list){
  	steps=0;
  for (int outer = 1; outer < list.size(); outer++){
    int position = outer;
    int key = list.get(position);
    steps += 1;	//count one get
  
    // Shift larger values to the last
    while (position > 0 && list.get(position) > key){
    	steps+=3;	//count 2 gets and one set
      list.set(position, list.get(position - 1));
      position--;
    }
    steps+=1;	//count one set
    list.set(position, key);
  		}
	}
	
	/*public void mergeSort2(ArrayList <Integer> list , int first, int last ){
   if (sublist has only one value){
      do nothing
   } else if (sublist has two values){
      sort it if necessary
   }else{ // recursion, divide list into two halves
      //Find midpoint of current sublist
      //Call mergeSort and process first sublist
      //Call med last sublists
		int first = 0;
		int last = list.size();
        int  mid;
        System.out.print("Before: ");
	for(int counter=0;counter<list.size();counter++) {
  			System.out.print(list.get(counter)+" ");
		}
		System.out.println();
  		mid = (first + last) / 2;
  		selectionSort2 (list, first, mid);
  		selectionSort2 (list, mid+1, last);
  		merge (list, first, mid, last);
  		selectionSort(list);
  		System.out.print("After : ");
  		for(int counter=0;counter<list.size();counter++) {
  			System.out.print(list.get(counter)+ " ");
		}
   }*/
   
   public void mergeSort3(ArrayList <Integer> list , int first, int last )
	{
		System.out.print("Before: ");
	for(int counter=0;counter<list.size();counter++) {
  			System.out.print(list.get(counter)+" ");
		}
 	 	int mid= (first + last) / 2;
  	 	selectionSort2(list, first, mid);
  	 	selectionSort2(list, mid+1, last);
  	 	System.out.println();
	 	merge2(list, first, mid+1, last); 
	}

	public void merge2(ArrayList <Integer> list, int first, int mid, int last)
	{
		System.out.println("merge starts");
	  int i, first_end, num_elements, tmp_pos;
		ArrayList <Integer> temp = new ArrayList <Integer> (list.size());
	  first_end = mid - 1;
	  tmp_pos = first;
	  num_elements = last - first + 1;
	
			System.out.println("loops start");

  	while ((first <= first_end) && (mid <= last))
  	{
  				System.out.println("start first loop");

  	  if (list.get(first) <= list.get(mid))
  	  {
  	  			System.out.println("temp add one " + first);

  	    temp.add(list.get(first));
  	    if (first < last-1) first++;
  	  }
  	  else
    {
    			System.out.println("temp add 2 " + mid);

      temp.add(list.get(mid));
      if (mid < last-1) mid++;
    }
  }

		System.out.println("done 1st loop");


  while (first <= first_end)
  {
  			System.out.println("start 2 loop");

    temp.add(list.get(first));
    first = first + 1;
  }
  while (mid <= last-1)
  {
  				System.out.println("start 3 loop " + mid);

    	temp.add(list.get(mid));
    	mid = mid + 1;
  }
		System.out.println("done 3 loop");

//list.clear();

last--;
  	  while(last>0)
  		{
  			  				System.out.println("start for loop " + last);

    	list.add(last,  temp.get(last));
    	last--;
  	}
System.out.print("After: ");
	for(int counter=0;counter<list.size();counter++) {
  			System.out.print(list.get(counter)+" ");
}

}

 


 
 
 
 

 
 
 
 
 
  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount(){
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(long stepCount){
    steps = stepCount;
  }

}

