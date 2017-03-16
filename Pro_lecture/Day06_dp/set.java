import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class set {
 
    static int N;
    static int M;
    static int[] A;
    static int[] B;
 
    public static void main(String[] args) {
        FScanner sc = new FScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
 
        for (int i = 1; i <= N; ++i) {
            A[i] = sc.nextInt();
        }
        for (int i = 1; i <= M; ++i) {
            B[i] = sc.nextInt();
        }
 
        Arrays.sort(A);
        Arrays.sort(B);
 
        int [][] dp = new int[N + 1][M + 1];
 
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
            	dp[i][j] = dp[i - 1][j - 1] + Math.abs(A[i] - B[j]);
        		if (i > j && dp[i][j] > dp[i - 1][j]) {
        			dp[i][j] = dp[i - 1][j];
        		}
        		if (i < j && dp[i][j] > dp[i][j - 1]) {
        			dp[i][j] = dp[i][j - 1];
        		}
            }
        }
        System.out.println(dp[N][M]);

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