package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*import java.sql.ResultSet;*/
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AddEmpModel;


public class AddEmpDao {
 

 private Connection connection;

private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public AddEmpModel create (AddEmpModel empModel) {
 
  try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Cannot connect to database: " + e);
      System.exit(-1);
   }
  
  
String query="INSERT INTO pkolatha_employees (empid, ename, etype, ephone, eaddr, esal) VALUES (?,?,?,?,?,?)";
  
  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
  {
	            statement.setString(1, empModel.getEmpid());
	            statement.setString(2, empModel.getEname());
	            statement.setString(3, empModel.getEtype());
	            statement.setString(4, empModel.getEphone());
	            statement.setString(5, empModel.getEaddr());
	            statement.setString(6, empModel.getEsal());
	            statement.executeUpdate();	            
	            Alert alert = new Alert(AlertType.INFORMATION);
	      	  
	            alert.setTitle("Information Dialog");
	      	  	alert.setHeaderText("Added");
	      	  	alert.setContentText("The user has been Added");
	      	  	alert.showAndWait();	    
	         	     
	           }
	    
 			catch(SQLException e){
	        	empModel = null;
	         System.out.println("Please enter the missing data");
	        }
  return empModel;
}
}