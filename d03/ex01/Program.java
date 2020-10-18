public class Program {

	public static void main(String[] args) {

		if (args.length != 1 || args[0].length() < 9 || !args[0].substring(0, 8).equals("--count=")) {
			System.out.println("Usage: java Program --count=N\nN - integer from 0 to INTMAX");
			System.exit(-1);
		}

		String strLoops = args[0].substring(8, args[0].length());

		char[] digitsArr = strLoops.toCharArray();

		long loopsCounter = 0;

		for (int i = 0; i < digitsArr.length; i++) {
			if (digitsArr[i] < '0' || digitsArr[i] > '9' || digitsArr.length > 10) {
				System.out.println("Usage: java Program --count=N\nN - integer from 0 to INTMAX");
				System.exit(-1);
			}
			loopsCounter *= 10;
			loopsCounter += digitsArr[i] - 48;
		}

		if (loopsCounter > 2147483647) {
			System.out.println("Usage: java Program --count=N\nN - integer from 0 to INTMAX");
			System.exit(-1);
		}

		PrintMessage printMessage = new PrintMessage();

		EggThread eggThread =  new EggThread(printMessage, loopsCounter);

		HehThread henThread =  new HehThread(printMessage, loopsCounter);

		eggThread.start();
		henThread.start();


		try {
			eggThread.join();
			henThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
