public class queen {
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

	static int queen() {
		int[] q = new int[N];
		int found = 0;
		int row = 0;
		int done = 0;
		while (done == 0) {
			if (check(q, row)) {
				if (row == N - 1)
					found++;
				else {
					row++;
					q[row] = 0;
					continue;
				}
			}
			q[row] += 1;
			while (q[row] >= N) {
				row--;
				if (row >= 0)
					q[row]++;
				else {
					done = 1;
					break;
				}
			}
		}
		return found;
	}

	public static void main(String[] args) {
		queen();
		long ts = System.nanoTime();
		int found = queen();
		ts = System.nanoTime() - ts;
		System.out.format("found=%d time=%.3fms%n", found, ts * 0.000001);
	}
}
