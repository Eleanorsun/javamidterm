import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {

		System.out.print("Welcome to the Account application\n\n");
		
		// create two subclass objects
		CheckingAccount ca = new CheckingAccount();
		SavingAccount sa = new SavingAccount();

		System.out.print("Starting Balances\n");
		System.out.println(ca.showStartBalance());
		System.out.println(sa.showStartBalance());

		System.out.print("\nEnter the transactions for the month\n");

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			String transaction = Validator.getChoiceString(sc, "\nWithdrawal or deposit? (w/d): ", "w", "d");
			String accountType = Validator.getChoiceString(sc, "Checking or saving? (c/s): ", "c", "s");
			BigDecimal amount = null;

			// Plymorphism (dynamic binding in action), assign subclass to superclass
			Account a = (accountType.equalsIgnoreCase("c")) ? ca : sa;

			if (transaction.equalsIgnoreCase("d")) {
				amount = Validator.getBigDeciWithinRange(sc, "Amount?: ", new BigDecimal("0.00"),
						new BigDecimal(Double.MAX_VALUE));
			} else if (transaction.equalsIgnoreCase("w")) {
				
				// if account balance is zero for saving account or $1 for checking account, 
				// user is not allowed to withdraw money.
				if (a.withdrawLimit().equals(new BigDecimal("0.00"))) {
					System.out.print("Sorry, you have reached withdraw limit, cannot withdraw money anymore.\n");
					choice = Validator.getChoiceString(sc, "\nContinue? (y/n): ", "y", "n");
					continue;
				} else {
					amount = Validator.getBigDeciWithinRange(sc, "Amount?: ", new BigDecimal("0.00"),
							a.withdrawLimit());
				}
			}

			a.updateAccount(transaction, amount);
			choice = Validator.getChoiceString(sc, "\nContinue? (y/n): ", "y", "n");
		}
		
		// subclass object have been updated if there is transaction, display as needed.
		System.out.print("\nMonthly Payments and Fees\n");
		System.out.println(ca.getFormattedFee());
		System.out.println(sa.getFormattedInterest());

		System.out.print("\nFinal Balances\n");
		System.out.println(ca.showFinalBalance());
		System.out.println(sa.showFinalBalance());

	}

}
