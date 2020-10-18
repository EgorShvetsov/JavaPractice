public class Point {

	private int y;

	private int x;

	private int numberInPath;

	private char name;

	private Point prevPointInQueue;

	public Point(int y, int x, int numberInPath, char name) {
		this.x = x;
		this.y = y;
		this.numberInPath = numberInPath;
		this.name = name;
	}

	public void setNumberInPath(int numberInPath) {
		this.numberInPath = numberInPath;
	}

	public void setPrevPointInQueue(Point prevPointInQueue) {
		this.prevPointInQueue = prevPointInQueue;
	}

	public Point getPrevPointInQueue() {
		return prevPointInQueue;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNumberInPath() {
		return numberInPath;
	}

	public char getName() {
		return name;
	}
}
