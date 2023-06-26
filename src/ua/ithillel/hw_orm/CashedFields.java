package ua.ithillel.hw_orm;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class CashedFields {
	
	private static Map<String, Map<String, Field>> reflectionFieldsData;
	
	public static <T> Map<String, Field> getReflectionFieldsData(
			Class<T> type) {
		
		if(reflectionFieldsData == null) {
			reflectionFieldsData = new HashMap<>();
		}
		
		if(!reflectionFieldsData.containsKey(type.getTypeName())) {		
			InitReflectionData(type);
		}
		
		return reflectionFieldsData.get(type.getTypeName());
	}

	static private <T> void InitReflectionData(Class<T> type) {
		
		Field[] fields = type.getDeclaredFields();
		Map<String, Field> temp = new HashMap<>();
		
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
	         
	         temp.put(columnName, field);
		 } 
		 
		 reflectionFieldsData.put(type.getTypeName(), temp);
	}

}
