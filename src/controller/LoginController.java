package controller;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {


@FXML 
private TextField logUN;

@FXML
private PasswordField logPW ;

@FXML
private Button logBTN;

@FXML 
private CheckBox ck1;

@FXML 
private Label logSTS ;
private static Connection connect = null;
private static Statement statement = null;
private static ResultSet resultSet = null;
String username1;
String password1;

String username2;
String password2;


public void login(ActionEvent event) throws IOException{

	  try 
  	{

Class.forName("com.mysql.jdbc.Driver");
	connect = (Connection) DriverManager.getConnection("jdbc:mysql://www.papademas.net/mydb?" + "user=dbuser&password=db1");	      	
	      	Statement st=null;
	      	st=(Statement) connect.createStatement();
	      	String queryadmin ="select uname, passw from mydb.plogin where uid='1'";
	      	ResultSet rs1 = st.executeQuery(queryadmin);
	      	 while (rs1.next()) 
	      	 {
	            username1 = rs1.getString("uname");	           
	            password1= rs1.getString("passw");
	      	 }
	      	String querytrainer ="select uname, passw from mydb.plogin where uid='2'";
	      	ResultSet rs2 = st.executeQuery(querytrainer);
	      	 while (rs2.next()) {
	            username2 = rs2.getString("uname");	           
	            password2= rs2.getString("passw");
	      	 }
	      	 
	      	
	          if(logUN.getText().equals(username1) && logPW.getText().equals(password1))
	             {
	            	 logSTS.setText("Login Successful");  
		         		Stage primaryStage= new Stage();
		        		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymAdmin.fxml"));
		                AnchorPane root =(AnchorPane) loader.load();
		        		Scene scene = new Scene(root,600,500);

		        		primaryStage.setScene(scene);
		        		primaryStage.show();
		        		Stage stage = (Stage) logBTN.getScene().getWindow();
		        		stage.close();
	             }
	             else if(logUN.getText().equals(username2) && logPW.getText().equals(password2)){
		         		logSTS.setText("Login Successful");  
		         		Stage primaryStage= new Stage();
		        		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/trainers.fxml"));
		                AnchorPane root =(AnchorPane) loader.load();
		        		Scene scene = new Scene(root,600,500);
		        		primaryStage.setScene(scene);
		        		primaryStage.show();
		        		Stage stage = (Stage) logBTN.getScene().getWindow();
		        		stage.close();
		             }
	      	 
	      	 else {
       				logSTS.setText("Login Failed");
        		   }
	         }   
	      	 	
	      	catch(Exception e)
	      	{
	      		System.out.println(e.getMessage());	
	      	}
	      	}
		
}

