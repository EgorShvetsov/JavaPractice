import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		long result = 0;

		long digitsCalc = 0;

		int weeksCalc = 0;

		int currentWeak = 0;

		int minGrade = 9;

		while (weeksCalc < 18) {
			String firstWord = scanner.next();
			if (firstWord.equals("42")) {
				break ;
			}
			else if (!firstWord.equals("Week")) {
				System.out.println("Illegal Argument");
				System.exit(-1);
			}
			currentWeak = scanner.nextInt();
			weeksCalc++;
			if (currentWeak != weeksCalc) {
				System.out.println("Illegal Argument");
				System.exit(-1);
			}

			for (int i = 0; i < 5; i++) {
				int currentGrade = scanner.nextInt();
				if (currentGrade < minGrade) {
					minGrade = currentGrade;
				}
			}
			result *= 10;
			result += minGrade;
			digitsCalc += 1;
			minGrade = 9;
		}

		progressPrinter(result, digitsCalc);
	}

	static void progressPrinter(long result, long digitsCalc) {

		String week = "Week ";

		int weekNumber = 1;

		long delim;

		while (digitsCalc > 0) {
			System.out.print(week + weekNumber + " ");
			delim = getDelim(digitsCalc);
			printArrows(result / delim);
			result %= delim;
			digitsCalc--;
			weekNumber++;
		}

	}

	static long getDelim(long digitsCalc) {

		long result = 1;

		while (digitsCalc > 1) {
			result *= 10;
			digitsCalc--;
		}
		return result;
	}

	static void printArrows(long arrowsCounter) {
		 while (arrowsCounter >= 1) {
		 	System.out.print("=");
		 	arrowsCounter--;
		 }
		System.out.println(">");
	}
}
