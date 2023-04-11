package hw4;

public class Cat extends Animal {
	
	public static int countCats;
	
	public Cat(String name) {
		super(name);
		
		countCats++;
		System.out.println("Was(were) created " + countCats + " cat(s)");
	}
	
	int maxRunPath = 200;

	public void Run(int length) {
		if (length > maxRunPath) {
			System.out.println("Cat can not run " + length + " m");
			return;
		}
		super.Run(length);
	}
	
	public void Swim(int length) {	
		System.out.println("Cat can not swim");
	}
	
	
	
	
	
}
