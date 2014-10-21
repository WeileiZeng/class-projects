public class NumberCubeTest   {
	public static void main ( String [] args )   {
		NumberCube qube = new NumberCube ( );
		int [] array = new int[18];

		//part (a) test
		array = qube.getCubeTosses ( qube, 18 );
		System.out.println ( "The result from getCubeTosses:" );
		for ( int value : array )
			System.out.print ( value + " " );
		System.out.println ( );

		//part (b) test
		int [] numbers = { 1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5 };
		for ( int value : numbers )
			System.out.print ( value + " " );
		System.out.println ( "\nLongest run should be 4:" );
		System.out.println ( qube.getLongestRun ( numbers ) );
		System.out.println ("\nLongest run of the random one:" );
		for ( int value : array )
			System.out.print ( value + " " );
		System.out.print ( "\nis :" );
		System.out.println ( qube.getLongestRun(array) );
		int[] zilch = { 1, 2, 3 };
		System.out.println ( "\nLongest run of zilch should be -1:" );
		System.out.println ( qube.getLongestRun ( zilch ) );
	}
}

class NumberCube   { 

	public NumberCube()   {
	}

	/** 
	* toss
	* @return an integer value between 1 and 6, inclusive  
	*/ 
	public int toss()  {  
      		return 1+(int)(6*Math.random()); 
	} 

	/** Returns an array of the values obtained by tossing a 
	* number cube numTosses times. 
	*  @param cube a NumberCube 
	*  @param numTosses the number of tosses to be recorded 
	*         Precondition: numTosses > 0 
	*  @return an array of numTosses values  
	*/ 
	public static int[] getCubeTosses(NumberCube cube, int numTosses)   {
		//part (a) solution
		int[] result=new int[numTosses];
		for(int i=0; i < numTosses; i++)   {
			result[i]=cube.toss();
		}
		return result;
	}

	/** Returns the starting index of a longest run of two or more 
	*  consecutive repeated values  
	*  in the array values. 
	*  @param values an array of integer values representing a series of number cube tosses  
	*         Precondition: values.length > 0 
	* @return the starting index of a run of maximum size;   
	*          -1 if there is no run 
	*/  
	public static int getLongestRun(int[] values)   {
		int lenCount = 1; int maxLen = 1; int runIndex = 0; int maxIndex = 0;
		for (int loop = 1; loop < values.length; loop++) {
			if (values[loop] == values[loop-1]) {
				lenCount++;
				if (lenCount==2) runIndex = loop-1;
			}
			if (lenCount > maxLen) {
				maxLen = lenCount;
				maxIndex = runIndex;
			}
			if (values[loop] != values[loop-1]) lenCount = 1;
		}
		if (maxLen==1) return -1;
		else return maxIndex;
	}
}

