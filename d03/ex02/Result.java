public class Result {

	private int[] results;

	public Result(final int threadsNumber) {
		results = new int[threadsNumber];
	}

	public int[] getResults() {
		return results;
	}
}
