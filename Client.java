import java.util.ArrayList;

/*
 * Program written by Devon Simmonds for 331 homework
 */

public class Client implements IClient{

	private String clientName;
	private int clientNumber;//must be at least 9 digits
	private String address;
	private static int startingClientNumber = 950123456;
	private ArrayList<Account> accountList;
	
	public Client(String name, String address){
		this.clientName = name;
		this.address = address;
		this.clientNumber = startingClientNumber;
		startingClientNumber++;
		this.accountList = new ArrayList<Account>();
	}

	@Override
	/*
	 * Opens an account for the client by initializing an account with given balance, adding it to accountList, then 
	 * returning the accountNumber
	 */
	public int openAccount(double balance) {
		// TODO Auto-generated method stub
		Account acc = new Account(balance);
		this.accountList.add(acc);
		return acc.getAccountNumber();
	}

	@Override
	/*
	 * Transfers amount from accountFrom to accountTo within the same client object. Checks to see if both accounts exist, 
	 * if they do, uses withdraw() and deposit() to transfer the amount.
	 */
	public boolean transfer(int accountFrom, int accountTo, double amount) {
		// TODO Auto-generated method stub
		boolean to = false;
		boolean from = false;
		if(this.getAccount(accountFrom) != null) {from = true;}
		if(this.getAccount(accountTo) != null) {to = true;}
		
		if((to & from) == true) {
			this.getAccount(accountFrom).withdraw(amount);
			this.getAccount(accountTo).deposit(amount);
			return true;
		}
		return false;
	}

	@Override
	/*
	 * Returns the Account object associated with accountNumber by iterating through accountList and checking accountNumber's
	 */
	public Account getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		for(Account e : this.accountList) {
			if(e.accountNumber == accountNumber) {
				return e;
			}
		}
		return null;
	}

	@Override
	/*
	 * Prints all of current Client's accounts by iterating through accountList
	 */
	public void printAccounts() {
		// TODO Auto-generated method stub
		System.out.println("\nAccounts for " + this.clientName + ":" + this.clientNumber);
		for(Account c : accountList) {
			c.printAccount();
		}
	}

	@Override
	/*
	 * simply returns the current Client's clientNumber
	 */
	public int getClientNumber() {
		// TODO Auto-generated method stub
		return this.clientNumber;
	}

	@Override
	/*
	 * Deletes Client's specified account by iterating through accountList, then using ArrayList's remove() on the account
	 * if found. Utilizes break; to avoid an error caused by the for each loop continuing to iterate after removal of the 
	 * account
	 */
	public void deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		for(Account f : accountList) {
			if(f.getAccountNumber() == accountNumber) {
				accountList.remove(f);
				break;
			}
		}
	}
	
	// Add other code here
	
}//end of class