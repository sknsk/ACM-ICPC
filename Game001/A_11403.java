import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 * 경로찾기
 * @author sknsk
 */
public class A_11403 {

	static int V;
	static int[][] adjMatrix;
	static int[] visited;

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		V = sc.nextInt();

		adjMatrix = new int[V + 1][V + 1];
		visited = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				adjMatrix[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= V; i++) {
			DFS(i);
			back(i);
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void DFS(int v) {

		for (int i = 1; i <= V; i++) {
			if (adjMatrix[v][i] == 1 && visited[i] != 1) {
				visited[i] = 1;
				DFS(i);
			}
		}
	}

	static void back(int v) {
		for (int i = 1; i <= V; i++) {
			if (visited[i] == 1) {
				adjMatrix[v][i] = 1;
				visited[i] = 0;
			}
		}

	}
}

class FastScanner {

	BufferedReader br;
	StringTokenizer st;

	public FastScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}