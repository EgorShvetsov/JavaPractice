public class NewThread extends Thread {

	private final String message;

	private int loopsCounter;

	public NewThread(final String message, final long loopsCounter) {
		this.message = message;
		this.loopsCounter = (int)loopsCounter;
	}

	@Override
	public void run() {
		while (this.loopsCounter > 0) {
			System.out.println(message);
			this.loopsCounter--;
		}
	}

}
