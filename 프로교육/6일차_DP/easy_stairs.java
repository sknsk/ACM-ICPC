import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class easy_stairs {
	static final int MOD = 1000000000;
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int N = sc.nextInt();
		int [][] dp = new int[N + 1][10];
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][1];
				}else if(j == 9){
					dp[i][j] = dp[i - 1][8];
				}else{
					dp[i][j] = ((dp[i - 1][j - 1]) % MOD + (dp[i - 1][j + 1]) % MOD) % MOD; 					
				}
			}
		}
		int ans = 0;
		for(int i = 0; i <= 9; i++) {
			ans =  (ans + dp[N][i]) % MOD;
			
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
