import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class topology {
	private static final int MAXN = 50005;
	private static int V, E;
	private static int[] indegree = new int[MAXN];
	private static List<Integer>[] adv = new ArrayList[MAXN];
	private static List<Integer> ret = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			init(in);

			solve();

			show();
		}
	}

	public static void show() {
		StringBuffer sb = new StringBuffer();
		for (int ans : ret) {
			sb.append(ans + " ");
		}

		System.out.println(sb.toString());
	}

	public static void solve() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int start = q.poll();

			ret.add(start);

			for (int end : adv[start]) {
				indegree[end]--;

				if (indegree[end] == 0) {
					q.offer(end);
				}
			}
		}
	}

	public static void init(BufferedReader in) throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= V; i++) {
			adv[i] = new ArrayList<>();
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adv[start].add(end);
			indegree[end]++;
		}
	}
}