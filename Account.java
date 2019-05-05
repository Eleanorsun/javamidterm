

public class Account {

	private double balance;
	
	public Account() {
		this.balance = 1000.00;
	}
	
	private void withdraw(double amount) {
		this.balance -= amount;
	}
	
	private void deposit(double amount) {
		this.balance += amount;
	}
	
	public void updateAccount(String transaction, double amount) {
		if (transaction.equalsIgnoreCase("w")) {
			withdraw(amount);
		} else if (transaction.equalsIgnoreCase("d")) {
			deposit(amount);
		}
	}
	
	public double getBalance() {
		return balance;
	}
}
