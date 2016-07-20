package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AddEqpModel;

public class AddEqpDao {
 
private Connection connection;
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public AddEqpModel create (AddEqpModel eqpModel) {
 
  try {
        connection = DriverManager.getConnection(url, username, password);
      }
  
  catch(SQLException e)
  {
      System.out.println("Cannot connect to database: " + e);
      System.exit(-1);
   }  
  
String query="INSERT INTO pkolatha_equipment (eqpname, eqpid, main) VALUES (?,?,?)";
  
  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
  {
	            statement.setString(1, eqpModel.getEqpid());
	            statement.setString(2, eqpModel.getEqpname());
	            statement.setString(3, eqpModel.getMain());
	            statement.executeUpdate();	            
	            Alert alert = new Alert(AlertType.INFORMATION);
	      	  
	            alert.setTitle("Information Dialog");
	      	  	alert.setHeaderText("Added");
	      	  	alert.setContentText("The Equipment has been Added");
	      	  	alert.showAndWait();	    
	                    
	           }
	    
 			catch(SQLException e){
	        	eqpModel = null;
	            System.out.println("Catch the Error here" + e);
	        }
  return eqpModel;
}
}