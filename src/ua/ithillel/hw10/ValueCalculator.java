package ua.ithillel.hw10;

public class ValueCalculator {
	
	private Double[] arr;
	private Integer arrLength;
	private Integer halfArrLength;
	
	private Integer threadsCount;
	private Long startTime;
	private Double initValue;
	private Thread[] threads;
	
	public static Boolean useLog = false;

	public ValueCalculator(
			Integer arrLength,
			Integer threadsCount,
			Double initValue) 
	{	
		this.arrLength = arrLength;
		this.threadsCount = threadsCount;
		this.initValue = initValue;
		
		threads = new Thread[this.threadsCount];
		
		method();
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
		
		// Initiate and Run all threads
		for (int i = 0; i < threads.length; i++) 
		{
			var indexLimits = 
					new Integer[] {
							i * getCountElementsForOneThread(),
							(i+1)*getCountElementsForOneThread()};
			
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
		
		printEllapsedTime();
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
	
	private void printEllapsedTime() 
	{
		var dif = 
				System.currentTimeMillis() - startTime;
		
		System.out.println(
				"Array length: " + arrLength + 
				"; Treads count: " + threadsCount +
				"; Ellapsed time: " + dif );
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
