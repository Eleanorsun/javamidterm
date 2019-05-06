
import java.math.BigDecimal;
import java.util.Scanner;

public class Validator {
	
	public static String getRequiredString(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			s = sc.nextLine();
			if (s.equals("")) {
				System.out.println("The entry is required. Try again.");
			}else {
				isValid = true;
			}
		}
		return s;
	}
	
	public static String getChoiceString(Scanner sc, String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			s = getRequiredString(sc, prompt);
			if ((!s.equalsIgnoreCase(s1)) && (!s.equalsIgnoreCase(s2))) {
				System.out.println("Error! Entry must be " + s1 + " or " + s2 + " Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}
	
	public static BigDecimal getBigDeci(Scanner sc, String prompt) {
		BigDecimal d = null;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextBigDecimal()) {
				d = sc.nextBigDecimal();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}
	public static BigDecimal getBigDeciWithinRange(Scanner sc, String prompt, BigDecimal min, BigDecimal max) {
		BigDecimal d = null;
		boolean isValid = false;
		while (isValid == false) {
			d = getBigDeci(sc, prompt);
			if (d.compareTo(min) != 1)
				System.out.println("Error! Number must be greater than " + min + ". Try again.");
			else if (d.compareTo(max) == 1)
				System.out.println("Error! Number must be less than or equal to " + max + ". Try again.");
			else
				isValid = true;
		}
		return d;
	}

}