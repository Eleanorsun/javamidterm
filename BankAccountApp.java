import java.util.Scanner;

public class BankAccountApp {
	
	public static void main(String[] args) {
		
		System.out.print("Welcome to the Account application\n\n");
		
		CheckingAccount ca = new CheckingAccount();
		SavingAccount sa = new SavingAccount();
		
		System.out.print("Starting Balances\n");
		System.out.println(ca.getStartBalance());
		System.out.println(sa.getStartBalance());
		
		System.out.print("\nEnter the transactions for the month\n");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String transaction = Validator.getChoiceString(sc, "\nWithdrawal or deposit? (w/d): ", "w", "d");
			String accountType = Validator.getChoiceString(sc, "Checking or saving? (c/s): ", "c", "s");
			double amount = 0.0;

			if (accountType.equalsIgnoreCase("c")) {
				if (transaction.equalsIgnoreCase("d")) {
					amount = Validator.getDoubleWithinRange(sc, "Amount?: ", 0, Double.MAX_VALUE);
				} else {
					amount = Validator.getDoubleWithinRange(sc, "Amount?: ", 0, ca.getBalance() - 1);
				}
				ca.updateAccount(transaction, amount);
				
			} else if (accountType.equalsIgnoreCase("s")) {
				
				if (transaction.equalsIgnoreCase("d")) {
					amount = Validator.getDoubleWithinRange(sc, "Amount?: ", 0, Double.MAX_VALUE);
				} else {
					amount = Validator.getDoubleWithinRange(sc, "Amount?: ", 0, sa.getBalance());
				}
				sa.updateAccount(transaction, amount);
			}
			
			
			choice = Validator.getChoiceString(sc, "\nContinue? (y/n): ", "y", "n");
		}
		
		System.out.print("\nMonthly Payments and Fees\n");
		System.out.println(ca.getFormattedFee());
		System.out.println(sa.getFormattedPayment());
		
		
		System.out.print("\nFinal Balances\n");
		System.out.println(ca.getFinalBalance());
		System.out.println(sa.getFinalBalance());
		
		
	}

}
