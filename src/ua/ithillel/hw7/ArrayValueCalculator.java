package ua.ithillel.hw7;

public class ArrayValueCalculator {
	
	public int doCalc(Object[][] array) {
		
		// Check array size
		if(array.length != 4) 
			{throw new ArraySizeException();}
		for(var i=0; i < 4; i++) {
			if(array[i].length != 4) 
				{throw new ArraySizeException();}
		}
		
		// Convert Object to Int type
		var intArray = new int[4][4];
		for(var i=0; i < 4; i++) {
			for(var j=0; j < 4; j++) {
			  try {
				  intArray[i][j] = Integer.parseInt(
				  					array[i][j].toString());
				  } catch (NumberFormatException e) {
					  throw new ArrayDataException(i,j);
				  }
			}
		}
		
		// Calculate sum
		var sum = 0;
		for(var i=0; i < 4; i++) {
			for(var j=0; j < 4; j++) {
				sum += intArray[i][j];
			}
		}
		
		// Result
		return sum;
	}
}
