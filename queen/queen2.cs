using System;
using System.Runtime.CompilerServices;

public class Queen2 {
	const int N = 13;

	[MethodImpl(MethodImplOptions.AggressiveInlining)]
	static bool check(int[] q, int row) {
		if (row == 0)
			return true;
		int x0 = q[row];
		for (int y = 0; y < row; y++) {
			int x = q[y];
			if (x == x0)
				return false;
			if (x - x0 == row - y)
				return false;
			if (x0 - x == row - y)
				return false;
		}
		return true;
	}

	[MethodImpl(MethodImplOptions.AggressiveInlining)]
	static int search(int[] array, int row) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			array[row] = i;
			if (check(array, row)) {
				if (row == N - 1)
					count++;
				else
					count += search(array, row + 1);
			}
		}
		return count;
	}

	static int queen() {
		return search(new int[N], 0);
	}

	public static void Main(string[] args) {
		queen();
		DateTime t = DateTime.Now;
		int found = queen();
		Console.WriteLine("found=" + found + " time=" + (DateTime.Now - t).TotalMilliseconds + " ms");
	}
}
