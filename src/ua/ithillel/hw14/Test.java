/*
0. Створити новий пакет coffee.order


1. Створити клас CoffeeOrderBoard. 
Клас є цифровим поданням черги замовлень у кав'ярні.

Цей клас містить список замовлень.


2. Створити клас Order. 
Клас є цифровим поданням замовлення. 
Даний клас містить номер замовлення та ім'я людини, що його замовила.


3. Реалізувати метод add у класі CoffeeOrderBoard. 
Даний метод додає нове замовлення та надає замовленню номер 
(натуральний порядок).

Натуральний порядок (natural ordering) означає, 
що й у останнього замовлення номер 86, то наступний буде 87. 

Не може бути такої ситуації, 
що номер повторюється у межах одного об'єкта типу CoffeeOrderBoard.


4. Реалізувати метод deliver у класі CoffeeOrderBoard. 
Цей метод видає найближче у черзі замовлення. 
Видача супроводжується видаленням замовлення зі списку.


5. Реалізувати метод deliver у класі CoffeeOrderBoard. 
Даний метод видає замовлення з певним номером. 
Видача супроводжується видаленням замовлення зі списку.

Даний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, 
готове раніше.


6. Реалізувати метод draw у класі CoffeeOrderBoard. 
Цей метод виводить у консоль інформацію про поточний стан черги у 
порядку найближчого до видачі замовлення.

Наприклад:

=============
Num | Name
4   | Alen
27  | Yoda
33  | Obi-van
34  | John Snow
 */

package ua.ithillel.hw14;

import ua.ithillel.hw14.coffee.order.CoffeeOrderBoard;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw14\n");
		
		// Init
		var orderBoard = new CoffeeOrderBoard(10);
		
		// Add orders
		orderBoard.add("Name1");
		orderBoard.add("Name2");
		orderBoard.add("Name3");
		orderBoard.add("Name4");
		orderBoard.add("Name5");

		// Current queue
		orderBoard.draw();
		
		// Deliver by number
		orderBoard.deliver(14);
		orderBoard.deliver(12);
		
		// Add order
		orderBoard.add("Name6");
		
		// Current queue
		orderBoard.draw();
		
		// Deliver by FIFO
		orderBoard.deliver();
		orderBoard.deliver();
		
		// Add order
		orderBoard.add("Name7");
		
		// Current queue
		orderBoard.draw();
	}
}
