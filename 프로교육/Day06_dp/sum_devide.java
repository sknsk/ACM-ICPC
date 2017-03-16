import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sum_devide {
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [][] dp = new int [201][201];
		for(int i = 0; i <= n; i++) {
			dp[1][i] = 1;
		}
		for(int i = 1; i <= k; i++) {
			for(int j = 1; j <= n; j++) {
				for(int x = 0; x <= j; x++) {
					dp[i][j] = dp[i][j] + dp[i - 1][j - x];					
				}
			}
		}
		System.out.println(dp[k][n]);
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
