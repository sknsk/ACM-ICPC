import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fenwick_tree {

	static int[] tree;
	static int n;
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		n = 8;
		tree = new int[n + 1];
		for (int i = 1; i < 9; i++) {
			update(i, i);
		}
		for (int i = 1; i < 9; i++) {
			System.out.println(sum(i));
		}
		sc.close();
	}
	
	static void update(int i, int num) {
		while(i <= n){
			tree[i] += num;
			i += (i & -i);
		}
	}
	
	static int sum(int i) {
		int ans = 0;
		while(i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
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
