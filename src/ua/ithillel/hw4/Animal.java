package ua.ithillel.hw4;

public class Animal {
	
	public static int countAnimals;
	
	private String name;
	
	public Animal(String name) {
		this.name = name;
		
		countAnimals++;
		System.out.println("Was(were) created " + countAnimals + " animal(s)");
	}
	
	public void Run(int length) {	
		System.out.println(name + " run " + length + " m");
	}
	
	public void Swim(int length) {	
		System.out.println(name + " swim " + length + " m");
	}
}
