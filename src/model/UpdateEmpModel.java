package model;

public class UpdateEmpModel {

	String empid;
	String ename;
	String etype;
	String ephone;
	String eaddr;
	String esal;
	
	
	
	public UpdateEmpModel(String empid, String ename, String etype, String ephone, String eaddr, String esal) 
	{
		this.empid = empid;
		this.ename = ename;
		this.etype = etype;
		this.ephone = ephone;
		this.eaddr = eaddr;
		this.esal = esal;	
	}
	public UpdateEmpModel(){
	}

	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEtype() {
		return etype;
	}


	public void setEtype(String etype) {
		this.etype = etype;
	}


	public String getEphone() {
		return ephone;
	}


	public void setEphone(String ephone) {
		this.ephone = ephone;
	}


	public String getEaddr() {
		return eaddr;
	}


	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}


	public String getEsal() {
		return esal;
	}


	public void setEsal(String esal) {
		this.esal = esal;
	}
}
