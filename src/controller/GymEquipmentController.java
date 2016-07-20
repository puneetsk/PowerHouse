package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.AddEqpDao;
import dao.DeleteEqpDao;
import dao.DeleteExeDao;
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
import model.AddEqpModel;
import model.DeleteEqpModel;
import model.DeleteExeModel;


public class GymEquipmentController
{
	@FXML
	private Button backbutton;
	
	@FXML
	private TextField eqpName;
	
	@FXML
	private TextField eqpId;
	
	@FXML 
	private TextField eqpMtd;
	
	@FXML
	private Button addEqp;
	
	@FXML
	private Button delEqp;

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
	
	public void add(ActionEvent event) throws IOException
	{

		String eqpname=this.eqpName.getText();
		String eqpid =this.eqpId.getText();
		String main =this.eqpMtd.getText();			
		AddEqpModel addeqpModel =new AddEqpModel();		
		addeqpModel.setEqpname(eqpname);
		addeqpModel.setEqpid(eqpid);
		addeqpModel.setMain(main);					
		AddEqpDao eqpdao = new AddEqpDao();
		eqpdao.create(addeqpModel);
		Stage stage=(Stage) addEqp.getScene().getWindow();			
	}
	
	
	public void delete(ActionEvent event) throws IOException
	{
		String eqpidd= eqpId.getText();
		DeleteEqpModel delexeModel =new DeleteEqpModel();
		delexeModel.setEqpid(eqpidd);		
		DeleteEqpDao delexe = new DeleteEqpDao();
		delexe.delete(delexeModel);
		Stage stage=(Stage) delEqp.getScene().getWindow();	
		
		eqpName.setText("");
		eqpId.setText("");
		eqpMtd.setText("");
		
	}
	
}