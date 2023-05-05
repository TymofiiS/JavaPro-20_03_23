/*
1. Створити клас ValueCalculator

2. У класі ValueCalculator додати: 
- властивість-масив із дійсних чисел
- властивість, що відображає розмір масиву (мінімально 1 000 000)
- властивість, що відображає половину розміру масиву 

3. У класі ValueCalculator додати метод Метод виконує:
- Зафіксувати час старту виконання методу: long start = System.currentTimeMillis()
- Заповнити масив одиницями або будь-якими іншими однаковими значеннями
- Розбити масив на два масиви однакової величини:


Приклад розподілу одного масиву на два:
System.arraycopy(arr, 0 , a1, 0, half);
System.arraycopy(arr, half, a2, 0, half);

- Створити два потоки, у кожному з яких пройтися 
одним із раніше отриманих масивів. 

Присвоїти його значенням нові значення, сформовані виразом:
 (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)) 

- Виконати зворотне склеювання двох масивів в один початковий

Приклад зворотного склеювання:
System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);


- Обчислити витрачений час від старту до завершення програми 
та виведення його в консоль.
 */

package ua.ithillel.hw10;


public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw10 \n");
		
		ValueCalculator.useLog = false;
		
		for (int i = 1; i < 10; i++) {
			new ValueCalculator(10000000,i,2.0);	
		}
		
	}

}
