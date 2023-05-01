/*
1. Створити клас FileLogger. Клас здійснюватиме логування 
(протоколування) інформації в зазначений файл на підставі конфігураційного об'єкта.

2. Створити перелік LoggingLevel. Складається із значень: INFO, DEBUG. 
Таблиця видимості:

| LEVEL | INFO | DEBUG |
| INFO   | X | |   
| DEBUG | X | X |

Тобто, якщо активовано рівень DEBUG, то його також включається INFO, але не навпаки.


3. Створити клас FileLoggerConfiguration. Клас представляє конфігурацію для логування.
 Складається з властивостей: файл, куди буде записуватися інформація, 
 поточний рівень логування, максимальний розмір файлу (в байтах), 
 формат для запису в файл. 


3. У класі FileLogger. Створити методи debug та info, 
які як параметр приймають рядок-повідомлення. 
Метод повинен виконувати запис у вказаний у конфігурації файл у 
встановленому форматі для запису з конфігурації. 

Формат запису: [ПОТОЧНИЙ_ЧАС][DEBUG] Повідомлення: [СТРОКА-ПОВІДОМЛЕННЯ]


4. При виконанні методів debug та info врахувати максимально допустимий розмір файлу, 
куди будуть записуватися логи.
При досягненні максимального розміру файлу або його перевищення, 
викинути виняток FileMaxSizeReachedException з 
повідомленням максимального і поточного розміру файлу, шляхи до файлу.
 */

package ua.ithillel.hw9;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw9");
		
		// Create log file
		var file = new File("log.txt");
		System.out.println(file.getAbsolutePath());
		
		// Init logger
		var config =   
				new FileLoggerConfiguration(
						file, 
						FileLoggerConfiguration.LoggingLevel.DEBUG, 
						1000,
						"Explanation");
		var fileLogger = 
				new FileLogger(config);
		
		fileLogger.debug("Some message for logging");
		fileLogger.info("Some data for logging");
		
		// Print logger file	
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	System.out.println(line);
		    }
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
