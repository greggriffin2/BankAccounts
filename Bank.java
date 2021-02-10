import java.util.ArrayList;

/*
 * Program written by Devon Simmonds for 331 homework
 */

public class Bank implements IBank{
	private String name;
	private int bankId;
	private ArrayList<Client> clientList;

	public Bank(String name, int bankId) {
		this.name = name;
		this.bankId = bankId;
		this.clientList = new ArrayList<Client>();
	}
	/*
	 * Opens a new account by initializing a new Client with name and address, opening an account using given amount, 
	 * then adding that Client to clientList, then returns the clientNumber
	 */
	public int openAccount(String name, String address, double amount) {
		// TODO Auto-generated method stub
		Client client = new Client(name, address);
		client.openAccount(amount);
		this.clientList.add(client);
		return client.getClientNumber();
		
	}

	@Override
	/*
	 * Alternate version of openAccount which does not create a new Client, instead searching for an existing client by iterating
	 * through clientList, then opens a new account for that client by using the given amount
	 */
	public void openAccount(int clientNumber, double amount) {
		// TODO Auto-generated method stub
		for(Client c : this.clientList) {
			if(c.getClientNumber() == clientNumber){
				c.openAccount(amount);
			}
		}
	}

	@Override
	/*
	 * Deletes a client by iterating though clientList using the given clientNumber, then uses ArrayList's remove() to remove
	 * the client, then immediately returns true to avoid errors
	 */
	public boolean deleteClient(int clientNumber) {
		// TODO Auto-generated method stub
		for(Client c : this.clientList) {
			if(c.getClientNumber() == clientNumber) {
				this.clientList.remove(c);
				return true;
			}
		}
		return false;
	}

	@Override
	/*
	 * Deletes a specified account by repeating deleteClient()'s steps, but utilizes deleteAccount() instead of remove()
	 */
	public boolean deleteAccount(int clientNumber, int accountNumber) {
		// TODO Auto-generated method stub
		for(Client c : this.clientList) {
			if(c.getClientNumber() == clientNumber) {
				c.deleteAccount(accountNumber);
				return true;
			}
		}
		return false;
	}

	@Override
	/*
	 * Transfers a given amount from accountFrom to accountTo by iterating through clientList until e.getAccount(accountFrom)
	 * returns true, then from there the method utilizes Client class's transfer() method to do the rest of the work
	 */
	public boolean transfer(int accountFrom, int accountTo, double amount) {
		// TODO Auto-generated method stub
		for(Client e : this.clientList) {
			if((e.getAccount(accountFrom)) != null) {
				e.transfer(accountFrom, accountTo, amount);
				return true;
			}
		}
		return false;
	}

	@Override
	/*
	 * Prints all Clients of the bank by iterating through clientList and calling on Client class's printAccounts() method
	 * on each element
	 */
	public void printClients() {
		// TODO Auto-generated method stub
		for(Client c : clientList) {
			c.printAccounts();
		}
	}


}//end of class
