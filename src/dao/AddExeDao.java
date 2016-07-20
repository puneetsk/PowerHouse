package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*import java.sql.ResultSet;*/
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AddExeModel;



public class AddExeDao {
 
 //Connection object
 private Connection connection;
/* private ResultSet resultset;
 private Statement statement;*/
 
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public AddExeModel create (AddExeModel exeModel) {
 
  try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Cannot connect to database: " + e);
      System.exit(-1);
   }
  
  
String query="INSERT INTO pkolatha_exercise (exeid, exename, exeprogram) VALUES (?,?,?)";
  
  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
  {
	            statement.setString(1, exeModel.getExeid());
	            statement.setString(2, exeModel.getExename());
	            statement.setString(3, exeModel.getExeprogram());
	            statement.executeUpdate();	            
	            Alert alert = new Alert(AlertType.INFORMATION);
	      	  
	            alert.setTitle("Information Dialog");
	      	  	alert.setHeaderText("Added");
	      	  	alert.setContentText("The user has been Added");
	      	  	alert.showAndWait();	    
	                    
	           }
	    
 			catch(SQLException e){
	        	exeModel = null;
	            System.out.println("Catch the Error here" + e);
	        }
  return exeModel;
}
}