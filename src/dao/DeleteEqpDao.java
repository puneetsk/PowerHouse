package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.DeleteEqpModel;

public class DeleteEqpDao { 
 
 private Connection connection;

 
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public DeleteEqpModel delete (DeleteEqpModel eqpModel) 
 {
	 try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Cannot Connect " + e);
      System.exit(-1);
   }
	 
	 String query="delete from pkolatha_equipment where eqpid=?";  
	 try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
	 {
	  statement.setString(1, eqpModel.getEqpid());
	  statement.executeUpdate();	  
	  Alert alert = new Alert(AlertType.INFORMATION);	  
	  alert.setTitle("Information Dialog");
	  alert.setHeaderText("Delete");
	  alert.setContentText("The Equipment has been Deleted");
	  alert.showAndWait();	  
	  }
	 
	 catch(SQLException e)
	 {
		 eqpModel = null;
		 System.out.println("Place to catch the Error" + e);
	 }
	 return eqpModel;
}
}