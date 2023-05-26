/*
Реалізувати алгоритм "Швидкого сортування"

Реалізувати алгоритм "Сортування перемішуванням (Шейкерне сортування)"
 */

package ua.ithillel.hw16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw16\n");
			
		// Quick sort
		System.out.println("Quick sort");
		
		// Init parameters
		var countElements = 100000;	

		{			
			// Init list
			int i = 1;
			List<Integer> list = new ArrayList<>();
			Random rand = new Random();
			for (int j = 0; j < countElements; j++) {
				list.add(rand.nextInt(countElements));			
			}
			
			// Sort list
			var startTime = 
					System.currentTimeMillis();
			
			var sortedList = new FastSortedList<>(
					new ArrayList<>(list));
			var res = sortedList.getSortedList();
			
			var dif = 
					System.currentTimeMillis() - startTime;
			
			// Print results
			System.out.println(
					"Count elements: " + countElements +
					"; Elapsed time: " + dif);
			//System.out.println(res + "\n");		
		}	
		
		// Quick sort
		System.out.println("\nQuick sort two threads");		
		{
			// Init list
			List<Integer> list = new ArrayList<>();
			Random rand = new Random();
			for (int j = 0; j < countElements; j++) {
				list.add(rand.nextInt(countElements));			
			}
			
			// Sort list
			var startTime = 
					System.currentTimeMillis();
			
			var sortedList = new AsyncFastSortedList2<>(
					new ArrayList<>(list));
			var res = sortedList.getSortedList();
			
			var dif = 
					System.currentTimeMillis() - startTime;
			
			// Print results
			System.out.println(
					"Count elements: " + countElements +
					"; Elapsed time: " + dif);
			//System.out.println(res + "\n");
		}
		
		
		// Quick sort
		System.out.println("\nJava sort built in");
		{
			// Init list
			List<Integer> list = new ArrayList<>();
			Random rand = new Random();
			for (int j = 0; j < countElements; j++) {
				list.add(rand.nextInt(countElements));			
			}
			
			// Sort list
			var startTime = 
					System.currentTimeMillis();
			
			Collections.sort(list);
			
			var dif = 
					System.currentTimeMillis() - startTime;
			
			// Print results
			System.out.println(
					"Count elements: " + countElements +
					"; Elapsed time: " + dif);
			//System.out.println(list + "\n");
		}
		
		
		// Shake sort
		System.out.println("\nShake sort");		
		{
			// Init list
			countElements = 1000;
			List<Integer> list = new ArrayList<>();
			Random rand = new Random();
			for (int j = 0; j < countElements; j++) {
				list.add(rand.nextInt(countElements));			
			}
			
			// Sort list
			var startTime = 
					System.currentTimeMillis();
			
			var sortedList = new ShakeSortedList<>(
					new ArrayList<>(list));
			var res = sortedList.getSortedList();
			
			var dif = 
					System.currentTimeMillis() - startTime;
			
			// Print results
			System.out.println(
					"Count elements: " + countElements +
					"; Elapsed time: " + dif);
			System.out.println(res + "\n");
		}

	}
}
