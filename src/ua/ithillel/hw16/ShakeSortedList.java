package ua.ithillel.hw16;

import java.util.List;

public class ShakeSortedList<E extends Comparable<? super E>>{
	
	private List<E> list;

	public ShakeSortedList(List<E> list) 
	{		
		this.list = list;
	}
	
	public List<E> getSortedList()
	{
		sort();      
        return list;
	}
	
    private void swap(int i, int j)
    {
        var temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
	
	void sort()
    {
        boolean swapped = true;
        int start = 0;
        int end = list.size();
 
        while (swapped == true)
        {
            swapped = false;
 
            // Forward
            for (int i = start; i < end - 1; ++i)
            {
                if (list.get(i).compareTo(list.get(i+1)) > 0) {
                	swap(i, i+1);
                    swapped = true;
                }
            }
 
            // if nothing moved, then array is sorted.
            if (swapped == false)
                break;
 
            swapped = false;
 
            end = end - 1;
 
            // Reverse
            for (int i = end - 1; i >= start; i--)
            {
                if (list.get(i).compareTo(list.get(i+1)) > 0) {
                	swap(i, i+1);
                    swapped = true;
                }
            }
            
            start = start + 1;
        }
    }

}
