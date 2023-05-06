package ua.ithillel.hw10;

public class ValueCalculator {
	
	private Double[] arr;
	private Integer arrLength;
	private Integer halfArrLength;
	
	private Integer threadsCount;
	private Long startTime;
	private Double initValue;
	private Thread[] threads;
	private Integer countForOneThread;
	
	public static Boolean useLog = false;
	public static Boolean copyArray = false;

	public ValueCalculator(
			Integer arrLength,
			Integer threadsCount,
			Double initValue) 
	{	
		this.arrLength = arrLength;
		this.threadsCount = threadsCount;
		this.initValue = initValue;
		
		threads = new Thread[this.threadsCount];
		
		countForOneThread = 
				getCountElementsForOneThread();
		
		if(copyArray) 
			{method();}
		else 
			{methodNoCopyArray();}
	}
	
	private void initArray() 
	{
		arr = new Double[arrLength];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = initValue;
		}
	}
	
	public Integer getCountElementsForOneThread() 
	{
		return (int)Math.ceil(arrLength *1.0/threadsCount);
	}
	
	
	private void method() 
	{	
		startTime = 
				System.currentTimeMillis();
		
		initArray();
		
		var resultArray = new Double[threadsCount][];
		
		// Initiate and Run all threads
		for (int i = 0; i < threads.length; i++) 
		{
			var indexLimits = 
					new Integer[] {
							i * countForOneThread,
							(i+1)*countForOneThread,
							i};
			
			if(indexLimits[0] > arrLength) {continue;}
			
			
			// Prepare part of data for this thread
			var partArray = 
					new Double[countForOneThread];		
				
			var lenForCopy = 
					indexLimits[0] + countForOneThread >= arrLength
					?arrLength - indexLimits[0]
					:countForOneThread;
					
			System.arraycopy(
					arr, indexLimits[0] , 
					partArray, 0, lenForCopy);

			
			// Initiate thread
			var thread = new Thread(()-> 
			{
				logToConsole(Thread.currentThread().getName() 
						+ " creating for indexes " +
						indexLimits[0] + " - " + indexLimits[1]);
				
				for(int j = 0; j < partArray.length; j++) 
				{					
					var value = partArray[j];
					value = ValueCalculator.calculate(j,value);
					partArray[j] = value;
				}
				
				resultArray[indexLimits[2]] = partArray;
						
			});
			
			thread.start();
			
			threads[i] = thread;			
		}
		
		// Wait all threads finished
		for (int i = 0; i < threads.length; i++) 
		{
			try 
			{
				if(threads[i] == null) {continue;}
				threads[i].join();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		// Update initial array with calculated data
		var startIndex = 0;
		for(int k=0; k<resultArray.length;k++) 
		{
			if(resultArray[k] == null) {continue;}
			
			var len = 
					startIndex + resultArray[k].length >= arrLength
					?arrLength - startIndex
					:resultArray[k].length;
					
			System.arraycopy(
					resultArray[k], 0, 
					arr, startIndex, len);
			
			startIndex += resultArray[k].length;
		}
		
		
		// Print elapsed time
		printElapsedTime();
	}
	
	
	private void methodNoCopyArray() 
	{	
		startTime = 
				System.currentTimeMillis();
		
		initArray();
		
		// Initiate and Run all threads
		for (int i = 0; i < threads.length; i++) 
		{
			var indexLimits = 
					new Integer[] {
							i * countForOneThread,
							(i+1)*countForOneThread};
			
			// Initiate thread
			var thread = new Thread(()-> 
			{
				logToConsole(Thread.currentThread().getName() 
						+ " creating for indexes " +
						indexLimits[0] + " - " + indexLimits[1]);
				
				for(int j = indexLimits[0]; j < indexLimits[1]; j++) 
				{					
					var value = this.readArrElement(j);
					value = ValueCalculator.calculate(j,value);
					this.writeArrElement(j, value);
				}	
						
			});
			
			thread.start();
			
			threads[i] = thread;			
		}
		
		// Wait all threads finished
		for (int i = 0; i < threads.length; i++) 
		{
			try 
			{
				threads[i].join();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		// Print elapsed time
		printElapsedTime();
	}
	
	public synchronized Double readArrElement(
			Integer index)
	{
		logToConsole(Thread.currentThread().getName() + 
				" reading index " + index);
		
		return index >= arrLength ? null: arr[index];
	}
	
	public synchronized void writeArrElement(
			Integer index, Double value)
	{
		if(index >= arrLength) {return;}
		if(value == null) {return;}
		
		logToConsole(Thread.currentThread().getName() + 
				" writing index " + index);
		
		arr[index] = value;
	}
	
	private void printElapsedTime() 
	{
		var dif = 
				System.currentTimeMillis() - startTime;
		
		System.out.println(
				"Array length: " + arrLength + 
				"; Treads count: " + threadsCount +
				"; Elapsed time: " + dif );
	}
	
	public static void logToConsole(String str) 
	{
		if(!useLog) return;
		System.out.println(str);
	}
	
	public static Double calculate(
			Integer i, Double value) 
	{
		if(value == null) {return null;}
		if(i == null) {return null;}	
		 
		var res =(Double)(value 
						* Math.sin(0.2f + i / 5) 
						* Math.cos(0.2f + i / 5) 
						* Math.cos(0.4f + i / 2)); 
		
		logToConsole(Thread.currentThread().getName() + 
				" calculating index " + i + 
				" value " + value +
				" result " + res);
		
		return res;
	}

}
