public class EggThread extends Thread {

	private static String egg = "Egg";

	private PrintMessage printMessage;

	private long loopsNum;

	public EggThread(PrintMessage printMessage, final long loopsNum) {
		this.printMessage = printMessage;
		this.loopsNum = loopsNum;
	}

	@Override
	public void run() {
		while (this.loopsNum != 0) {
			printMessage.printMessage(egg);
			this.loopsNum--;
		}
	}
}
