import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	소수에서 소수로 변경 
	BFS의 특성을 이용함
	G = (V, E)
	B = 소수(4자리)
	E = (V1, V2) V1에서 V2로 변경
	작은 소수부터 정점을 구하고 BFS로 찾아 들어가면 됨
 */

public class prime_path {

	static int T, A, B;
	static int[] D;
	static boolean[] primeArr;

	private static void input(FScanner sc) {
		A = sc.nextInt();
		B = sc.nextInt();
	}

	private static void pre() {
		primeArr = new boolean[10000];
		// 어차피 2의 배수는 소수가 아님
		for (int i = 1001; i <= 9999; i += 2) {
			primeArr[i] = isPrime(i);
		}
	}

	private static void process() {
		D = new int[10000];
		for (int i = 0; i < 10000; i++)
			D[i] = Integer.MAX_VALUE;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(A);
		D[A] = 0;
		while (!que.isEmpty()) {
			int q = que.poll();
			for (int b = 1; b < 10000; b *= 10) {
				for (int d = 0; d < 10; d++) {
					int v = q / b / 10 * b * 10 + q % b + b * d;
					if (!primeArr[v] || D[v] < Integer.MAX_VALUE)
						continue;
					D[v] = D[q] + 1;
					que.add(v);
				}
			}
		}
		System.out.println(D[B]);
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			pre();
			input(sc);
			process();
		}
		sc.close();
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
