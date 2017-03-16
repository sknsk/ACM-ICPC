import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cow_party {

	static int N, M, X;
	static ArrayList<Edge>[] adjMatrix;
	static ArrayList<Edge>[] comeList;
	static int[] dist;
	static int[] cowList;

	public static void main(String[] args) {
		FScanner sc = new FScanner();
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		adjMatrix = new ArrayList[N + 1];
		dist = new int[N + 1];
		cowList = new int[N + 1];

		// list initialize
		for (int i = 1; i <= N; i++) {
			adjMatrix[i] = new ArrayList<Edge>();
		}

		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adjMatrix[a].add(new Edge(b, c));
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int goTime = djkstraPriorityQueue(adjMatrix, i)[X];
			int comeTime = djkstraPriorityQueue(adjMatrix, X)[i];
			result = Math.max(result, goTime + comeTime);
		}
		System.out.println(result);
		sc.close();
	}

	private static int [] djkstraPriorityQueue(ArrayList<Edge>[] list, int start) {
		
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		PriorityQueue<Edge> que = new PriorityQueue<>();
		que.offer(new Edge(start, dist[start]));

		while (!que.isEmpty()) {

			Edge e = que.poll();
			int distance = e.distance;
			int cIndex = e.index;
			
			if (distance > dist[cIndex]) continue;
			
			for (Edge edge : list[cIndex]) {
				int nextIndex = edge.index;
				int nextDistance = edge.distance;
				if (dist[nextIndex] > dist[cIndex] + nextDistance) {
					dist[nextIndex] = dist[cIndex] + nextDistance;
					que.offer(new Edge(nextIndex, dist[nextIndex]));
				}
			}
		}
		return dist;
	}

	static class Edge implements Comparable<Edge> {
		int index;
		int distance;

		public Edge(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance <= o.distance ? -1 : 1;
		}

		@Override
		public String toString() {
			return "Edge [index=" + index + ", distance=" + distance + "]";
		}

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
