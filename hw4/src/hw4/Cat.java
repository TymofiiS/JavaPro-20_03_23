package hw4;

import java.lang.constant.Constable;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
