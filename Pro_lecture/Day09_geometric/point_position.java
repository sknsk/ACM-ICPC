import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class point_position {
	static int n;
	static int[] X;
	static int[] Y;
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		n = sc.nextInt();
		X = new int[n + 1];
		Y = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		System.out.println(check(x1, y1) ? "in" : "out");
		System.out.println(check(x2, y2) ? "in" : "out");
	}

	static boolean check(int x, int y){
		int x2 = (int) 1e9 + 1;
		int y2 = y + 1;
		boolean flag = false;
		for (int i = 1; i <= n; i++) {
			int j = i % n + 1;
			if(isCross(x, y, x2, y2, X[i], Y[i], X[j], Y[j])){
				if(flag){
					flag = false;
				}else{
					flag = true;					
				}
			}
		}
		return flag;
	}

	static boolean isCross(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		return ccw(ax, ay, bx, by, cx, cy) * ccw(ax, ay, bx, by, dx, dy) < 0
				&& ccw(cx, cy, dx, dy, ax, ay) * ccw(cx, cy, dx, dy, bx, by) < 0;
	}

	static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {
		// Input : A(ax, ay), B(bx, by), C(cx, cy)
		// Output : 사람이 A에 서서 B를 바라볼때,
		// C가 왼쪽이면 1, 오른쪽이면 0
 		long area = (long) (ax - cx) * by +  (long) (bx - ax) * cy + (long) (cx - bx) * ay ;
		if (area > 0){
			return 1;			
		}
		if (area < 0){
			return -1;			
		}
		return 0;
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
