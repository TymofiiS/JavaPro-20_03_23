/*
1. Створити Клас ArrayValueCalculator

2. Створити метод doCalc. 
На вхід до методу подається двомірний рядковий масив розміром 4х4.

3. При передачі масиву іншого розміру в метод doCalc 
необхідно викинути виняток ArraySizeException.

4. Метод doCalc повинен пройтися за всіма елементами масиву 
і перетворити в int (використовувати Integer#parseInt) і підсумувати. 
Після загального підсумовування метод повертає фінальний 
результат у вигляді int.

5. Якщо в якомусь елементі масиву перетворення не вдалося 
(наприклад, в комірці лежить символ або текст замість числа), 
тоді викинути виняток ArrayDataException, 
з деталізацією в якому саме комірці лежать невірні дані.

6. У методі main() викликати отриманий метод, обробити можливі винятки 
ArraySizeException та ArrayDataException, та вивести результат розрахунку.

7. * Необхідно дотримуватись усіх правил збереження контексту 
викинутого виключення.

8. * При вилові винятків у процесі перетворення, 
взяти до уваги винятки, що викидаються іншими (сторонніми) методами,
 що використовуються.
 */

package ua.ithillel.hw7;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw7");
		
		try {
			// Init array
			var rows = 4;		
			var columns = 4;
			//rows = 2; // test ArraySizeException
			//columns = 3; // test ArraySizeException
	        var arr = new Object[rows][columns];   
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                arr[i][j] = 1;
	            }
	        }
	        //arr[1][2] = "test"; // test ArrayDataException
	        
	        // Init and use helper
			var calcObj = new ArrayValueCalculator();
			var res = calcObj.doCalc(arr);
			
			//var a = 10/0; // test another exceptions
			
			// Return result
			System.out.println("res = " + res);
		
		} catch (ArraySizeException e) {
			System.out.println(e.getMessage());
		} catch (ArrayDataException e) {
			System.out.println(e.getMessage());			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
