package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewCustDao 
{
	
		private Connection connection;
		 //Database connection parameters
		    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
		    private String username = "dbuser";
		    private String password = "db1";
		    public ArrayList<String> setCustID(){
			
			ArrayList<String> id = new ArrayList<String>();
			ResultSet rs;
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("Error creating connection to database: " + e);
				System.exit(-1);
			}
			String query = "select cid from pcustomer ";
			
			try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
			{
				
				// Set the parameters to the query
				// Execute the insert
				rs=statement.executeQuery();				
				while(rs.next())
				{
					id.add(rs.getString(1));

				}

			} catch (SQLException e) {
				
				System.out.println("Error creating cs: " + e);
			}

		
			try {
				connection.close();
				connection = null;
			} 
			catch (SQLException e) 
			{
				System.out.println("Error closing connection: " + e);
			}

			return id;
		
		}
	}




