public class Program {

	public static void main(String[] args) {

		checkArgsValidity(args);

		int arraySize = Integer.parseInt(args[0].substring(12, args[0].length()));
		int threadsCount = Integer.parseInt(args[1].substring(15, args[1].length()));

		CalculatorThread[] calculatorThreads = new	CalculatorThread[threadsCount];
		int[] arr = new int[arraySize];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 2000 - 1000);
		}

		long loopResult = 0;
		for (int i = 0; i < arr.length; i++) {
			loopResult += arr[i];
		}

		System.out.println("Sum: " + loopResult);

		Result result = new Result(threadsCount);

		PrintResultForThreadSynchronized printResult = new PrintResultForThreadSynchronized();

		for (int i = 0; i < calculatorThreads.length; i++) {
			calculatorThreads[i] = new CalculatorThread(arr, i, calculatorThreads.length, result, printResult);
			calculatorThreads[i].start();
		}

		for (int i = 0; i < calculatorThreads.length; i++) {
			try {
				calculatorThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

		int threadsResult = 0;
		for (int i = 0; i < result.getResults().length; i++) {
			threadsResult += result.getResults()[i];
		}

		System.out.println("Sum by threads: " + threadsResult);
	}

	public static void checkArgsValidity(final String[] args) {

		if (args.length != 2
				|| args[0].length() < 12
				|| args[1].length() < 15
				|| !args[0].substring(0, 12).equals("--arraySize=")
				|| !args[1].substring(0, 15).equals("--threadsCount=")) {
			System.out.println("Usage: java Program  --arraySize=S --threadsCount=T\nS - array size <= 2,000,000\nT - number of threads");
			System.exit(-1);
		}

		if (args[0].substring(12, args[0].length()).length() > 13
			|| args[1].substring(15, args[1].length()).length() > 13) {
			System.out.println("Too many digits...");
			System.exit(-1);
		}

		long arraySize = Integer.parseInt(args[0].substring(12, args[0].length()));

		long threadsCount = Integer.parseInt(args[1].substring(15, args[1].length()));

		if (arraySize > 2_000_000) {
			System.out.println("Array size should be equal or less then 2,000,000");
			System.exit(-1);
		}

		if (arraySize < threadsCount) {
			System.out.println("Number of threads should be less or equal to array size");
			System.exit(-1);
		}
	}
}
