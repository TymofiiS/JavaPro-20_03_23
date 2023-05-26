package ua.ithillel.hw16;

import java.util.List;
import java.util.ArrayList;

public class AsyncFastSortedList2<E extends Comparable<? super E>>{
	
	private List<E> entireList;
	private List<E> part1;
	private List<E> part2;
	private Thread thread1;
	private Thread thread2;

	public AsyncFastSortedList2(List<E> list) 
	{
		entireList = new ArrayList<>(list);
	}
		
	public List<E> getSortedList()
	{
        quickSort(
        		0, entireList.size() - 1, entireList);
        
		// Wait all threads finished
        try {
			 if(thread1 != null) {thread1.join();}
			 if(thread2 != null) {thread2.join();}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
		// Combine result list
		var res = new ArrayList<E>();
		res.addAll(part1);
		res.addAll(part2);

        return res;
	}
	
    private void swap(
    		int i, int j, List<E> partList)
    {
        var temp = partList.get(i);
        partList.set(i, partList.get(j));
        partList.set(j, temp);
    }
 
    private int partition(
    		int low, int high, List<E> partList)
    {
    	var pivot = partList.get(high);
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) 
        {
            if (partList.get(j).compareTo(pivot) >= 0) 
            	{ continue; }           
            i++;
            swap(i, j, partList);   
        }
        swap(i + 1, high, partList);
        
        return (i + 1);
    }
 
    private void quickSort(
    		int low, int high, List<E> partList)
    {
    	// Exit condition
        if (low >= high) { return;}
 
        int pi = partition(low, high, partList);
        
        // Run first dividing in separate threads
        if(part1 == null || part2 == null) 
        {
        	part1 = partList.subList(low, pi - 1);
			thread1 = new Thread(()-> {
				quickSort(0, part1.size() - 1, part1);
			});		
			thread1.start();			

        	part2 = partList.subList(pi + 1, high);
			thread2 = new Thread(()-> {
				quickSort(0, part2.size() - 1, part2);
			});		
			thread2.start();			
        }
        // Perform sorting operation in one thread 
        else {
        	quickSort(low, pi - 1, partList);
        	quickSort(pi + 1, high, partList);
		}
                     
    }
}
