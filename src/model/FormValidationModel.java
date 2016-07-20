package model;

import javafx.scene.control.*;

public class FormValidationModel {
	public static boolean textFieldNotEmpty(TextField l){
		boolean r=false;
		if(l.getText()!=null && !l.getText().isEmpty()){
			r=true;
		}
		return r;
	}
	public static boolean textFieldNotEmpty(TextField l, Label i,String sValidationText){
		
		boolean r=true;
		String c=null;
		if(!textFieldNotEmpty(l)){
			r=false;
			c=sValidationText;
		}
		i.setText(c);
		return r;
	}

}

