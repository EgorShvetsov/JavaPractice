public class PrintResultForThreadSynchronized {

	private int currentThread = 1;

	public synchronized void printResultForThread(final CalculatorThread thread) {

		while (this.currentThread != thread.getThreadNumber() + 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

		System.out.println("Thread "  + (thread.getThreadNumber() + 1) + ": from "
				+ thread.getFirstIndex() + " to " + thread.getLastIndex()
				+ " sum is " + thread.getResult().getResults()[thread.getThreadNumber()]);
		this.currentThread++;
		notifyAll();
	}
}
