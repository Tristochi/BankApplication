/*
 * Account Number - Number - 7 Digits (last 2 digits match account type
 * 							prefixed with a 0
 * Account Type - Number - 1 digit (1 - checking, 2 - savings)
 * Open Date - Date - MM-DD-YY
 * Balance - Float 
 * Customer ID - Number - 5 digits
 * 
 */
package BankApplicationPkg;
import java.util.*;
import java.io.*;

public class Account {
	private int acctNbr;
	private int acctType;
	private float balance;
	private int customerID;
	private String openDate;
	
	Customer cust1;
	Scanner scnr;
	ArrayList<Transaction> transHistory;
	Transaction someTrans;
	
	
	
	public Account() {
		acctNbr = 0;
		acctType = 2;
		balance = 0.00f;
		customerID = 0;
		openDate = "01/01/1900";
		
		scnr = new Scanner(System.in);
		transHistory = new ArrayList<Transaction>();
		
	}
	// Create a test customer in system
	void loadCustomers(Customer[] clients, int totalClients) throws FileNotFoundException{
		//Create a file for customer data
		FileReader file = new FileReader("customers.dat");
		Scanner reader = new Scanner(file);
		
		//Variables for parsing file
		int i = 0;
		int customerID = 0;
		int pin = 0;
		String custName = "";
		String custEmail = "";
		String custPhone = "";
		String custAddress = "";
		
		String eachLine = " ";
		StringTokenizer str;
		
		while (reader.hasNextLine()) {
			eachLine = reader.nextLine();
			str = new StringTokenizer(eachLine, ",");
			while (str.hasMoreTokens()) {
				customerID = Integer.parseInt(str.nextToken());
				pin = Integer.parseInt(str.nextToken());
				custName = str.nextToken();
				custEmail = str.nextToken();
				custPhone = str.nextToken();
				custAddress = str.nextToken();
				
				//Store customers in array
				clients[i] = new Customer(customerID, pin, custName, custEmail, custPhone, custAddress);
				i++;
			} //end of one line
		}// end of file
		reader.close();
		
		
	}
	
	void loadTransactions(Transaction[] transList, int transListSize) throws IOException {
		//Create file for transactions 
		FileReader transFile = new FileReader("transactions.dat");
		Scanner reader = new Scanner(transFile);
		
		int i = 0;
		int transNum = 0;
		float custNbr = 0f;
		float acctNbr = 0f;
		char transactionType = '*';
		String transactionDate = " ";
		float transactionAmt = 0.00f;
		
		String eachLine = " ";
		StringTokenizer str;
		
		while(reader.hasNextLine()) {
			eachLine = reader.nextLine();
			str = new StringTokenizer(eachLine, ",");
			
			while(str.hasMoreTokens()) {
				transNum = Integer.parseInt(str.nextToken());
				custNbr = Float.parseFloat(str.nextToken());
				acctNbr = Float.parseFloat(str.nextToken());
				transactionType = (str.nextToken()).charAt(0);
				transactionDate = str.nextToken();
				transactionAmt = Float.parseFloat(str.nextToken());
			}
			transList[i] = new Transaction(transNum, custNbr, acctNbr, transactionType, transactionDate, transactionAmt);
			i++;
		}// Done reading file
		reader.close();
		System.out.println("Transaction data loaded.");
	}
	
	int login(Customer[] clients, int totalClients) {
		boolean validLogin = false;
		int customerIndex = 0, idInput = 0, attempts = 0;
		
		System.out.println("Welcome to the Bank of Szakacs");
		
		//Check login
		do {
			System.out.println("Please enter your Customer ID: ");
			idInput = scnr.nextInt();
			
			for(int i = 0; i < totalClients; i++) {
				if(idInput == clients[i].getCustID()) {
					validLogin = true;
					customerIndex = i;
				}
				if(!validLogin) {
					System.out.println("Invalid Login. Please try again.");
					attempts++;
				}
			}
			
		} while(attempts < 3 && !validLogin);
		
		if(!validLogin) {
			System.out.println("Invalid login, max attempts reached. Program terminating.");
			System.exit(200);
		}
		else {
			System.out.println("Logged in Successfully: " + clients[customerIndex].getCustName());
		}
		
		return customerIndex;
	}
	
	public void displayMenu() {
		System.out.println("What would you like to do? (Enter Corresponding Number);;");
		System.out.println("\t1. Deposit Funds");
		System.out.println("\t2. Withdraw Funds");
		System.out.println("\t3. Display Funds");
		System.out.println("\t4. Process Transfer");
	}
	
	public void executeMenu(Customer cust) {
		Scanner scnr = new Scanner(System.in);
		int choice = scnr.nextInt();
		float transAmt = 0f;
		float accountNum = 0f;

		
		if(choice == 1) {
			System.out.println("Enter account to deposit to: ");
			System.out.println("\t1. Checking");
			System.out.println("\t2. Savings");
			accountNum = scnr.nextFloat();
			
			System.out.println("Enter amount to deposit: ");
			transAmt = scnr.nextFloat();
			
			someTrans = new Transaction();
			someTrans.setTransNum(someTrans.getTransNum() + 1);
			someTrans.setCustNbr(cust.getCustID());
			someTrans.setAcctNbr(accountNum);
			someTrans.setTransType('D');
			someTrans.setTransDate("07-01-2021");
			
			transHistory.add(someTrans);
			balance += transAmt;
			
		}
		else if(choice == 2) {
			System.out.println("Enter account to withdraw from: ");
			System.out.println("\t1. Checking");
			System.out.println("\t2. Savings");
			accountNum = scnr.nextFloat();
			
			System.out.println("Enter amount to withdraw: ");
			transAmt = scnr.nextFloat();
			
			someTrans = new Transaction();
			someTrans.setTransNum(someTrans.getTransNum() + 1);
			someTrans.setCustNbr(cust.getCustID());
			someTrans.setAcctNbr(accountNum);
			someTrans.setTransType('D');
			someTrans.setTransDate("07-01-2021");
			
			transHistory.add(someTrans);
			balance -= transAmt;			
		}
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
