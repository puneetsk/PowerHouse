package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.DeleteNutModel;

public class DeleteNutDao { 
 
 private Connection connection;

 
private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
private String username = "dbuser";
private String password = "db1";
    

 public DeleteNutModel delete (DeleteNutModel nutModel) 
 {
	 try {
        connection = DriverManager.getConnection(url, username, password);
         }
  catch(SQLException e)
  {
      System.out.println("Cannot Connect " + e);
      System.exit(-1);
   }
	 
	 String query="delete from pkolatha_nutrition where nutid=?";  
	 try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
	 {
	  statement.setString(1, nutModel.getNutid());
	  statement.executeUpdate();	  
	  Alert alert = new Alert(AlertType.INFORMATION);	  
	  alert.setTitle("Information Dialog");
	  alert.setHeaderText("Delete");
	  alert.setContentText("The Nutrition has been Deleted");
	  alert.showAndWait();	  
	  }
	 
	 	   catch(SQLException e)
	 	{
		 	nutModel = null;
		 	System.out.println("Place to catch the Error" + e);
	 	}
	 	   return nutModel;
}
}