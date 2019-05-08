import java.math.BigDecimal;
import java.text.NumberFormat;

public class SavingAccount extends Account implements AccountConstants, AccountBehaviors {

	private NumberFormat currency = NumberFormat.getCurrencyInstance();

	public SavingAccount() {
		super();
		currency.setMinimumFractionDigits(2);
	}

	private BigDecimal getInterestPayment() {
		return super.getBalance().multiply(INTEREST_RATE);
	}

	//show interest payment
	public String getFormattedInterest() {
		return "Saving interest payment:" + currency.format(getInterestPayment());
	}

	//implement below two methods in interface AccountBehaviors
	@Override
	public String showStartBalance() {
		return "Saving:\t\t" + currency.format(INITIAL_BALANCE);
	}

	@Override
	public String showFinalBalance() {
		BigDecimal b = super.getBalance().add(this.getInterestPayment());
		return "Saving:\t\t" + currency.format(b);
	}

}
