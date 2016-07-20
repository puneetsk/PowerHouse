package model;

public class DeleteExeModel 
{
	String exeid;
	
	public DeleteExeModel(String exeid)
	{
		this.exeid= exeid;
	}
	public DeleteExeModel(){
	}
	public String getExeid() {
		return exeid;
	}
	public void setExeid(String exeid) {
		this.exeid = exeid;
	}
}