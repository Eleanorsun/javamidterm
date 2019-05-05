import java.text.NumberFormat;

public class CheckingAccount extends Account{

	private double checkingFee;
	private boolean hasTransaction;
	private static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public CheckingAccount() {
		super();
		this.checkingFee = 0.00;
		this.hasTransaction = false;
	}
	@Override
	public void updateAccount(String transaction, double amount) {
		super.updateAccount(transaction, amount);
		hasTransaction = true;
	}
	
	public double getFee() {
		if (hasTransaction) {
			this.checkingFee = 1.00;
		} else {
			this.checkingFee = 0.00;
		}
		return checkingFee;
	}
	
	public String getFormattedFee() {
		currency.setMinimumFractionDigits(2);
		return "Checking fee:\t\t" + currency.format(this.getFee());
	}
	
	public String getStartBalance() {
		currency.setMinimumFractionDigits(2);
		return "Checking:\t" + currency.format(getBalance());
	}
	public String getFinalBalance() {
		double b = super.getBalance() - this.getFee();
		currency.setMinimumFractionDigits(2);
		return "Checking:\t" + currency.format(b);
		
	}
}
