/*
  Continue hw17:
 
. sql-скрипт fetch.sql містить такі операції:

1. Отримання всіх записів Homework
2. Отримання всіх записів Lesson, включаючи дані Homework
3. Отримання всіх записів Lesson (включаючи дані Homework) 
	відсортовані за часом оновлення
4. Отримання всіх записів Schedule, включаючи дані Lesson
5. Отримання кількості Lesson для кожного Schedule


ВАЖЛИВО ! Файл init.sql і fetch.sql є результатом завдання, 
що має бути додане як рішення
 */

package ua.ithillel.hw18;

import ua.ithillel.hw17.InitializerBD;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw17\n");
			
		// Create Schema and init with demo data using hw17
		InitializerBD.CreateBd();
		InitializerBD.CreateTables();
		//InitializerBD.InitTablesWithDemoData();
		
		System.out.println("\nua.ithillel.hw18\n");
		
		// Create file with DDL commands
		InitializerBD.PrintDDLIntoFile("hw18_init.sql");
		
		// Print all queries results 
		QueryHelper.PrintAllQueriesResults();
		
		// Create file with DML commands
		QueryHelper.PrintDMLIntoFile("fetch.sql");
	}
}
