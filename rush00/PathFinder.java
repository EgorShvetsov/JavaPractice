public class PathFinder {

	private Point[][] arr;

	public PathFinder(final Point[][] arr) {
		this.arr = arr;
	}

	public Point pathFinder(final Point source, final Point goal) {

		Point[] queue = new Point[this.arr.length * this.arr.length];

		queue[0] = source;

		int i = 0;
		int k = i + 1;
		while (k < queue.length) {

			if (k == i) {
				break;
			}

			for (int dotsAroundIIterator = 0; dotsAroundIIterator < 4; dotsAroundIIterator++) {
				Point tmp = isAGoodDot(queue[i], dotsAroundIIterator, goal);
				if (tmp != null) {
					queue[k] = tmp;
					queue[k].setNumberInPath(queue[i].getNumberInPath() + 1);
					queue[k].setPrevPointInQueue(queue[i]);
					if (queue[k] == goal) {
						break;
					}
					k++;
				}
			}
 			if (queue[k] != null && queue[k] == goal) {
				break;
			}
			i++;
		}

		if (k == queue.length || i == k) {
			setToDefaultNumbersInPathAndPrevPoints(queue);
			return null;
		}

		Point result = queue[k];
		while (result.getPrevPointInQueue() != source) {
			result = result.getPrevPointInQueue();
		}
		setToDefaultNumbersInPathAndPrevPoints(queue);
		return result;
	}

	public Point getPoint(final int y, final int x) {
		return this.arr[y][x];
	}

	private Point isAGoodDot(final Point point, final int dotsAround, final Point goal) {
		Point result;

		if (dotsAround == 0) {
			if (point.getY() != 0) {
				result = this.getPoint(point.getY() - 1, point.getX());
				if (result.getNumberInPath() == -1 && result.getName() == '.' || result == goal) {
					return result;
				}
				return null;
			}
		}
		else if (dotsAround == 1) {
			if (point.getX() != this.arr.length - 1) {
				result = this.getPoint(point.getY(), point.getX() + 1);
				if (result.getNumberInPath() == -1 && result.getName() == '.' || result == goal) {
					return result;
				}
				return null;
			}
		}
		else if (dotsAround == 2) {
			if (point.getY() != this.arr.length - 1) {
				result = this.getPoint(point.getY() + 1, point.getX());
				if (result.getNumberInPath() == -1 && result.getName() == '.' || result == goal) {
					return result;
				}
				return null;
			}
		}
		else if (dotsAround == 3) {
			if (point.getX() != 0) {
				result = this.getPoint(point.getY(), point.getX() - 1);
				if (result.getNumberInPath() == -1 && result.getName() == '.' || result == goal) {
					return result;
				}
				return null;
			}
		}
		return null;
	}

	private void setToDefaultNumbersInPathAndPrevPoints(final Point[] queue) {

		int i = 0;

		while (queue[i] != null) {
			queue[i].setNumberInPath(-1);
			queue[i].setPrevPointInQueue(null);
			i++;
		}

	}
}
