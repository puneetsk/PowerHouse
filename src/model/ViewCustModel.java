package model;

public class ViewCustModel 
{
	private String CustID;
	private String CustName;
	private String CustAddress;
	private String CustPhn;
	private String CustHeight;
	private String CustWeight;
	private String CustAge;
	
	
	public ViewCustModel()
	{
		
	}
	public ViewCustModel(String CustID, String CustName,  String CustAddress, String CustPhn, String CustHeight, String CustWeight,String CustAge)
	{
		
	}
	public String getCustID() {
		return CustID;
	}
	public void setCustID(String custID) {
		CustID = custID;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}
	public String getCustPhn() {
		return CustPhn;
	}
	public void setCustPhn(String custPhn) {
		CustPhn = custPhn;
	}
	public String getCustHeight() {
		return CustHeight;
	}
	public void setCustHeight(String custHeight) {
		CustHeight = custHeight;
	}
	public String getCustWeight() {
		return CustWeight;
	}
	public void setCustWeight(String custWeight) {
		CustWeight = custWeight;
	}
	public String getCustAge() {
		return CustAge;
	}
	public void setCustAge(String custAge) {
		CustAge = custAge;
	}
}
