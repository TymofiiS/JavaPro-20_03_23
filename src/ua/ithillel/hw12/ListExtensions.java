package ua.ithillel.hw12;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class ListExtensions {

	public static <T> List<T> toList(T[] initArray) 
	{
		if(initArray == null || initArray.length == 0) 
		{
			return null;
		}
		
		List<T> list = Arrays.asList(initArray);
		return  list;
	}
	
	public static <T>int countOccurance(
			List<T> lst, T key) {
		
		if(lst == null) {return 0;}
		if(key == null) {return 0;}
		
		var res = 0;
		for (T obj : lst) {
			if(!obj.equals(key)) {continue;}
			res++;
		}
		
		return res;
	}
	
	public static <T> List<T>findUnique(List<T> lst){
		if (lst == null) {return null;}
		Set<T> set = new HashSet<T>(lst);
		List<T> list = new ArrayList<T>(set);
		return list;
	}
	
	public static <T> List<FindOccuranceModel> findOccurance(List<T> lst){
		if (lst == null) {return null;}
		
		var res = 
				new ArrayList<FindOccuranceModel>();		
		var unique = findUnique(lst);
		
		for (T obj : unique) {
			var occurance = 
					countOccurance(lst, obj);
			res.add(
					new FindOccuranceModel(
							obj, occurance));
		}
		
		return res;	
	}
	
	
	public static <T> void calcOccurance(List<T> lst){
		if (lst == null) {return;}
		
		var temp = findOccurance(lst);
		var res = new ArrayList<String>();
		
		for (FindOccuranceModel findOccuranceModel : temp) {
			res.add(findOccuranceModel.toStringShort());
		}
		
		System.out.println(res);
	}

}
