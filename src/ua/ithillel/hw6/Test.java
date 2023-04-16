/*
Пререквізити дивне слово:

- Ознайомитись з методами класу String
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html

- Звернути увагу на методи: toCharArray, charAt , indexOf, intern, contains, startWith, valueOf

1. Створити порожній проект в IntelliJ IDEA


2. Створити метод findSymbolOccurance.
 Метод приймає як параметр рядок і символ. 
 Необхідно обчислити, скільки разів символ зустрічається в переданому рядку 
 і повернути це числове значення.


3. Створити метод findWordPosition. 
Метод приймає як параметри два рядки (source, target). 
Необхідно з'ясувати, чи є target (підрядок) частиною рядка source. 
Якщо так, тоді повернути номер позиції (індекс) першого елемента підрядка у рядку, 
інакше повернути -1.

Приклад 1:
Source: Apollo
Target: pollo
Result: 1

Приклад 2:
Source: Apple
Target: Plant
Result: -1


4. Створити метод stringReverse. 
Метод приймає як параметр - рядок. 
Необхідно її розгорнути та повернути змінений варіант.

Наприклад:
Hello -> olleH


5. Створити метод isPalindrome. 
Метод приймає як параметр - рядок. 
Необхідно Перевірити, чи є переданий рядок паліндромом. 
Якщо так, тоді повернуть true, інакше false.

Приклад 1:
ERE -> true

Приклад 2:
Allo -> false



6. * Створити масив зі слів 
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , 
"broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", 
"mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple",
 "pumpkin", "potato"};

При запуску програми комп'ютер загадує слово, запитує відповідь у користувача,
порівнює його із загаданим словом та повідомляє чи правильно відповів користувач. 
Якщо слово не вгадано, комп'ютер показує літери, які стоять на своїх місцях.

apple – загадане
apricot - відповідь гравця

ap############# (15 символів, щоб користувач не міг дізнатися довжину слова)

Для порівняння двох слів посимвольно, можна скористатися:

String str = "apple";
str.charAt(0); - метод, поверне char, який стоїть у слові str на першій позиції

Граємо до тих пір, поки гравець не відгадає слово
Використовуємо лише маленькі літери


ВАЖЛИВО: Під час роботи із завданням використовувати класи:
- java.util.Scanner для введення інформації через консоль 
https: //docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html

- java.util.Random для генерації випадкових чисел (індексів)
https://docs. oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
 
 */

package ua.ithillel.hw6;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw6");
		
		System.out.println(HomeWorkApp.findSymbolOccurance("testtest", 't'));
		System.out.println(HomeWorkApp.findWordPosition("Apple", "Plant"));
		System.out.println(HomeWorkApp.stringReverse("Hello"));
		System.out.println(HomeWorkApp.isPalindrome("Allo"));
		HomeWorkApp.wordGuessing();
	}

}