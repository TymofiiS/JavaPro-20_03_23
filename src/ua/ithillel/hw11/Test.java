/*
1. Створити метод toList. 
Метод приймає на вхід масив і перетворює їх у список. 
Колекція зберігає такий самий тип даних, як і вхідний масив. 

Після перетворення необхідно повернути щойно створений список.

2. Скриньки-фрукти
2.1 Створити базовий тип Fruit.
2.2 Створити типи Apple, Orange які продають тип Fruit.
2.3. Створити тип Box. У коробку можна складати фрукти. 
Однак, в одну коробку не можна скласти фрукти одного типу. 

Наприклад: яблука з апельсинами буде неприпустимою комбінацією.

2.4. Реалізувати метод додавання фрукта (1 од.) до коробки.

2.5. Реалізувати метод додавання фруктів (множ.) у коробку.

2.6 Реалізувати метод getWeight(). 
Метод вираховує вагу коробки на підставі ваги одного фрукта та його кількості.
Вага: яблука – 1.0F, апельсина – 1.5F.

2.7 У класі Box реалізувати метод compare. 
Метод робить порівняння поточної коробки з переданою як параметр.

Повертати true - якщо їх ваги рівні, інакше - false

ВАЖЛИВО! Можна порівнювати коробки, що містять різні фрукти. 
Так, коробки з яблуками можна порівняти з коробками з апельсинами і так далі.


2.8 Реалізувати метод merge. 
Метод виконує пересип з переданої коробки як параметр, в поточну.  

Однак варто враховувати, що в одну коробку не можна скласти фрукти 
різного типу.
 */

package ua.ithillel.hw11;

import java.util.List;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw11");
		
		System.out.println("\nArray to list");	
		var intArr = new Integer[] { 1, 2, 3 };
		System.out.println( 
				"Is list: " +
				(ArrayExtensions.toList(intArr) instanceof List) + 
				"; Instanceof " +
				ArrayExtensions.toList(intArr).get(0).getClass());
		var strArr = new String[] { "1", "2", "3" };
		System.out.println( 
				"Is list: " +
				(ArrayExtensions.toList(strArr) instanceof List) + 
				"; Instanceof " +
				ArrayExtensions.toList(strArr).get(0).getClass());
		
		System.out.println("\nFruit boxes");
		
		// Init empty appleBox1, appleBox2, orangeBox1
		var appleBox1 = new Box<Apple>("appleBox1");
		var appleBox2 = new Box<Apple>("appleBox2");
		var orangeBox1 = new Box<Orange>("orangeBox1");
			
		// Filling out appleBox1, appleBox2, orangeBox1		
		appleBox1.add(new Apple());
		appleBox2.addMany(
				ArrayExtensions.toList(
						(new Apple[] {
								new Apple(), 
								new Apple(),
								new Apple()})));
		orangeBox1.add(new Orange());
		orangeBox1.add(new Orange());
		
		// Weight of appleBox1, appleBox2, orangeBox1
		appleBox1.getWeight();
		appleBox2.getWeight();
		orangeBox1.getWeight();
		
		// Compare appleBox1, appleBox2, orangeBox1
		appleBox1.compare(appleBox2);
		appleBox1.compare(orangeBox1);
		appleBox2.compare(orangeBox1);
		orangeBox1.getWeight();
		
		// Merge appleBox1, appleBox2
		appleBox1.merge(appleBox2);
	}
}
