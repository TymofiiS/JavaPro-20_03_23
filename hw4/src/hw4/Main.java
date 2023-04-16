package hw4;

public class Main {

	public static void main(String[] args) {
		
		var dog1 = new Dog("Dog1");
		dog1.Run(50);
		dog1.Run(550);
		dog1.Swim(5);
		dog1.Swim(15);
		
		var cat1 = new Cat("Cat1");
		cat1.Run(50);
		cat1.Run(350);
		cat1.Swim(5);
		
		var cat2 = new Cat("Cat2");
		var cat3 = new Cat("Cat3");
		var dog2 = new Dog("Dog2");
	}
}
