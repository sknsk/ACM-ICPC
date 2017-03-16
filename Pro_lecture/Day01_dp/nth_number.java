import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nth_number {
	
	static int N;
	static int [] NUMBER;
	static int ANS_NUM;
	static int ANS_CNT;
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		N = sc.nextInt(); // 1 <= N <= 1000000
		NUMBER = new int[N + 1];
		for(int i = 0; i < N; i ++) {
			NUMBER[i] = sc.nextInt();
		}
		int cnt = 1;
		ANS_NUM = 0;
		ANS_CNT = 0;
		Arrays.sort(NUMBER, 0, N);
		NUMBER[N] = -1;
		 for (int i = 1; i <= N; i++) {
		        if (NUMBER[i] == NUMBER[i - 1]) {
		        	cnt++;
		        } else {
		            if (ANS_CNT < cnt) {
		            	ANS_CNT = cnt;
		                ANS_NUM = NUMBER[i - 1];
		            }
		            cnt = 1;
		        }
		    }
	    System.out.println(ANS_NUM);
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