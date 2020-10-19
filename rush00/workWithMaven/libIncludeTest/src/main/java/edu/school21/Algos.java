package edu.school21;

import edu.school21.PathFinder;
import edu.school21.Point;

public class Algos {

	public static void main(String[] args) {

		Point[][] arr = new Point[6][6];

		arr[0][0] = new Point(0, 0, -1, '.');
		arr[0][1] = new Point(0, 1, -1, '.');
		arr[0][2] = new Point(0, 2, -1, '.');
		arr[0][3] = new Point(0, 3, -1, '.');
		arr[0][4] = new Point(0, 4, -1, 'X');
		arr[0][5] = new Point(0, 5, -1, '.');

		arr[1][0] = new Point(1, 0, -1, 'X');
		arr[1][1] = new Point(1, 1, -1, '.');
		arr[1][2] = new Point(1, 2, -1, 'X');
		arr[1][3] = new Point(1, 3, -1, '.');
		arr[1][4] = new Point(1, 4, -1, 'S');
		arr[1][5] = new Point(1, 5, -1, '.');

		arr[2][0] = new Point(2, 0, -1, 'X');
		arr[2][1] = new Point(2, 1, -1, '.');
		arr[2][2] = new Point(2, 2, -1, 'X');
		arr[2][3] = new Point(2, 3, -1, '.');
		arr[2][4] = new Point(2, 4, -1, '.');
		arr[2][5] = new Point(2, 5, -1, '.');

		arr[3][0] = new Point(3, 0, -1, 'X');
		arr[3][1] = new Point(3, 1, -1, 'X');
		arr[3][2] = new Point(3, 2, -1, 'X');
		arr[3][3] = new Point(3, 3, -1, '.');
		arr[3][4] = new Point(3, 4, -1, 'X');
		arr[3][5] = new Point(3, 5, -1, '.');

		arr[4][0] = new Point(4, 0, -1, '.');
		arr[4][1] = new Point(4, 1, -1, 'G');
		arr[4][2] = new Point(4, 2, -1, '.');
		arr[4][3] = new Point(4, 3, -1, '.');
		arr[4][4] = new Point(4, 4, -1, '.');
		arr[4][5] = new Point(4, 5, -1, '.');

		arr[5][0] = new Point(5, 0, -1, 'E');
		arr[5][1] = new Point(5, 1, -1, '.');
		arr[5][2] = new Point(5, 2, -1, '.');
		arr[5][3] = new Point(5, 3, -1, '.');
		arr[5][4] = new Point(5, 4, -1, '.');
		arr[5][5] = new Point(5, 5, -1, '.');

//
//		Point[][] arr = new Point[3][3];
//
//		arr[0][0] = new Point(0, 0, -1, '.');
//		arr[0][1] = new Point(0, 1, -1, 'X');
//		arr[0][2] = new Point(0, 2, -1, 'G');
//
//		arr[1][0] = new Point(1, 0, -1, '.');
//		arr[1][1] = new Point(1, 1, -1, 'X');
//		arr[1][2] = new Point(1, 2, -1, 'X');
//
//		arr[2][0] = new Point(2, 0, -1, '.');
//		arr[2][1] = new Point(2, 1, -1, 'S');
//		arr[2][2] = new Point(2, 2, -1, '.');


		PathFinder pathFinder = new PathFinder(arr);

		Point result = pathFinder.pathFinder(pathFinder.getPoint(1,4), pathFinder.getPoint(4, 1));

		result = pathFinder.pathFinder(pathFinder.getPoint(2,4), pathFinder.getPoint(5, 0));
		result = pathFinder.pathFinder(pathFinder.getPoint(2,4), pathFinder.getPoint(5, 1));
		result = pathFinder.pathFinder(pathFinder.getPoint(1,0), pathFinder.getPoint(5, 5));
		result = pathFinder.pathFinder(pathFinder.getPoint(0,0), pathFinder.getPoint(5, 5));

		System.out.println("#######DONE#######");

	}
}
