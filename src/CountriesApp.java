import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) throws IOException {

		Scanner scnr = new Scanner(System.in);
		int menu;
		Path path = Paths.get("countries.txt");
		if (Files.notExists(path)) {
			Files.createFile(path);
		}
		System.out.println("Welcome to the Countries Maintainence Application!");
		System.out.println("1-See the list of countries");
		System.out.println("2-Add a country");
		System.out.println("3-Exit");
		do {
			menu = Validator.getInt(scnr, "Enter menu number", 1, 3);
			switch (menu) {
			case 1:
				List<Country> countries = CountryFileUtil.readFile();
				for (Country c : countries) {
					System.out.println(c.getName() + " " + c.getPopulation());
				}
				break;
			case 2:
				String userContinue = "Y";
				String[] validValues = { "Y", "N" };
				do {
					System.out.println("Enter country: ");
					String name = scnr.next();
					int population = Validator.getInt(scnr, "Enter population: ");
					Country newcountry = new Country(name, population);
					try {
						CountryFileUtil.appendToFile(newcountry);
					} catch (IOException | InputMismatchException e) {
						System.out.println("Sorry, can't edit the file.");
					}
					userContinue = Validator.getStringMatching(scnr, "Would you like to add another country? (y/n)",
							validValues);
				} while (userContinue.equalsIgnoreCase("Y"));
				break;
			case 3:
				System.out.println("Goodbye!");
			}
		} while (menu != 3);
		scnr.close();
	}
}
