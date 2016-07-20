package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;


import model.DeleteCustomerModel;


public class DeleteCustomerDao {
 
 //Connection object
 private Connection connection;

 
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public DeleteCustomerModel delete (DeleteCustomerModel custModel) 
 {
	 System.out.println("Hello");
 
  try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Error creating connection to database: " + e);
      System.exit(-1);
   }
  
   
String query="delete from pcustomer where cid=?";
  
  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
	   //Set the parameters to the query
	            statement.setString(1, custModel.getCustId());

	            //Execute the insert
	            statement.executeUpdate();
	            
	            System.out.println(statement.getUpdateCount());
	      	           }
	    
 			catch(SQLException e){
	        	custModel = null;
	            System.out.println("Hello" + e);
	        }
  return custModel;
}
}