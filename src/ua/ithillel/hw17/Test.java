/*
Створити таблицю Homework. 
Ця таблиця складається з атрибутів: 
id, name, description
Для атрибуту ID має бути забезпечене обмеження Primary Key та AutoIncrement

Створити таблицю Lesson. 
Ця таблиця складається з атрибутів: 
id, name, updatedAt, homework_id (зв'язок one-to-one)
Для атрибуту ID має бути забезпечене обмеження Primary Key та AutoIncrement
Пов'язано з таблицею Homework через Foreign Key

Створити таблицю Schedule. 
Ця таблиця складається з атрибутів: 
id, name, updatedAt, lessons (зв'язок many-to-many)
Для атрибуту ID має бути забезпечене обмеження Primary Key і AutoIncrement
Зв'язано з таблицею Lesson через Foreign Key

Перенести ініціалізаційні sql-скрипти у файл initsql
. ! Файл init.sql і є результатом завдання, яке має бути додане як рішення 
 */

package ua.ithillel.hw17;


public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw17\n");
			
		// Create empty BD
		InitializerBD.CreateBd();
		
		// Create Tables
		InitializerBD.CreateTables();

		// Init with demo data
		InitializerBD.InitTablesWithDemoData();
	}
}
