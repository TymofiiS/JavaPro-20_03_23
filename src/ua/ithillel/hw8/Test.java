/*
0. Створити базовий інтерфейс для геометричної фігури, 
в якому є метод, який повертає площу фігури.

Створити 3 класи, які реалізують цей інтерфейс: коло, трикутник, квадрат.

Створити масив фігур, і написати метод який виведе сумарну площу всіх фігур 
у цьому масиві


1. Створіть тип даних Учасник та кілька його реалізацій: Людина, Кіт, Робот.


2. Класи з п.2 повинні мати поведінку бігати і стрибати 
(методи просто виводять інформацію про дію в консоль).


3. Створіть тип даних Перешкода та кілька її реалізацій: Бігова Доріжка та Стіна.


4. Класи з п.3 повинні мати поведінку подолати перешкоду (overcome).


5. Налагодити взаємодію між Учасником та Перешкодою. 

Іншими словами, учасники під час проходження через перешкоди мають виконувати 
відповідні дії (бігти чи стрибати).

Наприклад: Людина пробігла бігову доріжку.


6. Створіть два масиви: з учасниками та перешкодами. 

7. Кожен елемент з масиву з учасниками повинен пройти кожну перешкоду з масиву 
з перешкодами.


8. * У перешкод є довжина (для доріжки) або висота (для стіни), 
а учасників обмеження на біг та стрибки. 

Якщо учасник не зміг пройти одну з перешкод, 
то наступного він не приступає (цілком вибуває з участі в серії перешкод). 


9. * Результат виконання учасником конкретної перешкоди виводити у консоль.
 Наприклад:
 
"Учасник[ІМ'Я] пройшов перешкоду[НАЗВА] на дистанції[ЗНАЧЕННЯ]"
"Учасник[ІМ'Я] не пройшов перешкоду[НАЗВА] на дистанції[ЗНАЧЕННЯ]. Пройдено[ЗНАЧЕНИЕ]"
 */

package ua.ithillel.hw8;

import java.util.List; 

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw8");
		
		// Task 0
		System.out.println("---------------------------");
		System.out.println("Task0");
		IAreaCalculable[] arr = {
		      new Circle(1.0),
		      new Rectangle(1.0, 1.0),
		      new Triangle(1.0, 1.0)
		};
		var totalArea = IAreaCalculable.TotalArea(arr);
		System.out.println("Total area: " + totalArea );
		
		// Tasks 1-8
		System.out.println("---------------------------");
		System.out.println("Tasks 1-8");
		
		var wall = new Wall("wall", 2);
		var runPass = new RunPass("run pass", 20);
		var pool = new Pool("pool", 15);
		Obstacle[] obstacles = { wall, runPass, pool};
		
		Participant[] participants = {
				new Participant("Human",
						List.of(
								new Run(100, runPass.typeName()),
								new Jump(3, wall.typeName()),
								new Swim(30, pool.typeName())
								)
						),
				new Participant("Cat",
						List.of(
								new Run(20, runPass.typeName()),
								new Jump(2, wall.typeName())
								)
						),
				new Participant("Robot",
						List.of(
								new Run(10, runPass.typeName()),
								new Jump(2, wall.typeName()))
								)
		};
		
		Participant.Competition(obstacles, participants);
	}

}
