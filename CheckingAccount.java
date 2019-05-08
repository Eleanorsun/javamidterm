import java.math.BigDecimal;
import java.text.NumberFormat;

public class CheckingAccount extends Account implements AccountConstants, AccountBehaviors {

	private BigDecimal fee;
	private boolean hasTransaction;
	private NumberFormat currency = NumberFormat.getCurrencyInstance();

	public CheckingAccount() {
		super();
		this.fee = new BigDecimal("0.00");
		this.hasTransaction = false;
		currency.setMinimumFractionDigits(2);
	}
	
	//withdraw upper limit
	@Override
	public BigDecimal withdrawLimit() {
		return super.getBalance().subtract(CHECKING_FEE);
	}
	@Override
	public void updateAccount(String transaction, BigDecimal amount) {
		super.updateAccount(transaction, amount);
		hasTransaction = true;
	}

	//checking fee is $1 only when there is transaction.
	private BigDecimal getFee() {
		if (hasTransaction) {
			this.fee = CHECKING_FEE;
		}
		return fee;
	}

	//show formatted checking fee
	public String getFormattedFee() {
		return "Checking fee:\t\t" + currency.format(this.getFee());
	}

	//implement below two methods in interface AccountBehaviors
	@Override
	public String showStartBalance() {
		return "Checking:\t" + currency.format(INITIAL_BALANCE);
	}

	@Override
	public String showFinalBalance() {
		BigDecimal b = super.getBalance().subtract(this.getFee());
		return "Checking:\t" + currency.format(b);

	}
}
