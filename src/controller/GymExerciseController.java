package controller;

import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import model.AddExeModel;
import model.DeleteEmpModel;
import model.DeleteExeModel;
import dao.AddExeDao;
import dao.DeleteEmpDao;
import dao.DeleteExeDao;

public class GymExerciseController {
	
	@FXML
	private Button backbutton;
	
	@FXML
	private TextField txtexeid;
	
	@FXML
	private TextField txtexename;
	
	@FXML
	private TextField txtexeprogram;
	
	@FXML
	private Button addExe;
	
	@FXML
	private Button updExe;
	
	@FXML
	private Button delExe;
	
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
			String exeid=this.txtexeid.getText();
			String exename =this.txtexename.getText();
			String exeprogram =this.txtexeprogram.getText();			
			AddExeModel addexeModel =new AddExeModel();		
			addexeModel.setExeid(exeid);
			addexeModel.setExename(exename);
			addexeModel.setExeprogram(exeprogram);					
			AddExeDao exedao = new AddExeDao();
			exedao.create(addexeModel);
			Stage stage=(Stage) addExe.getScene().getWindow();			
		}
	
	public void delete(ActionEvent event) throws IOException
	{
		String exeid= txtexeid.getText();
		DeleteExeModel delexeModel =new DeleteExeModel();
		delexeModel.setExeid(exeid);		
		DeleteExeDao delexe = new DeleteExeDao();
		delexe.delete(delexeModel);
		Stage stage=(Stage) delExe.getScene().getWindow();	
		
		txtexeid.setText("");
		txtexename.setText("");
		txtexeprogram.setText("");
		
		
	}
	}
