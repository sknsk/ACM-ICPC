import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class jewery {
	static int N;
	static int K;
	static int[][] pi;
	static int[] ci;

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		N = sc.nextInt();
		K = sc.nextInt();
		pi = new int[N][2];
		ci = new int[K];

		for (int i = 0; i < N; i++) {
			pi[i][0] = sc.nextInt();
			pi[i][1] = sc.nextInt();
		}
		for (int i = 0; i < K; i++) {
			ci[i] = sc.nextInt();
		}

		Arrays.sort(pi, new Comparator<int[]>() {
			@Override
			public int compare(int[] ar1, int[] ar2) {
				return ar1[0] < ar2[0] ? -1 : 1;
			}
		});
		
		Arrays.sort(ci);
		PriorityQueue<Integer> pq = new PriorityQueue<>(K, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0 < arg1 ? 1 : -1;
			}
		});
		
		long sum = 0;
		for (int i = 0, j = 0; i < K; i++) {
			while(j < N && pi[j][0] <= ci[i]){
				pq.offer(pi[j++][1]);
			}
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		System.out.println(sum);

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
