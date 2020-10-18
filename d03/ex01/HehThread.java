public class HehThread extends Thread{

	private static String heh = "Heh";

	private long loopsNum;

	private PrintMessage printMessage;

	public HehThread(PrintMessage printMessage, final long loopsNum) {
		this.printMessage = printMessage;
		this.loopsNum = loopsNum;
	}

	@Override
	public void run() {
		while (this.loopsNum != 0) {
			printMessage.printMessage(heh);
			this.loopsNum--;
		}
	}
}
