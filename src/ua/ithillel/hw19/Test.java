/*
0. Створити клас TestRunner, який може виконувати “метод-тести”. 
Як тести виступають “класи-тести” з наборами методів. 

ВАЖЛИВО! Клас-тест - це клас, що містить набір методів з інструкціями 
@Test, @BeforeSuite, @AfterSuite

1. Створити інструкції: @Test, @BeforeSuite, @AfterSuite. 
Дані інструкція застосовні лише методам. 

ВАЖЛИВО! Інструкція @Test свідчить у тому, 
що даним метод є “методом-тестом”.

2. У класі TestRunner створити статичний метод start, 
що приймає як параметр об'єкт типу Class.

3. З «класу-тесту» спочатку має бути запущений метод з 
анотацією @BeforeSuite, якщо така є, 
далі запущені методи з анотаціями @Test, 
а по завершенню всіх тестів - метод з анотацією @AfterSuite. 

4. До кожного методу-тесту необхідно також додати пріоритети 
(int числа від 1 до 10), відповідно до яких вибиратиметься порядок їх виконання,
 якщо пріоритет однаковий, то порядок не має значення. 

5. Методи з анотаціями @BeforeSuite та @AfterSuite 
у межах одного “класу-тесту” повинні бути присутніми в єдиному екземплярі, 
інакше необхідно викинути виняток.

6. У “методах-тестах” виконати виведення у консоль довільного значення, 
для ідентифікації дійсності виконання цього методу.
 */

package ua.ithillel.hw19;

public class Test {
	
	public static void Run() {
		System.out.println("ua.ithillel.hw19\n");
			
		// Incorrect test class
		System.out.println("\nIncorrect:");
		try {
			TestRunner.start(TestClassIncorrect.class);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		// Correct test class
		System.out.println("\nCorrect:");
		try {
			TestRunner.start(TestClassCorrect.class);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
