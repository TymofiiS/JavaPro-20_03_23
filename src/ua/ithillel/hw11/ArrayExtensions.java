package ua.ithillel.hw11;

import java.util.Arrays;
import java.util.List;

public class ArrayExtensions {

	public static <T> List<T> toList(T[] initArray) 
	{
		if(initArray == null || initArray.length == 0) 
		{
			return null;
		}
		
		List<T> list = Arrays.asList(initArray);
		return  list;
	}

}
