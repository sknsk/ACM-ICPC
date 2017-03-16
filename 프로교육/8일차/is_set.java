import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class is_set {
	static final int NM = 205;
	static int n;
	static char a[];
	static int dy[][], list[][], visit[][];

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			input(sc);
			solve(1, n);
			System.out.printf("Word #%d: %s\n", tc, dy[1][n] == 1 ? "Set" : "No Set");
		}
	}

	private static void input(FScanner sc) {
		a = new char[NM];
		dy = new int[NM][NM];
		list = new int[NM][NM];
		visit = new int[NM][NM];
		String str = sc.next();
		for (int i = 1; i <= str.length(); i++) {
			a[i] = str.charAt(i - 1);
		}
		n = str.length();
	}

	static void solve(int x, int y) {

		if (x > y) {
			return;
		}
		if (visit[x][y] == 1) {
			return;
		}
		visit[x][y] = 1;
		// set
		if (y == x + 1 && a[x] == '{' && a[y] == '}') {
			dy[x][y] = list[x][y] = 1;
		}
		solve(x + 1, y - 1);
		if (list[x + 1][y - 1] == 1 && a[x] == '{' && a[y] == '}') {
			dy[x][y] = list[x][y] = 1;
		}

		// list
		if (x == y) {
			list[x][y] = 1;
		}
		if (list[x][y] == 1) {
			return;
		}
		for (int i = x + 1; i <= y - 1; i++) {
			if (a[i] == ',') {
				solve(x, i - 1);
				solve(i + 1, y);
				if (list[x][i - 1] == 1 && list[i + 1][y] == 1) {
					list[x][y] = 1;
				}
			}
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
