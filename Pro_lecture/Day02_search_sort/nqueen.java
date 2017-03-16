import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nqueen {
	
	static int N;
	static int ANSWER = 0;
	
	static void input() {
		FScanner sc = new FScanner();
		N = sc.nextInt();
		sc.close();
	}

	static void process() {
		f(0, new int[N], new int[N + N], new int[N + N]);
	}
	
	static void f(int v, int [] col, int [] up, int [] down){
		
		if(v >= N){
			ANSWER++;
			return;
		}
		
		for(int i = 0; i < N; i++) {			
			int downIndex = N - (v - i);
			int upIndex = v + i;
			if(col[i] != 1 && down[downIndex] != 1 && up[upIndex] != 1) {
				col[i] = 1;
				down[downIndex] = 1;
				up[upIndex] = 1;
				f(v + 1, col, up, down);
				col[i] = 0;
				up[upIndex] = 0;
				down[downIndex] = 0;
			}
		}
	}
	
	static void print() {
		System.out.println(ANSWER);
	}
	
	
	public static void main(String[] args) {
		input();
		process();
		print();
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
