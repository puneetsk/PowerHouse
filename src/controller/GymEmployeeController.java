package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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


import model.ViewEmpModel;
import model.AddEmpModel;
import model.DeleteEmpModel;
import model.UpdateCustomerModel;
import model.UpdateEmpModel;
import dao.AddEmpDao;
import dao.DeleteEmpDao;
import dao.EmpDetailDao;

import dao.UpdateEmpDao;
import dao.ViewEmpDao;
import model.FormValidationModel;
public class GymEmployeeController implements Initializable {
	@FXML
	private Button backbutton;
	
	@FXML
	private Button addEmp;
	
	@FXML
	private Button updEmp;
	
	@FXML
	private Button delEmp;
	
	@FXML
	private ComboBox<String> dropDown2;
	
	@FXML	
	private TextField txtempid;
	
	@FXML
	private TextField txtempName;
	
	@FXML
	private TextField txtempTy;
	
	@FXML
	private TextField txtempPh;
	
	@FXML
	private TextField txtempAdr;
	
	@FXML
	private TextField txtempSal;
	
	@FXML
	private Button btnok;
	
	@FXML
	private Label empvaltext1;
	
	@FXML
	private Label empvaltext2;
	
	@FXML
	private Label empvaltext3;
	
	@FXML
	private Label empvaltext4;
	
	@FXML
	private Label empvaltext5;
	
	@FXML
	private Label empvaltext6;
	
	@FXML
	private Label employee;

	
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
	public void addEmployee(ActionEvent events) throws IOException
	{		
		
		//Input validation
		boolean emp1=FormValidationModel.textFieldNotEmpty(txtempid,empvaltext1,"Employee Id is required");
		boolean emp2=FormValidationModel.textFieldNotEmpty(txtempName,empvaltext2,"Employee name is required");
		boolean emp3=FormValidationModel.textFieldNotEmpty(txtempTy,empvaltext3,"Employee Type is required");
		boolean emp4=FormValidationModel.textFieldNotEmpty(txtempPh,empvaltext4,"Contact number is required");
		boolean emp5=FormValidationModel.textFieldNotEmpty(txtempAdr,empvaltext5,"Address is required");
		boolean emp6=FormValidationModel.textFieldNotEmpty(txtempSal,empvaltext6,"Salary Id is required");


		if(emp1&&emp2&&emp3&&emp4&&emp5&&emp6){
		
	    String empid=this.txtempid.getText();
		String ename =this.txtempName.getText();
		String etype =this.txtempTy.getText();
		String ephone =this.txtempPh.getText();
		String eaddr =this.txtempAdr.getText();
		String esal =this.txtempSal.getText();
		
		AddEmpModel addempModel =new AddEmpModel();
	
		addempModel.setEmpid(empid);
		addempModel.setEname(ename);
		addempModel.setEtype(etype);
		addempModel.setEphone(ephone);
		addempModel.setEaddr(eaddr);
		addempModel.setEsal(esal);
				
		AddEmpDao empdao = new AddEmpDao();
		empdao.create(addempModel);
		Stage stage=(Stage) addEmp.getScene().getWindow();
		}
	}
	
	public void delete(ActionEvent event) throws IOException
	{	
		String empid= txtempid.getText();
		DeleteEmpModel delempModel =new DeleteEmpModel();
		delempModel.setEmpid(empid);		
		DeleteEmpDao delempo = new DeleteEmpDao();
		delempo.delete(delempModel);
		Stage stage=(Stage) delEmp.getScene().getWindow();	
		
		txtempid.setText("");
		txtempName.setText("");
		txtempPh.setText("");
		txtempAdr.setText("");
		txtempSal.setText("");
		txtempTy.setText("");
	}
	
	public void update(ActionEvent event) throws IOException
	{
		String empid=this.txtempid.getText();
		String ename =this.txtempName.getText();
		String etype =this.txtempTy.getText();
		String ephone =this.txtempPh.getText();
		String eaddr =this.txtempAdr.getText();
		String esal =this.txtempSal.getText();
		
		
		UpdateEmpModel UpdateEmpsModel = new UpdateEmpModel();
	
		UpdateEmpsModel.setEmpid(empid);
		UpdateEmpsModel.setEname(ename);
		UpdateEmpsModel.setEtype(etype);
		UpdateEmpsModel.setEphone(ephone);
		UpdateEmpsModel.setEaddr(eaddr);
		UpdateEmpsModel.setEsal(esal);
					
		UpdateEmpDao a = new UpdateEmpDao();
		a.update(UpdateEmpsModel);
		Stage stage=(Stage) updEmp.getScene().getWindow();
	   
	}
	
	
	
	public void showempdetails(ActionEvent event) throws IOException
	{
		try {
			String dropDown = this.dropDown2.getValue();
			ViewEmpModel ViewEmpModel = new ViewEmpModel();
			
			ViewEmpModel.setEmpid(dropDown);
			EmpDetailDao db = new EmpDetailDao();
			String[] x = db.employee(dropDown);					
			txtempid.setText(x[0]);
			txtempName.setText(x[1]);
			txtempTy.setText(x[2]);
			txtempPh.setText(x[3]);
			txtempAdr.setText(x[4]);
			txtempSal.setText(x[5]);
						
		} 
		catch (Exception e) 
		{
		System.out.println(e + "");				
		}
		}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ViewEmpDao db = new ViewEmpDao();
	ArrayList<String> ar = db.setEmpid();
	ObservableList<String> options = (ObservableList<String>) FXCollections.observableArrayList(ar);
	dropDown2.setItems(options);
	System.out.println(options);
	
}
		
	}
	
