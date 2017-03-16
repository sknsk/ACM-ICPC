import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bit_count {

	public static void main(String[] args) {
		FScanner sc = new FScanner();

		int[][][] dp = new int[101][101][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;
		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				// 0으로 끝날때
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];

				// 1로 끝날때
				dp[i][j][1] = dp[i - 1][j][0] + (j > 0 ? dp[i - 1][j - 1][1] : 0);
			}
		}
		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(t + " " + (dp[n][k][1] + dp[n][k][0]));
		}

		sc.close();
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
