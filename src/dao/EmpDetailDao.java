package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ViewEmpModel;
import java.util.ArrayList;



public class EmpDetailDao 
{
		
		public ArrayList<String> setEmpid() {		
			return null;
		}
		private Connection connection;
		
		    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
		    private String username = "dbuser";
		    private String password = "db1";
		
		  
		public String[] employee(String Empid) throws SQLException{
			
			ResultSet resultset;
			String p1= "", p2="", p3="", p4="", p5="", p6="";
			try
			{
				connection = DriverManager.getConnection(url, username, password);
			} 
			catch (SQLException ex) 
			{
				System.out.println("Error: " + ex);
				System.exit(-1);
			}
			String query = "select empid, ename, etype, ephone, eaddr, esal from pkolatha_employees where empid=?";
			try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) 
			{
				statement.setString(1,Empid );
				resultset=statement.executeQuery();				
				while(resultset.next())
				{
					resultset.getString(1);
					resultset.getString(2);
					resultset.getString(3);
					resultset.getString(4);
					resultset.getString(5);
					resultset.getString(6);					
			
				ViewEmpModel vem = new ViewEmpModel();
				vem.setEmpid(resultset.getString(1));
				vem.setEname(resultset.getString(2));
				vem.setEtype(resultset.getString(3));
				vem.setEphone(resultset.getString(4));
				vem.setEaddr(resultset.getString(5));
				vem.setEsal(resultset.getString(6));				
				
				p1 = resultset.getString(1);
				p2 = resultset.getString(2);
				p3 = resultset.getString(3);
				p4 = resultset.getString(4);
				p5 = resultset.getString(5);
				p6 = resultset.getString(6);
				
				}

			} catch (SQLException e1) {
				
				System.out.println("Error creating cs: " + e1);
			}

			
			try {
				connection.close();
				connection = null;
			} catch (SQLException e1) {
				System.out.println("Error closing connection: " + e1);
			}

			return (new String[]{p1,p2,p3,p4,p5,p6});
		}
	}





