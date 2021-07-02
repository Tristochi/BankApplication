/*
	Transaction Number Static INT
	Customer Number - Float - 5 digits
	Account Number - Float - 7 Digits
	Transaction Type - Char - W = withdrawal
							- D = Deposit
							- B = Balance
	Transaction Date - Date - Sys Date/Timestamp
	Transaction Amount - Float - Actual Amount ($0 for Checking Bal)
	

*/

package BankApplicationPkg;


public class Transaction {
	private int transNum;
	private float custNbr;
	private float acctNbr;
	private char transactionType;
	private String transactionDate;
	private float transactionAmt;
	
	Account custAcct;
	
	public Transaction() {
		transNum = 0;
		custNbr = 0f;
		acctNbr = 0f;
		transactionType = '*';
		transactionDate = "01/01/1900";
		transactionAmt = 0.00f; 
	}
	
	public Transaction(int transNum, float custNbr, float acctNbr, char transactionType, String transactionDate, float transactionAmt) {
		this.transNum = transNum;
		this.custNbr = custNbr;
		this.acctNbr = acctNbr;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmt = transactionAmt;
	}
	
	public void setTransNum(int transNum) {
		this.transNum = transNum;
	}
	
	public void setCustNbr(float custNbr) {
		this.custNbr = custNbr;
	}
	
	public void setAcctNbr(float acctNbr) {
		this.acctNbr = acctNbr;
	}
	
	public void setTransType(char transactionType) {
		this.transactionType = transactionType;
	}
	
	public void setTransDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public void setTransAmt(float transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	
	public int getTransNum() {
		return transNum;
	}
	
	public float getCustNbr() {
		return custNbr;
	}
	
	public float getAcctNbr() {
		return acctNbr;
	}
	
	public char getTransType() {
		return transactionType;
	}
	
	public String getTransDate() {
		return transactionDate;
	}
	
	public float getTransAmt() {
		return transactionAmt;
	}
	
}

