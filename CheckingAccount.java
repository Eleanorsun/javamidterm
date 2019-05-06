import java.math.BigDecimal;
import java.text.NumberFormat;

public class CheckingAccount extends Account{

	private final BigDecimal FEE = new BigDecimal("1.00");
	private BigDecimal checkingFee;
	private boolean hasTransaction;
	private NumberFormat currency = NumberFormat.getCurrencyInstance();

	
	public CheckingAccount() {
		super();
		this.checkingFee = new BigDecimal("0.00");
		this.hasTransaction = false;
		currency.setMinimumFractionDigits(2);
	}
	public BigDecimal withdrawLimit() {
		return super.getBalance().subtract(FEE);
	}
	
	@Override
	public void updateAccount(String transaction, BigDecimal amount) {
		super.updateAccount(transaction, amount);
		hasTransaction = true;
	}
	
	public BigDecimal getFee() {
		if (hasTransaction) {
			this.checkingFee = FEE;
		} 
		return checkingFee;
	}
	
	public String getFormattedFee() {
		return "Checking fee:\t\t" + currency.format(this.getFee());
	}
	
	public String getStartBalance() {
		return "Checking:\t" + currency.format(getBalance());
	}
	public String getFinalBalance() {
		BigDecimal b = super.getBalance().subtract(this.getFee()) ;
		return "Checking:\t" + currency.format(b);
		
	}
}
