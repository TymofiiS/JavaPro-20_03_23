package ua.ithillel.hw17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializerBD {
	
   static final String DB_URL = "jdbc:mysql://localhost:3306/";
   static final String USER = "JavaDbManager";
   static final String PASS = "(yLG26&%upd56";
   
   static final String createBdQuery = 
		   "CREATE DATABASE IF NOT EXISTS LearningProcess";
   
   static final String createHomeworkTableQuery = 
		   "CREATE TABLE IF NOT EXISTS `homework` (\r\n"
		   
		   + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
		   + "  `name` varchar(25) NOT NULL,\r\n"
		   + "  `description` varchar(255) NOT NULL,\r\n"
		   
		   + "  PRIMARY KEY (`id`)\r\n"
		   + ")"; 
   
   static final String createLessonTableQuery = 
		   "CREATE TABLE IF NOT EXISTS `lesson` (\r\n"
		   
		   + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
		   + "  `name` varchar(25) NOT NULL,\r\n"
		   + "  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n"
           + "  `homework_id` INT UNSIGNED,\r\n"
		   
		   + " PRIMARY KEY (`id`),\r\n"
		   + " FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`)"
		   + ")"; 
   
   static final String createScheduleTableQuery = 
		   "CREATE TABLE IF NOT EXISTS `schedule` (\r\n"
		   
		   + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
		   + "  `name` varchar(25) NOT NULL,\r\n"
		   + "  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n"
		   
		   + "  PRIMARY KEY (`id`)\r\n"
		   + ")"; 
   
   static final String createScheduledLessonsTableQuery = 
		   "CREATE TABLE IF NOT EXISTS `scheduled_lessons` (\r\n"
		   
		   + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
		   + "  `schedule_id` INT UNSIGNED NOT NULL,\r\n"
		   + "  `lesson_id` INT UNSIGNED NOT NULL,\r\n"
		   
		   + " PRIMARY KEY (`id`),\r\n"
		   + " FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`),\r\n"
		   + " FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)\r\n"
		   + ")";
   
   
   public static void CreateBd()
   {	      
      try(Connection conn = DriverManager.getConnection(
    		  DB_URL, USER, PASS);
    		  Statement stmt = conn.createStatement();
      ) {
    	  
         stmt.executeUpdate(createBdQuery);
         System.out.println("Database created successfully...");   	             
        
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
   
   public static void CreateTables()
   {	      
      try(Connection conn = DriverManager.getConnection(
    		  DB_URL + "LearningProcess", USER, PASS);
    		  Statement stmt = conn.createStatement();
      ) {
    	  
         stmt.executeUpdate(createHomeworkTableQuery);
         System.out.println("Table Homework created successfully...");   	  
         
         stmt.executeUpdate(createLessonTableQuery);
         System.out.println("Table Lesson created successfully...");  
         
         stmt.executeUpdate(createScheduleTableQuery);
         System.out.println("Table Schedule created successfully..."); 
         
         stmt.executeUpdate(createScheduledLessonsTableQuery);
         System.out.println("Table ScheduledLessons created successfully...");         
        
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
   
   
   public static void InitTablesWithDemoData()
   {	      
      try(Connection conn = DriverManager.getConnection(
    		  DB_URL + "LearningProcess", USER, PASS);
    		  Statement stmt = conn.createStatement();
      ) {
    	  // Homework
    	  String tableNameString = "homework";
    	  for (int i = 0; i < 10; i++) {	
	          String sql = 
	        		  "INSERT INTO " + tableNameString 
	        		  + " (`name`, `description`) VALUES ("
	        		  + "\"" + tableNameString + "_name_" + i + "\", "
	        		  + "\"" + tableNameString + "_description_" + i + "\""
	        		  + ")";
	          stmt.executeUpdate(sql);
    	  }
    	  System.out.println("Table Homework initialized with demo data.");
    	    
    	  // Schedule
    	  tableNameString = "schedule";
    	  for (int i = 0; i < 10; i++) {	
	          String sql = 
	        		  "INSERT INTO " + tableNameString 
	        		  + " (`name`) VALUES ("
	        		  + "\"" + tableNameString + "_name_" + i + "\""
	        		  + ")";
	          stmt.executeUpdate(sql);
    	  }
    	  System.out.println("Table Schedule initialized with demo data.");
    	  
    	  // Lesson
    	  
    	  // ScheduledLessons
    
        
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
   
}
