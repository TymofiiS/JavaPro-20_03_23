/*
0. Створити клас FileNavigator. 
Клас призначений для зберігання списку файлів, 
які розташовані на конкретному шляху.

Наприклад: /path/to/file-> [files.txt, firstApp.java]


1. Створити клас FileData. 
Клас представляє конкретний файл і складається з: 
ім'я файлу, розміру в байтах, шлях до файлу.


2. Реалізувати метод add у класі FileNavigator. 
Цей метод додає файл за вказаним шляхом. 
Якщо шлях вже існує, новий файл необхідно додати до списку, 
вже пов'язаному з відповідним шляхом. 
ВАЖЛИВО: Шлях – унікальне значення і не повинно повторюватися.


3. Реалізувати метод find у класі FileNavigator. 
Метод повертає список файлів, 
пов'язаних з шляхом переданим як параметр.


4. Реалізувати метод filterBySize у класі FileNavigator. 
Метод повертає список файлів, розмір (в байтах) 
яких не перевищує значення, передане як параметр.


5. Реалізувати метод remove у класі FileNavigator. 
Метод видаляє шлях і пов'язані з ним файли, 
виходячи з значення шляху, переданого як параметр.


6. * Реалізувати метод sortBySize у класі FileNavigator. 
Метод сортує всі наявні файли за розміром (за зростанням), 
потім повертає список відсортованих файлів.


7. ** Реалізувати перевірку консистентності у методі add у класі FileNavigator. 
Не дозволяти додавати значення і повідомити про це в консолі, 
при спробі додати значення FileData 
значення шляху якого не відповідає шляху-ключу, що веде до списку файлів.

Наприклад: 
Має бути помилка, оскільки шлях-ключ і шлях до файлу не співпадають
Шлях: /path/to/file
FileData: {name: ..., size: ..., path: /another/path/}
 */

package ua.ithillel.hw13;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw13\n");
		
		// Init
		var fileNavigator = new FileNavigator();
		
		// Add
		fileNavigator.add(new FileData("name1", "/path1/subpath1/", 300));
		fileNavigator.add(new FileData("name2", "/path1/subpath2/", 200));
		fileNavigator.add(new FileData("name3", "/path1/subpath2/", 220));
		fileNavigator.add(new FileData("name4", "/path1/subpath2/", 50));
		
		// Add with error
		fileNavigator.add(
				"/path2/subpath2/", 
				new FileData("name5", "/path3/subpath3/", 300));	
		
		// Find by path
		System.out.println(fileNavigator.find("/path1/subpath2/"));
		
		// Sort by size
		System.out.println(fileNavigator.sortBySize());
		
		// Delete by path
		fileNavigator.remove("/path1/subpath1/");
		
		// Sort by size
		System.out.println(fileNavigator.sortBySize());
		
		// Filter by size
		System.out.println(fileNavigator.filterBySize(200));
	}
}
