import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine();

		char[] charArr = str.toCharArray();

		int[] occurrences = new int[65535];

		int shortFromChar;

		char[] champions = new char[10];

		int[] championsOccurrences = new int[10];

		for (int i = 0; i < charArr.length; i++) {
			shortFromChar = charArr[i];
			occurrences[shortFromChar]++;
		}

		for (int i = 0; i < occurrences.length; i++) {
			if (occurrences[i] != 0) {
				setCharToRightPlace(champions, championsOccurrences, occurrences, i);
			}
		}

		printHistogram(champions, championsOccurrences);
	}

	static void setCharToRightPlace(char[] champions,
									int[] championsOccurrences,
									int[] occurrences,
									int iterator) {

		for (int i = 0; i < champions.length; i++) {
			if (championsOccurrences[i] <= occurrences[iterator]) {
				if (championsOccurrences[i] == occurrences[iterator] && champions[i] < iterator) {
					continue;
				}
				if (championsOccurrences[i] != 0) {
					moveChampionsAndChampionsOccurrences(champions, championsOccurrences, i);
				}
				champions[i] = (char)iterator;
				championsOccurrences[i] = occurrences[iterator];
				break;
			}
		}

	}

	static void moveChampionsAndChampionsOccurrences(char[] champions,
													 int[] championsOccurrences,
													 int i) {
		char firstChar = champions[i];
		char secondChar;
		int  firstInt = championsOccurrences[i];
		int  secondInt;

		for (; i < champions.length - 1; i++) {

			secondChar = champions[i + 1];
			champions[i + 1] = firstChar;
			firstChar = secondChar;

			secondInt = championsOccurrences[i + 1];
			championsOccurrences[i + 1] = firstInt;
			firstInt = secondInt;

		}
	}

	static void printHistogram(final char[] champions, final int[] championsOccurrences) {

		int[] hashes = hashCalculator(champions, championsOccurrences);

		int hashesIterator;

		int champOccIterator = 0;

		int linesCalc = hashes[0] + 1;

		if (linesCalc == 1) {
			return;
		}

		while (linesCalc > 0) {
			hashesIterator = 0;
			while (hashesIterator < champOccIterator) {
				System.out.print("  #");
				hashes[hashesIterator]--;
				hashesIterator++;
			}
			if (hashesIterator == champOccIterator) {
				while (champOccIterator < 10 && hashes[champOccIterator] == hashes[0]
						&& championsOccurrences[champOccIterator] != 0) {
					printOcc(championsOccurrences, champOccIterator);
					champOccIterator++;
				}
			}
			System.out.print("\n");
			linesCalc--;
		}

		for (int championsIterator = 0; championsIterator < champions.length; championsIterator++) {
			if (champions[championsIterator] != 0){
				System.out.print("  " + champions[championsIterator]);
			}
		}
		System.out.print("\n");
	}

	static void printOcc(final int[] championsOccurrences, final int champOccIterator) {

		if (championsOccurrences[champOccIterator] < 100) {
			System.out.print(" ");
		}
		if (championsOccurrences[champOccIterator] < 10) {
			System.out.print(" ");
		}
		System.out.print(championsOccurrences[champOccIterator]);

	}

	static int[] hashCalculator(final char[] champions, final int[] championsOccurrences) {

		int[] hashes = new int[10];

		double hashCf;

		if (championsOccurrences[0] <= 10) {
			for (int i = 0; i < champions.length; i++) {
				hashes[i] = championsOccurrences[i];
			}
		}
		else {
			hashes[0] = 10;
			hashCf = championsOccurrences[0] / 10f;
			for (int i = 1; i < champions.length; i++) {
				hashes[i] = (int)(championsOccurrences[i] / hashCf);
			}
		}
		return hashes;
	}
}
