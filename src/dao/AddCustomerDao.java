package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*import java.sql.ResultSet;*/
import java.sql.SQLException;
import java.sql.Statement;

import model.AddCustomerModel;


public class AddCustomerDao {
 

 private Connection connection;

 
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public AddCustomerModel create (AddCustomerModel custModel) {
 
  try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Error creating connection to database: " + e);
      System.exit(-1);
   }
  

String query="INSERT INTO pcustomer (cid, cname, caddress,cph,cheight,cweight,cage) VALUES (?,?,?,?,?,?,?)";
  
  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

	            statement.setString(1, custModel.getCustids());
	            statement.setString(2, custModel.getCustnames());
	            statement.setString(3, custModel.getCustaddress());
	            statement.setString(4, custModel.getCustomerage());
	            statement.setString(5, custModel.getHeight());
	            statement.setString(6, custModel.getWeight());
	            statement.setString(7, custModel.getPhone());
	            //Execute the insert
	            statement.executeUpdate();
	            
	     
	           }
	    
 			catch(SQLException e){
	        	custModel = null;
	            System.out.println("Hello" + e);
	        }
  return custModel;
}
}