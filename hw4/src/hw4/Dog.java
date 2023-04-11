package hw4;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
