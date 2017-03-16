import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class histogram {
	static int n;
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		for(;;){
			solve(sc);
			if(n == 0) break;
		}
	}
	static void solve(FScanner sc) {
		n = sc.nextInt();
		if(n == 0){
			return;
		}
		int[] a = new int[100000];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();
		long ans = 0;

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
				int height = a[stack.peek()];
				stack.pop();
				int width = i;
				if (!stack.empty()) {
					width = i - stack.peek() - 1;
				}
				ans = Math.max(ans, (long) width * height);
			}
			stack.push(i);
		}

		while (!stack.empty()) {
			int height = a[stack.peek()];
			stack.pop();
			int width = n;
			if (!stack.empty()) {
				width = n - stack.peek() - 1;
			}
			ans = Math.max(ans, (long) width * height);
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
