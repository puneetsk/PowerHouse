package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ViewCustModel;
import java.util.ArrayList;



public class CustDetailDao 
{
		
		public ArrayList<String> setCustID() {
			// TODO Auto-generated method stub
			return null;
		}
		private Connection connection;
		 //Database connection parameters
		    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
		    private String username = "dbuser";
		    private String password = "db1";
		    
		  
		public String[] prof(String Custid) throws SQLException{
			
			ResultSet rs;
			String a = "",b="",c="",d="",e="",f="",g="";
			try
			{
				connection = DriverManager.getConnection(url, username, password);
			} 
			catch (SQLException e1) 
			{
				System.out.println("Error creating connection to database: " + e);
				System.exit(-1);
			}
			String query = "select cid,cname,caddress,cph,cheight,cweight,cage from pcustomer where cid=? ";
			
			
			
			try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				// Set the parameters to the query
				// Execute the insert
				statement.setString(1,Custid );
				rs=statement.executeQuery();
				
				
				
				while(rs.next())
				{
					rs.getString(1);
					rs.getString(2);
					rs.getString(3);
					rs.getString(4);
					rs.getString(5);
					rs.getString(6);
					rs.getString(7);
				//System.out.println(rs.getString(1));
				ViewCustModel ViewCustModel = new ViewCustModel();
				ViewCustModel.setCustID(rs.getString(1));
				ViewCustModel.setCustName(rs.getString(2));
				ViewCustModel.setCustAddress(rs.getString(3));
				ViewCustModel.setCustPhn (rs.getString(4));
				ViewCustModel.setCustHeight(rs.getString(5));
				ViewCustModel.setCustWeight(rs.getString(6));
				ViewCustModel.setCustAge(rs.getString(7));
				
				
				a = rs.getString(1);
				b = rs.getString(2);
				c = rs.getString(3);
				d = rs.getString(4);
				e = rs.getString(5);
				f = rs.getString(6);
				g = rs.getString(7);
				}

			} catch (SQLException e1) {
				
				System.out.println("Error creating cs: " + e1);
			}

			// Close the connection to the database - Very important!!!
			try {
				connection.close();
				connection = null;
			} catch (SQLException e1) {
				System.out.println("Error closing connection: " + e1);
			}

			return (new String[]{a, b, c, d, e, f,g});
		}

	}





