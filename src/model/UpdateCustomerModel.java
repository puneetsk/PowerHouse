package model;

public class UpdateCustomerModel 
{
	
		String custids;
		String custnames;
		String custaddress;
		String customerage;
		String height;
		String weight;
		String phone;

	public UpdateCustomerModel(String custids, String custnames, String custaddress, String customerage, String height, String weight, String phone) {
	this.custids = custids;
	this.custnames = custnames;
	this.custaddress = custaddress;
	this.customerage = customerage;
	this.height = height;
	this.weight = weight;
	this.phone=phone;
	}
	public UpdateCustomerModel(){
	}

	public String getCustids() {
		return custids;
	}

	public void setCustids(String custids) {
		this.custids = custids;
	}

	public String getCustnames() {
		return custnames;
	}

	public void setCustnames(String custnames) {
		this.custnames = custnames;
	}

	public String getCustaddress() {
		return custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public String getCustomerage() {
		return customerage;
	}

	public void setCustomerage(String customerage) {
		this.customerage = customerage;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	}
	



