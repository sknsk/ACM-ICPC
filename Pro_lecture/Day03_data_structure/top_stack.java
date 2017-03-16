import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class top_stack {

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> rootStack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();

		int first = sc.nextInt();
		rootStack.push(first);
		indexStack.push(1);
		sb.append("0 ");
		for (int i = 2; i <= n; i++) {
			int value = sc.nextInt();

			while (!rootStack.isEmpty() && value >= rootStack.peek()) {
				rootStack.pop();
				indexStack.pop();					
			}
			
			// 2. stack empty면 0추가 아니면 index추가
			if (rootStack.isEmpty()) {
				sb.append("0 ");
			}else{
				sb.append(indexStack.peek() + " ");
			}

			// 3. 자신을 push
			rootStack.push(value);
			indexStack.push(i);
		}

		System.out.println(sb.toString());
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
