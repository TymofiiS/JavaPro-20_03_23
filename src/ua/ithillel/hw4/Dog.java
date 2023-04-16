package ua.ithillel.hw4;

public class Dog extends Animal {
	
	public static int countDogs;
	
	public Dog(String name) {
		super(name);
		
		countDogs++;
		System.out.println("Was(were) created " + countDogs + " dog(s)");
	}
	
	int maxRunPath = 500;

	public void Run(int length) {
		if (length > maxRunPath) {
			System.out.println("Dog can not run " + length + " m");
			return;
		}
		super.Run(length);
	}
	
	int maxSwimPath = 10;
	
	public void Swim(int length) {	
		if (length > maxSwimPath) {
			System.out.println("Dog can not swim " + length + " m");
			return;
		}
		super.Swim(length);
	}

}
