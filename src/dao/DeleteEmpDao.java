package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.DeleteEmpModel;

public class DeleteEmpDao { 
 
 private Connection connection;

 
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public DeleteEmpModel delete (DeleteEmpModel empModel) 
 {
	 try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Cannot Connect " + e);
      System.exit(-1);
   }
	 
	 String query="delete from pkolatha_employees where empid=?";  
	 try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
	 {
	  statement.setString(1, empModel.getEmpid());
	  statement.executeUpdate();	  
	  Alert alert = new Alert(AlertType.INFORMATION);	  
	  alert.setTitle("Information Dialog");
	  alert.setHeaderText("Delete");
	  alert.setContentText("The user has been Deleted");
	  alert.showAndWait();	  
	  }
	 
	 catch(SQLException e)
	 {
	 empModel = null;
	 System.out.println("Place to catch the Error" + e);
	  }
	 return empModel;
}
}