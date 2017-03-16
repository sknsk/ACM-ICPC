import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coin {
	
	static int N;
	static int [] COIN;
	static int [] DP;
	static int CHANGE; 
	
	static void input() {
		FScanner sc = new FScanner();
		N = sc.nextInt();
		COIN = new int[N + 1];
		for(int i = 1; i <= N; i++){
			COIN[i] = sc.nextInt();
		}
		
		CHANGE = sc.nextInt();
		DP = new int[CHANGE + 1];
		Arrays.fill(DP, Integer.MAX_VALUE);
		DP[0] = 0;
		sc.close();
	}

	static void process() {
		
		for(int i = 1; i <= CHANGE; i++) {
			for(int j = 1; j <= N; j++) {
				if(i - COIN[j] >= 0 && DP[i - COIN[j]] + 1 <= Integer.MAX_VALUE){
					DP[i] = Math.min(DP[i], DP[i - COIN[j]] + 1);					
				}
			}
		}
	}
	
	static void print() {
		System.out.println(DP[CHANGE]);
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

/*
 * ID: COIN
������ ����, �ܵ�
dy[i][j]: ���� 1~ i���� ���, j���� ����� �ּ� ��������
dy[i][0] = 0, dy[1][x] = inf
dy[i][j] = { dy[i][j-a[i]] + 1 : (!= inf)
			 dy[i-1][j] (!= inf)
			}
dy[n][w]

-------------------------------------------------------------
dy[i] : ��絿�� ��� �ؼ� i���� ����� �ּ� ���� ����
dy[0] = 0, d[������] = inf
dy[i] = min(dy[i-a[j]] + 1) j=1���� N����
*/
