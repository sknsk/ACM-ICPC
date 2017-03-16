import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class balloon {
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int n = sc.nextInt();
		int[] baloon = new int[n + 1];
		int[] arrow = new int[n + 1];
		int arrowCount = 0;
		for (int i = 1; i <= n; i++) {
			baloon[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			if (arrow[baloon[i]] == 0) {
				arrowCount++;
			} else {
				arrow[baloon[i]]--;
			}
			arrow[baloon[i] - 1]++;
		}
		sc.close();
		System.out.println(arrowCount);
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