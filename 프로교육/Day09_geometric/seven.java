import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class seven {
	
	static int n; 
	static int [] sum;
	static int [] dy;
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		n = sc.nextInt();
		sum = new int[n];
		dy = new int[7];
		sum[0] = sc.nextInt() % 7;
		for(int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + sc.nextInt();
			sum[i] = sum[i] % 7;			
		}
		dy[0]++;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 7; j++) {
				if(j == sum[i]){
					dy[j]++;
				}				
			}
		}
		long ans = 0;
		for(int i = 0; i < 7; i++) {
			ans += (long) dy[i] * (dy[i] - 1) / 2;
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
