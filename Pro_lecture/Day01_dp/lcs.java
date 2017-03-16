import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lcs {
	
	static char [] line1;
	static char [] line2;
	static int [][] DP;
	static int [][] SOURCE;
	
	static void input() {
		FScanner sc = new FScanner();
		line1 = sc.next().toCharArray();
		line2 = sc.next().toCharArray();
		DP = new int[line1.length + 1][line2.length + 1];
		SOURCE = new int[line1.length + 1][line2.length + 1];
		sc.close();
	}
	//1 : 대각
	//2 : 왼쪽
	//3 : 위쪽
	static void process() {
		for(int i = 1; i <= line1.length; i++) {
			for(int j = 1; j <= line2.length; j++) {
				if(i - 1 < 0 || j - 1 < 0){
					break;
				}
				if(line1[i - 1] == line2[j - 1]) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
					SOURCE[i][j] = 1;
				}else {
					if(DP[i][j - 1] >=  DP[i - 1][j] ) {
						DP[i][j] = DP[i][j - 1];
						SOURCE[i][j] = 2;
					}else {
						DP[i][j] = DP[i - 1][j];
						SOURCE[i][j] = 3;
					}
				}
			}
		}
		int i = line1.length;
		int j = line2.length;
	
		ArrayList<Character> result = new ArrayList<Character>();
		while(i > 0 && j > 0) {
			switch(SOURCE[i][j]) {
				case 1:
					result.add(line1[i - 1]);
					i--;
					j--;
					break;
				case 2:
					j--;
					break;
					
				case 3:
					i--;
					break;
			}
		}
		for(int t = result.size() - 1; t >=0; t--){
			System.out.print(result.get(t));			
		}
	}

	
	public static void main(String[] args) {
		input();
		process();
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
