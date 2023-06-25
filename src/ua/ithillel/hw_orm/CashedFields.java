package ua.ithillel.hw_orm;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Optional;

public class CashedFields {
	
	// Initiate reflection data of fields
	{
		if(reflectionFieldsData == null) {
			InitReflectionData(this.getClass());
		}
	}
    
	static public Map<String, Field> reflectionFieldsData;
	
	static public <T> void InitReflectionData(Class<T> type) {
		
		Field[] fields = type.getDeclaredFields();
		
		
		
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
		 }
		 
		 
	}

}
