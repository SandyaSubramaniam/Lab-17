import java.util.Scanner;

public class Validator {

	/**
	 * Get any valid integer.
	 */
	public static int getInt(Scanner scnr, String prompt) {

		// This approach use "hasNext" look ahead.
		System.out.print(prompt);
		while (!scnr.hasNextInt()) {
			scnr.next(); // clear bad line.
			System.out.println("Sorry, I can't read that. Enter a whole number, using digits.");
			System.out.println(prompt);
		}
		int result = scnr.nextInt();
//		scnr.nextLine(); // clear for next line of input.
		return result;
	}

	/**
	 * Get any valid positive integer.
	 */
	public static int getPositiveInt(Scanner scnr, String prompt) {

		int result = -1;
		// This approach use "hasNext" look ahead.
		System.out.print(prompt);
		while (!scnr.hasNextInt() && (result = scnr.nextInt()) < 0) {
			scnr.nextLine(); // clear bad line.
			System.out.println("Sorry, I can't read that. Enter a valid positive number.");
			System.out.println(prompt);
		}
//		scnr.nextLine(); // clear for next line of input.
		return result;
	}

	/**
	 * Get any valid double.
	 */
	public static double getDouble(Scanner scnr, String prompt) {

		// This approach use "hasNext" look ahead.
		boolean isValid = false;
		do {
			System.out.print(prompt);
			isValid = scnr.hasNextDouble();
			if (!isValid) {
				scnr.nextLine(); // clear bad line.
				System.out.println("Sorry, I can't read that. Enter a number, using digits.");
			}
		} while (!isValid);
		double number = scnr.nextDouble();
		scnr.nextLine(); // clear for next line of input.
		return number;
	}

	/**
	 * Get any string.
	 */
	public static String getString(Scanner scnr, String prompt) {

		// This approach uses exception handling.
		System.out.print(prompt);
		return scnr.nextLine();
	}

	/**
	 * Get any valid integer between min and max.
	 */
	public static int getInt(Scanner scnr, String prompt, int min, int max) {

		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr, prompt);
			if (number < min) {
				isValid = false;
				System.out.println("Please enter numbers between " + min + " and " + max);
			} else if (number > max) {
				isValid = false;
				System.out.println("Please enter numbers between " + min + " and " + max);
			} else {
				isValid = true;
			}
		} while (!isValid);
		return number;
	}

	/**
	 * Get any valid double between min and max.
	 */
	public static double getDouble(Scanner scnr, String prompt, double min, double max) {

		boolean isValid = false;
		double number;
		do {
			number = getDouble(scnr, prompt);
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
		} while (!isValid);
		return number;
	}

	/**
	 * Get a string of input from the user that must match the given regex.
	 */
	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {

		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt);
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}
		} while (!isValid);
		return input;
	}

	public static String getStringMatching(Scanner scnr, String prompt, String[] validValues) {

		boolean isValid = false;
		String input = "";
		do {
			System.out.print(prompt);
			input = scnr.next();
			for (int i = 0; i < validValues.length; i++) {
				if (input.equalsIgnoreCase(validValues[i])) {
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.println("Please enter a valid value.");
			}
		} while (!isValid);
		return input;
	}

	public static int getIntMatching(Scanner scnr, String prompt, int[] validValues) {

		boolean isValid = false;
		int input = 0;
		do {
			System.out.print(prompt);
			input = scnr.nextInt();
			for (int i = 0; i < validValues.length; i++) {
				if (input == (validValues[i])) {
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.println("Please enter a valid option.");
			}
		} while (!isValid);
		return input;
	}
}