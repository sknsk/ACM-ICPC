import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class source {

	static int V;
	static int E;
	static ArrayList<Integer>[] adjList;
	static int[] endTime;
	static int timer;
	static ArrayList<Integer> result;

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		V = sc.nextInt();
		E = sc.nextInt();
		
		endTime = new int[V + 1];
		adjList = new ArrayList[V + 1];
		result = new ArrayList<>();
		for (int i = 1; i <= E; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adjList[x].add(y);
		}
		dfs(1, new int[V + 1]);
		for(int i = result.size() - 1; i >= 0; i--){
			System.out.print(result.get(i) + " ");
		}
	}

	static void dfs(int v, int[] visit) {

		visit[v] = 1;
		timer++;
		for (int i : adjList[v]) {
			if (visit[i] == 0) {
				dfs(i, visit);
			}
		}
		result.add(v);
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
