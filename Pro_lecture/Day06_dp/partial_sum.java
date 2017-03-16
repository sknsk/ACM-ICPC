import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class partial_sum {
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int N = sc.nextInt();
		int [] a = new int[N + 1];
		long [] dp = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
		}
		dp[1] = a[1];
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(a[i],  + dp[i - 1] + a[i]);
		}
		
		long ans = a[1];
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[i]);
		}
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
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {}
			}
			return st.nextToken(); 
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		void close(){
			try {
				br.close();
			} catch (IOException e) {}
		}
	}
}
