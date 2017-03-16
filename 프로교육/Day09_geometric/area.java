import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class area {
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int n = sc.nextInt();
		int[] X = new int[n + 1];
		int[] Y = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			int j = (i % n) + 1;
			ans += (long) X[i] * Y[j] - (long) X[j] * Y[i];
		}
		ans = Math.abs(ans);
		System.out.printf("%d.%d\n", ans / 2, ans % 2 == 0 ? 0 : 5);
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
