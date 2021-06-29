/*
 * Customer ID - Integer - 5 digits
 * Customer PIN - Integer - 4 Digits
 * Customer Name - String
 * Customer Email - String
 * Customer Phone - String
 * Customer Address - String
 */

package BankApplicationPkg;

public class Customer {
	private int customerID;
	private int pin;
	private String custName;
	private String custEmail;
	private String custPhone;
	private String custAddress;
	
	public Customer() {
		customerID = 0;
		pin = 0;
		custName = "";
		custEmail = "";
		custPhone = "";
		custAddress = "";
	}
	public Customer(int customerID, int pin, String custName, String custEmail, String custPhone, String custAddress) {
		this.customerID = customerID;
		this.pin = pin;
		this.custAddress  = custAddress;
		this.custEmail = custEmail;
		this.custPhone = custPhone;
		this.custAddress = custAddress;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID; 
	}
	
	public void setCustomerEmail(String custEmail) {
		this.custEmail= custEmail;
	}
	
	public void setCustomerPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	public void setCustomerAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	public int getCustID() {
		return customerID;
	}
	
	public int getPin() {
		return pin;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public String getCustEmail() {
		return custEmail;
	}
	
	public String getCustPhone() {
		return custPhone;
	}
	
	public String getCustAddress() {
		return custAddress;
	}
	

}
