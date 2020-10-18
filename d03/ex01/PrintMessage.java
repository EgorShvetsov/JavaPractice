public class PrintMessage {

	private String currentMessage = "Heh";

	public synchronized void printMessage(final String message){
		while (this.currentMessage.equals(message)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		this.currentMessage = message;
		System.out.println(this.currentMessage);
		notify();
	}

}
