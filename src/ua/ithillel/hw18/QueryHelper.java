package ua.ithillel.hw18;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.ithillel.hw17.InitializerBD;

public class QueryHelper extends InitializerBD {
	
	static final String allHomeworkTableRecords = 
			  "\r\n SELECT \r\n"
	  		+ "	* \r\n"
	  		+ "FROM \r\n"
	  		+ "	learningprocess.homework h \r\n";

	static final String allLessonAndHomeworkTableRecords = 
			  "\r\n SELECT \r\n"
			  + "*\r\n"
			  + "FROM \r\n"
			  + "	learningprocess.lesson l\r\n"
			  + "INNER JOIN\r\n"
			  + "	learningprocess.homework h \r\n"
			  + "ON \r\n"
			  + "	l.homework_id = h.id  \r\n";
	
	static final String allLessonAndHomeworkTableOrderedRecords =
			allLessonAndHomeworkTableRecords 
			+"ORDER BY \r\n  l.updatedAt DESC \r\n";
	
	static final String allScheduleAndLessonTableRecords = 
			  "\r\n SELECT \r\n"
			  + "*\r\n"
			  + "FROM \r\n"
			  + "	learningprocess.schedule s\r\n"
			  + "Inner Join\r\n"
			  + "	learningprocess.scheduled_lessons sl\r\n"
			  + "On \r\n"
			  + "	s.id = sl.schedule_id\r\n"
			  + "Inner Join\r\n"
			  + "	learningprocess.lesson l\r\n"
			  + "On \r\n"
			  + "	l.id = sl.lesson_id\r\n";

	static final String allScheduleTableRecordsWithLessonsCount = 
			  "\r\n SELECT  \r\n"
			  + "	s.name, COUNT(sl.lesson_id) AS l_count\r\n"
			  + "FROM \r\n"
			  + "	learningprocess.schedule s\r\n"
			  + "Inner Join\r\n"
			  + "	learningprocess.scheduled_lessons sl\r\n"
			  + "On \r\n"
			  + "	s.id = sl.schedule_id\r\n"
			  + "GROUP BY \r\n"
			  + "	sl.schedule_id\r\n"
			  + "ORDER BY\r\n"
			  + "	s.name\r\n";
	
	 public static void PrintAllQueriesResults()
	 {		
		 // Print all Homework records
	      try(Connection conn = DriverManager.getConnection(
	    		  DB_URL + "LearningProcess", USER, PASS);
	    		  Statement stmt = conn.createStatement();
	    		  ResultSet rs = stmt.executeQuery(
	    				  allHomeworkTableRecords);
	      ) {
	    	  
	    	  System.out.println(
	    			  "\nAll HomeWorks table records:");
	          while(rs.next()){
	        	  System.out.print("Id: " + rs.getInt("h.id"));
	              System.out.print(", Name: " + rs.getString("h.name"));
	              System.out.println(", Description: " + rs.getString("h.description"));
	           }
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	      
	      
		// Print all Lesson table records including 
		// Homework table records
	      try(Connection conn = DriverManager.getConnection(
	    		  DB_URL + "LearningProcess", USER, PASS);
	    		  Statement stmt = conn.createStatement();
	    		  ResultSet rs = stmt.executeQuery(
	    				  allLessonAndHomeworkTableRecords);
	      ) {
	    	  
	    	  System.out.println(
	    			  "\nAll Lesson with HomeWorks tables records:");
	          while(rs.next()){
	        	  System.out.print("h.id: " + rs.getInt("h.id"));
	              System.out.print(", h.name: " + rs.getString("h.name"));
	              System.out.print(", l.id: " + rs.getInt("l.id"));
	              System.out.print(", l.name: " + rs.getString("l.name"));
	              System.out.println(", l.homework_id: " + rs.getInt("l.homework_id"));
	           }
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
		
		// Print all Lesson table records including 
		// Homework table records, ordered by updatedAt
	      try(Connection conn = DriverManager.getConnection(
	    		  DB_URL + "LearningProcess", USER, PASS);
	    		  Statement stmt = conn.createStatement();
	    		  ResultSet rs = stmt.executeQuery(
	    				  allLessonAndHomeworkTableOrderedRecords);
	      ) {
	    	  
	    	  System.out.println(
	    			  "\nAll Lesson with HomeWorks tables ordered records:");
	          while(rs.next()){
	        	  System.out.print("h.id: " + rs.getInt("h.id"));
	              System.out.print(", h.name: " + rs.getString("h.name"));
	              System.out.print(", l.id: " + rs.getInt("l.id"));
	              System.out.print(", l.name: " + rs.getString("l.name"));
	              System.out.print(", l.homework_id: " + rs.getInt("l.homework_id"));
	              System.out.println(", date: " + rs.getString("l.updatedAt"));
	           }
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	      

		// Print all Schedule table records including 
		// Lesson table records
	      try(Connection conn = DriverManager.getConnection(
	    		  DB_URL + "LearningProcess", USER, PASS);
	    		  Statement stmt = conn.createStatement();
	    		  ResultSet rs = stmt.executeQuery(
	    				  allScheduleAndLessonTableRecords);
	      ) {
	    	  
	    	  System.out.println(
	    			  "\nAll Schedule with Lesson tables records:");
	          while(rs.next()){
	        	  System.out.print("s.id: " + rs.getInt("s.id"));
	              System.out.print(", s.name: " + rs.getString("s.name"));
	              System.out.print(", l.id: " + rs.getInt("l.id"));
	              System.out.print(", l.name: " + rs.getString("l.name"));
	              System.out.print(", sl.schedule_id: " + rs.getInt("sl.schedule_id"));
	              System.out.println(", sl.lesson_id: " + rs.getInt("sl.lesson_id"));
	           }	         
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      

		// Print Lesson count for each Schedule
	      try(Connection conn = DriverManager.getConnection(
	    		  DB_URL + "LearningProcess", USER, PASS);
	    		  Statement stmt = conn.createStatement();
	    		  ResultSet rs = stmt.executeQuery(
	    				  allScheduleTableRecordsWithLessonsCount);
	      ) {
	    	  
	    	  System.out.println(
	    			  "\nAll Lessons count for each Schedule:");
	          while(rs.next()){
	              System.out.print("s.name: " + rs.getString("s.name"));
	              System.out.println(", l.count: " + rs.getInt("l_count"));
	           }	         
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      
	  }
	 
	   public static void PrintDMLIntoFile(String fileName)
	   {
		   	var file = new File(fileName);
		   	
			try (BufferedWriter bw = 
					new BufferedWriter(new FileWriter(file))) {
				bw.append(allHomeworkTableRecords);
				bw.append(allLessonAndHomeworkTableRecords);
				bw.append(allLessonAndHomeworkTableOrderedRecords);
				bw.append(allScheduleAndLessonTableRecords);
				bw.append(allScheduleTableRecordsWithLessonsCount);
				bw.close();
			}
			catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			
	  	  	System.out.println(
				  "\nDML commands saved into file: "+ file.getAbsolutePath());
		   
	   }
}
