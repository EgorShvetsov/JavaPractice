public class CalculatorThread extends Thread {

	private final int[] arr;

	private final int threadNumber;

	private final int firstIndex;

	private final int lastIndex;

	private final Result result;

	private final PrintResultForThreadSynchronized printResult;

	public CalculatorThread(final int[] arr,
							final int threadNumber,
							final int numOfThreads,
							final Result result,
							final PrintResultForThreadSynchronized printResult) {
		this.arr = arr;
		this.threadNumber = threadNumber;

		int steps = this.arr.length / numOfThreads;

		this.firstIndex = steps * threadNumber;
		if (this.firstIndex + steps > this.arr.length || threadNumber == numOfThreads - 1) {
			this.lastIndex = this.arr.length;
		} else {
			this.lastIndex = this.firstIndex + steps;
		}

		this.result = result;
		this.printResult = printResult;
	}

	@Override
	public void run() {

		for (int i = firstIndex; i < lastIndex; i++) {
			result.getResults()[this.threadNumber] += arr[i];
		}
		printResult.printResultForThread(this);
	}

	public int[] getArr() {
		return arr;
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public Result getResult() {
		return result;
	}
}
