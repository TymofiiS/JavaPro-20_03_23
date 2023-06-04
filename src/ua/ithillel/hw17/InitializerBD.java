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
		   
		   + "  `id` int NOT NULL AUTO_INCREMENT,\r\n"
		   + "  `name` varchar(25),\r\n"
		   + "  `description` varchar(255),\r\n"
		   
		   + "  PRIMARY KEY (`id`)\r\n"
		   + ")"; 
   
   static final String createLessonTableQuery = 
		   "CREATE TABLE IF NOT EXISTS `lesson` (\r\n"
		   
		   + "  `id` int NOT NULL AUTO_INCREMENT,\r\n"
		   + "  `name` varchar(25),\r\n"
		   + "  `updatedAt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\r\n"
           + "  `homework_id` int,\r\n"
		   
		   + " PRIMARY KEY (`id`),\r\n"
		   + " FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`)"
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
        
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
   
   
}
