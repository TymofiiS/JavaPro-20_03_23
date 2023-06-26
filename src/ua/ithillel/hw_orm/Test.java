/*

 */

package ua.ithillel.hw_orm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Test {

	public static void Run() {
		System.out.println("ua.ithillel.hw_orm\n");
			

		for (int i = 0; i < 3; i++) {
			
			try {
				
				Homework obj = 
						Homework.class.getDeclaredConstructor().newInstance();
				var map = obj.getReflectionFieldsData();
				
				for (Map.Entry<String, Field> entry : map.entrySet()) {
				    System.out.println(entry.getKey() + ": " + entry.getValue());
				}
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
		}

	}
}
