package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import model.AddEmpModel;
import model.UpdateEmpModel;

public class UpdateEmpDao 
{

	private Connection connection;
	private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
	private String username = "dbuser";
	private String password = "db1";
	public UpdateEmpModel update (UpdateEmpModel empModel) {	 
	 try {
		 connection = DriverManager.getConnection(url, username, password);
	      }
	  catch(SQLException e)
	  {
	      System.out.println("Connection Error: " + e);
	      System.exit(-1);
	   }
	  
	
	String query="update pkolatha_employees set empid=? ,ename=?,etype=?,ephone=?,eaddr=?,esal=? where empid=?";
	  
	  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
		 
		            
		            statement.setString(1, empModel.getEmpid());
		            statement.setString(2, empModel.getEname());
		            statement.setString(3, empModel.getEtype());
		            statement.setString(4, empModel.getEphone());
		            statement.setString(5, empModel.getEaddr());
		            statement.setString(6, empModel.getEsal());
		            statement.setString(7, empModel.getEmpid());
		            //Execute the insert
		            statement.executeUpdate();
		            Alert alert = new Alert(AlertType.INFORMATION);	  
		      	  	alert.setTitle("Information Dialog");
		      	  	alert.setHeaderText("Update");
		      	  	alert.setContentText("The user has been Updated");
		      	  	alert.showAndWait();	  
		            System.out.println(statement.getUpdateCount());
		         	           
		           }		    
	  catch(SQLException e)
	  {
		  empModel = null;
		  System.out.println("Hello" + e);
	  }
	  return empModel;
		}
	}

