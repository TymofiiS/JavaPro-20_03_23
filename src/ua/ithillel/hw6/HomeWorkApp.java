package ua.ithillel.hw6;

import java.util.Scanner;
import java.util.Random;

public class HomeWorkApp {
	
	public static int findSymbolOccurance(
			String source, Character target) {
		
		var res = 0;
		
		if(source == null || target == null) return res;
		
		int index = source.indexOf(target);
		while (index >= 0) {
		    res++;
		    index = source.indexOf(target, index + 1);
		}
		
		return res;
	}
	
	public static int findWordPosition(
			String source, String target) {
		
		var res = -1;
		
		if(source == null || target == null) return res;
		
		res = source.indexOf(target);
		
		return res;
	}
	
	public static String stringReverse(String source) {
		
		if(source == null ) return null;
		
	    StringBuilder sb=new StringBuilder(source);  
	    sb.reverse();  
	    
	    return sb.toString();  
	}
	
	public static boolean isPalindrome(String source) {
		
		if(source == null ) return false;
		
		var target = stringReverse(source);
		
		return source.equals(target);
	}
	
	public static void wordGuessing() {
		
		String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , 
				"broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", 
				"mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple",
				 "pumpkin", "potato"};
		
		var in = new Scanner(System.in);
		var exit = false;
		
	    var rnd = new Random().nextInt(words.length);
	    var initialWord = words[rnd];
	    
	    //System.out.println("Initial word: " + initialWord);
		
		do {
			// Get user guess
			System.out.print(
					"Input your guess 3..15 characters: "); 
			var guessWord = in.nextLine();
			
			// Check correct input
			if(guessWord == null) continue;
			if(guessWord.length() > 15) continue;
	        
			// Check if it is match with initial word
	        if(initialWord.equals(guessWord)) {
	        	System.out.println(
	        			"Correct, it is " + initialWord);
	        	break;
	        }
	        
	        // Filling out correct characters
	        var reply = "###############";
	        for (int i = 0; i < reply.length(); i++)
	        {
	        	if(initialWord.length() <= i) break;
				if(guessWord.length() <= i) break;
				
				if(Character.compare(
						initialWord.charAt(i), 
						guessWord.charAt(i)) == 0) {
					reply = 
							replaceCharUsingCharArray(
									reply, 
									initialWord.charAt(i),
									i);
				}
	        }
	        
	        // Show correct characters
	        System.out.println("Current result: " + reply);
		
		} while (!exit);
		
		in.close();
	}
	
	public static String replaceCharUsingCharArray(
			String str, char ch, int index) {
	    char[] chars = str.toCharArray();
	    chars[index] = ch;
	    return String.valueOf(chars);
	}
}
