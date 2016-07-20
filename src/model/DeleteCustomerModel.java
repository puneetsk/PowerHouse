package model;

public class DeleteCustomerModel 
{
	String custId;
	public DeleteCustomerModel(String custId)
	{
		this.custId=custId;
	}
	public DeleteCustomerModel(){
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}

	

}
