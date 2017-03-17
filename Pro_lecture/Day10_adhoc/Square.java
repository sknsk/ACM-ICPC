import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square {

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int n = sc.nextInt();
		int [][] dy = new int[n + 1][n + 1];
		int [][] a = new int[n + 1][n + 1];
		long ans = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 1) {
		            dy[i][j] = Math.min(Math.min(dy[i - 1][j], dy[i][j - 1]),dy[i - 1][j - 1] ) + a[i][j];
		            if (dy[i][j] >= 1) ans += dy[i][j] - 1;
				}
			}
		}
		System.out.println(ans);
				
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
