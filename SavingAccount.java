import java.text.NumberFormat;

public class SavingAccount extends Account {

	private double interest;
	private static NumberFormat currency = NumberFormat.getCurrencyInstance();

	public SavingAccount() {
		super();
		this.interest = 0.01;
	}
	
	private double getInterestPayment() {
		return super.getBalance() * this.interest;
	}
	
	public String getFormattedPayment() {
		currency.setMinimumFractionDigits(2);
		return "Saving interest payment:" + currency.format(getInterestPayment());
	}

	public String getStartBalance() {
		currency.setMinimumFractionDigits(2);
		return "Saving:\t\t" + currency.format(getBalance());
	}
	public String getFinalBalance() {
		double b = super.getBalance() + this.getInterestPayment();
		currency.setMinimumFractionDigits(2);
		return "Saving:\t\t" + currency.format(b);
	}

}
