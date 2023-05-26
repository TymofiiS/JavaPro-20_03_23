package ua.ithillel.hw16;

import java.util.List;

public class FastSortedList<E extends Comparable<? super E>>{
	
	private List<E> list;

	public FastSortedList(List<E> list) 
	{		
		this.list = list;
	}
	
	public List<E> getSortedList()
	{
        int N = list.size();
        quickSort(0, N - 1);
        
        return list;
	}
	
    private void swap(int i, int j)
    {
        var temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
 
    private int partition(int low, int high)
    {
    	var pivot = list.get(high);
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) 
        {
            if (list.get(j).compareTo(pivot) >= 0) 
            	{ continue; }           
            i++;
            swap(i, j);   
        }
        swap(i + 1, high);
        
        return (i + 1);
    }
 
    private void quickSort(int low, int high)
    {
        if (low >= high) { return;}
 
        int pi = partition(low, high);
        
    	quickSort(low, pi - 1);
    	quickSort(pi + 1, high);                
    }

}
