package ua.ithillel.hw_orm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import ua.ithillel.hw17.InitializerBD;

public  class OrmHelper extends InitializerBD {
	
	 public static void PrintAllQueriesResults()
	 {		
		 // Print all Homework instances
		 String sql = "select * from ?";
		 Object[] params = {"learningprocess.homework"};
		 List<Homework> homeworks = fillingOutListObjFromBd(
				 Homework.class, sql, params);
	     
	   	  System.out.println(
				  "\nAll HomeWork instances:");
	   	  for (Homework homework : homeworks) {
	   		System.out.println(homework);
	   	  }
	 }
	 
	 private static <T extends CashedFields> List<T> fillingOutListObjFromBd(
			 Class<T> type,
			 String sql,
			 Object... params) {
		 
		 List<T> result = new ArrayList<>();
		 
	     try(Connection conn = DriverManager.getConnection(
	    		  DB_URL + "LearningProcess", USER, PASS);
			  PreparedStatement st = prepareStatement(
					  conn, sql, params);
			  ResultSet rs = st.executeQuery();
	      ) {
	    	 
	    	 try {
	    		 
				T obj = type.getDeclaredConstructor().newInstance();
				var reflectionData = obj.getReflectionFieldsData();
				
				for (Map.Entry<String, Field> entry : reflectionData.entrySet()) {
					
                	entry.getValue().setAccessible(true);
                	
                	Object fieldValue = fieldValueFromResultSet(
                					entry.getValue().getType(), 
                					entry.getKey(), 
                					rs);
                    try {
                    	entry.getValue().set(obj, fieldValue);         
                    }catch (Exception e) {
                        throw new RuntimeException(
                        		"Cannot set value for column " + 
                        				entry.getKey(), e);
                    }finally {
                    	entry.getValue().setAccessible(false);
                    }		    
				}			
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	     
	     return result;
	 }
	 
	 private static PreparedStatement prepareStatement(
			 Connection connection,
			 String sql, 
			 Object... params) throws SQLException {
		 
		 PreparedStatement ps = 
				 connection.prepareStatement(
	        		sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 
         if (params != null) {
             for (int i = 0; i < params.length; i++) {

                 Object param = params[i];

                 Class<?> paramType = param.getClass();

                 final int parameterIndex = i + 1;

                 if (paramType == String.class) {
                     ps.setString(parameterIndex, (String) param);
                 } else if (paramType == Byte.TYPE) {
                     ps.setByte(parameterIndex, (Byte) param);
                 } else if (paramType == Short.TYPE) {
                     ps.setShort(parameterIndex, (Short) param);
                 } else if (paramType == Integer.TYPE) {
                     ps.setInt(parameterIndex, (Integer) param);
                 } else if (paramType == Long.TYPE) {
                     ps.setLong(parameterIndex, (Long) param);
                 } else if (paramType == Float.TYPE) {
                     ps.setFloat(parameterIndex, (Float) param);
                 } else if (paramType == Double.TYPE) {
                     ps.setDouble(parameterIndex, (Double) param);
                 } else if (paramType == Boolean.TYPE) {
                     ps.setBoolean(parameterIndex, (Boolean) param);
                 } else {
                     ps.setObject(parameterIndex, param);
                 }
             }
         }
		 
		 return ps;
	 }
	 
	 private static Object fieldValueFromResultSet(
			 Class<?> fieldType, 
			 String fieldName, 
			 ResultSet rs) throws SQLException {
		 
        if (fieldType == String.class) {
            return rs.getString(fieldName);
        } else if (fieldType == Byte.TYPE) {
            return rs.getByte(fieldName);
        } else if (fieldType == Short.TYPE) {
            return rs.getShort(fieldName);
        } else if (fieldType == Integer.TYPE) {
            return rs.getInt(fieldName);
        } else if (fieldType == Long.TYPE) {
            return rs.getLong(fieldName);
        } else if (fieldType == Float.TYPE) {
            return rs.getFloat(fieldName);
        } else if (fieldType == Double.TYPE) {
            return rs.getDouble(fieldName);
        } else if (fieldType == Boolean.TYPE) {
            return rs.getBoolean(fieldName);
        } else if (fieldType == Date.class) {
            return rs.getDate(fieldName);
        } else {
            return rs.getObject(fieldName);
        }

    }
	 
}
