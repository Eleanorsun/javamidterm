import java.math.BigDecimal;
import java.text.NumberFormat;

public class SavingAccount extends Account {

	private BigDecimal interest;
	private NumberFormat currency = NumberFormat.getCurrencyInstance();

	public SavingAccount() {
		super();
		this.interest = new BigDecimal("0.01");
		currency.setMinimumFractionDigits(2);
	}
	public BigDecimal withdrawLimit() {
		return super.getBalance();
	}
	
	private BigDecimal getInterestPayment() {
		return super.getBalance().multiply(this.interest) ;
	}
	
	public String getFormattedPayment() {
		return "Saving interest payment:" + currency.format(getInterestPayment());
	}

	public String getStartBalance() {
		return "Saving:\t\t" + currency.format(getBalance());
	}
	public String getFinalBalance() {
		BigDecimal b = super.getBalance().add(this.getInterestPayment()) ;
		return "Saving:\t\t" + currency.format(b);
	}

}
