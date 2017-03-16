import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class paper_divide {
	static int white;
	static int blue;
	
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int N = sc.nextInt(); //색종이 길이
		int [][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		divide(arr, 0, 0, N);
		System.out.println(white);
		System.out.println(blue);
		sc.close();
	}
	

	private static void divide(int[][] arr, int x, int y, int length) {
		if(length == 0) {
			return;
		}
		int cnt = 0;
		for(int i = x; i < x + length; i++){
			for(int j = y; j < y + length; j++) {
				if(arr[x][y] != arr[i][j]) {
					cnt++;
					break;
				}
			
			}
		}
		if(cnt == 0) {
			if(arr[x][y] == 1) {
				blue++;
			}else {
				white++;
			}
		}else{
			divide(arr, x, y, length / 2);
			divide(arr, x, y + length / 2, length / 2);
			divide(arr, x + length / 2, y, length / 2);
			divide(arr, x + length / 2, y + length / 2, length / 2);
		}
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
