import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rope {
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int N = sc.nextInt();
		int [] length = new int[N + 1];
		for(int i = 0; i < N; i++){
			length[i] = sc.nextInt();
		}
		int [] rope = new int [N + 1];
		
		for(int i = 1; i <= N; i++) {
			int maxLength = 0;
			for(int j = 1; j <= i; j++){
//				System.out.println("i : " + i + "    i - j : " + (i - j));
				maxLength = Math.max(maxLength, length[j- 1] + rope[i - j]); 
			}
			rope[i] = maxLength;
		}
		System.out.println(rope[N]);
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
