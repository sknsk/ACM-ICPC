import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class stone_bridge {

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		char[] spell = sc.next().toCharArray();
		char[] devil = sc.next().toCharArray();
		char[] angel = sc.next().toCharArray();
		int n = devil.length;
		int m = spell.length;
		char[][] a = new char[2][n + 1];
		char[] b = new char[m + 1];
		for (int i = 1; i <= n; i++) {
			a[0][i] = devil[i - 1];
			a[1][i] = angel[i - 1];
		}
		for (int i = 1; i <= m; i++) {
			b[i] = spell[i - 1];
		}

		int[][][] dp = new int[n + 1][m + 1][2];
		dp[0][0][0] = dp[0][0][1] = 1;
		
		for (int i = 1; i <= n; i++) {
			dp[i][0][0] = dp[i][0][1] = 1;
			for (int j = 1; j <= m; j++) {
				for (int x = 0; x <= 1; x++) {
					dp[i][j][x] = dp[i - 1][j][x] 
							+ dp[i - 1][j - 1][1 - x] * (a[x][i] == b[j] ? 1 : 0);
				}
			}
		}
		int ans = dp[n][m][0] + dp[n][m][1];
		System.out.println(ans);

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
