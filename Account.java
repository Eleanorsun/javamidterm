import java.math.BigDecimal;

public class Account {

	private BigDecimal balance;
	
	public Account() {
		this.balance = new BigDecimal("1000.00");
	}
	
	private void withdraw(BigDecimal amount) {
		this.balance = balance.subtract(amount);
	}
	
	private void deposit(BigDecimal amount) {
		this.balance = balance.add(amount);;
	}
	
	public void updateAccount(String transaction, BigDecimal amount) {
		if (transaction.equalsIgnoreCase("w")) {
			withdraw(amount);
		} else if (transaction.equalsIgnoreCase("d")) {
			deposit(amount);
		}
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
}
