package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import model.AddCustomerModel;
import model.UpdateCustomerModel;
public class UpdateCustomerDao 
{

	private Connection connection;
	private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
	private String username = "dbuser";
	private String password = "db1";
	public UpdateCustomerModel update (UpdateCustomerModel custModel) {	 
	 try {
		 connection = DriverManager.getConnection(url, username, password);
	      }
	  catch(SQLException e)
	  {
	      System.out.println("Connection Error: " + e);
	      System.exit(-1);
	   }
	  

	String query="update pcustomer set cname=? ,caddress=?,cph=?,cheight=?,cweight=?,cage=? where cid=?";
	  
	  try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
		   
		            
		            statement.setString(1, custModel.getCustnames());
		            statement.setString(2, custModel.getCustaddress());
		            statement.setString(3, custModel.getPhone());
		            statement.setString(4, custModel.getHeight());
		            statement.setString(5, custModel.getWeight());
		            statement.setString(6, custModel.getCustomerage());
		            statement.setString(7, custModel.getCustids());
		            //Execute the insert
		            statement.executeUpdate();
		            
		            System.out.println(statement.getUpdateCount());
		          		           
		           }		    
	  catch(SQLException e)
	  {
		  custModel = null;
		  System.out.println("Hello" + e);
	  }
	  return custModel;
	}
	}

