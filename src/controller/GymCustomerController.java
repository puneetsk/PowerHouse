package controller;

import java.io.IOException;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AddCustomerModel;
import model.DeleteCustomerModel;
import model.FormValidationModel;
import model.UpdateCustomerModel;

import model.ViewCustModel;
import dao.CustDetailDao;
import dao.ViewCustDao;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.AddCustomerDao;
import dao.DeleteCustomerDao;
import dao.UpdateCustomerDao;



public class GymCustomerController implements Initializable{
	@FXML
	private Button backbutton;
	@FXML
	private Button addCust;
	@FXML
	private Button updCust;
	@FXML
	private TextField custId;
	
	@FXML
	private TextField custName;
	
	@FXML
	private TextField custAdr;
	
	@FXML
	private TextField custAge;
	
	@FXML
	private TextField custPh;
	
	@FXML
	private TextField Ht;
	@FXML
	private TextField Wt;
	@FXML
	private ComboBox custExe;
	@FXML
	private Label lbl6;
	@FXML 
	private Button clr;
	@FXML
	private ComboBox<String> dropDown1;
	@FXML
	private Button btnok;
	
	private Stage dialogStage;
	private Stage stag = new Stage();
	@FXML
	private Button delCust;
	@FXML
	private Label custval1;
	@FXML
	private Label custval2;
	@FXML
	private Label custval3;
	@FXML
	private Label custval4;
	@FXML
	private Label custval5;
	@FXML
	private Label custval6;
	@FXML
	private Label custval7;
	@FXML
	private Label custval8;


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void back(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymAdmin.fxml"));
        AnchorPane root =(AnchorPane) loader.load();
		Scene scene1 = new Scene(root,600,500);

		primaryStage.setScene(scene1);
		primaryStage.show();
		Stage stage = (Stage) backbutton.getScene().getWindow();
		stage.close();
	}
			public void add(ActionEvent es) throws IOException
			{
		
				//Form validation 
				boolean cust1=FormValidationModel.textFieldNotEmpty(custId,custval1,"Customer Id is required");
				boolean cust2=FormValidationModel.textFieldNotEmpty(custName,custval2,"Customer name is required");
				boolean cust3=FormValidationModel.textFieldNotEmpty(custAdr,custval3,"Customer address is required");
				boolean cust4=FormValidationModel.textFieldNotEmpty(custPh,custval4,"Contact number is required");
				boolean cust5=FormValidationModel.textFieldNotEmpty(custAge,custval5,"Age is required");
				boolean cust6=FormValidationModel.textFieldNotEmpty(Ht,custval6,"Please enter height");
				boolean cust7=FormValidationModel.textFieldNotEmpty(Wt,custval7,"Please enter weight");
				
				custId.setEditable(true);
				if(cust1&&cust2&&cust3&&cust4&&cust5&&cust6&&cust7){
				String custID=this.custId.getText();
				String custName =this.custName.getText();
				String custAdr =this.custAdr.getText();
				String custAge =this.custAge.getText();
				String custPh =this.custPh.getText();
				String Ht =this.Ht.getText();
				String Wt =this.Wt.getText();
				
				AddCustomerModel addcustModel =new AddCustomerModel();
			
				addcustModel.setCustids(custID);
				addcustModel.setCustnames(custName);
				addcustModel.setCustaddress(custAdr);
				addcustModel.setCustomerage(custAge);
				addcustModel.setPhone(custPh);
				addcustModel.setHeight(Ht);
				addcustModel.setWeight(Wt);				
				AddCustomerDao a = new AddCustomerDao();
				a.create(addcustModel);
				Stage stage=(Stage) addCust.getScene().getWindow();
				}		
}
	public void del(ActionEvent es) throws IOException
			{
				String custids= custId.getText();
				DeleteCustomerModel delcustModel =new DeleteCustomerModel();
				delcustModel.setCustId(custids);
				custId.setEditable(true);
				DeleteCustomerDao a = new DeleteCustomerDao();	
				a.delete(delcustModel);
				Stage stage=(Stage) delCust.getScene().getWindow();
				custId.setText("");
				custName.setText("");
				custAdr.setText("");
				custAge.setText("");
				custPh.setText("");
				Ht.setText("");
				Wt.setText("");
				
			}
				
			public void initialize(URL url, ResourceBundle rb)
			{
				ViewCustDao db = new ViewCustDao();
				ArrayList<String> ar = db.setCustID();
				ObservableList<String> options = (ObservableList<String>) FXCollections.observableArrayList(ar);
				dropDown1.setItems(options);
				System.out.println(options);
				custId.setEditable(true);
			}

			public void showCustDetails() 
			{
				try {
					String dropDown = this.dropDown1.getValue();
					ViewCustModel ViewProfModel = new ViewCustModel();
					custId.setEditable(false);
					ViewProfModel.setCustID(dropDown);
					CustDetailDao db = new CustDetailDao();
					String[] x = db.prof(dropDown);					
					custId.setText(x[0]);
					custName.setText(x[1]);
					custAdr.setText(x[2]);
					custPh.setText(x[3]);
					Ht.setText(x[4]);
					Wt.setText(x[5]);
					custAge.setText(x[6]);		
					
				} 
				catch (Exception e) 
				{
				System.out.println(e + "");				
				}
				}
		
			public void updateCustDetails() 
			{
				String custID=this.custId.getText();
				String custName =this.custName.getText();
				String custAdr =this.custAdr.getText();
				String custAge =this.custAge.getText();
				String custPh =this.custPh.getText();
				String Ht =this.Ht.getText();
				String Wt =this.Wt.getText();
				
				UpdateCustomerModel UpdateCustomerModel =new UpdateCustomerModel();
			
				UpdateCustomerModel.setCustids(custID);
				UpdateCustomerModel.setCustnames(custName);
				UpdateCustomerModel.setCustaddress(custAdr);
				UpdateCustomerModel.setCustomerage(custAge);
				UpdateCustomerModel.setPhone(custPh);
				UpdateCustomerModel.setHeight(Ht);
				UpdateCustomerModel.setWeight(Wt);				
				UpdateCustomerDao a = new UpdateCustomerDao();
				a.update(UpdateCustomerModel);
				Stage stage=(Stage) updCust.getScene().getWindow();
			    lbl6.setVisible(true);
				lbl6.setText("Data Updated");			
			}
			
			public void clear()
			{				
				custId.setText("");
				custName.setText("");
				custAdr.setText("");
				custAge.setText("");
				custPh.setText("");
				Ht.setText("");
				Wt.setText("");
			}
			
	}