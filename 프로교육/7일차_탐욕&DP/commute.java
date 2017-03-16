import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class commute {

	static int n;
	static int m;
	static int k;
	static int[][] a;
	static int[][] dy;

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		a = new int[1005][1005];
		dy = new int[1005][1005];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		dy[1][1] = k - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i - 1][j] == 1) {
					dy[i][j] += dy[i - 1][j] / 2;
				} else {
					dy[i][j] += (dy[i - 1][j] + 1) / 2;
				}
				if (a[i][j - 1] == 0) {
					dy[i][j] += dy[i][j - 1] / 2;
				} else {
					dy[i][j] += (dy[i][j - 1] + 1) / 2;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int ch = ((dy[i][j] & 1) == 0 ? 0 : 1);
				a[i][j] = (a[i][j] + ch) % 2;
			}
		}

		int x = 1, y = 1;
		while (x <= n && y <= m) {
			if (a[x][y] == 1){
				y++;				
			}
			else {
				x++;				
			}
		}
		System.out.printf("%d %d", x, y);
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
