package ua.ithillel.hw5;

import java.util.Arrays;
import java.util.List;

public class HomeWorkApp {
	
	public static void printThreeWords() {
		
		List<String> fruitStrings= 
				Arrays.asList("Orange", "Banana", "Apple");
		
		for (String fruit : fruitStrings) 
			System.out.println(fruit);
	}

	public static void checkSumSign() {
		
		int a = 5;
		int b = -6;
		
		var res = ((a+b) >= 0) ? "positive":"negative";
		
		System.out.println("Sum is " + res);
	}
	
	public static void printColor() {
		
		int key=150;
		
		if(key <= 0) 
			System.out.println("red");
		else if(key > 0 & key <= 100)
			System.out.println("yellow");
		else 
			System.out.println("green");
			
		}
	
	public static void compareNumbers() {
		
		int a = 5;
		int b = 6;
		
		var res = (a >= b) ? "a >= b":"a < b";
		
		System.out.println(res);
	}
	
	
	public static boolean checkLimits(int a, int b) {
		
		return a+b>=10 & a+b <= 20;
	}
	
	public static void checkInputSign(int a) {
		
		var res = (a >= 0) ? "positive":"negative";
		
		System.out.println(res);
	}
	
	public static boolean checkInputSignInvert(int a) {
		
		return (a < 0) ;
		
	}
	
	public static void printWordManyTimes(
			String word, int count) {

		while (count > 0) {
			System.out.println(word);
			count--;
		}
	}
	
	public static boolean checkYearIsLeap(int year) {
		
		if(year <= 0) return false;
		
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);

	}
	
	
}

