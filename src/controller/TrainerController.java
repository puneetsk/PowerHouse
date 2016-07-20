package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.ViewCustModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.CustDetailDao;
import dao.ViewCustDao;

public class TrainerController extends GymCustomerController implements Initializable {
	
	@FXML
	private TextField custId;
	@FXML
	private TextField custName;
	@FXML
	private TextField custAge;
	@FXML
	private TextField Ht;
	@FXML
	private TextField Wt;
	@FXML 
	private ComboBox <String> dropdown3;
	
	public void initialize(URL url, ResourceBundle rb)
	{
		ViewCustDao db = new ViewCustDao();
		ArrayList<String> ar = db.setCustID();
		ObservableList<String> options = (ObservableList<String>) FXCollections.observableArrayList(ar);
		dropdown3.setItems(options);
		System.out.println(options);
		custId.setEditable(true);
	}
	
	/*@Override	
	public void showCustDetails()
	{
		
	}*/
/*	
   public TrainerController(){
   this.custName=custName;
   this.custAge=custAge;
   this.Ht=Ht;
   this.Wt=Wt;
   this.dropdown3=dropdown3;
   this.showCustDetails();*/


   public void ok(ActionEvent event) throws IOException
   {
	   
	   this.showCustDetails();
   }	

}
