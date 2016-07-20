package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GymAdminController {
	@FXML
	private Button admCust;
	@FXML
	private Button admEmp;
	@FXML
	private Button admEqp;
	@FXML
	private Button admExe;
	@FXML
	private Button admNut;
	
	public void customer(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymCustomer.fxml"));
        AnchorPane root =(AnchorPane) loader.load();
		Scene scene1 = new Scene(root,800,500);
		primaryStage.setScene(scene1);
		primaryStage.show();
		Stage stage = (Stage) admCust.getScene().getWindow();
		stage.close();
		

}
	public void employee(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymEmployee.fxml"));
        AnchorPane root =(AnchorPane) loader.load();
		Scene scene = new Scene(root,600,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) admEmp.getScene().getWindow();
	    stage.close();
	}
	public void exercise(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymExercise.fxml"));
        AnchorPane root =(AnchorPane) loader.load();
		Scene scene = new Scene(root,600,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) admExe.getScene().getWindow();
			stage.close();
	}
	public void equipment(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymEquipment.fxml"));
        AnchorPane root =(AnchorPane) loader.load();
		Scene scene = new Scene(root,600,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) admEqp.getScene().getWindow();
			stage.close();
	}
	public void nutrition(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/GymNutrition.fxml"));
        AnchorPane root =(AnchorPane) loader.load();
		Scene scene = new Scene(root,600,500);

		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) admNut.getScene().getWindow();
			stage.close();
	}
}