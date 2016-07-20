package model;

public class AddNutModel {

	String nutname;
	String nutid;
	String nuttype;


public AddNutModel(String nutname, String nutid, String nuttype)
{
this.nutname=nutname;
this.nutid=nutid;
this.nuttype=nuttype;

}

public AddNutModel()
{
	
}

public String getNutname() {
	return nutname;
}

public void setNutname(String nutname) {
	this.nutname = nutname;
}

public String getNutid() {
	return nutid;
}

public void setNutid(String nutid) {
	this.nutid = nutid;
}

public String getNuttype() {
	return nuttype;
}

public void setNuttype(String nuttype) {
	this.nuttype = nuttype;
}



}