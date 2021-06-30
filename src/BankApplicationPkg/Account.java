/*
 * Account Number - Number - 7 Digits (last 2 digits match account type
 * 							prefixed with a 0
 * Account Type - Number - 1 digit (1 - checking, 2 - savings)
 * Open Date - Date - MM-DD-YY
 * Balance - Float 
 * Customer ID - Number - 5 digits
 */
package BankApplicationPkg;


public class Account {
	private int acctNbr;
	private int acctType;
	private float balance;
	private int customerID;
	private String openDate;
	
	public Account() {
		acctNbr = 0;
		acctType = 2;
		balance = 0.00f;
		customerID = 0;
		openDate = "01/01/1900";
	}
	
	public void setAcctNbr(int acctNbr) {
		this.acctNbr = acctNbr;
	}
	
	public void setAcctType(int acctType) {
		this.acctType = acctType;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void setCustomerId(int customerID) {
		this.customerID = customerID;
	}
	
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	
	public int getAcctNbr() {
		return acctNbr;
	}
	
	public int getAcctType() {
		return acctType;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public String getOpenDate() {
		return openDate;
	}

}
