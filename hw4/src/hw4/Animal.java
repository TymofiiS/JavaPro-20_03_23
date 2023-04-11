package hw4;

public class Animal {
	
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void Run(int length) {	
		System.out.println(name + " run " + length + " m");
	}
	
	public void Swim(int length) {	
		System.out.println(name + " swim " + length + " m");
	}
}
