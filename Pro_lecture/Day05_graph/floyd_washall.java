import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class floyd_washall {
	static int N;
	static int[][] w;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 도시의 수 (1 ≤ N ≤ 300)
		w = new int[N + 1][N + 1];

		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				ans = Math.max(ans, w[i][j]);

		System.out.println(ans);

	}
}