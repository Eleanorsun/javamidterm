import java.math.BigDecimal;

public class Account implements AccountConstants {

	private BigDecimal balance;

	public Account() {
		this.balance = INITIAL_BALANCE;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	//withdraw upper limit
	public BigDecimal withdrawLimit() {
		return balance;
	}
	
	//withdraw money
	private void withdraw(BigDecimal amount) {
		this.balance = balance.subtract(amount);
	}

	//deposit money
	private void deposit(BigDecimal amount) {
		this.balance = balance.add(amount);
	}

	//update account based on transaction and money amount.
	public void updateAccount(String transaction, BigDecimal amount) {
		if (transaction.equalsIgnoreCase("w")) {
			withdraw(amount);
		} else if (transaction.equalsIgnoreCase("d")) {
			deposit(amount);
		}
	}

	

}
