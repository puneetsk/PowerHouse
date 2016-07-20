package model;

public class AddExeModel {

	String exeid;
	String exename;
	String exeprogram;


public AddExeModel(String exeid, String exename, String exeprogram)
{
this.exeid=exeid;
this.exename=exename;
this.exeprogram=exeprogram;

}

public AddExeModel()
{
	
}


public String getExeid() {
	return exeid;
}


public void setExeid(String exeid) {
	this.exeid = exeid;
}


public String getExename() {
	return exename;
}


public void setExename(String exename) {
	this.exename = exename;
}


public String getExeprogram() {
	return exeprogram;
}


public void setExeprogram(String exeprogram) {
	this.exeprogram = exeprogram;
}
}