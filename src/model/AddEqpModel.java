package model;

public class AddEqpModel {
	String eqpname;
	String eqpid;
	String main;
	
public AddEqpModel(String eqpname, String eqpid, String main) 
{
this.eqpname = eqpname;
this.eqpid = eqpid;
this.main = main;
}
public AddEqpModel()
{
	
}
public String getEqpname() {
	return eqpname;
}
public void setEqpname(String eqpname) {
	this.eqpname = eqpname;
}
public String getEqpid() {
	return eqpid;
}
public void setEqpid(String eqpid) {
	this.eqpid = eqpid;
}
public String getMain() {
	return main;
}
public void setMain(String main) {
	this.main = main;
}

}