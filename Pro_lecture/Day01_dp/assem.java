import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class assem {
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int N = sc.nextInt();
		int e1 = sc.nextInt();
		int e2 = sc.nextInt();
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		
		int [] s1 = new int [N + 1];
		for(int i = 1; i <= N; i++){
			s1[i] = sc.nextInt();
		}
		
		int [] s2 = new int [N + 1];
		for(int i = 1; i <= N; i++){
			s2[i] = sc.nextInt();
		}
		int [] t1 = new int [N];
		for(int i = 1; i < N; i++){
			t1[i] = sc.nextInt();
		}
		int [] t2 = new int [N];
		for(int i = 1; i < N; i++){
			t2[i] = sc.nextInt();
		}
	
		
		int e1Pre = e1 + s1[1];
		int e2Pre = e2 + s2[1];
		
		for(int i = 2; i <= N; i++){
			int e1Tmp = e1Pre;
			int e2Tmp = e2Pre;

			e1Tmp = Math.min(e2Pre + t2[i - 1], e1Pre) + s1[i];
			e2Tmp = Math.min(e1Pre + t1[i - 1], e2Pre) + s2[i];
			
			e1Pre = e1Tmp;
			e2Pre = e2Tmp;

		}		
		System.out.println(Math.min(e1Pre + x1, e2Pre + x2));
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
