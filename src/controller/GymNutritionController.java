package controller;

import java.io.IOException;

import dao.AddExeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import model.AddNutModel;
import model.DeleteExeModel;
import model.DeleteNutModel;
import dao.AddNutDao;
import dao.DeleteExeDao;
import dao.DeleteNutDao;
public class GymNutritionController {
	@FXML
	private Button backbutton;
	
	@FXML
	private Button addNut;
	
	@FXML 
	private Button delNut;
	
	@FXML
	private TextField nutname;
	
	@FXML
	private TextField nutid;
	
	@FXML
	private TextField nuttype;

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
	
	public void add(ActionEvent event)throws IOException
	{
		String nutname=this.nutname.getText();
		String nutid =this.nutid.getText();
		String nuttype =this.nuttype.getText();			
		AddNutModel addnutModel =new AddNutModel();		
		addnutModel.setNutname(nutname);
		addnutModel.setNutid(nutid);
		addnutModel.setNuttype(nuttype);					
		AddNutDao nutdao = new AddNutDao();
		nutdao.create(addnutModel);
		Stage stage=(Stage) addNut.getScene().getWindow();		
		
	}
	
	public void delete(ActionEvent event)throws IOException
	{
		String nutids= nutid.getText();
		DeleteNutModel delexeModel =new DeleteNutModel();
		delexeModel.setNutid(nutids);		
		DeleteNutDao delexe = new DeleteNutDao();
		delexe.delete(delexeModel);
		Stage stage=(Stage) delNut.getScene().getWindow();	
		
		nutid.setText("");
		nutname.setText("");
		nuttype.setText("");
	}
	
	
	
	
	
}