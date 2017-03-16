import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * naive하게 생각해보면 10만 -> 문제 풀수 없음
 * 교차하는 쌍의 개수를 numberOfInversion 문제로 바꿀 수있음
 * 
 * 순열을 원하는 만큼 왼쪽으로 cyclic shift 할 수 있을 때,
 * 가능한 최소 Inversion의 개수를 출력하라.
 */

public class why_cow {
	
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
