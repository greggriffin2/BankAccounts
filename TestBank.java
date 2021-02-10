
public class TestBank {

	public static void main(String[] args) {
		Bank bofa = new Bank("Bofa Bank", 123456);
		Bank wells = new Bank("Wells Bank", 123457);
		
		System.out.println("\n--------------------Creating 4 clients each with 1 account--------------------------");
		bofa.openAccount("Greg", "GregAccount", 1000.00);
		bofa.openAccount("Alec", "AlecAccount", 750.00);
		wells.openAccount("John", "JohnAccount", 800.00);
		wells.openAccount("Adam", "AdamAccount", 900.00);
		
		bofa.printClients();
		wells.printClients();
		System.out.println("\n--------------------adding new accounts for Greg and John--------------------------");
		
		bofa.openAccount(950123456,  300.00);
		wells.openAccount(950123458,  200.00);
		
		bofa.printClients();
		wells.printClients();
		System.out.println("\n--------------------deleting client Adam and Greg's 2nd account--------------------------");
		
		bofa.deleteAccount(950123456, 123460);
		wells.deleteClient(950123459);
		
		bofa.printClients();
		wells.printClients();
		System.out.println("\n--------------------transferring 500.00 from John's 1st account to 2nd----------------------");
		
		wells.transfer(123458, 123461, 500.00);
		
		bofa.printClients();
		wells.printClients();
		System.out.println("\n--------------------deleting client John----------------------");
		
		wells.deleteClient(950123458);
		bofa.printClients();
		wells.printClients();
		}
}
