package ua.ithillel.hw_orm;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class CashedFields {
	
	// Initiate reflection data of fields
	{
		if(reflectionFieldsData == null) {
			InitReflectionData(this.getClass());
			System.out.println("Filling outing reflected data");
		}
		else {System.out.println("Already filling out reflected data");}
	}
    
	static private Map<String, Field> reflectionFieldsData;
	
	public static Map<String, Field> getReflectionFieldsData() {
		return reflectionFieldsData;
	}

	static private <T> void InitReflectionData(Class<T> type) {
		
		Field[] fields = type.getDeclaredFields();
		reflectionFieldsData = new HashMap<>();
		
		 for (Field field : fields) {
	
	         if (field.getType().isArray() || 
	    		 Modifier.isStatic(field.getModifiers())) {
	             continue;
	         }
	
	         String fieldName = field.getName();
	
	         String columnName = Optional.ofNullable(
	        		 field.getAnnotation(Column.class))
	                     .map(column -> column.name())
	                     .filter(name -> name != null && !name.isEmpty())
	                     .orElse(fieldName);
	         
	         reflectionFieldsData.put(columnName, field);
		 } 
	}

}
