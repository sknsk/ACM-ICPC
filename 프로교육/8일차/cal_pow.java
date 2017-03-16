import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cal_pow {
	
	static long MOD = 1000000007;
	static long a;
	static long m;
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		a = sc.nextLong();
		m = sc.nextLong();
		System.out.println(pow(a, m));
		sc.close();
	}
	
	static long pow(long base, long exp) {
		if (exp == 0) {
			return 1;
		}
		long newPow = pow(base, exp >> 1) % MOD;
		newPow = (newPow * newPow) % MOD;
		if(exp % 2 != 0) {
			newPow = (newPow * base) % MOD;
		}
		return newPow;
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
		long nextLong(){
			return Long.parseLong(next());
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
}
