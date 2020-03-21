public class queen2 {
	static final int N = 13;

	static boolean check(int[] q, int row) {
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

	public static void main(String[] args) {
		queen();
		long ts = System.nanoTime();
		int found = queen();
		ts = System.nanoTime() - ts;
		System.out.format("found=%d time=%.3fms%n", found, ts * 0.000001);
	}
}
