import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nugget {
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int n = sc.nextInt();
		int [] a = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		long t = 0;
		for(int i = 1; i <= n; i++) {
			if(a[i] <= t + 1) {
				t += a[i];
			}else{
				break;
			}
		}
		System.out.println(t + 1);
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
