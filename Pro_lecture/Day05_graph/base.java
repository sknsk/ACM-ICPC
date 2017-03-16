import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class base {
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
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
