import java.io.*;
import java.util.*;

public class dfs_bfs {
	static int N, M, S;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> dfsorder, bfsorder;
	static boolean[] visit;

	static void dfs(int v) {
		dfsorder.add(v);
		visit[v] = true;
		for (int i : adjList[v])
			if (!visit[i]) {
				dfs(i);
			}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visit[v] = true;
		while (!queue.isEmpty()) {
			int q = queue.poll();
			bfsorder.add(q);
			for (int i : adjList[q])
				if (!visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		visit = new boolean[N + 1];
		dfsorder = new ArrayList<>();
		dfs(S);
		visit = new boolean[N + 1];
		bfsorder = new ArrayList<>();
		bfs(S);
		for (int t : dfsorder) {
			System.out.print(t + " ");
		}
		System.out.println();
		for (int t : bfsorder) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
}