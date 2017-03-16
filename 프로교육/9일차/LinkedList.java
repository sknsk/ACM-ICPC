import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedList {

	static int n;
	static int[][] dy;
	static final int mod = 10007;

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		dy = new int[50002][2];
		dy[1][0] = 1;
		dy[2][0] = 4;
		dy[2][1] = 3;
		for (int i = 3; i <= 50000; i++) {
			dy[i][0] = (3 * dy[i - 1][0] + dy[i - 1][1]) % mod;
			dy[i][1] = (2 * dy[i - 1][0] + dy[i - 1][1]) % mod;
		}

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			int a = dy[n][0];
			int b = ((dy[n][0] + dy[n][1] - 1) * n) % mod;
			System.out.printf("%d %d\n", a, b);
		}
	}

	static class FScanner {
		BufferedReader br;
		StringTokenizer st;

		public FScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
}