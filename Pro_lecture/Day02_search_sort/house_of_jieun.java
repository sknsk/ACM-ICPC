import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class house_of_jieun {

	static int X;
	static int N;
	static int[] A;

	// O(N) 시간복잡도 + O(NlogN)) => O(NlogN))
	// 1. 양끝에서 오면서
	// 2. Binary search 이용
	public static void main(String[] args) {
		FScanner sc = new FScanner();
		X = sc.nextInt() * 10000000;
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();

		// solution
		Arrays.sort(A);
		for (int i = 0, r = N - 1; i < r; i++) {
			while (r > i && A[i] + A[r] > X)
				r--;
			if (r <= i)
				break;
			if (A[i] + A[r] == X) {
				System.out.printf("yes %d %d\n", A[i], A[r]);
				return;
			}
		}
		System.out.println("danger");
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
