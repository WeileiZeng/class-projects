import java.util.*;

/**
 *  Sorts list of integers using three quadratic sorting algorithms
 *
 * @author     Venkata Poreddy, Period 3, S.N.(4,5)
 * @created    November 23, 2009
 */
public class Sorts{
  private long steps;

  /**
   *  Constructs Sorts with number of steps equal to 0
   *
   */
  public Sorts(){
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
    swap list[outer] & list[min]
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
  	//steps=0;
  for (int outer = 1; outer < list.size(); outer++){
    int position = outer;
    int key = list.get(position);
    //steps += 1;	//count one get
  
    // Shift larger values to the right
    while (position > 0 && list.get(position) > key){
    	//steps+=3;	//count 2 gets and one set
      list.set(position, list.get(position - 1));
      position--;
    }
    //steps+=1;	//count one set
    list.set(position, key);
  		}
	}
	
	public void mergeSort(ArrayList <Integer> list, int first, int last){
   /*if (sublist has only one value){
      do nothing
   } else if (sublist has two values){
      sort it if necessary
   }else{ // recursion, divide list into two halves
      //Find midpoint of current sublist
      //Call mergeSort and process left sublist
      //Call med right sublists*/

        int  mid;

  		mid = (first + last) / 2;
  		selectionSort (list, first, mid);
  		selectionSort (list, mid+1, last);
  		merge (list, first, mid, last);

   }
}

	public void merge(Arraylist <Integer> list, int first, int mid, int last) {
		
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
